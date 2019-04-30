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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\5\4.\n\4\3\5\3\5\5\5\62\n\5\3\6\3\6"+
		"\7\6\66\n\6\f\6\16\69\13\6\3\7\3\7\7\7=\n\7\f\7\16\7@\13\7\3\7\3\7\3\b"+
		"\5\bE\n\b\3\t\3\t\5\tI\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ne\n\n"+
		"\3\13\3\13\7\13i\n\13\f\13\16\13l\13\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\6\21y\n\21\r\21\16\21z\3\21\3\21\2\2\22\3\3\5\4\7"+
		"\2\t\2\13\5\r\6\17\2\21\2\23\2\25\7\27\b\31\t\33\n\35\13\37\f!\r\3\2\b"+
		"\5\2C\\aac|\6\2\62;C\\c|\u0080\u0080\6\2//\62;C\\c|\6\2\60\61C\\aac|\6"+
		"\2/\60\62;C\\c|\5\2\13\f\17\17\"\"\2\u0084\2\3\3\2\2\2\2\5\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7-\3\2\2"+
		"\2\t\61\3\2\2\2\13\63\3\2\2\2\r:\3\2\2\2\17D\3\2\2\2\21H\3\2\2\2\23d\3"+
		"\2\2\2\25f\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37"+
		"u\3\2\2\2!x\3\2\2\2#$\7\f\2\2$\4\3\2\2\2%)\5\7\4\2&(\5\t\5\2\'&\3\2\2"+
		"\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\6\3\2\2\2+)\3\2\2\2,.\t\2\2\2-,\3\2"+
		"\2\2.\b\3\2\2\2/\62\5\7\4\2\60\62\5\13\6\2\61/\3\2\2\2\61\60\3\2\2\2\62"+
		"\n\3\2\2\2\63\67\t\3\2\2\64\66\t\4\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65"+
		"\3\2\2\2\678\3\2\2\28\f\3\2\2\29\67\3\2\2\2:>\5\17\b\2;=\5\21\t\2<;\3"+
		"\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\5\23\n\2B\16"+
		"\3\2\2\2CE\t\5\2\2DC\3\2\2\2E\20\3\2\2\2FI\5\17\b\2GI\5\25\13\2HF\3\2"+
		"\2\2HG\3\2\2\2I\22\3\2\2\2JK\7\60\2\2KL\7r\2\2LM\7p\2\2Me\7i\2\2NO\7\60"+
		"\2\2OP\7R\2\2PQ\7P\2\2Qe\7I\2\2RS\7\60\2\2ST\7d\2\2TU\7o\2\2Ue\7r\2\2"+
		"VW\7\60\2\2WX\7D\2\2XY\7O\2\2Ye\7R\2\2Z[\7\60\2\2[\\\7l\2\2\\]\7r\2\2"+
		"]^\7g\2\2^e\7i\2\2_`\7\60\2\2`a\7L\2\2ab\7R\2\2bc\7G\2\2ce\7I\2\2dJ\3"+
		"\2\2\2dN\3\2\2\2dR\3\2\2\2dV\3\2\2\2dZ\3\2\2\2d_\3\2\2\2e\24\3\2\2\2f"+
		"j\t\3\2\2gi\t\6\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\26\3\2\2"+
		"\2lj\3\2\2\2mn\7?\2\2n\30\3\2\2\2op\7,\2\2p\32\3\2\2\2qr\7\61\2\2r\34"+
		"\3\2\2\2st\7-\2\2t\36\3\2\2\2uv\7/\2\2v \3\2\2\2wy\t\7\2\2xw\3\2\2\2y"+
		"z\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\21\2\2}\"\3\2\2\2\r\2)-\61"+
		"\67>DHdjz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}