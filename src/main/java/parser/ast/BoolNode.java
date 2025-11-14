// BoolNode.java
package parser.ast;

public class BoolNode implements ASTNode {
    private final boolean value;
    
    public BoolNode(boolean value) {
        this.value = value;
    }
    
    public boolean getValue() { 
        return value; 
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}