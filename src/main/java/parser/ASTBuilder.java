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
    public ASTNode visitStmt(StmtContext ctx) {
        if (ctx.simple_stmt() != null) {
            return visit(ctx.simple_stmt());
        } else {
            return visit(ctx.compound_stmt());
        }
    }

    @Override
    public ASTNode visitSimple_stmt(Simple_stmtContext ctx) {
        if (ctx.assign_stmt() != null) {
            return visit(ctx.assign_stmt());
        } else {
            return visit(ctx.expr_stmt());
        }
    }

    @Override
    public ASTNode visitCompound_stmt(Compound_stmtContext ctx) {
        if (ctx.for_stmt() != null) {
            return visit(ctx.for_stmt());
        } else {
            return visit(ctx.while_stmt());
        }
    }

    // ===== NUEVOS MÉTODOS PARA LA GRAMÁTICA ACTUALIZADA =====
    
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

    // ===== NUEVOS MÉTODOS PARA LA GRAMÁTICA ACTUALIZADA =====
    
    // expr rules
    @Override
    public ASTNode visitLogicalOr(LogicalOrContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        return new BinaryOpNode("or", left, right);
    }

    @Override
    public ASTNode visitLogicalAnd(LogicalAndContext ctx) {
        ASTNode left = visit(ctx.expr(0));
        ASTNode right = visit(ctx.expr(1));
        return new BinaryOpNode("and", left, right);
    }

    @Override
    public ASTNode visitComparisonExpr(ComparisonExprContext ctx) {
        return visit(ctx.comparison());
    }

    // comparison rule
    @Override
    public ASTNode visitComparison(ComparisonContext ctx) {
        ASTNode left = visit(ctx.arith_expr(0));
        if (ctx.arith_expr().size() > 1) {
            String op = ctx.comp.getText();
            ASTNode right = visit(ctx.arith_expr(1));
            return new BinaryOpNode(op, left, right);
        }
        return left;
    }

    // arith_expr rules
    @Override
    public ASTNode visitAddSub(AddSubContext ctx) {
        String op = ctx.op.getText();
        ASTNode left = visit(ctx.arith_expr(0));
        ASTNode right = visit(ctx.arith_expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitMulDivMod(MulDivModContext ctx) {
        String op = ctx.op.getText();
        ASTNode left = visit(ctx.arith_expr(0));
        ASTNode right = visit(ctx.arith_expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitArithUnary(ArithUnaryContext ctx) {
        return visit(ctx.unary_expr());
    }

    // unary_expr rules
    @Override
    public ASTNode visitLogicalNot(LogicalNotContext ctx) {
        ASTNode operand = visit(ctx.unary_expr());
        return new UnaryOpNode("not", operand);
    }

    @Override
    public ASTNode visitUnaryOp(UnaryOpContext ctx) {
        String op = ctx.getChild(0).getText(); // '+' o '-'
        ASTNode operand = visit(ctx.unary_expr());
        return new UnaryOpNode(op, operand);
    }

    @Override
    public ASTNode visitPowerBase(PowerBaseContext ctx) {
        return visit(ctx.power_expr());
    }

    // power_expr rule
    @Override
    public ASTNode visitPower(PowerContext ctx) {
        ASTNode base = visit(ctx.atom_expr());
        if (ctx.unary_expr() != null) {
            ASTNode exponent = visit(ctx.unary_expr());
            return new BinaryOpNode("**", base, exponent);
        }
        return base;
    }

    // atom_expr rules - ya existían, solo actualizo nombres si es necesario

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
    public ASTNode visitTrueLiteral(TrueLiteralContext ctx) {
        return new BoolNode(true);
    }

    @Override
    public ASTNode visitFalseLiteral(FalseLiteralContext ctx) {
        return new BoolNode(false);
    }

    @Override
    public ASTNode visitVarRef(VarRefContext ctx) {
        return new VarRefNode(ctx.IDENTIFIER().getText());
    }

    // @Override
    // public ASTNode visitComparison(ComparisonContext ctx) {
    //     ASTNode left = visit(ctx.expr(0));
    //     ASTNode right = visit(ctx.expr(1));
    //     String op = ctx.comp.getText();
    //     return new BinaryOpNode(op, left, right);
    // }

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

    // ===== NUEVOS MÉTODOS PARA FOR LOOPS =====

    @Override
    public ASTNode visitFor_stmt(For_stmtContext ctx) {
        String variable = ctx.IDENTIFIER().getText();
        ASTNode iterable = visit(ctx.iterable());
        
        // Procesar directamente los statements del bloque indentado
        List<ASTNode> body = ctx.stmt()
                .stream()
                .map(this::visit)
                .collect(Collectors.toList());
        
        return new ForNode(variable, iterable, body);
    }

    @Override
    public ASTNode visitWhile_stmt(While_stmtContext ctx) {
        ASTNode condition = visit(ctx.expr());
        
        // Procesar directamente los statements del bloque indentado
        List<ASTNode> body = ctx.stmt()
                .stream()
                .map(this::visit)
                .collect(Collectors.toList());
        
        return new WhileNode(condition, body);
    }

    @Override
    public ASTNode visitIterable(IterableContext ctx) {
        if (ctx.range_call() != null) {
            return visit(ctx.range_call());
        } else {
            return visit(ctx.expr());
        }
    }

    @Override
    public ASTNode visitRange_call(Range_callContext ctx) {
        return visit(ctx.range_args());
    }

    @Override
    public ASTNode visitRangeStop(RangeStopContext ctx) {
        List<ASTNode> args = List.of(visit(ctx.expr()));
        return new RangeNode(args);
    }

    @Override
    public ASTNode visitRangeStartStop(RangeStartStopContext ctx) {
        List<ASTNode> args = List.of(
            visit(ctx.expr(0)),  // start
            visit(ctx.expr(1))   // stop
        );
        return new RangeNode(args);
    }

    @Override
    public ASTNode visitRangeStartStopStep(RangeStartStopStepContext ctx) {
        List<ASTNode> args = List.of(
            visit(ctx.expr(0)),  // start
            visit(ctx.expr(1)),  // stop
            visit(ctx.expr(2))   // step
        );
        return new RangeNode(args);
    }

}
