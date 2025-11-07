// Generated from grammar/PythonSubset.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonSubsetParser}.
 */
public interface PythonSubsetListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PythonSubsetParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PythonSubsetParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PythonSubsetParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PythonSubsetParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(PythonSubsetParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(PythonSubsetParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(PythonSubsetParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(PythonSubsetParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(PythonSubsetParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpr}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(PythonSubsetParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(PythonSubsetParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(PythonSubsetParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(PythonSubsetParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(PythonSubsetParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonSubsetParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonSubsetParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(PythonSubsetParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(PythonSubsetParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithUnary}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithUnary(PythonSubsetParser.ArithUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithUnary}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithUnary(PythonSubsetParser.ArithUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(PythonSubsetParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PythonSubsetParser#arith_expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(PythonSubsetParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(PythonSubsetParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalNot}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(PythonSubsetParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(PythonSubsetParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(PythonSubsetParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowerBase}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPowerBase(PythonSubsetParser.PowerBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowerBase}
	 * labeled alternative in {@link PythonSubsetParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPowerBase(PythonSubsetParser.PowerBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link PythonSubsetParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(PythonSubsetParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link PythonSubsetParser#power_expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(PythonSubsetParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(PythonSubsetParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(PythonSubsetParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(PythonSubsetParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(PythonSubsetParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(PythonSubsetParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(PythonSubsetParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PythonSubsetParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PythonSubsetParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(PythonSubsetParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link PythonSubsetParser#atom_expr}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(PythonSubsetParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonSubsetParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(PythonSubsetParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonSubsetParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(PythonSubsetParser.Arg_listContext ctx);
}