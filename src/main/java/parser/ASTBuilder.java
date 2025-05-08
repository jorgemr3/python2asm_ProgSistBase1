// src/main/java/parser/ASTBuilder.java
package parser;
import parser.PythonSubsetParser.StringLiteralContext;
// import parser.PythonSubsetBaseVisitor;
import parser.PythonSubsetParser.*;
import parser.ast.*;

import java.util.List;
import java.util.stream.Collectors;

public class ASTBuilder extends PythonSubsetBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProg(ProgContext ctx) {
        List<ASTNode> stmts = ctx.stmt()
                .stream()
                .map(this::visit)
                .collect(Collectors.toList());
        return new ProgNode(stmts);
    }

    @Override
    public ASTNode visitAssign_stmt(Assign_stmtContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        ASTNode expr = visit(ctx.expr());
        return new AssignNode(name, expr);
    }

    @Override
    public ASTNode visitExpr_stmt(Expr_stmtContext ctx) {
        ASTNode expr = visit(ctx.expr());
        return new ExprStmtNode(expr);
    }

    @Override
    public ASTNode visitPow(PowContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        return new BinaryOpNode("^", left, right);
    }

    @Override
    public ASTNode visitMulDivMod(MulDivModContext ctx) {
        String op = ctx.op.getText();
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitAddSub(AddSubContext ctx) {
        String op = ctx.op.getText();
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitParens(ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitIntLiteral(IntLiteralContext ctx) {
        int value = Integer.parseInt(ctx.INT().getText());
        return new IntNode(value);
    }

    @Override
    public ASTNode visitVarRef(VarRefContext ctx) {
        return new VarRefNode(ctx.IDENTIFIER().getText());
    }

    @Override
    public ASTNode visitComparison(ComparisonContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        String op = ctx.comp.getText();
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitFuncCall(PythonSubsetParser.FuncCallContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        List<ASTNode> args = ctx.arg_list() != null
                ? ctx.arg_list().expr().stream().map(this::visit).collect(Collectors.toList())
                : List.of();
        return new FuncCallNode(name, args);
    }

    @Override
    public ASTNode visitStringLiteral(StringLiteralContext ctx) {
        // ctx.STRING().getText() devuelve algo como "\"Hello\""
        String raw = ctx.STRING().getText();
        // quita las comillas de inicio y fin:
        String content = raw.substring(1, raw.length() - 1);
        return new StringNode(content);
    }

}
