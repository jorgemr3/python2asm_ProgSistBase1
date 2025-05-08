// ASTNode.java
package parser.ast;

public interface ASTNode {
    <T> T accept(ASTVisitor<T> visitor);
}

