grammar Cliffhanger;

cliffhangerClass: ( WHITESPACE | statement | EOF )+;

statement: ( simpleStatement | nameBranchedStatement ) ( '\n\n' | ';' ) '\n'*;

simpleStatement: name=datapointName definition=datapointDefinition;

nameBranchedStatement: definitionReference COLON ('\n' WHITESPACE* statement)+;

definitionReference: ( typeRequest | datapointName | indexedDatapointName | WHITESPACE )+;

typeRequest: ( A | AN );

datapointName: ( WORD | WHITESPACE | substitution )+;

substitution: LFBRA WHITESPACE* ( expression | substitution ) WHITESPACE* RFBRA;

indexedDatapointName: ( datapointName ('#' index=NUMBER )? )+;

datapointDefinition: ( simpleDefinition | branchedDefinition );

simpleDefinition: (labelDefinition | valueDefinition );

labelDefinition: typeRequest WHITESPACE+ datapointName;

valueDefinition: DEF WHITESPACE+ expression (WHITESPACE+ datapointCondition)?;

branchedDefinition: DEF COLON ('\n' branchedDefinitionLine )+;

branchedDefinitionLine: ( expression | branchedDefinitionConditionLine );

branchedDefinitionConditionLine: ( branchedDefinitionSimpleConditionLine | branchedDefinitionBranchedConditionLine );

branchedDefinitionSimpleConditionLine: datapointCondition COLON ( labelDefinition | expression );

branchedDefinitionBranchedConditionLine: datapointCondition COLON ('\n' branchedDefinitionLine)+;

datapointCondition: ( datapointConditionWhen | datapointConditionBefore );

datapointConditionWhen: WHEN expression;

datapointConditionBefore: BEFORE expression;

expression
  : LPAREN WHITESPACE* expression WHITESPACE* RPAREN                #GroupedExpression
  | expression HAT<assoc=right> expression                              #PowExpr
  | MINUS WHITESPACE* expression                                        #UnaryMinusExpression
  | NOT WHITESPACE+ expression                                          #NotExpr
  | expression WHITESPACE+ op=( STAR | SLASH ) WHITESPACE+ expression               #DivMulExpression
  | expression WHITESPACE+ op=( PLUS | MINUS ) WHITESPACE+ expression   #AdditiveExpression
  | expression WHITESPACE+ op=( LTEQ | GTEQ | LT | GT ) WHITESPACE+ expression      #RelationExpression
  | expression WHITESPACE+ op=( EQ | NEQ ) WHITESPACE+ expression                   #EqualityExpression
  | expression WHITESPACE+ AND WHITESPACE+ expression                               #AndExpression
  | expression WHITESPACE+ OR WHITESPACE+ expression                                #OrExpression
  | expressionReference                                                 #ReferenceExpression
  | literal                                                             #LiteralExpression
;

expressionReference: ( THE | datapointName | WHITESPACE )+;

literal: ( NUMBER | stringLiteral | booleanLiteral );

stringLiteral: singleQuotedStringLiteral | doubleQuotedStringLiteral;

booleanLiteral: TRUE | FALSE;

singleQuotedStringLiteral: SQUOTE ( escapedSingleQuotedStringMember | singleQuotedStringMember );

escapedSingleQuotedStringMember: ( ESC_SQUOTE | commonEscapedStringMembers );

singleQuotedStringMember: ( commonStringMembers | DQUOTE );

commonEscapedStringMembers: ( UNICODE | escapedSubstitution | ESC_TAB | ESC_NEWLINE | ESC_LINERET | ESC_ESC );

commonStringMembers: substitution | TEXT;

doubleQuotedStringLiteral: DQUOTE ( escapedDoubleQuotedStringMember | doubleQuotedStringMember );

escapedDoubleQuotedStringMember: ( ESC_DQUOTE | commonEscapedStringMembers );

doubleQuotedStringMember: ( commonStringMembers | SQUOTE );

escapedSubstitution: ESC LFBRA;

/*
 * Lexer Rules
 */
SPACE: ' ';
COLON: ':';

LFBRA: '{';
RFBRA: '}';
LPAREN: '(';
RPAREN: ')';
WHITESPACE: ' ' | '\t';

ESC: '\\';
ESC_TAB: '\\t';
ESC_NEWLINE: '\\n';
ESC_LINERET: '\\r';
ESC_ESC: '\\\\';
ESC_SQUOTE: ESC SQUOTE;
ESC_DQUOTE: ESC DQUOTE;
UNICODE: ESC 'u' NUMBER;

TRUE: [Tt] [Rr] [Uu] [Ee];
FALSE: [Ff] [Aa] [Ll] [Ss] [Ee];
IS: [Ii] [Ss];
ARE: [Aa] [Rr] [Ee];
DEF: ( IS | ARE );
AN: [Aa] [Nn];
A: [Aa];
THE: [Tt] [Hh] [Ee];
WHEN: [Ww] [Hh] [Ee] [Nn];
BEFORE: [Bb] [Ee] [Ff] [Oo] [Rr] [Ee];
NOT: [Nn] [Oo] [Tt];
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
HAT: '^';
LSHIFT: '<<';
RSHIFT: '>>';
BINARY_AND: '&';
BOOLEAN_AND: 'and';

DIGIT: [0-9];
LETTER: [a-zA-Z];
SQUOTE: '\'';
DQUOTE: '"';
TEXT: ~[\\'"]+;

WORD: LETTER ( LETTER | DIGIT )+;
NUMBER: DIGIT+ ('.' DIGIT+);
