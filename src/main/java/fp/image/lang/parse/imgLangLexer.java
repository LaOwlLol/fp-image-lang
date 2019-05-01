// Generated from imgLang.g4 by ANTLR 4.7.2
package fp.image.lang.parse;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class imgLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, ID_STRING=3, PATH_LITERAL=4, PATH_STRING=5, EQUAL=6, MULT=7, 
		DIV=8, PLUS=9, MINUS=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "ID", "VALID_ID_START", "VALID_ID_CHAR", "ID_STRING", "PATH_LITERAL", 
			"VALID_PATH_START", "VALID_PATH_CHAR", "IMAGE_EXTENSION", "PATH_STRING", 
			"EQUAL", "MULT", "DIV", "PLUS", "MINUS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", null, null, null, null, "'='", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ID", "ID_STRING", "PATH_LITERAL", "PATH_STRING", "EQUAL", 
			"MULT", "DIV", "PLUS", "MINUS", "WS"
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


	public imgLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "imgLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u0087\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\5\4.\n\4\3\5\3\5\5\5\62\n\5\3\6\3"+
		"\6\7\6\66\n\6\f\6\16\69\13\6\3\7\3\7\7\7=\n\7\f\7\16\7@\13\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bN\n\b\3\t\3\t\5\tR\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nn\n\n\3\13\3\13\7\13r\n\13\f\13\16\13"+
		"u\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\6\21\u0082"+
		"\n\21\r\21\16\21\u0083\3\21\3\21\2\2\22\3\3\5\4\7\2\t\2\13\5\r\6\17\2"+
		"\21\2\23\2\25\7\27\b\31\t\33\n\35\13\37\f!\r\3\2\7\5\2C\\aac|\6\2\62;"+
		"C\\c|\u0080\u0080\6\2//\62;C\\c|\6\2/\60\62;C\\c|\5\2\13\f\17\17\"\"\2"+
		"\u0091\2\3\3\2\2\2\2\5\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\3#\3\2\2\2\5%\3\2\2\2\7-\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r:\3"+
		"\2\2\2\17M\3\2\2\2\21Q\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27v\3\2\2\2\31"+
		"x\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37~\3\2\2\2!\u0081\3\2\2\2#$\7\f\2\2"+
		"$\4\3\2\2\2%)\5\7\4\2&(\5\t\5\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2"+
		"\2\2*\6\3\2\2\2+)\3\2\2\2,.\t\2\2\2-,\3\2\2\2.\b\3\2\2\2/\62\5\7\4\2\60"+
		"\62\5\13\6\2\61/\3\2\2\2\61\60\3\2\2\2\62\n\3\2\2\2\63\67\t\3\2\2\64\66"+
		"\t\4\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\f\3\2\2"+
		"\29\67\3\2\2\2:>\5\17\b\2;=\5\21\t\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3"+
		"\2\2\2?A\3\2\2\2@>\3\2\2\2AB\5\23\n\2B\16\3\2\2\2CN\t\2\2\2DE\7\60\2\2"+
		"EN\7\61\2\2FN\7\61\2\2GH\4c|\2HI\7<\2\2IN\7\61\2\2JK\4C\\\2KL\7<\2\2L"+
		"N\7\61\2\2MC\3\2\2\2MD\3\2\2\2MF\3\2\2\2MG\3\2\2\2MJ\3\2\2\2N\20\3\2\2"+
		"\2OR\5\17\b\2PR\5\25\13\2QO\3\2\2\2QP\3\2\2\2R\22\3\2\2\2ST\7\60\2\2T"+
		"U\7r\2\2UV\7p\2\2Vn\7i\2\2WX\7\60\2\2XY\7R\2\2YZ\7P\2\2Zn\7I\2\2[\\\7"+
		"\60\2\2\\]\7d\2\2]^\7o\2\2^n\7r\2\2_`\7\60\2\2`a\7D\2\2ab\7O\2\2bn\7R"+
		"\2\2cd\7\60\2\2de\7l\2\2ef\7r\2\2fg\7g\2\2gn\7i\2\2hi\7\60\2\2ij\7L\2"+
		"\2jk\7R\2\2kl\7G\2\2ln\7I\2\2mS\3\2\2\2mW\3\2\2\2m[\3\2\2\2m_\3\2\2\2"+
		"mc\3\2\2\2mh\3\2\2\2n\24\3\2\2\2os\t\3\2\2pr\t\5\2\2qp\3\2\2\2ru\3\2\2"+
		"\2sq\3\2\2\2st\3\2\2\2t\26\3\2\2\2us\3\2\2\2vw\7?\2\2w\30\3\2\2\2xy\7"+
		",\2\2y\32\3\2\2\2z{\7\61\2\2{\34\3\2\2\2|}\7-\2\2}\36\3\2\2\2~\177\7/"+
		"\2\2\177 \3\2\2\2\u0080\u0082\t\6\2\2\u0081\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\b\21\2\2\u0086\"\3\2\2\2\r\2)-\61\67>MQms\u0083\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}