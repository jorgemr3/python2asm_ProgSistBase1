package parser.ast;

import java.util.List;

public class ForNode implements ASTNode {
    private final String variable;
    private final ASTNode iterable;
    private final List<ASTNode> body;

    public ForNode(String variable, ASTNode iterable, List<ASTNode> body) {
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;
    }

    public String getVariable() {
        return variable;
    }

    public ASTNode getIterable() {
        return iterable;
    }

    public List<ASTNode> getBody() {
        return body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}