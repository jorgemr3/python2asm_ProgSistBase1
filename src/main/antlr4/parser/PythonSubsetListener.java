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
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(PythonSubsetParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(PythonSubsetParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(PythonSubsetParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(PythonSubsetParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(PythonSubsetParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(PythonSubsetParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PythonSubsetParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PythonSubsetParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(PythonSubsetParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(PythonSubsetParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(PythonSubsetParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(PythonSubsetParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPow(PythonSubsetParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPow(PythonSubsetParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(PythonSubsetParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PythonSubsetParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(PythonSubsetParser.IntLiteralContext ctx);
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