// UnaryOpNode.java
package parser.ast;

public class UnaryOpNode implements ASTNode {
    private final String op;
    private final ASTNode operand;
    
    public UnaryOpNode(String op, ASTNode operand) {
        this.op = op; 
        this.operand = operand;
    }
    
    public String getOp() { return op; }
    public ASTNode getOperand() { return operand; }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}