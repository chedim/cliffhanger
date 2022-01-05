// Generated from /home/chedim/projects/cliff/parser/src/main/antlr/Cliffhanger.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CliffhangerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, SPACE=4, COLON=5, LFBRA=6, RFBRA=7, LPAREN=8, 
		RPAREN=9, WHITESPACE=10, ESC=11, ESC_TAB=12, ESC_NEWLINE=13, ESC_LINERET=14, 
		ESC_ESC=15, ESC_SQUOTE=16, ESC_DQUOTE=17, UNICODE=18, TRUE=19, FALSE=20, 
		IS=21, ARE=22, DEF=23, AN=24, A=25, THE=26, WHEN=27, BEFORE=28, NOT=29, 
		PLUS=30, MINUS=31, STAR=32, SLASH=33, HAT=34, LSHIFT=35, RSHIFT=36, BINARY_AND=37, 
		BOOLEAN_AND=38, DIGIT=39, LETTER=40, SQUOTE=41, DQUOTE=42, TEXT=43, WORD=44, 
		NUMBER=45, LTEQ=46, GTEQ=47, LT=48, GT=49, EQ=50, NEQ=51, AND=52, OR=53;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_simpleStatement = 2, RULE_nameBranchedStatement = 3, 
		RULE_definitionReference = 4, RULE_typeRequest = 5, RULE_datapointName = 6, 
		RULE_substitution = 7, RULE_indexedDatapointName = 8, RULE_datapointDefinition = 9, 
		RULE_simpleDefinition = 10, RULE_labelDefinition = 11, RULE_valueDefinition = 12, 
		RULE_branchedDefinition = 13, RULE_branchedDefinitionLine = 14, RULE_branchedDefinitionConditionLine = 15, 
		RULE_branchedDefinitionSimpleConditionLine = 16, RULE_branchedDefinitionBranchedConditionLine = 17, 
		RULE_datapointCondition = 18, RULE_datapointConditionWhen = 19, RULE_datapointConditionBefore = 20, 
		RULE_expression = 21, RULE_expressionReference = 22, RULE_literal = 23, 
		RULE_stringLiteral = 24, RULE_booleanLiteral = 25, RULE_singleQuotedStringLiteral = 26, 
		RULE_escapedSingleQuotedStringMember = 27, RULE_singleQuotedStringMember = 28, 
		RULE_commonEscapedStringMembers = 29, RULE_commonStringMembers = 30, RULE_doubleQuotedStringLiteral = 31, 
		RULE_escapedDoubleQuotedStringMember = 32, RULE_doubleQuotedStringMember = 33, 
		RULE_escapedSubstitution = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "simpleStatement", "nameBranchedStatement", "definitionReference", 
			"typeRequest", "datapointName", "substitution", "indexedDatapointName", 
			"datapointDefinition", "simpleDefinition", "labelDefinition", "valueDefinition", 
			"branchedDefinition", "branchedDefinitionLine", "branchedDefinitionConditionLine", 
			"branchedDefinitionSimpleConditionLine", "branchedDefinitionBranchedConditionLine", 
			"datapointCondition", "datapointConditionWhen", "datapointConditionBefore", 
			"expression", "expressionReference", "literal", "stringLiteral", "booleanLiteral", 
			"singleQuotedStringLiteral", "escapedSingleQuotedStringMember", "singleQuotedStringMember", 
			"commonEscapedStringMembers", "commonStringMembers", "doubleQuotedStringLiteral", 
			"escapedDoubleQuotedStringMember", "doubleQuotedStringMember", "escapedSubstitution"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "';'", "'#'", "' '", "':'", "'{'", "'}'", "'('", "')'", 
			null, "'\\'", "'\\t'", "'\\n'", "'\\r'", "'\\\\'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "'^'", "'<<'", "'>>'", "'&'", "'and'", null, null, 
			"'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "SPACE", "COLON", "LFBRA", "RFBRA", "LPAREN", 
			"RPAREN", "WHITESPACE", "ESC", "ESC_TAB", "ESC_NEWLINE", "ESC_LINERET", 
			"ESC_ESC", "ESC_SQUOTE", "ESC_DQUOTE", "UNICODE", "TRUE", "FALSE", "IS", 
			"ARE", "DEF", "AN", "A", "THE", "WHEN", "BEFORE", "NOT", "PLUS", "MINUS", 
			"STAR", "SLASH", "HAT", "LSHIFT", "RSHIFT", "BINARY_AND", "BOOLEAN_AND", 
			"DIGIT", "LETTER", "SQUOTE", "DQUOTE", "TEXT", "WORD", "NUMBER", "LTEQ", 
			"GTEQ", "LT", "GT", "EQ", "NEQ", "AND", "OR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cliffhanger.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CliffhangerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				statement();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LFBRA) | (1L << WHITESPACE) | (1L << AN) | (1L << A) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public NameBranchedStatementContext nameBranchedStatement() {
			return getRuleContext(NameBranchedStatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CliffhangerParser.EOF, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(75);
				simpleStatement();
				}
				break;
			case 2:
				{
				setState(76);
				nameBranchedStatement();
				}
				break;
			}
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(79);
				match(T__0);
				2,
				}
				break;
			case T__1:
				{
				setState(81);
				match(T__1);
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(82);
						match(T__0);
						}
						} 
					}
					setState(87);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				break;
			case EOF:
				{
				setState(88);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleStatementContext extends ParserRuleContext {
		public DatapointNameContext name;
		public DatapointDefinitionContext definition;
		public DatapointNameContext datapointName() {
			return getRuleContext(DatapointNameContext.class,0);
		}
		public DatapointDefinitionContext datapointDefinition() {
			return getRuleContext(DatapointDefinitionContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitSimpleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((SimpleStatementContext)_localctx).name = datapointName();
			setState(92);
			((SimpleStatementContext)_localctx).definition = datapointDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameBranchedStatementContext extends ParserRuleContext {
		public DefinitionReferenceContext definitionReference() {
			return getRuleContext(DefinitionReferenceContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CliffhangerParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public NameBranchedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameBranchedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterNameBranchedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitNameBranchedStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitNameBranchedStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameBranchedStatementContext nameBranchedStatement() throws RecognitionException {
		NameBranchedStatementContext _localctx = new NameBranchedStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nameBranchedStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			definitionReference();
			setState(95);
			match(COLON);
			setState(104); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(96);
					match(T__0);
					setState(100);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(97);
							match(WHITESPACE);
							}
							} 
						}
						setState(102);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					}
					setState(103);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(106); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionReferenceContext extends ParserRuleContext {
		public List<TypeRequestContext> typeRequest() {
			return getRuleContexts(TypeRequestContext.class);
		}
		public TypeRequestContext typeRequest(int i) {
			return getRuleContext(TypeRequestContext.class,i);
		}
		public List<DatapointNameContext> datapointName() {
			return getRuleContexts(DatapointNameContext.class);
		}
		public DatapointNameContext datapointName(int i) {
			return getRuleContext(DatapointNameContext.class,i);
		}
		public List<IndexedDatapointNameContext> indexedDatapointName() {
			return getRuleContexts(IndexedDatapointNameContext.class);
		}
		public IndexedDatapointNameContext indexedDatapointName(int i) {
			return getRuleContext(IndexedDatapointNameContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public DefinitionReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDefinitionReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDefinitionReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDefinitionReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionReferenceContext definitionReference() throws RecognitionException {
		DefinitionReferenceContext _localctx = new DefinitionReferenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definitionReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(112);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(108);
					typeRequest();
					}
					break;
				case 2:
					{
					setState(109);
					datapointName();
					}
					break;
				case 3:
					{
					setState(110);
					indexedDatapointName();
					}
					break;
				case 4:
					{
					setState(111);
					match(WHITESPACE);
					}
					break;
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LFBRA) | (1L << WHITESPACE) | (1L << AN) | (1L << A) | (1L << WORD))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeRequestContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(CliffhangerParser.A, 0); }
		public TerminalNode AN() { return getToken(CliffhangerParser.AN, 0); }
		public TypeRequestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRequest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterTypeRequest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitTypeRequest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitTypeRequest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRequestContext typeRequest() throws RecognitionException {
		TypeRequestContext _localctx = new TypeRequestContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeRequest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==AN || _la==A) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapointNameContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(CliffhangerParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(CliffhangerParser.WORD, i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public List<SubstitutionContext> substitution() {
			return getRuleContexts(SubstitutionContext.class);
		}
		public SubstitutionContext substitution(int i) {
			return getRuleContext(SubstitutionContext.class,i);
		}
		public DatapointNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapointName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDatapointName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDatapointName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDatapointName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapointNameContext datapointName() throws RecognitionException {
		DatapointNameContext _localctx = new DatapointNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_datapointName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(121);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(118);
						match(WORD);
						}
						break;
					case WHITESPACE:
						{
						setState(119);
						match(WHITESPACE);
						}
						break;
					case LFBRA:
						{
						setState(120);
						substitution();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(123); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubstitutionContext extends ParserRuleContext {
		public TerminalNode LFBRA() { return getToken(CliffhangerParser.LFBRA, 0); }
		public TerminalNode RFBRA() { return getToken(CliffhangerParser.RFBRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubstitutionContext substitution() {
			return getRuleContext(SubstitutionContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public SubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstitutionContext substitution() throws RecognitionException {
		SubstitutionContext _localctx = new SubstitutionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_substitution);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(LFBRA);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					match(WHITESPACE);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(132);
				expression(0);
				}
				break;
			case 2:
				{
				setState(133);
				substitution();
				}
				break;
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(136);
				match(WHITESPACE);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(RFBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexedDatapointNameContext extends ParserRuleContext {
		public Token index;
		public List<DatapointNameContext> datapointName() {
			return getRuleContexts(DatapointNameContext.class);
		}
		public DatapointNameContext datapointName(int i) {
			return getRuleContext(DatapointNameContext.class,i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CliffhangerParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CliffhangerParser.NUMBER, i);
		}
		public IndexedDatapointNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexedDatapointName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterIndexedDatapointName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitIndexedDatapointName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitIndexedDatapointName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexedDatapointNameContext indexedDatapointName() throws RecognitionException {
		IndexedDatapointNameContext _localctx = new IndexedDatapointNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_indexedDatapointName);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(144);
					datapointName();
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__2) {
						{
						setState(145);
						match(T__2);
						setState(146);
						((IndexedDatapointNameContext)_localctx).index = match(NUMBER);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(151); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapointDefinitionContext extends ParserRuleContext {
		public SimpleDefinitionContext simpleDefinition() {
			return getRuleContext(SimpleDefinitionContext.class,0);
		}
		public BranchedDefinitionContext branchedDefinition() {
			return getRuleContext(BranchedDefinitionContext.class,0);
		}
		public DatapointDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapointDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDatapointDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDatapointDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDatapointDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapointDefinitionContext datapointDefinition() throws RecognitionException {
		DatapointDefinitionContext _localctx = new DatapointDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_datapointDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(153);
				simpleDefinition();
				}
				break;
			case 2:
				{
				setState(154);
				branchedDefinition();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleDefinitionContext extends ParserRuleContext {
		public LabelDefinitionContext labelDefinition() {
			return getRuleContext(LabelDefinitionContext.class,0);
		}
		public ValueDefinitionContext valueDefinition() {
			return getRuleContext(ValueDefinitionContext.class,0);
		}
		public SimpleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterSimpleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitSimpleDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitSimpleDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleDefinitionContext simpleDefinition() throws RecognitionException {
		SimpleDefinitionContext _localctx = new SimpleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_simpleDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AN:
			case A:
				{
				setState(157);
				labelDefinition();
				}
				break;
			case DEF:
				{
				setState(158);
				valueDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelDefinitionContext extends ParserRuleContext {
		public TypeRequestContext typeRequest() {
			return getRuleContext(TypeRequestContext.class,0);
		}
		public DatapointNameContext datapointName() {
			return getRuleContext(DatapointNameContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public LabelDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterLabelDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitLabelDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitLabelDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelDefinitionContext labelDefinition() throws RecognitionException {
		LabelDefinitionContext _localctx = new LabelDefinitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_labelDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			typeRequest();
			setState(163); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(162);
					match(WHITESPACE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(165); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(167);
			datapointName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueDefinitionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(CliffhangerParser.DEF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public DatapointConditionContext datapointCondition() {
			return getRuleContext(DatapointConditionContext.class,0);
		}
		public ValueDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterValueDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitValueDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitValueDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueDefinitionContext valueDefinition() throws RecognitionException {
		ValueDefinitionContext _localctx = new ValueDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(DEF);
			setState(171); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(170);
					match(WHITESPACE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(173); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(175);
			expression(0);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHITESPACE) {
				{
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					match(WHITESPACE);
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHITESPACE );
				setState(181);
				datapointCondition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchedDefinitionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(CliffhangerParser.DEF, 0); }
		public TerminalNode COLON() { return getToken(CliffhangerParser.COLON, 0); }
		public List<BranchedDefinitionLineContext> branchedDefinitionLine() {
			return getRuleContexts(BranchedDefinitionLineContext.class);
		}
		public BranchedDefinitionLineContext branchedDefinitionLine(int i) {
			return getRuleContext(BranchedDefinitionLineContext.class,i);
		}
		public BranchedDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchedDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBranchedDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBranchedDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBranchedDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchedDefinitionContext branchedDefinition() throws RecognitionException {
		BranchedDefinitionContext _localctx = new BranchedDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_branchedDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(DEF);
			setState(185);
			match(COLON);
			setState(188); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(186);
					match(T__0);
					setState(187);
					branchedDefinitionLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(190); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchedDefinitionLineContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BranchedDefinitionConditionLineContext branchedDefinitionConditionLine() {
			return getRuleContext(BranchedDefinitionConditionLineContext.class,0);
		}
		public BranchedDefinitionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchedDefinitionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBranchedDefinitionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBranchedDefinitionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBranchedDefinitionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchedDefinitionLineContext branchedDefinitionLine() throws RecognitionException {
		BranchedDefinitionLineContext _localctx = new BranchedDefinitionLineContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_branchedDefinitionLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LFBRA:
			case LPAREN:
			case WHITESPACE:
			case TRUE:
			case FALSE:
			case THE:
			case NOT:
			case MINUS:
			case SQUOTE:
			case DQUOTE:
			case WORD:
			case NUMBER:
				{
				setState(192);
				expression(0);
				}
				break;
			case WHEN:
			case BEFORE:
				{
				setState(193);
				branchedDefinitionConditionLine();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchedDefinitionConditionLineContext extends ParserRuleContext {
		public BranchedDefinitionSimpleConditionLineContext branchedDefinitionSimpleConditionLine() {
			return getRuleContext(BranchedDefinitionSimpleConditionLineContext.class,0);
		}
		public BranchedDefinitionBranchedConditionLineContext branchedDefinitionBranchedConditionLine() {
			return getRuleContext(BranchedDefinitionBranchedConditionLineContext.class,0);
		}
		public BranchedDefinitionConditionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchedDefinitionConditionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBranchedDefinitionConditionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBranchedDefinitionConditionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBranchedDefinitionConditionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchedDefinitionConditionLineContext branchedDefinitionConditionLine() throws RecognitionException {
		BranchedDefinitionConditionLineContext _localctx = new BranchedDefinitionConditionLineContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_branchedDefinitionConditionLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(196);
				branchedDefinitionSimpleConditionLine();
				}
				break;
			case 2:
				{
				setState(197);
				branchedDefinitionBranchedConditionLine();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchedDefinitionSimpleConditionLineContext extends ParserRuleContext {
		public DatapointConditionContext datapointCondition() {
			return getRuleContext(DatapointConditionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CliffhangerParser.COLON, 0); }
		public LabelDefinitionContext labelDefinition() {
			return getRuleContext(LabelDefinitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BranchedDefinitionSimpleConditionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchedDefinitionSimpleConditionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBranchedDefinitionSimpleConditionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBranchedDefinitionSimpleConditionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBranchedDefinitionSimpleConditionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchedDefinitionSimpleConditionLineContext branchedDefinitionSimpleConditionLine() throws RecognitionException {
		BranchedDefinitionSimpleConditionLineContext _localctx = new BranchedDefinitionSimpleConditionLineContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_branchedDefinitionSimpleConditionLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			datapointCondition();
			setState(201);
			match(COLON);
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AN:
			case A:
				{
				setState(202);
				labelDefinition();
				}
				break;
			case LFBRA:
			case LPAREN:
			case WHITESPACE:
			case TRUE:
			case FALSE:
			case THE:
			case NOT:
			case MINUS:
			case SQUOTE:
			case DQUOTE:
			case WORD:
			case NUMBER:
				{
				setState(203);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchedDefinitionBranchedConditionLineContext extends ParserRuleContext {
		public DatapointConditionContext datapointCondition() {
			return getRuleContext(DatapointConditionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CliffhangerParser.COLON, 0); }
		public List<BranchedDefinitionLineContext> branchedDefinitionLine() {
			return getRuleContexts(BranchedDefinitionLineContext.class);
		}
		public BranchedDefinitionLineContext branchedDefinitionLine(int i) {
			return getRuleContext(BranchedDefinitionLineContext.class,i);
		}
		public BranchedDefinitionBranchedConditionLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchedDefinitionBranchedConditionLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBranchedDefinitionBranchedConditionLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBranchedDefinitionBranchedConditionLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBranchedDefinitionBranchedConditionLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchedDefinitionBranchedConditionLineContext branchedDefinitionBranchedConditionLine() throws RecognitionException {
		BranchedDefinitionBranchedConditionLineContext _localctx = new BranchedDefinitionBranchedConditionLineContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_branchedDefinitionBranchedConditionLine);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			datapointCondition();
			setState(207);
			match(COLON);
			setState(210); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(208);
					match(T__0);
					setState(209);
					branchedDefinitionLine();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(212); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapointConditionContext extends ParserRuleContext {
		public DatapointConditionWhenContext datapointConditionWhen() {
			return getRuleContext(DatapointConditionWhenContext.class,0);
		}
		public DatapointConditionBeforeContext datapointConditionBefore() {
			return getRuleContext(DatapointConditionBeforeContext.class,0);
		}
		public DatapointConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapointCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDatapointCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDatapointCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDatapointCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapointConditionContext datapointCondition() throws RecognitionException {
		DatapointConditionContext _localctx = new DatapointConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_datapointCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHEN:
				{
				setState(214);
				datapointConditionWhen();
				}
				break;
			case BEFORE:
				{
				setState(215);
				datapointConditionBefore();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapointConditionWhenContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(CliffhangerParser.WHEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DatapointConditionWhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapointConditionWhen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDatapointConditionWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDatapointConditionWhen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDatapointConditionWhen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapointConditionWhenContext datapointConditionWhen() throws RecognitionException {
		DatapointConditionWhenContext _localctx = new DatapointConditionWhenContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_datapointConditionWhen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(WHEN);
			setState(219);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatapointConditionBeforeContext extends ParserRuleContext {
		public TerminalNode BEFORE() { return getToken(CliffhangerParser.BEFORE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DatapointConditionBeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datapointConditionBefore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDatapointConditionBefore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDatapointConditionBefore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDatapointConditionBefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatapointConditionBeforeContext datapointConditionBefore() throws RecognitionException {
		DatapointConditionBeforeContext _localctx = new DatapointConditionBeforeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_datapointConditionBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(BEFORE);
			setState(222);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivMulExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(CliffhangerParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(CliffhangerParser.SLASH, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public DivMulExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDivMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDivMulExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDivMulExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CliffhangerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CliffhangerParser.MINUS, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(CliffhangerParser.AND, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusExpressionContext extends ExpressionContext {
		public TerminalNode MINUS() { return getToken(CliffhangerParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public UnaryMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterUnaryMinusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitUnaryMinusExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitUnaryMinusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(CliffhangerParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(CliffhangerParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(CliffhangerParser.LT, 0); }
		public TerminalNode GT() { return getToken(CliffhangerParser.GT, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public RelationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterRelationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitRelationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitRelationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExpressionContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode HAT() { return getToken(CliffhangerParser.HAT, 0); }
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReferenceExpressionContext extends ExpressionContext {
		public ExpressionReferenceContext expressionReference() {
			return getRuleContext(ExpressionReferenceContext.class,0);
		}
		public ReferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupedExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CliffhangerParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CliffhangerParser.RPAREN, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public GroupedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterGroupedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitGroupedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitGroupedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(CliffhangerParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CliffhangerParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(CliffhangerParser.NEQ, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(CliffhangerParser.OR, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(225);
				match(LPAREN);
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(226);
						match(WHITESPACE);
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(232);
				expression(0);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(233);
					match(WHITESPACE);
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(RPAREN);
				}
				break;
			case MINUS:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(MINUS);
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(242);
						match(WHITESPACE);
						}
						} 
					}
					setState(247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(248);
				expression(10);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(NOT);
				setState(251); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(250);
						match(WHITESPACE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(253); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(255);
				expression(9);
				}
				break;
			case LFBRA:
			case WHITESPACE:
			case THE:
			case WORD:
				{
				_localctx = new ReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				expressionReference();
				}
				break;
			case TRUE:
			case FALSE:
			case SQUOTE:
			case DQUOTE:
			case NUMBER:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(343);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(341);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(261);
						match(HAT);
						setState(262);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new DivMulExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(263);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(265); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(264);
							match(WHITESPACE);
							}
							}
							setState(267); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(269);
						((DivMulExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((DivMulExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(271); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(270);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(273); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(275);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(277);
							match(WHITESPACE);
							}
							}
							setState(280); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(282);
						((AdditiveExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(283);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(286); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(288);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new RelationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(291); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(290);
							match(WHITESPACE);
							}
							}
							setState(293); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(295);
						((RelationExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTEQ) | (1L << GTEQ) | (1L << LT) | (1L << GT))) != 0)) ) {
							((RelationExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(296);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(299); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(301);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(304); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(303);
							match(WHITESPACE);
							}
							}
							setState(306); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(308);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(310); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(309);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(312); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(314);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(317); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(316);
							match(WHITESPACE);
							}
							}
							setState(319); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(321);
						match(AND);
						setState(323); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(322);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(325); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(327);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(330); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(329);
							match(WHITESPACE);
							}
							}
							setState(332); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==WHITESPACE );
						setState(334);
						match(OR);
						setState(336); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(335);
								match(WHITESPACE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(338); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(340);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(345);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionReferenceContext extends ParserRuleContext {
		public List<TerminalNode> THE() { return getTokens(CliffhangerParser.THE); }
		public TerminalNode THE(int i) {
			return getToken(CliffhangerParser.THE, i);
		}
		public List<DatapointNameContext> datapointName() {
			return getRuleContexts(DatapointNameContext.class);
		}
		public DatapointNameContext datapointName(int i) {
			return getRuleContext(DatapointNameContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(CliffhangerParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(CliffhangerParser.WHITESPACE, i);
		}
		public ExpressionReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterExpressionReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitExpressionReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitExpressionReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionReferenceContext expressionReference() throws RecognitionException {
		ExpressionReferenceContext _localctx = new ExpressionReferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionReference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(349); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(349);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						setState(346);
						match(THE);
						}
						break;
					case 2:
						{
						setState(347);
						datapointName();
						}
						break;
					case 3:
						{
						setState(348);
						match(WHITESPACE);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(351); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CliffhangerParser.NUMBER, 0); }
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(353);
				match(NUMBER);
				}
				break;
			case SQUOTE:
			case DQUOTE:
				{
				setState(354);
				stringLiteral();
				}
				break;
			case TRUE:
			case FALSE:
				{
				setState(355);
				booleanLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public SingleQuotedStringLiteralContext singleQuotedStringLiteral() {
			return getRuleContext(SingleQuotedStringLiteralContext.class,0);
		}
		public DoubleQuotedStringLiteralContext doubleQuotedStringLiteral() {
			return getRuleContext(DoubleQuotedStringLiteralContext.class,0);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_stringLiteral);
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				singleQuotedStringLiteral();
				}
				break;
			case DQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				doubleQuotedStringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(CliffhangerParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CliffhangerParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleQuotedStringLiteralContext extends ParserRuleContext {
		public TerminalNode SQUOTE() { return getToken(CliffhangerParser.SQUOTE, 0); }
		public EscapedSingleQuotedStringMemberContext escapedSingleQuotedStringMember() {
			return getRuleContext(EscapedSingleQuotedStringMemberContext.class,0);
		}
		public SingleQuotedStringMemberContext singleQuotedStringMember() {
			return getRuleContext(SingleQuotedStringMemberContext.class,0);
		}
		public SingleQuotedStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleQuotedStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterSingleQuotedStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitSingleQuotedStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitSingleQuotedStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleQuotedStringLiteralContext singleQuotedStringLiteral() throws RecognitionException {
		SingleQuotedStringLiteralContext _localctx = new SingleQuotedStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_singleQuotedStringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(SQUOTE);
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC:
			case ESC_TAB:
			case ESC_NEWLINE:
			case ESC_LINERET:
			case ESC_ESC:
			case ESC_SQUOTE:
			case UNICODE:
				{
				setState(365);
				escapedSingleQuotedStringMember();
				}
				break;
			case LFBRA:
			case DQUOTE:
			case TEXT:
				{
				setState(366);
				singleQuotedStringMember();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapedSingleQuotedStringMemberContext extends ParserRuleContext {
		public TerminalNode ESC_SQUOTE() { return getToken(CliffhangerParser.ESC_SQUOTE, 0); }
		public CommonEscapedStringMembersContext commonEscapedStringMembers() {
			return getRuleContext(CommonEscapedStringMembersContext.class,0);
		}
		public EscapedSingleQuotedStringMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapedSingleQuotedStringMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterEscapedSingleQuotedStringMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitEscapedSingleQuotedStringMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitEscapedSingleQuotedStringMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapedSingleQuotedStringMemberContext escapedSingleQuotedStringMember() throws RecognitionException {
		EscapedSingleQuotedStringMemberContext _localctx = new EscapedSingleQuotedStringMemberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_escapedSingleQuotedStringMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC_SQUOTE:
				{
				setState(369);
				match(ESC_SQUOTE);
				}
				break;
			case ESC:
			case ESC_TAB:
			case ESC_NEWLINE:
			case ESC_LINERET:
			case ESC_ESC:
			case UNICODE:
				{
				setState(370);
				commonEscapedStringMembers();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleQuotedStringMemberContext extends ParserRuleContext {
		public CommonStringMembersContext commonStringMembers() {
			return getRuleContext(CommonStringMembersContext.class,0);
		}
		public TerminalNode DQUOTE() { return getToken(CliffhangerParser.DQUOTE, 0); }
		public SingleQuotedStringMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleQuotedStringMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterSingleQuotedStringMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitSingleQuotedStringMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitSingleQuotedStringMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleQuotedStringMemberContext singleQuotedStringMember() throws RecognitionException {
		SingleQuotedStringMemberContext _localctx = new SingleQuotedStringMemberContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_singleQuotedStringMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LFBRA:
			case TEXT:
				{
				setState(373);
				commonStringMembers();
				}
				break;
			case DQUOTE:
				{
				setState(374);
				match(DQUOTE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonEscapedStringMembersContext extends ParserRuleContext {
		public TerminalNode UNICODE() { return getToken(CliffhangerParser.UNICODE, 0); }
		public EscapedSubstitutionContext escapedSubstitution() {
			return getRuleContext(EscapedSubstitutionContext.class,0);
		}
		public TerminalNode ESC_TAB() { return getToken(CliffhangerParser.ESC_TAB, 0); }
		public TerminalNode ESC_NEWLINE() { return getToken(CliffhangerParser.ESC_NEWLINE, 0); }
		public TerminalNode ESC_LINERET() { return getToken(CliffhangerParser.ESC_LINERET, 0); }
		public TerminalNode ESC_ESC() { return getToken(CliffhangerParser.ESC_ESC, 0); }
		public CommonEscapedStringMembersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonEscapedStringMembers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterCommonEscapedStringMembers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitCommonEscapedStringMembers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitCommonEscapedStringMembers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommonEscapedStringMembersContext commonEscapedStringMembers() throws RecognitionException {
		CommonEscapedStringMembersContext _localctx = new CommonEscapedStringMembersContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_commonEscapedStringMembers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNICODE:
				{
				setState(377);
				match(UNICODE);
				}
				break;
			case ESC:
				{
				setState(378);
				escapedSubstitution();
				}
				break;
			case ESC_TAB:
				{
				setState(379);
				match(ESC_TAB);
				}
				break;
			case ESC_NEWLINE:
				{
				setState(380);
				match(ESC_NEWLINE);
				}
				break;
			case ESC_LINERET:
				{
				setState(381);
				match(ESC_LINERET);
				}
				break;
			case ESC_ESC:
				{
				setState(382);
				match(ESC_ESC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonStringMembersContext extends ParserRuleContext {
		public SubstitutionContext substitution() {
			return getRuleContext(SubstitutionContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(CliffhangerParser.TEXT, 0); }
		public CommonStringMembersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonStringMembers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterCommonStringMembers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitCommonStringMembers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitCommonStringMembers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommonStringMembersContext commonStringMembers() throws RecognitionException {
		CommonStringMembersContext _localctx = new CommonStringMembersContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_commonStringMembers);
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LFBRA:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				substitution();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleQuotedStringLiteralContext extends ParserRuleContext {
		public TerminalNode DQUOTE() { return getToken(CliffhangerParser.DQUOTE, 0); }
		public EscapedDoubleQuotedStringMemberContext escapedDoubleQuotedStringMember() {
			return getRuleContext(EscapedDoubleQuotedStringMemberContext.class,0);
		}
		public DoubleQuotedStringMemberContext doubleQuotedStringMember() {
			return getRuleContext(DoubleQuotedStringMemberContext.class,0);
		}
		public DoubleQuotedStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleQuotedStringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDoubleQuotedStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDoubleQuotedStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDoubleQuotedStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleQuotedStringLiteralContext doubleQuotedStringLiteral() throws RecognitionException {
		DoubleQuotedStringLiteralContext _localctx = new DoubleQuotedStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_doubleQuotedStringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(DQUOTE);
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC:
			case ESC_TAB:
			case ESC_NEWLINE:
			case ESC_LINERET:
			case ESC_ESC:
			case ESC_DQUOTE:
			case UNICODE:
				{
				setState(390);
				escapedDoubleQuotedStringMember();
				}
				break;
			case LFBRA:
			case SQUOTE:
			case TEXT:
				{
				setState(391);
				doubleQuotedStringMember();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapedDoubleQuotedStringMemberContext extends ParserRuleContext {
		public TerminalNode ESC_DQUOTE() { return getToken(CliffhangerParser.ESC_DQUOTE, 0); }
		public CommonEscapedStringMembersContext commonEscapedStringMembers() {
			return getRuleContext(CommonEscapedStringMembersContext.class,0);
		}
		public EscapedDoubleQuotedStringMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapedDoubleQuotedStringMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterEscapedDoubleQuotedStringMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitEscapedDoubleQuotedStringMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitEscapedDoubleQuotedStringMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapedDoubleQuotedStringMemberContext escapedDoubleQuotedStringMember() throws RecognitionException {
		EscapedDoubleQuotedStringMemberContext _localctx = new EscapedDoubleQuotedStringMemberContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_escapedDoubleQuotedStringMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESC_DQUOTE:
				{
				setState(394);
				match(ESC_DQUOTE);
				}
				break;
			case ESC:
			case ESC_TAB:
			case ESC_NEWLINE:
			case ESC_LINERET:
			case ESC_ESC:
			case UNICODE:
				{
				setState(395);
				commonEscapedStringMembers();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleQuotedStringMemberContext extends ParserRuleContext {
		public CommonStringMembersContext commonStringMembers() {
			return getRuleContext(CommonStringMembersContext.class,0);
		}
		public TerminalNode SQUOTE() { return getToken(CliffhangerParser.SQUOTE, 0); }
		public DoubleQuotedStringMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleQuotedStringMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterDoubleQuotedStringMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitDoubleQuotedStringMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitDoubleQuotedStringMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleQuotedStringMemberContext doubleQuotedStringMember() throws RecognitionException {
		DoubleQuotedStringMemberContext _localctx = new DoubleQuotedStringMemberContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_doubleQuotedStringMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LFBRA:
			case TEXT:
				{
				setState(398);
				commonStringMembers();
				}
				break;
			case SQUOTE:
				{
				setState(399);
				match(SQUOTE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscapedSubstitutionContext extends ParserRuleContext {
		public TerminalNode ESC() { return getToken(CliffhangerParser.ESC, 0); }
		public TerminalNode LFBRA() { return getToken(CliffhangerParser.LFBRA, 0); }
		public EscapedSubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapedSubstitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).enterEscapedSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CliffhangerListener ) ((CliffhangerListener)listener).exitEscapedSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CliffhangerVisitor ) return ((CliffhangerVisitor<? extends T>)visitor).visitEscapedSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapedSubstitutionContext escapedSubstitution() throws RecognitionException {
		EscapedSubstitutionContext _localctx = new EscapedSubstitutionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_escapedSubstitution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(ESC);
			setState(403);
			match(LFBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0198\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2J\n\2\r\2\16\2K\3\3\3\3\5\3P\n\3\3\3\3"+
		"\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\5\3\\\n\3\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\7\5e\n\5\f\5\16\5h\13\5\3\5\6\5k\n\5\r\5\16\5l\3\6\3\6\3\6\3\6"+
		"\6\6s\n\6\r\6\16\6t\3\7\3\7\3\b\3\b\3\b\6\b|\n\b\r\b\16\b}\3\t\3\t\7\t"+
		"\u0082\n\t\f\t\16\t\u0085\13\t\3\t\3\t\5\t\u0089\n\t\3\t\7\t\u008c\n\t"+
		"\f\t\16\t\u008f\13\t\3\t\3\t\3\n\3\n\3\n\5\n\u0096\n\n\6\n\u0098\n\n\r"+
		"\n\16\n\u0099\3\13\3\13\5\13\u009e\n\13\3\f\3\f\5\f\u00a2\n\f\3\r\3\r"+
		"\6\r\u00a6\n\r\r\r\16\r\u00a7\3\r\3\r\3\16\3\16\6\16\u00ae\n\16\r\16\16"+
		"\16\u00af\3\16\3\16\6\16\u00b4\n\16\r\16\16\16\u00b5\3\16\5\16\u00b9\n"+
		"\16\3\17\3\17\3\17\3\17\6\17\u00bf\n\17\r\17\16\17\u00c0\3\20\3\20\5\20"+
		"\u00c5\n\20\3\21\3\21\5\21\u00c9\n\21\3\22\3\22\3\22\3\22\5\22\u00cf\n"+
		"\22\3\23\3\23\3\23\3\23\6\23\u00d5\n\23\r\23\16\23\u00d6\3\24\3\24\5\24"+
		"\u00db\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u00e6\n"+
		"\27\f\27\16\27\u00e9\13\27\3\27\3\27\7\27\u00ed\n\27\f\27\16\27\u00f0"+
		"\13\27\3\27\3\27\3\27\3\27\7\27\u00f6\n\27\f\27\16\27\u00f9\13\27\3\27"+
		"\3\27\3\27\6\27\u00fe\n\27\r\27\16\27\u00ff\3\27\3\27\3\27\5\27\u0105"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\6\27\u010c\n\27\r\27\16\27\u010d\3\27\3"+
		"\27\6\27\u0112\n\27\r\27\16\27\u0113\3\27\3\27\3\27\6\27\u0119\n\27\r"+
		"\27\16\27\u011a\3\27\3\27\6\27\u011f\n\27\r\27\16\27\u0120\3\27\3\27\3"+
		"\27\6\27\u0126\n\27\r\27\16\27\u0127\3\27\3\27\6\27\u012c\n\27\r\27\16"+
		"\27\u012d\3\27\3\27\3\27\6\27\u0133\n\27\r\27\16\27\u0134\3\27\3\27\6"+
		"\27\u0139\n\27\r\27\16\27\u013a\3\27\3\27\3\27\6\27\u0140\n\27\r\27\16"+
		"\27\u0141\3\27\3\27\6\27\u0146\n\27\r\27\16\27\u0147\3\27\3\27\3\27\6"+
		"\27\u014d\n\27\r\27\16\27\u014e\3\27\3\27\6\27\u0153\n\27\r\27\16\27\u0154"+
		"\3\27\7\27\u0158\n\27\f\27\16\27\u015b\13\27\3\30\3\30\3\30\6\30\u0160"+
		"\n\30\r\30\16\30\u0161\3\31\3\31\3\31\5\31\u0167\n\31\3\32\3\32\5\32\u016b"+
		"\n\32\3\33\3\33\3\34\3\34\3\34\5\34\u0172\n\34\3\35\3\35\5\35\u0176\n"+
		"\35\3\36\3\36\5\36\u017a\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0182"+
		"\n\37\3 \3 \5 \u0186\n \3!\3!\3!\5!\u018b\n!\3\"\3\"\5\"\u018f\n\"\3#"+
		"\3#\5#\u0193\n#\3$\3$\3$\3$\2\3,%\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDF\2\b\3\2\32\33\3\2\"#\3\2 !\3\2\60\63"+
		"\3\2\64\65\3\2\25\26\2\u01c0\2I\3\2\2\2\4O\3\2\2\2\6]\3\2\2\2\b`\3\2\2"+
		"\2\nr\3\2\2\2\fv\3\2\2\2\16{\3\2\2\2\20\177\3\2\2\2\22\u0097\3\2\2\2\24"+
		"\u009d\3\2\2\2\26\u00a1\3\2\2\2\30\u00a3\3\2\2\2\32\u00ab\3\2\2\2\34\u00ba"+
		"\3\2\2\2\36\u00c4\3\2\2\2 \u00c8\3\2\2\2\"\u00ca\3\2\2\2$\u00d0\3\2\2"+
		"\2&\u00da\3\2\2\2(\u00dc\3\2\2\2*\u00df\3\2\2\2,\u0104\3\2\2\2.\u015f"+
		"\3\2\2\2\60\u0166\3\2\2\2\62\u016a\3\2\2\2\64\u016c\3\2\2\2\66\u016e\3"+
		"\2\2\28\u0175\3\2\2\2:\u0179\3\2\2\2<\u0181\3\2\2\2>\u0185\3\2\2\2@\u0187"+
		"\3\2\2\2B\u018e\3\2\2\2D\u0192\3\2\2\2F\u0194\3\2\2\2HJ\5\4\3\2IH\3\2"+
		"\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MP\5\6\4\2NP\5\b\5\2OM\3"+
		"\2\2\2ON\3\2\2\2P[\3\2\2\2QR\7\3\2\2R\\\b\3\1\2SW\7\4\2\2TV\7\3\2\2UT"+
		"\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\\\3\2\2\2YW\3\2\2\2Z\\\7\2\2\3"+
		"[Q\3\2\2\2[S\3\2\2\2[Z\3\2\2\2\\\5\3\2\2\2]^\5\16\b\2^_\5\24\13\2_\7\3"+
		"\2\2\2`a\5\n\6\2aj\7\7\2\2bf\7\3\2\2ce\7\f\2\2dc\3\2\2\2eh\3\2\2\2fd\3"+
		"\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ik\5\4\3\2jb\3\2\2\2kl\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2m\t\3\2\2\2ns\5\f\7\2os\5\16\b\2ps\5\22\n\2qs\7\f\2\2"+
		"rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2"+
		"u\13\3\2\2\2vw\t\2\2\2w\r\3\2\2\2x|\7.\2\2y|\7\f\2\2z|\5\20\t\2{x\3\2"+
		"\2\2{y\3\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\17\3\2\2\2\177"+
		"\u0083\7\b\2\2\u0080\u0082\7\f\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2"+
		"\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0089\5,\27\2\u0087\u0089\5\20\t\2\u0088\u0086\3"+
		"\2\2\2\u0088\u0087\3\2\2\2\u0089\u008d\3\2\2\2\u008a\u008c\7\f\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\t\2\2\u0091"+
		"\21\3\2\2\2\u0092\u0095\5\16\b\2\u0093\u0094\7\5\2\2\u0094\u0096\7/\2"+
		"\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0092"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\23\3\2\2\2\u009b\u009e\5\26\f\2\u009c\u009e\5\34\17\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009c\3\2\2\2\u009e\25\3\2\2\2\u009f\u00a2\5\30\r\2\u00a0\u00a2"+
		"\5\32\16\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\27\3\2\2\2\u00a3"+
		"\u00a5\5\f\7\2\u00a4\u00a6\7\f\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\5\16\b\2\u00aa\31\3\2\2\2\u00ab\u00ad\7\31\2\2\u00ac\u00ae\7\f"+
		"\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b8\5,\27\2\u00b2\u00b4\7\f"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\5&\24\2\u00b8\u00b3\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\7\31\2\2\u00bb\u00be"+
		"\7\7\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00bf\5\36\20\2\u00be\u00bc\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\35"+
		"\3\2\2\2\u00c2\u00c5\5,\27\2\u00c3\u00c5\5 \21\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c9\5\"\22\2\u00c7\u00c9\5$\23"+
		"\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9!\3\2\2\2\u00ca\u00cb"+
		"\5&\24\2\u00cb\u00ce\7\7\2\2\u00cc\u00cf\5\30\r\2\u00cd\u00cf\5,\27\2"+
		"\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf#\3\2\2\2\u00d0\u00d1\5"+
		"&\24\2\u00d1\u00d4\7\7\2\2\u00d2\u00d3\7\3\2\2\u00d3\u00d5\5\36\20\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7%\3\2\2\2\u00d8\u00db\5(\25\2\u00d9\u00db\5*\26\2\u00da\u00d8"+
		"\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\'\3\2\2\2\u00dc\u00dd\7\35\2\2\u00dd"+
		"\u00de\5,\27\2\u00de)\3\2\2\2\u00df\u00e0\7\36\2\2\u00e0\u00e1\5,\27\2"+
		"\u00e1+\3\2\2\2\u00e2\u00e3\b\27\1\2\u00e3\u00e7\7\n\2\2\u00e4\u00e6\7"+
		"\f\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ee\5,"+
		"\27\2\u00eb\u00ed\7\f\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f1\u00f2\7\13\2\2\u00f2\u0105\3\2\2\2\u00f3\u00f7\7!\2\2\u00f4"+
		"\u00f6\7\f\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u0105\5,\27\f\u00fb\u00fd\7\37\2\2\u00fc\u00fe\7\f\2\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0105\5,\27\13\u0102\u0105\5.\30\2\u0103\u0105\5"+
		"\60\31\2\u0104\u00e2\3\2\2\2\u0104\u00f3\3\2\2\2\u0104\u00fb\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0159\3\2\2\2\u0106\u0107\f\r"+
		"\2\2\u0107\u0108\7$\2\2\u0108\u0158\5,\27\16\u0109\u010b\f\n\2\2\u010a"+
		"\u010c\7\f\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010b\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\t\3\2\2\u0110"+
		"\u0112\7\f\2\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0158\5,\27\13\u0116"+
		"\u0118\f\t\2\2\u0117\u0119\7\f\2\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011e\t\4\2\2\u011d\u011f\7\f\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0158\5,\27\n\u0123\u0125\f\b\2\2\u0124\u0126\7\f\2\2\u0125\u0124\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012b\t\5\2\2\u012a\u012c\7\f\2\2\u012b\u012a\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0158\5,\27\t\u0130\u0132\f\7\2\2\u0131\u0133\7\f"+
		"\2\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\t\6\2\2\u0137\u0139\7\f"+
		"\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0158\5,\27\b\u013d\u013f\f\6"+
		"\2\2\u013e\u0140\7\f\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\7\66"+
		"\2\2\u0144\u0146\7\f\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0158\5,"+
		"\27\7\u014a\u014c\f\5\2\2\u014b\u014d\7\f\2\2\u014c\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150\u0152\7\67\2\2\u0151\u0153\7\f\2\2\u0152\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0158\5,\27\6\u0157\u0106\3\2\2\2\u0157\u0109\3\2\2\2\u0157"+
		"\u0116\3\2\2\2\u0157\u0123\3\2\2\2\u0157\u0130\3\2\2\2\u0157\u013d\3\2"+
		"\2\2\u0157\u014a\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a-\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0160\7\34\2\2"+
		"\u015d\u0160\5\16\b\2\u015e\u0160\7\f\2\2\u015f\u015c\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u015f\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162/\3\2\2\2\u0163\u0167\7/\2\2\u0164\u0167\5\62\32\2"+
		"\u0165\u0167\5\64\33\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165"+
		"\3\2\2\2\u0167\61\3\2\2\2\u0168\u016b\5\66\34\2\u0169\u016b\5@!\2\u016a"+
		"\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\63\3\2\2\2\u016c\u016d\t\7\2"+
		"\2\u016d\65\3\2\2\2\u016e\u0171\7+\2\2\u016f\u0172\58\35\2\u0170\u0172"+
		"\5:\36\2\u0171\u016f\3\2\2\2\u0171\u0170\3\2\2\2\u0172\67\3\2\2\2\u0173"+
		"\u0176\7\22\2\2\u0174\u0176\5<\37\2\u0175\u0173\3\2\2\2\u0175\u0174\3"+
		"\2\2\2\u01769\3\2\2\2\u0177\u017a\5> \2\u0178\u017a\7,\2\2\u0179\u0177"+
		"\3\2\2\2\u0179\u0178\3\2\2\2\u017a;\3\2\2\2\u017b\u0182\7\24\2\2\u017c"+
		"\u0182\5F$\2\u017d\u0182\7\16\2\2\u017e\u0182\7\17\2\2\u017f\u0182\7\20"+
		"\2\2\u0180\u0182\7\21\2\2\u0181\u017b\3\2\2\2\u0181\u017c\3\2\2\2\u0181"+
		"\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2"+
		"\2\2\u0182=\3\2\2\2\u0183\u0186\5\20\t\2\u0184\u0186\7-\2\2\u0185\u0183"+
		"\3\2\2\2\u0185\u0184\3\2\2\2\u0186?\3\2\2\2\u0187\u018a\7,\2\2\u0188\u018b"+
		"\5B\"\2\u0189\u018b\5D#\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b"+
		"A\3\2\2\2\u018c\u018f\7\23\2\2\u018d\u018f\5<\37\2\u018e\u018c\3\2\2\2"+
		"\u018e\u018d\3\2\2\2\u018fC\3\2\2\2\u0190\u0193\5> \2\u0191\u0193\7+\2"+
		"\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193E\3\2\2\2\u0194\u0195"+
		"\7\r\2\2\u0195\u0196\7\b\2\2\u0196G\3\2\2\2<KOW[flrt{}\u0083\u0088\u008d"+
		"\u0095\u0099\u009d\u00a1\u00a7\u00af\u00b5\u00b8\u00c0\u00c4\u00c8\u00ce"+
		"\u00d6\u00da\u00e7\u00ee\u00f7\u00ff\u0104\u010d\u0113\u011a\u0120\u0127"+
		"\u012d\u0134\u013a\u0141\u0147\u014e\u0154\u0157\u0159\u015f\u0161\u0166"+
		"\u016a\u0171\u0175\u0179\u0181\u0185\u018a\u018e\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}