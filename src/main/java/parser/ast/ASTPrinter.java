package parser.ast;

import java.util.List;

public class ASTPrinter implements ASTVisitor<Void> {
    private int indent = 0;

    private void printIndent() {
        System.err.print("  ".repeat(indent));
    }

    public void print(ASTNode node) {
        indent = 0;
        node.accept(this);
    }

    @Override
    public Void visit(ProgNode node) {
        printIndent();
        System.err.println("ProgNode");
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
        System.err.println("AssignNode: " + node.getName());
        indent++;
        node.getExpr().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(ExprStmtNode node) {
        printIndent();
        System.err.println("ExprStmtNode");
        indent++;
        node.getExpr().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(BinaryOpNode node) {
        printIndent();
        System.err.println("BinaryOpNode: " + node.getOp());
        indent++;
        node.getLeft().accept(this);
        node.getRight().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(UnaryOpNode node) {
        printIndent();
        System.err.println("UnaryOpNode: " + node.getOp());
        indent++;
        node.getOperand().accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(IntNode node) {
        printIndent();
        System.err.println("IntNode: " + node.getValue());
        return null;
    }

    @Override
    public Void visit(BoolNode node) {
        printIndent();
        System.err.println("BoolNode: " + node.getValue());
        return null;
    }

    @Override
    public Void visit(VarRefNode node) {
        printIndent();
        System.err.println("VarRefNode: " + node.getName());
        return null;
    }

    @Override
    public Void visit(FuncCallNode node) {
        printIndent();
        System.err.println("FuncCallNode: " + node.getName());
        indent++;
        List<ASTNode> args = node.getArgs();
        for (ASTNode arg : args) {
            arg.accept(this);
        }
        indent--;
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        printIndent();
        System.err.println("StringNode: \"" + node.getValue() + "\"");
        return null;
    }

    @Override
    public Void visit(ForNode node) {
        printIndent();
        System.err.println("ForNode: variable=" + node.getVariable());
        indent++;
        
        printIndent();
        System.err.println("Iterable:");
        indent++;
        node.getIterable().accept(this);
        indent--;
        
        printIndent();
        System.err.println("Body:");
        indent++;
        for (ASTNode stmt : node.getBody()) {
            stmt.accept(this);
        }
        indent--;
        
        indent--;
        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        printIndent();
        System.err.println("WhileNode:");
        indent++;
        
        printIndent();
        System.err.println("Condition:");
        indent++;
        node.getCondition().accept(this);
        indent--;
        
        printIndent();
        System.err.println("Body:");
        indent++;
        for (ASTNode stmt : node.getBody()) {
            stmt.accept(this);
        }
        indent--;
        
        indent--;
        return null;
    }

    @Override
    public Void visit(IfNode node) {
        printIndent();
        System.err.println("IfNode:");
        indent++;
        
        printIndent();
        System.err.println("Condition:");
        indent++;
        node.getCondition().accept(this);
        indent--;
        
        printIndent();
        System.err.println("Then:");
        indent++;
        for (ASTNode stmt : node.getThenBody()) {
            stmt.accept(this);
        }
        indent--;
        
        // Imprimir elif clauses
        if (!node.getElifClauses().isEmpty()) {
            for (int i = 0; i < node.getElifClauses().size(); i++) {
                IfNode.ElifClause elifClause = node.getElifClauses().get(i);
                printIndent();
                System.err.println("Elif " + (i + 1) + ":");
                indent++;
                
                printIndent();
                System.err.println("Condition:");
                indent++;
                elifClause.getCondition().accept(this);
                indent--;
                
                printIndent();
                System.err.println("Body:");
                indent++;
                for (ASTNode stmt : elifClause.getBody()) {
                    stmt.accept(this);
                }
                indent--;
                
                indent--;
            }
        }
        
        // Imprimir else clause
        if (node.getElseBody() != null) {
            printIndent();
            System.err.println("Else:");
            indent++;
            for (ASTNode stmt : node.getElseBody()) {
                stmt.accept(this);
            }
            indent--;
        }
        
        indent--;
        return null;
    }

    @Override
    public Void visit(RangeNode node) {
        printIndent();
        System.err.println("RangeNode:");
        indent++;
        for (int i = 0; i < node.getArgs().size(); i++) {
            printIndent();
            System.err.println("Arg " + i + ":");
            indent++;
            node.getArgs().get(i).accept(this);
            indent--;
        }
        indent--;
        return null;
    }
}
