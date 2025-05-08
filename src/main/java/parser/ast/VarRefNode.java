// VarRefNode.java
package parser.ast;

public class VarRefNode implements ASTNode {
    private final String name;
    public VarRefNode(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
