// Generated from imgLang.g4 by ANTLR 4.7.2
package fp.image.lang.parse;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link imgLangParser}.
 */
public interface imgLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link imgLangParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(imgLangParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link imgLangParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(imgLangParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link imgLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(imgLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link imgLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(imgLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleTerm}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleTerm(imgLangParser.SingleTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleTerm}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleTerm(imgLangParser.SingleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(imgLangParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(imgLangParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(imgLangParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link imgLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(imgLangParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDiv(imgLangParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDiv(imgLangParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMult(imgLangParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMult(imgLangParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImageTerm}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterImageTerm(imgLangParser.ImageTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImageTerm}
	 * labeled alternative in {@link imgLangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitImageTerm(imgLangParser.ImageTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link imgLangParser#image}.
	 * @param ctx the parse tree
	 */
	void enterVar(imgLangParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link imgLangParser#image}.
	 * @param ctx the parse tree
	 */
	void exitVar(imgLangParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link imgLangParser#image}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(imgLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link imgLangParser#image}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(imgLangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link imgLangParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(imgLangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link imgLangParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(imgLangParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link imgLangParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(imgLangParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link imgLangParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(imgLangParser.PathContext ctx);
}