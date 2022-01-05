// Generated from /home/chedim/projects/cliff/parser/src/main/antlr/Cliffhanger.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CliffhangerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CliffhangerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(CliffhangerParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CliffhangerParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(CliffhangerParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#nameBranchedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameBranchedStatement(CliffhangerParser.NameBranchedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#definitionReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionReference(CliffhangerParser.DefinitionReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#typeRequest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRequest(CliffhangerParser.TypeRequestContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#datapointName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapointName(CliffhangerParser.DatapointNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#substitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitution(CliffhangerParser.SubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#indexedDatapointName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedDatapointName(CliffhangerParser.IndexedDatapointNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#datapointDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapointDefinition(CliffhangerParser.DatapointDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#simpleDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDefinition(CliffhangerParser.SimpleDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#labelDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDefinition(CliffhangerParser.LabelDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#valueDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueDefinition(CliffhangerParser.ValueDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#branchedDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchedDefinition(CliffhangerParser.BranchedDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#branchedDefinitionLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchedDefinitionLine(CliffhangerParser.BranchedDefinitionLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#branchedDefinitionConditionLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchedDefinitionConditionLine(CliffhangerParser.BranchedDefinitionConditionLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#branchedDefinitionSimpleConditionLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchedDefinitionSimpleConditionLine(CliffhangerParser.BranchedDefinitionSimpleConditionLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#branchedDefinitionBranchedConditionLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchedDefinitionBranchedConditionLine(CliffhangerParser.BranchedDefinitionBranchedConditionLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#datapointCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapointCondition(CliffhangerParser.DatapointConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#datapointConditionWhen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapointConditionWhen(CliffhangerParser.DatapointConditionWhenContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#datapointConditionBefore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatapointConditionBefore(CliffhangerParser.DatapointConditionBeforeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivMulExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivMulExpression(CliffhangerParser.DivMulExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(CliffhangerParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CliffhangerParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(CliffhangerParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(CliffhangerParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(CliffhangerParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PowExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(CliffhangerParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReferenceExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceExpression(CliffhangerParser.ReferenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(CliffhangerParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(CliffhangerParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(CliffhangerParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(CliffhangerParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#expressionReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionReference(CliffhangerParser.ExpressionReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CliffhangerParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(CliffhangerParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(CliffhangerParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#singleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuotedStringLiteral(CliffhangerParser.SingleQuotedStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#escapedSingleQuotedStringMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapedSingleQuotedStringMember(CliffhangerParser.EscapedSingleQuotedStringMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#singleQuotedStringMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleQuotedStringMember(CliffhangerParser.SingleQuotedStringMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#commonEscapedStringMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonEscapedStringMembers(CliffhangerParser.CommonEscapedStringMembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#commonStringMembers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonStringMembers(CliffhangerParser.CommonStringMembersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#doubleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuotedStringLiteral(CliffhangerParser.DoubleQuotedStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#escapedDoubleQuotedStringMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapedDoubleQuotedStringMember(CliffhangerParser.EscapedDoubleQuotedStringMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#doubleQuotedStringMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleQuotedStringMember(CliffhangerParser.DoubleQuotedStringMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CliffhangerParser#escapedSubstitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscapedSubstitution(CliffhangerParser.EscapedSubstitutionContext ctx);
}