// ExprStmtNode.java
package parser.ast;

public class ExprStmtNode implements ASTNode {
    private final ASTNode expr;
    public ExprStmtNode(ASTNode expr) { this.expr = expr; }
    public ASTNode getExpr() { return expr; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
