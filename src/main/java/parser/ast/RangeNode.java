package parser.ast;

import java.util.List;

public class RangeNode implements ASTNode {
    private final List<ASTNode> args;

    public RangeNode(List<ASTNode> args) {
        this.args = args;
    }

    public List<ASTNode> getArgs() {
        return args;
    }

    public int getStart() {
        if (args.size() == 1) {
            return 0; // range(stop)
        } else {
            // range(start, stop) o range(start, stop, step)
            return ((IntNode) args.get(0)).getValue();
        }
    }

    public int getStop() {
        if (args.size() == 1) {
            return ((IntNode) args.get(0)).getValue(); // range(stop)
        } else {
            return ((IntNode) args.get(1)).getValue(); // range(start, stop) o range(start, stop, step)
        }
    }

    public int getStep() {
        if (args.size() == 3) {
            return ((IntNode) args.get(2)).getValue(); // range(start, stop, step)
        } else {
            return 1; // default step
        }
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}