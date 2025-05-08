// FuncCallNode.java
package parser.ast;

import java.util.List;

public class FuncCallNode implements ASTNode {
    private final String name;
    private final List<ASTNode> args;
    public FuncCallNode(String name, List<ASTNode> args) {
        this.name = name;
        this.args = args;
    }
    public String getName() { return name; }
    public List<ASTNode> getArgs() { return args; }
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
