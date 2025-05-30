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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, IDENTIFIER=17, 
		INT=18, STRING=19, NEWLINE=20, WS=21, COMMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "IDENTIFIER", 
			"INT", "STRING", "NEWLINE", "WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", "'^'", "'*'", "'/'", "'%'", "'+'", "'-'", 
			"'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "IDENTIFIER", "INT", "STRING", "NEWLINE", 
			"WS", "COMMENT"
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
		"\u0004\u0000\u0016\u0087\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0005\u0010T\b\u0010\n\u0010\f\u0010W\t\u0010\u0001\u0011\u0004\u0011"+
		"Z\b\u0011\u000b\u0011\f\u0011[\u0001\u0012\u0001\u0012\u0005\u0012`\b"+
		"\u0012\n\u0012\f\u0012c\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012h\b\u0012\n\u0012\f\u0012k\t\u0012\u0001\u0012\u0003\u0012n\b\u0012"+
		"\u0001\u0013\u0003\u0013q\b\u0013\u0001\u0013\u0004\u0013t\b\u0013\u000b"+
		"\u0013\f\u0013u\u0001\u0014\u0004\u0014y\b\u0014\u000b\u0014\f\u0014z"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015\u0081\b\u0015"+
		"\n\u0015\f\u0015\u0084\t\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001"+
		"\u0000\u0007\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003"+
		"\u0000\n\n\r\r\"\"\u0003\u0000\n\n\r\r\'\'\u0002\u0000\t\t  \u0002\u0000"+
		"\n\n\r\r\u008f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000"+
		"\u0000\u0003/\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u0007"+
		"3\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b7\u0001\u0000"+
		"\u0000\u0000\r9\u0001\u0000\u0000\u0000\u000f;\u0001\u0000\u0000\u0000"+
		"\u0011=\u0001\u0000\u0000\u0000\u0013?\u0001\u0000\u0000\u0000\u0015B"+
		"\u0001\u0000\u0000\u0000\u0017E\u0001\u0000\u0000\u0000\u0019H\u0001\u0000"+
		"\u0000\u0000\u001bK\u0001\u0000\u0000\u0000\u001dM\u0001\u0000\u0000\u0000"+
		"\u001fO\u0001\u0000\u0000\u0000!Q\u0001\u0000\u0000\u0000#Y\u0001\u0000"+
		"\u0000\u0000%m\u0001\u0000\u0000\u0000\'s\u0001\u0000\u0000\u0000)x\u0001"+
		"\u0000\u0000\u0000+~\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\u0002"+
		"\u0001\u0000\u0000\u0000/0\u0005(\u0000\u00000\u0004\u0001\u0000\u0000"+
		"\u000012\u0005)\u0000\u00002\u0006\u0001\u0000\u0000\u000034\u0005^\u0000"+
		"\u00004\b\u0001\u0000\u0000\u000056\u0005*\u0000\u00006\n\u0001\u0000"+
		"\u0000\u000078\u0005/\u0000\u00008\f\u0001\u0000\u0000\u00009:\u0005%"+
		"\u0000\u0000:\u000e\u0001\u0000\u0000\u0000;<\u0005+\u0000\u0000<\u0010"+
		"\u0001\u0000\u0000\u0000=>\u0005-\u0000\u0000>\u0012\u0001\u0000\u0000"+
		"\u0000?@\u0005=\u0000\u0000@A\u0005=\u0000\u0000A\u0014\u0001\u0000\u0000"+
		"\u0000BC\u0005!\u0000\u0000CD\u0005=\u0000\u0000D\u0016\u0001\u0000\u0000"+
		"\u0000EF\u0005>\u0000\u0000FG\u0005=\u0000\u0000G\u0018\u0001\u0000\u0000"+
		"\u0000HI\u0005<\u0000\u0000IJ\u0005=\u0000\u0000J\u001a\u0001\u0000\u0000"+
		"\u0000KL\u0005>\u0000\u0000L\u001c\u0001\u0000\u0000\u0000MN\u0005<\u0000"+
		"\u0000N\u001e\u0001\u0000\u0000\u0000OP\u0005,\u0000\u0000P \u0001\u0000"+
		"\u0000\u0000QU\u0007\u0000\u0000\u0000RT\u0007\u0001\u0000\u0000SR\u0001"+
		"\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\"\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000XZ\u0007\u0002\u0000\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\$\u0001"+
		"\u0000\u0000\u0000]a\u0005\"\u0000\u0000^`\b\u0003\u0000\u0000_^\u0001"+
		"\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000dn\u0005\"\u0000\u0000ei\u0005\'\u0000\u0000fh\b\u0004\u0000\u0000"+
		"gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000ln\u0005\'\u0000\u0000m]\u0001\u0000\u0000\u0000me\u0001\u0000"+
		"\u0000\u0000n&\u0001\u0000\u0000\u0000oq\u0005\r\u0000\u0000po\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0005"+
		"\n\u0000\u0000sp\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v(\u0001\u0000\u0000\u0000"+
		"wy\u0007\u0005\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|}\u0006\u0014\u0000\u0000}*\u0001\u0000\u0000\u0000~\u0082"+
		"\u0005#\u0000\u0000\u007f\u0081\b\u0006\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0006"+
		"\u0015\u0000\u0000\u0086,\u0001\u0000\u0000\u0000\n\u0000U[aimpuz\u0082"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}