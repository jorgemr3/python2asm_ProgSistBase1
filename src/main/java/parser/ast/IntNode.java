// IntNode.java
package parser.ast;

public class IntNode implements ASTNode {
    private final int value;
    public IntNode(int value) { this.value = value; }
    public int getValue() { return value; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
