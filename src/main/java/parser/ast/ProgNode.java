// ProgNode.java
package parser.ast;

import java.util.List;

public class ProgNode implements ASTNode {
    private final List<ASTNode> statements;
    public ProgNode(List<ASTNode> statements) {
        this.statements = statements;
    }
    public List<ASTNode> getStatements() { return statements; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
