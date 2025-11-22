// IfNode.java
package parser.ast;

import java.util.List;

public class IfNode implements ASTNode {
    private final ASTNode condition;
    private final List<ASTNode> thenBody;
    private final List<ElifClause> elifClauses;
    private final List<ASTNode> elseBody;
    
    public IfNode(ASTNode condition, List<ASTNode> thenBody, 
                  List<ElifClause> elifClauses, List<ASTNode> elseBody) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elifClauses = elifClauses;
        this.elseBody = elseBody;
    }
    
    public ASTNode getCondition() { 
        return condition; 
    }
    
    public List<ASTNode> getThenBody() { 
        return thenBody; 
    }
    
    public List<ElifClause> getElifClauses() {
        return elifClauses;
    }
    
    public List<ASTNode> getElseBody() { 
        return elseBody; 
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    // Clase interna para representar cláusulas elif
    public static class ElifClause {
        private final ASTNode condition;
        private final List<ASTNode> body;
        
        public ElifClause(ASTNode condition, List<ASTNode> body) {
            this.condition = condition;
            this.body = body;
        }
        
        public ASTNode getCondition() {
            return condition;
        }
        
        public List<ASTNode> getBody() {
            return body;
        }
    }
}
