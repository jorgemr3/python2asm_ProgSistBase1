// Generated from grammar/PythonSubset.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PythonSubsetLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, AND=17, 
		OR=18, NOT=19, IDENTIFIER=20, INT=21, STRING=22, NEWLINE=23, WS=24, COMMENT=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "AND", 
			"OR", "NOT", "IDENTIFIER", "INT", "STRING", "NEWLINE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'**'", "'('", "')'", "','", "'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "AND", "OR", "NOT", "IDENTIFIER", "INT", 
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


	public PythonSubsetLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonSubset.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u0099\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0005\u0013f\b\u0013\n\u0013\f\u0013i\t\u0013\u0001\u0014\u0004"+
		"\u0014l\b\u0014\u000b\u0014\f\u0014m\u0001\u0015\u0001\u0015\u0005\u0015"+
		"r\b\u0015\n\u0015\f\u0015u\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015z\b\u0015\n\u0015\f\u0015}\t\u0015\u0001\u0015\u0003\u0015"+
		"\u0080\b\u0015\u0001\u0016\u0003\u0016\u0083\b\u0016\u0001\u0016\u0004"+
		"\u0016\u0086\b\u0016\u000b\u0016\f\u0016\u0087\u0001\u0017\u0004\u0017"+
		"\u008b\b\u0017\u000b\u0017\f\u0017\u008c\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u0093\b\u0018\n\u0018\f\u0018\u0096\t\u0018"+
		"\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000"+
		"\u0007\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000"+
		"\n\n\r\r\"\"\u0003\u0000\n\n\r\r\'\'\u0002\u0000\t\t  \u0002\u0000\n\n"+
		"\r\r\u00a1\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0001"+
		"3\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u00058\u0001"+
		"\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000\t>\u0001\u0000\u0000"+
		"\u0000\u000bA\u0001\u0000\u0000\u0000\rC\u0001\u0000\u0000\u0000\u000f"+
		"E\u0001\u0000\u0000\u0000\u0011G\u0001\u0000\u0000\u0000\u0013I\u0001"+
		"\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017M\u0001\u0000\u0000"+
		"\u0000\u0019O\u0001\u0000\u0000\u0000\u001bR\u0001\u0000\u0000\u0000\u001d"+
		"T\u0001\u0000\u0000\u0000\u001fV\u0001\u0000\u0000\u0000!X\u0001\u0000"+
		"\u0000\u0000#\\\u0001\u0000\u0000\u0000%_\u0001\u0000\u0000\u0000\'c\u0001"+
		"\u0000\u0000\u0000)k\u0001\u0000\u0000\u0000+\u007f\u0001\u0000\u0000"+
		"\u0000-\u0085\u0001\u0000\u0000\u0000/\u008a\u0001\u0000\u0000\u00001"+
		"\u0090\u0001\u0000\u0000\u000034\u0005=\u0000\u00004\u0002\u0001\u0000"+
		"\u0000\u000056\u0005=\u0000\u000067\u0005=\u0000\u00007\u0004\u0001\u0000"+
		"\u0000\u000089\u0005!\u0000\u00009:\u0005=\u0000\u0000:\u0006\u0001\u0000"+
		"\u0000\u0000;<\u0005>\u0000\u0000<=\u0005=\u0000\u0000=\b\u0001\u0000"+
		"\u0000\u0000>?\u0005<\u0000\u0000?@\u0005=\u0000\u0000@\n\u0001\u0000"+
		"\u0000\u0000AB\u0005>\u0000\u0000B\f\u0001\u0000\u0000\u0000CD\u0005<"+
		"\u0000\u0000D\u000e\u0001\u0000\u0000\u0000EF\u0005+\u0000\u0000F\u0010"+
		"\u0001\u0000\u0000\u0000GH\u0005-\u0000\u0000H\u0012\u0001\u0000\u0000"+
		"\u0000IJ\u0005*\u0000\u0000J\u0014\u0001\u0000\u0000\u0000KL\u0005/\u0000"+
		"\u0000L\u0016\u0001\u0000\u0000\u0000MN\u0005%\u0000\u0000N\u0018\u0001"+
		"\u0000\u0000\u0000OP\u0005*\u0000\u0000PQ\u0005*\u0000\u0000Q\u001a\u0001"+
		"\u0000\u0000\u0000RS\u0005(\u0000\u0000S\u001c\u0001\u0000\u0000\u0000"+
		"TU\u0005)\u0000\u0000U\u001e\u0001\u0000\u0000\u0000VW\u0005,\u0000\u0000"+
		"W \u0001\u0000\u0000\u0000XY\u0005a\u0000\u0000YZ\u0005n\u0000\u0000Z"+
		"[\u0005d\u0000\u0000[\"\u0001\u0000\u0000\u0000\\]\u0005o\u0000\u0000"+
		"]^\u0005r\u0000\u0000^$\u0001\u0000\u0000\u0000_`\u0005n\u0000\u0000`"+
		"a\u0005o\u0000\u0000ab\u0005t\u0000\u0000b&\u0001\u0000\u0000\u0000cg"+
		"\u0007\u0000\u0000\u0000df\u0007\u0001\u0000\u0000ed\u0001\u0000\u0000"+
		"\u0000fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000h(\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0007"+
		"\u0002\u0000\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n*\u0001\u0000\u0000"+
		"\u0000os\u0005\"\u0000\u0000pr\b\u0003\u0000\u0000qp\u0001\u0000\u0000"+
		"\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000v\u0080"+
		"\u0005\"\u0000\u0000w{\u0005\'\u0000\u0000xz\b\u0004\u0000\u0000yx\u0001"+
		"\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000~\u0080\u0005\'\u0000\u0000\u007fo\u0001\u0000\u0000\u0000\u007f"+
		"w\u0001\u0000\u0000\u0000\u0080,\u0001\u0000\u0000\u0000\u0081\u0083\u0005"+
		"\r\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0005\n\u0000"+
		"\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088.\u0001\u0000\u0000\u0000\u0089\u008b\u0007\u0005\u0000\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0006\u0017\u0000\u0000"+
		"\u008f0\u0001\u0000\u0000\u0000\u0090\u0094\u0005#\u0000\u0000\u0091\u0093"+
		"\b\u0006\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0094\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0006\u0018\u0000\u0000\u00982\u0001\u0000"+
		"\u0000\u0000\n\u0000gms{\u007f\u0082\u0087\u008c\u0094\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}