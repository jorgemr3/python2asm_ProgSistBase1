// WhileNode.java
package parser.ast;

import java.util.List;

public class WhileNode implements ASTNode {
    private final ASTNode condition;
    private final List<ASTNode> body;
    
    public WhileNode(ASTNode condition, List<ASTNode> body) {
        this.condition = condition;
        this.body = body;
    }
    
    public ASTNode getCondition() { 
        return condition; 
    }
    
    public List<ASTNode> getBody() { 
        return body; 
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}