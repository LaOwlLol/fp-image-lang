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
		ID=1, ID_STRING=2, PATH_LITERAL=3, PATH_STRING=4, EQUAL=5, MULT=6, DIV=7, 
		PLUS=8, MINUS=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "VALID_ID_START", "VALID_ID_CHAR", "ID_STRING", "PATH_LITERAL", 
			"VALID_PATH_START", "VALID_PATH_CHAR", "IMAGE_EXTENSION", "PATH_STRING", 
			"EQUAL", "MULT", "DIV", "PLUS", "MINUS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'='", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "ID_STRING", "PATH_LITERAL", "PATH_STRING", "EQUAL", "MULT", 
			"DIV", "PLUS", "MINUS", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fz\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2$\n\2\f\2"+
		"\16\2\'\13\2\3\3\5\3*\n\3\3\4\3\4\5\4.\n\4\3\5\3\5\7\5\62\n\5\f\5\16\5"+
		"\65\13\5\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\3\7\5\7A\n\7\3\b\3\b"+
		"\5\bE\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\7\ne\n\n"+
		"\f\n\16\nh\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20"+
		"u\n\20\r\20\16\20v\3\20\3\20\2\2\21\3\3\5\2\7\2\t\4\13\5\r\2\17\2\21\2"+
		"\23\6\25\7\27\b\31\t\33\n\35\13\37\f\3\2\b\5\2C\\aac|\6\2\62;C\\c|\u0080"+
		"\u0080\6\2//\62;C\\c|\6\2\60\61C\\aac|\6\2/\60\62;C\\c|\5\2\13\f\17\17"+
		"\"\"\2\u0080\2\3\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\3!\3\2\2\2\5)\3\2\2\2\7-\3\2\2\2\t/\3\2\2\2\13\66\3\2\2\2\r@\3\2\2"+
		"\2\17D\3\2\2\2\21`\3\2\2\2\23b\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3\2"+
		"\2\2\33o\3\2\2\2\35q\3\2\2\2\37t\3\2\2\2!%\5\5\3\2\"$\5\7\4\2#\"\3\2\2"+
		"\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\4\3\2\2\2\'%\3\2\2\2(*\t\2\2\2)(\3"+
		"\2\2\2*\6\3\2\2\2+.\5\5\3\2,.\5\t\5\2-+\3\2\2\2-,\3\2\2\2.\b\3\2\2\2/"+
		"\63\t\3\2\2\60\62\t\4\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\n\3\2\2\2\65\63\3\2\2\2\66:\5\r\7\2\679\5\17\b\28\67\3"+
		"\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\5\21\t\2>\f"+
		"\3\2\2\2?A\t\5\2\2@?\3\2\2\2A\16\3\2\2\2BE\5\r\7\2CE\5\23\n\2DB\3\2\2"+
		"\2DC\3\2\2\2E\20\3\2\2\2FG\7\60\2\2GH\7r\2\2HI\7p\2\2Ia\7i\2\2JK\7\60"+
		"\2\2KL\7R\2\2LM\7P\2\2Ma\7I\2\2NO\7\60\2\2OP\7d\2\2PQ\7o\2\2Qa\7r\2\2"+
		"RS\7\60\2\2ST\7D\2\2TU\7O\2\2Ua\7R\2\2VW\7\60\2\2WX\7l\2\2XY\7r\2\2YZ"+
		"\7g\2\2Za\7i\2\2[\\\7\60\2\2\\]\7L\2\2]^\7R\2\2^_\7G\2\2_a\7I\2\2`F\3"+
		"\2\2\2`J\3\2\2\2`N\3\2\2\2`R\3\2\2\2`V\3\2\2\2`[\3\2\2\2a\22\3\2\2\2b"+
		"f\t\3\2\2ce\t\6\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\24\3\2\2"+
		"\2hf\3\2\2\2ij\7?\2\2j\26\3\2\2\2kl\7,\2\2l\30\3\2\2\2mn\7\61\2\2n\32"+
		"\3\2\2\2op\7-\2\2p\34\3\2\2\2qr\7/\2\2r\36\3\2\2\2su\t\7\2\2ts\3\2\2\2"+
		"uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\b\20\2\2y \3\2\2\2\r\2%)-\63"+
		":@D`fv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}