package parser.ast;

public class StringNode implements ASTNode {
    private final String value;
    public StringNode(String value) { this.value = value; }
    public String getValue() { return value; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public String toString() {
        return "StringNode(\"" + value + "\")";
    }
}
