// BinaryOpNode.java
package parser.ast;

public class BinaryOpNode implements ASTNode {
    private final String op;
    private final ASTNode left, right;
    public BinaryOpNode(String op, ASTNode left, ASTNode right) {
        this.op = op; this.left = left; this.right = right;
    }
    public String getOp() { return op; }
    public ASTNode getLeft() { return left; }
    public ASTNode getRight() { return right; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
