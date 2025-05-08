package parser.ast;

import java.util.List;

public class ASTPrinter implements ASTVisitor<Void> {
    private int indent = 0;

    private void printIndent() {
        System.out.print("  ".repeat(indent));
    }

    public void print(ASTNode node) {
        indent = 0;
        node.accept(this);
    }

    @Override
    public Void visit(ProgNode node) {
        printIndent();
        System.out.println("ProgNode");
        indent++;
        for (ASTNode stmt : node.getStatements()) {
            stmt.accept(this);
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(AssignNode node) {
        printIndent();
        System.out.println("AssignNode: " + node.getName());
        indent++;
        node.getExpr().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ExprStmtNode node) {
        printIndent();
        System.out.println("ExprStmtNode");
        indent++;
        node.getExpr().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(BinaryOpNode node) {
        printIndent();
        System.out.println("BinaryOpNode: " + node.getOp());
        indent++;
        node.getLeft().accept(this);
        node.getRight().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(IntNode node) {
        printIndent();
        System.out.println("IntNode: " + node.getValue());
        return null;
    }

    @Override
    public Void visit(VarRefNode node) {
        printIndent();
        System.out.println("VarRefNode: " + node.getName());
        return null;
    }

    @Override
    public Void visit(FuncCallNode node) {
        printIndent();
        System.out.println("FuncCallNode: " + node.getName());
        indent++;
        List<ASTNode> args = node.getArgs();
        for (ASTNode arg : args) {
            arg.accept(this);
        }
        indent--;
        return null;
    }
}
