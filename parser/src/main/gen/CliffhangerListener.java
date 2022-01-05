// Generated from /home/chedim/projects/cliff/parser/src/main/antlr/Cliffhanger.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CliffhangerParser}.
 */
public interface CliffhangerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(CliffhangerParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(CliffhangerParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CliffhangerParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CliffhangerParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(CliffhangerParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(CliffhangerParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#nameBranchedStatement}.
	 * @param ctx the parse tree
	 */
	void enterNameBranchedStatement(CliffhangerParser.NameBranchedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#nameBranchedStatement}.
	 * @param ctx the parse tree
	 */
	void exitNameBranchedStatement(CliffhangerParser.NameBranchedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#definitionReference}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionReference(CliffhangerParser.DefinitionReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#definitionReference}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionReference(CliffhangerParser.DefinitionReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#typeRequest}.
	 * @param ctx the parse tree
	 */
	void enterTypeRequest(CliffhangerParser.TypeRequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#typeRequest}.
	 * @param ctx the parse tree
	 */
	void exitTypeRequest(CliffhangerParser.TypeRequestContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#datapointName}.
	 * @param ctx the parse tree
	 */
	void enterDatapointName(CliffhangerParser.DatapointNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#datapointName}.
	 * @param ctx the parse tree
	 */
	void exitDatapointName(CliffhangerParser.DatapointNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#substitution}.
	 * @param ctx the parse tree
	 */
	void enterSubstitution(CliffhangerParser.SubstitutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#substitution}.
	 * @param ctx the parse tree
	 */
	void exitSubstitution(CliffhangerParser.SubstitutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#indexedDatapointName}.
	 * @param ctx the parse tree
	 */
	void enterIndexedDatapointName(CliffhangerParser.IndexedDatapointNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#indexedDatapointName}.
	 * @param ctx the parse tree
	 */
	void exitIndexedDatapointName(CliffhangerParser.IndexedDatapointNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#datapointDefinition}.
	 * @param ctx the parse tree
	 */
	void enterDatapointDefinition(CliffhangerParser.DatapointDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#datapointDefinition}.
	 * @param ctx the parse tree
	 */
	void exitDatapointDefinition(CliffhangerParser.DatapointDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#simpleDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDefinition(CliffhangerParser.SimpleDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#simpleDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDefinition(CliffhangerParser.SimpleDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void enterLabelDefinition(CliffhangerParser.LabelDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#labelDefinition}.
	 * @param ctx the parse tree
	 */
	void exitLabelDefinition(CliffhangerParser.LabelDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#valueDefinition}.
	 * @param ctx the parse tree
	 */
	void enterValueDefinition(CliffhangerParser.ValueDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#valueDefinition}.
	 * @param ctx the parse tree
	 */
	void exitValueDefinition(CliffhangerParser.ValueDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#branchedDefinition}.
	 * @param ctx the parse tree
	 */
	void enterBranchedDefinition(CliffhangerParser.BranchedDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#branchedDefinition}.
	 * @param ctx the parse tree
	 */
	void exitBranchedDefinition(CliffhangerParser.BranchedDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#branchedDefinitionLine}.
	 * @param ctx the parse tree
	 */
	void enterBranchedDefinitionLine(CliffhangerParser.BranchedDefinitionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#branchedDefinitionLine}.
	 * @param ctx the parse tree
	 */
	void exitBranchedDefinitionLine(CliffhangerParser.BranchedDefinitionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#branchedDefinitionConditionLine}.
	 * @param ctx the parse tree
	 */
	void enterBranchedDefinitionConditionLine(CliffhangerParser.BranchedDefinitionConditionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#branchedDefinitionConditionLine}.
	 * @param ctx the parse tree
	 */
	void exitBranchedDefinitionConditionLine(CliffhangerParser.BranchedDefinitionConditionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#branchedDefinitionSimpleConditionLine}.
	 * @param ctx the parse tree
	 */
	void enterBranchedDefinitionSimpleConditionLine(CliffhangerParser.BranchedDefinitionSimpleConditionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#branchedDefinitionSimpleConditionLine}.
	 * @param ctx the parse tree
	 */
	void exitBranchedDefinitionSimpleConditionLine(CliffhangerParser.BranchedDefinitionSimpleConditionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#branchedDefinitionBranchedConditionLine}.
	 * @param ctx the parse tree
	 */
	void enterBranchedDefinitionBranchedConditionLine(CliffhangerParser.BranchedDefinitionBranchedConditionLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#branchedDefinitionBranchedConditionLine}.
	 * @param ctx the parse tree
	 */
	void exitBranchedDefinitionBranchedConditionLine(CliffhangerParser.BranchedDefinitionBranchedConditionLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#datapointCondition}.
	 * @param ctx the parse tree
	 */
	void enterDatapointCondition(CliffhangerParser.DatapointConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#datapointCondition}.
	 * @param ctx the parse tree
	 */
	void exitDatapointCondition(CliffhangerParser.DatapointConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#datapointConditionWhen}.
	 * @param ctx the parse tree
	 */
	void enterDatapointConditionWhen(CliffhangerParser.DatapointConditionWhenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#datapointConditionWhen}.
	 * @param ctx the parse tree
	 */
	void exitDatapointConditionWhen(CliffhangerParser.DatapointConditionWhenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#datapointConditionBefore}.
	 * @param ctx the parse tree
	 */
	void enterDatapointConditionBefore(CliffhangerParser.DatapointConditionBeforeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#datapointConditionBefore}.
	 * @param ctx the parse tree
	 */
	void exitDatapointConditionBefore(CliffhangerParser.DatapointConditionBeforeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivMulExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivMulExpression(CliffhangerParser.DivMulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivMulExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivMulExpression(CliffhangerParser.DivMulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(CliffhangerParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(CliffhangerParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(CliffhangerParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(CliffhangerParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(CliffhangerParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(CliffhangerParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpression(CliffhangerParser.RelationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpression(CliffhangerParser.RelationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(CliffhangerParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(CliffhangerParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(CliffhangerParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(CliffhangerParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReferenceExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReferenceExpression(CliffhangerParser.ReferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReferenceExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReferenceExpression(CliffhangerParser.ReferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(CliffhangerParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(CliffhangerParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(CliffhangerParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(CliffhangerParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(CliffhangerParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(CliffhangerParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(CliffhangerParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrExpression}
	 * labeled alternative in {@link CliffhangerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(CliffhangerParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#expressionReference}.
	 * @param ctx the parse tree
	 */
	void enterExpressionReference(CliffhangerParser.ExpressionReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#expressionReference}.
	 * @param ctx the parse tree
	 */
	void exitExpressionReference(CliffhangerParser.ExpressionReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CliffhangerParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CliffhangerParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(CliffhangerParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(CliffhangerParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(CliffhangerParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(CliffhangerParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#singleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuotedStringLiteral(CliffhangerParser.SingleQuotedStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#singleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuotedStringLiteral(CliffhangerParser.SingleQuotedStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#escapedSingleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void enterEscapedSingleQuotedStringMember(CliffhangerParser.EscapedSingleQuotedStringMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#escapedSingleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void exitEscapedSingleQuotedStringMember(CliffhangerParser.EscapedSingleQuotedStringMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#singleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void enterSingleQuotedStringMember(CliffhangerParser.SingleQuotedStringMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#singleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void exitSingleQuotedStringMember(CliffhangerParser.SingleQuotedStringMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#commonEscapedStringMembers}.
	 * @param ctx the parse tree
	 */
	void enterCommonEscapedStringMembers(CliffhangerParser.CommonEscapedStringMembersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#commonEscapedStringMembers}.
	 * @param ctx the parse tree
	 */
	void exitCommonEscapedStringMembers(CliffhangerParser.CommonEscapedStringMembersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#commonStringMembers}.
	 * @param ctx the parse tree
	 */
	void enterCommonStringMembers(CliffhangerParser.CommonStringMembersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#commonStringMembers}.
	 * @param ctx the parse tree
	 */
	void exitCommonStringMembers(CliffhangerParser.CommonStringMembersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#doubleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuotedStringLiteral(CliffhangerParser.DoubleQuotedStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#doubleQuotedStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuotedStringLiteral(CliffhangerParser.DoubleQuotedStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#escapedDoubleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void enterEscapedDoubleQuotedStringMember(CliffhangerParser.EscapedDoubleQuotedStringMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#escapedDoubleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void exitEscapedDoubleQuotedStringMember(CliffhangerParser.EscapedDoubleQuotedStringMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#doubleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void enterDoubleQuotedStringMember(CliffhangerParser.DoubleQuotedStringMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#doubleQuotedStringMember}.
	 * @param ctx the parse tree
	 */
	void exitDoubleQuotedStringMember(CliffhangerParser.DoubleQuotedStringMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CliffhangerParser#escapedSubstitution}.
	 * @param ctx the parse tree
	 */
	void enterEscapedSubstitution(CliffhangerParser.EscapedSubstitutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CliffhangerParser#escapedSubstitution}.
	 * @param ctx the parse tree
	 */
	void exitEscapedSubstitution(CliffhangerParser.EscapedSubstitutionContext ctx);
}