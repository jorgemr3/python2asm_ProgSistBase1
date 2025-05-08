// AssignNode.java
package parser.ast;

public class AssignNode implements ASTNode {
    private final String name;
    private final ASTNode expr;
    public AssignNode(String name, ASTNode expr) {
        this.name = name;
        this.expr = expr;
    }
    public String getName() { return name; }
    public ASTNode getExpr() { return expr; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
