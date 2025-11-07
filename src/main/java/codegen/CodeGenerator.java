// src/main/java/codegen/CodeGenerator.java
package codegen;

import parser.ast.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class CodeGenerator implements ASTVisitor<Void> {
    private StringBuilder sb = new StringBuilder();
    private Map<String, Integer> varOffsets = new HashMap<>();
    private Map<String, String> stringLiterals = new LinkedHashMap<>(); // Mantiene orden de inserción
    private int nextOffset = 0;
    

    public String generate(ASTNode root) {
        // Primera pasada: recolectar todos los strings
        collectStrings(root);
        
        // Generar sección .data con todos los strings
        generateDataSection();
        
        // Generar sección .text
        sb.append("section .text\n");
        sb.append("global _start\n\n");
        sb.append("_start:\n");
        sb.append("    mov rbp, rsp\n\n");
        
        // Segunda pasada: generar código
        root.accept(this);
        
        sb.append("_start_end:\n");
        sb.append("    mov rax, 60\n");
        sb.append("    mov rdi, 0\n");
        sb.append("    syscall\n");
        return sb.toString();
    }
    
    private void collectStrings(ASTNode node) {
        if (node instanceof parser.ast.StringNode) {
            parser.ast.StringNode stringNode = (parser.ast.StringNode) node;
            String value = stringNode.getValue();
            String label = "str" + Math.abs(value.hashCode());
            stringLiterals.put(label, value);
        } else if (node instanceof ProgNode) {
            ProgNode progNode = (ProgNode) node;
            for (ASTNode stmt : progNode.getStatements()) {
                collectStrings(stmt);
            }
        } else if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;
            collectStrings(assignNode.getExpr());
        } else if (node instanceof ExprStmtNode) {
            ExprStmtNode exprStmt = (ExprStmtNode) node;
            collectStrings(exprStmt.getExpr());
        } else if (node instanceof BinaryOpNode) {
            BinaryOpNode binOp = (BinaryOpNode) node;
            collectStrings(binOp.getLeft());
            collectStrings(binOp.getRight());
        } else if (node instanceof UnaryOpNode) {
            UnaryOpNode unaryOp = (UnaryOpNode) node;
            collectStrings(unaryOp.getOperand());
        } else if (node instanceof FuncCallNode) {
            FuncCallNode funcCall = (FuncCallNode) node;
            for (ASTNode arg : funcCall.getArgs()) {
                collectStrings(arg);
            }
        }
        // VarRefNode e IntNode no contienen strings, no necesitan procesamiento
    }
    
    private void generateDataSection() {
        if (!stringLiterals.isEmpty()) {
            sb.append("section .data\n");
            for (Map.Entry<String, String> entry : stringLiterals.entrySet()) {
                sb.append(entry.getKey()).append(": db \"").append(entry.getValue()).append("\", 0x0A, 0\n");
            }
            sb.append("\n");
        }
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
            case "**": sb.append("    ; potencia placeholder\n"); break;
            case "and": 
                sb.append("    ; and: si rax es 0, resultado es 0; si no, resultado es rbx\n");
                sb.append("    test rax, rax\n");
                sb.append("    cmovz rbx, rax\n");
                sb.append("    mov rax, rbx\n");
                break;
            case "or": 
                sb.append("    ; or: si rax no es 0, resultado es rax; si no, resultado es rbx\n");
                sb.append("    test rax, rax\n");
                sb.append("    cmovnz rax, rax\n");
                sb.append("    cmovz rax, rbx\n");
                break;
        }
        sb.append("    push rax\n\n");
        return null;
    }

    public Void visit(UnaryOpNode node) {
        node.getOperand().accept(this);
        sb.append("    pop rax\n");
        switch (node.getOp()) {
            case "+": 
                // +x no hace nada, el valor ya está en rax
                break;
            case "-": 
                sb.append("    neg rax\n");
                break;
            case "not":
                sb.append("    ; not: si rax es 0, resultado es 1; si no, resultado es 0\n");
                sb.append("    test rax, rax\n");
                sb.append("    setz al\n");
                sb.append("    movzx rax, al\n");
                break;
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

    @Override
    public Void visit(parser.ast.StringNode node) {
        System.out.println("[CodeGen] visit(StringNode): \"" + node.getValue() + "\"");
        
        // El string ya fue recolectado en la primera pasada
        String label = "str" + Math.abs(node.getValue().hashCode());
        
        // Solo generar el código para cargar la dirección del string
        sb.append("    lea rdi, [rel ").append(label).append("]\n");
        sb.append("    push rdi\n\n");
        return null;
    }
}
