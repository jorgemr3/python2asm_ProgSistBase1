// ASTVisitor.java
package parser.ast;

public interface ASTVisitor<T> {
    T visit(ProgNode node);
    T visit(AssignNode node);
    T visit(ExprStmtNode node);
    T visit(BinaryOpNode node);
    T visit(UnaryOpNode node);
    T visit(IntNode node);
    T visit(BoolNode node);
    T visit(VarRefNode node);
    T visit(FuncCallNode node);
    T visit(StringNode node);
    T visit(ForNode node);
    T visit(WhileNode node);
    T visit(RangeNode node);
}
