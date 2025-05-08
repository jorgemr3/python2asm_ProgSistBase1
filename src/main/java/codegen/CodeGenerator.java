// src/main/java/codegen/CodeGenerator.java
package codegen;

import parser.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator implements ASTVisitor<Void> {
    private StringBuilder sb = new StringBuilder();
    private Map<String, Integer> varOffsets = new HashMap<>();
    private int nextOffset = 0;

    public String generate(ASTNode root) {
        sb.append("section .data\n");
        sb.append("section .text\n");
        sb.append("global _start\n\n");
        root.accept(this);
        sb.append("_start_end:\n");
        sb.append("    mov rax, 60\n");
        sb.append("    mov rdi, 0\n");
        sb.append("    syscall\n");
        return sb.toString();
    }

    public Void visit(ProgNode node) {
        for (ASTNode stmt : node.getStatements()) {
            stmt.accept(this);
        }
        return null;
    }

    public Void visit(AssignNode node) {
        node.getExpr().accept(this);
        varOffsets.computeIfAbsent(node.getName(), k -> nextOffset -= 8);
        int offset = varOffsets.get(node.getName());
        sb.append("    pop rax\n");
        sb.append("    mov [rbp").append(offset).append("], rax\n\n");
        return null;
    }

    public Void visit(ExprStmtNode node) {
        node.getExpr().accept(this);
        sb.append("    pop rax\n\n");
        return null;
    }

    public Void visit(BinaryOpNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        sb.append("    pop rbx\n");
        sb.append("    pop rax\n");
        switch (node.getOp()) {
            case "+": sb.append("    add rax, rbx\n"); break;
            case "-": sb.append("    sub rax, rbx\n"); break;
            case "*": sb.append("    imul rax, rbx\n"); break;
            case "/": sb.append("    cqo\n    idiv rbx\n"); break;
            case "%": sb.append("    cqo\n    idiv rbx\n    mov rax, rdx\n"); break;
            case "==": sb.append("    cmp rax, rbx\n    sete al\n    movzx rax, al\n"); break;
            case "!=": sb.append("    cmp rax, rbx\n    setne al\n    movzx rax, al\n"); break;
            case ">": sb.append("    cmp rax, rbx\n    setg al\n    movzx rax, al\n"); break;
            case "<": sb.append("    cmp rax, rbx\n    setl al\n    movzx rax, al\n"); break;
            case ">=": sb.append("    cmp rax, rbx\n    setge al\n    movzx rax, al\n"); break;
            case "<=": sb.append("    cmp rax, rbx\n    setle al\n    movzx rax, al\n"); break;
            case "^": sb.append("    ; potencia placeholder\n"); break;
        }
        sb.append("    push rax\n\n");
        return null;
    }

    public Void visit(IntNode node) {
        sb.append("    push ").append(node.getValue()).append("\n\n");
        return null;
    }

    public Void visit(VarRefNode node) {
        String name = node.getName();
        if (!varOffsets.containsKey(name)) {
            throw new RuntimeException("Variable no definida: " + name);
        }
        int offset = varOffsets.get(name);
        sb.append("    mov rax, [rbp").append(offset).append("]\n");
        sb.append("    push rax\n\n");
        return null;
    }

    public Void visit(FuncCallNode node) {
        // placeholder si llegas a usar llamadas
        List<ASTNode> args = node.getArgs();
        for (ASTNode arg : args) {
            arg.accept(this);
        }
        sb.append("    call ").append(node.getName()).append("\n");
        sb.append("    push rax\n\n");
        return null;
    }
}
