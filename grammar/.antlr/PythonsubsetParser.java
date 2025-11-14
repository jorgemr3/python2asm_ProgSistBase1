// Generated from c:/Users/Jorge Melo/Desktop/python2asm_ProgSistBase1/grammar/PythonSubset.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PythonSubsetParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, FOR=19, WHILE=20, IN=21, AND=22, OR=23, NOT=24, TRUE=25, FALSE=26, 
		INDENT=27, DEDENT=28, IDENTIFIER=29, INT=30, STRING=31, NEWLINE=32, WS=33, 
		COMMENT=34;
	public static final int
		RULE_prog = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_compound_stmt = 3, 
		RULE_assign_stmt = 4, RULE_expr_stmt = 5, RULE_for_stmt = 6, RULE_while_stmt = 7, 
		RULE_iterable = 8, RULE_range_call = 9, RULE_range_args = 10, RULE_expr = 11, 
		RULE_comparison = 12, RULE_arith_expr = 13, RULE_unary_expr = 14, RULE_power_expr = 15, 
		RULE_atom_expr = 16, RULE_arg_list = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stmt", "simple_stmt", "compound_stmt", "assign_stmt", "expr_stmt", 
			"for_stmt", "while_stmt", "iterable", "range_call", "range_args", "expr", 
			"comparison", "arith_expr", "unary_expr", "power_expr", "atom_expr", 
			"arg_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "':'", "'range'", "'('", "')'", "','", "'=='", "'!='", "'>='", 
			"'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'for'", 
			"'while'", "'in'", "'and'", "'or'", "'not'", "'True'", "'False'", "'INDENT'", 
			"'DEDENT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "FOR", "WHILE", "IN", "AND", 
			"OR", "NOT", "TRUE", "FALSE", "INDENT", "DEDENT", "IDENTIFIER", "INT", 
			"STRING", "NEWLINE", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "PythonSubset.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonSubsetParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PythonSubsetParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				stmt();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8172101648L) != 0) );
			setState(41);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonSubsetParser.NEWLINE, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__13:
			case NOT:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				simple_stmt();
				setState(44);
				match(NEWLINE);
				}
				break;
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				compound_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(NEWLINE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_stmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simple_stmt);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				assign_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				expr_stmt();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_stmtContext extends ParserRuleContext {
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compound_stmt);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				for_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				while_stmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PythonSubsetParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IDENTIFIER);
			setState(59);
			match(T__0);
			setState(60);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PythonSubsetParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PythonSubsetParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(PythonSubsetParser.IN, 0); }
		public IterableContext iterable() {
			return getRuleContext(IterableContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonSubsetParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonSubsetParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonSubsetParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(FOR);
			setState(65);
			match(IDENTIFIER);
			setState(66);
			match(IN);
			setState(67);
			iterable();
			setState(68);
			match(T__1);
			setState(69);
			match(NEWLINE);
			setState(70);
			match(INDENT);
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				stmt();
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8172101648L) != 0) );
			setState(76);
			match(DEDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PythonSubsetParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonSubsetParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonSubsetParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonSubsetParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(WHILE);
			setState(79);
			expr(0);
			setState(80);
			match(T__1);
			setState(81);
			match(NEWLINE);
			setState(82);
			match(INDENT);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				stmt();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8172101648L) != 0) );
			setState(88);
			match(DEDENT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IterableContext extends ParserRuleContext {
		public Range_callContext range_call() {
			return getRuleContext(Range_callContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IterableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterable; }
	}

	public final IterableContext iterable() throws RecognitionException {
		IterableContext _localctx = new IterableContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iterable);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				range_call();
				}
				break;
			case T__3:
			case T__12:
			case T__13:
			case NOT:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Range_callContext extends ParserRuleContext {
		public Range_argsContext range_args() {
			return getRuleContext(Range_argsContext.class,0);
		}
		public Range_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_call; }
	}

	public final Range_callContext range_call() throws RecognitionException {
		Range_callContext _localctx = new Range_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_range_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__2);
			setState(95);
			match(T__3);
			setState(96);
			range_args();
			setState(97);
			match(T__4);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Range_argsContext extends ParserRuleContext {
		public Range_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_args; }
	 
		public Range_argsContext() { }
		public void copyFrom(Range_argsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RangeStartStopStepContext extends Range_argsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RangeStartStopStepContext(Range_argsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RangeStopContext extends Range_argsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RangeStopContext(Range_argsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RangeStartStopContext extends Range_argsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RangeStartStopContext(Range_argsContext ctx) { copyFrom(ctx); }
	}

	public final Range_argsContext range_args() throws RecognitionException {
		Range_argsContext _localctx = new Range_argsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_range_args);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new RangeStopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				expr(0);
				}
				break;
			case 2:
				_localctx = new RangeStartStopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				expr(0);
				setState(101);
				match(T__5);
				setState(102);
				expr(0);
				}
				break;
			case 3:
				_localctx = new RangeStartStopStepContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				expr(0);
				setState(105);
				match(T__5);
				setState(106);
				expr(0);
				setState(107);
				match(T__5);
				setState(108);
				expr(0);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ExprContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ComparisonExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PythonSubsetParser.AND, 0); }
		public LogicalAndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PythonSubsetParser.OR, 0); }
		public LogicalOrContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ComparisonExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(113);
			comparison();
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(116);
						match(OR);
						setState(117);
						expr(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(119);
						match(AND);
						setState(120);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public Token comp;
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			arith_expr(0);
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(127);
				((ComparisonContext)_localctx).comp = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8064L) != 0)) ) {
					((ComparisonContext)_localctx).comp = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				arith_expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Arith_exprContext extends ParserRuleContext {
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
	 
		public Arith_exprContext() { }
		public void copyFrom(Arith_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends Arith_exprContext {
		public Token op;
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public MulDivModContext(Arith_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithUnaryContext extends Arith_exprContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public ArithUnaryContext(Arith_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends Arith_exprContext {
		public Token op;
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public AddSubContext(Arith_exprContext ctx) { copyFrom(ctx); }
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		return arith_expr(0);
	}

	private Arith_exprContext arith_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, _parentState);
		Arith_exprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_arith_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArithUnaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(132);
			unary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(140);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new AddSubContext(new Arith_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(134);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(135);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						arith_expr(4);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new Arith_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(137);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(138);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						arith_expr(3);
						}
						break;
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_exprContext extends ParserRuleContext {
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
	 
		public Unary_exprContext() { }
		public void copyFrom(Unary_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalNotContext extends Unary_exprContext {
		public TerminalNode NOT() { return getToken(PythonSubsetParser.NOT, 0); }
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public LogicalNotContext(Unary_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends Unary_exprContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public UnaryOpContext(Unary_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerBaseContext extends Unary_exprContext {
		public Power_exprContext power_expr() {
			return getRuleContext(Power_exprContext.class,0);
		}
		public PowerBaseContext(Unary_exprContext ctx) { copyFrom(ctx); }
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unary_expr);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new LogicalNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(NOT);
				setState(146);
				unary_expr();
				}
				break;
			case T__12:
			case T__13:
				_localctx = new UnaryOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				unary_expr();
				}
				break;
			case T__3:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case INT:
			case STRING:
				_localctx = new PowerBaseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				power_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Power_exprContext extends ParserRuleContext {
		public Power_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power_expr; }
	 
		public Power_exprContext() { }
		public void copyFrom(Power_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerContext extends Power_exprContext {
		public Atom_exprContext atom_expr() {
			return getRuleContext(Atom_exprContext.class,0);
		}
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public PowerContext(Power_exprContext ctx) { copyFrom(ctx); }
	}

	public final Power_exprContext power_expr() throws RecognitionException {
		Power_exprContext _localctx = new Power_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_power_expr);
		try {
			_localctx = new PowerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			atom_expr();
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(153);
				match(T__17);
				setState(154);
				unary_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Atom_exprContext extends ParserRuleContext {
		public Atom_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom_expr; }
	 
		public Atom_exprContext() { }
		public void copyFrom(Atom_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarRefContext extends Atom_exprContext {
		public TerminalNode IDENTIFIER() { return getToken(PythonSubsetParser.IDENTIFIER, 0); }
		public VarRefContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends Atom_exprContext {
		public TerminalNode IDENTIFIER() { return getToken(PythonSubsetParser.IDENTIFIER, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public FuncCallContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends Atom_exprContext {
		public TerminalNode STRING() { return getToken(PythonSubsetParser.STRING, 0); }
		public StringLiteralContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends Atom_exprContext {
		public TerminalNode TRUE() { return getToken(PythonSubsetParser.TRUE, 0); }
		public TrueLiteralContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends Atom_exprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntLiteralContext extends Atom_exprContext {
		public TerminalNode INT() { return getToken(PythonSubsetParser.INT, 0); }
		public IntLiteralContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends Atom_exprContext {
		public TerminalNode FALSE() { return getToken(PythonSubsetParser.FALSE, 0); }
		public FalseLiteralContext(Atom_exprContext ctx) { copyFrom(ctx); }
	}

	public final Atom_exprContext atom_expr() throws RecognitionException {
		Atom_exprContext _localctx = new Atom_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atom_expr);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(IDENTIFIER);
				setState(158);
				match(T__3);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3875561488L) != 0)) {
					{
					setState(159);
					arg_list();
					}
				}

				setState(162);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(T__3);
				setState(164);
				expr(0);
				setState(165);
				match(T__4);
				}
				break;
			case 3:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(INT);
				}
				break;
			case 4:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new TrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				match(TRUE);
				}
				break;
			case 6:
				_localctx = new FalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(FALSE);
				}
				break;
			case 7:
				_localctx = new VarRefContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				match(IDENTIFIER);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			expr(0);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(175);
				match(T__5);
				setState(176);
				expr(0);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 13:
			return arith_expr_sempred((Arith_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arith_expr_sempred(Arith_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0004\u0000"+
		"&\b\u0000\u000b\u0000\f\u0000\'\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0003\u00025\b\u0002\u0001\u0003\u0001\u0003\u0003"+
		"\u00039\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006I\b\u0006\u000b"+
		"\u0006\f\u0006J\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007U\b\u0007\u000b"+
		"\u0007\f\u0007V\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\b]\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\no\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000bz\b\u000b\n\u000b\f\u000b}\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0082\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008d\b\r\n"+
		"\r\f\r\u0090\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u0097\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u009c\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00a1"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ad"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00b2\b\u0011"+
		"\n\u0011\f\u0011\u00b5\t\u0011\u0001\u0011\u0000\u0002\u0016\u001a\u0012"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"\u0000\u0003\u0001\u0000\u0007\f\u0001\u0000\r\u000e\u0001"+
		"\u0000\u000f\u0011\u00be\u0000%\u0001\u0000\u0000\u0000\u00020\u0001\u0000"+
		"\u0000\u0000\u00044\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000"+
		"\b:\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000\f@\u0001\u0000"+
		"\u0000\u0000\u000eN\u0001\u0000\u0000\u0000\u0010\\\u0001\u0000\u0000"+
		"\u0000\u0012^\u0001\u0000\u0000\u0000\u0014n\u0001\u0000\u0000\u0000\u0016"+
		"p\u0001\u0000\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u0083\u0001"+
		"\u0000\u0000\u0000\u001c\u0096\u0001\u0000\u0000\u0000\u001e\u0098\u0001"+
		"\u0000\u0000\u0000 \u00ac\u0001\u0000\u0000\u0000\"\u00ae\u0001\u0000"+
		"\u0000\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)*\u0005\u0000\u0000\u0001*\u0001\u0001\u0000"+
		"\u0000\u0000+,\u0003\u0004\u0002\u0000,-\u0005 \u0000\u0000-1\u0001\u0000"+
		"\u0000\u0000.1\u0003\u0006\u0003\u0000/1\u0005 \u0000\u00000+\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u00000/\u0001\u0000\u0000\u00001\u0003"+
		"\u0001\u0000\u0000\u000025\u0003\b\u0004\u000035\u0003\n\u0005\u00004"+
		"2\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0005\u0001\u0000"+
		"\u0000\u000069\u0003\f\u0006\u000079\u0003\u000e\u0007\u000086\u0001\u0000"+
		"\u0000\u000087\u0001\u0000\u0000\u00009\u0007\u0001\u0000\u0000\u0000"+
		":;\u0005\u001d\u0000\u0000;<\u0005\u0001\u0000\u0000<=\u0003\u0016\u000b"+
		"\u0000=\t\u0001\u0000\u0000\u0000>?\u0003\u0016\u000b\u0000?\u000b\u0001"+
		"\u0000\u0000\u0000@A\u0005\u0013\u0000\u0000AB\u0005\u001d\u0000\u0000"+
		"BC\u0005\u0015\u0000\u0000CD\u0003\u0010\b\u0000DE\u0005\u0002\u0000\u0000"+
		"EF\u0005 \u0000\u0000FH\u0005\u001b\u0000\u0000GI\u0003\u0002\u0001\u0000"+
		"HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005\u001c"+
		"\u0000\u0000M\r\u0001\u0000\u0000\u0000NO\u0005\u0014\u0000\u0000OP\u0003"+
		"\u0016\u000b\u0000PQ\u0005\u0002\u0000\u0000QR\u0005 \u0000\u0000RT\u0005"+
		"\u001b\u0000\u0000SU\u0003\u0002\u0001\u0000TS\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000XY\u0005\u001c\u0000\u0000Y\u000f\u0001"+
		"\u0000\u0000\u0000Z]\u0003\u0012\t\u0000[]\u0003\u0016\u000b\u0000\\Z"+
		"\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]\u0011\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0003\u0000\u0000_`\u0005\u0004\u0000\u0000`a\u0003"+
		"\u0014\n\u0000ab\u0005\u0005\u0000\u0000b\u0013\u0001\u0000\u0000\u0000"+
		"co\u0003\u0016\u000b\u0000de\u0003\u0016\u000b\u0000ef\u0005\u0006\u0000"+
		"\u0000fg\u0003\u0016\u000b\u0000go\u0001\u0000\u0000\u0000hi\u0003\u0016"+
		"\u000b\u0000ij\u0005\u0006\u0000\u0000jk\u0003\u0016\u000b\u0000kl\u0005"+
		"\u0006\u0000\u0000lm\u0003\u0016\u000b\u0000mo\u0001\u0000\u0000\u0000"+
		"nc\u0001\u0000\u0000\u0000nd\u0001\u0000\u0000\u0000nh\u0001\u0000\u0000"+
		"\u0000o\u0015\u0001\u0000\u0000\u0000pq\u0006\u000b\uffff\uffff\u0000"+
		"qr\u0003\u0018\f\u0000r{\u0001\u0000\u0000\u0000st\n\u0003\u0000\u0000"+
		"tu\u0005\u0017\u0000\u0000uz\u0003\u0016\u000b\u0004vw\n\u0002\u0000\u0000"+
		"wx\u0005\u0016\u0000\u0000xz\u0003\u0016\u000b\u0003ys\u0001\u0000\u0000"+
		"\u0000yv\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0017\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0081\u0003\u001a\r\u0000\u007f\u0080\u0007"+
		"\u0000\u0000\u0000\u0080\u0082\u0003\u001a\r\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0019\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0006\r\uffff\uffff\u0000\u0084\u0085\u0003\u001c"+
		"\u000e\u0000\u0085\u008e\u0001\u0000\u0000\u0000\u0086\u0087\n\u0003\u0000"+
		"\u0000\u0087\u0088\u0007\u0001\u0000\u0000\u0088\u008d\u0003\u001a\r\u0004"+
		"\u0089\u008a\n\u0002\u0000\u0000\u008a\u008b\u0007\u0002\u0000\u0000\u008b"+
		"\u008d\u0003\u001a\r\u0003\u008c\u0086\u0001\u0000\u0000\u0000\u008c\u0089"+
		"\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u001b"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u0018\u0000\u0000\u0092\u0097\u0003\u001c\u000e\u0000\u0093\u0094"+
		"\u0007\u0001\u0000\u0000\u0094\u0097\u0003\u001c\u000e\u0000\u0095\u0097"+
		"\u0003\u001e\u000f\u0000\u0096\u0091\u0001\u0000\u0000\u0000\u0096\u0093"+
		"\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u001d"+
		"\u0001\u0000\u0000\u0000\u0098\u009b\u0003 \u0010\u0000\u0099\u009a\u0005"+
		"\u0012\u0000\u0000\u009a\u009c\u0003\u001c\u000e\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u001f\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u001d\u0000\u0000\u009e\u00a0\u0005"+
		"\u0004\u0000\u0000\u009f\u00a1\u0003\"\u0011\u0000\u00a0\u009f\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00ad\u0005\u0005\u0000\u0000\u00a3\u00a4\u0005\u0004"+
		"\u0000\u0000\u00a4\u00a5\u0003\u0016\u000b\u0000\u00a5\u00a6\u0005\u0005"+
		"\u0000\u0000\u00a6\u00ad\u0001\u0000\u0000\u0000\u00a7\u00ad\u0005\u001e"+
		"\u0000\u0000\u00a8\u00ad\u0005\u001f\u0000\u0000\u00a9\u00ad\u0005\u0019"+
		"\u0000\u0000\u00aa\u00ad\u0005\u001a\u0000\u0000\u00ab\u00ad\u0005\u001d"+
		"\u0000\u0000\u00ac\u009d\u0001\u0000\u0000\u0000\u00ac\u00a3\u0001\u0000"+
		"\u0000\u0000\u00ac\u00a7\u0001\u0000\u0000\u0000\u00ac\u00a8\u0001\u0000"+
		"\u0000\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad!\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b3\u0003\u0016\u000b\u0000\u00af\u00b0\u0005\u0006\u0000"+
		"\u0000\u00b0\u00b2\u0003\u0016\u000b\u0000\u00b1\u00af\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4#\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u0012\'048JV\\ny{\u0081\u008c\u008e"+
		"\u0096\u009b\u00a0\u00ac\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}