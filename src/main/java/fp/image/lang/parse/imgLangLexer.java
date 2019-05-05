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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, ID_STRING=12, PATH_LITERAL=13, INT=14, FLOAT=15, NEWLINE=16, 
		PATH_STRING=17, EQUAL=18, MULT=19, DIV=20, PLUS=21, MINUS=22, COMMENT=23, 
		WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "ID", "VALID_ID_START", "VALID_ID_CHAR", "ID_STRING", "PATH_LITERAL", 
			"VALID_PATH_START", "VALID_PATH_CHAR", "IMAGE_EXTENSION", "DIGIT", "INT", 
			"FLOAT", "NEWLINE", "PATH_STRING", "EQUAL", "MULT", "DIV", "PLUS", "MINUS", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'canny'", "'('", "','", "')'", "'sobel'", "'chromaKey'", "'gaussianBlur'", 
			"'grayScale'", "'sharpen'", "'translucent'", null, null, null, null, 
			null, null, null, "'='", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"ID_STRING", "PATH_LITERAL", "INT", "FLOAT", "NEWLINE", "PATH_STRING", 
			"EQUAL", "MULT", "DIV", "PLUS", "MINUS", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0119\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\7\f\u0089\n\f\f\f\16\f\u008c\13\f\3\r\5\r\u008f"+
		"\n\r\3\16\3\16\5\16\u0093\n\16\3\17\3\17\7\17\u0097\n\17\f\17\16\17\u009a"+
		"\13\17\3\20\3\20\7\20\u009e\n\20\f\20\16\20\u00a1\13\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3\22"+
		"\5\22\u00b3\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d7\n\23\3\24\3\24"+
		"\3\25\6\25\u00dc\n\25\r\25\16\25\u00dd\3\26\6\26\u00e1\n\26\r\26\16\26"+
		"\u00e2\3\26\3\26\7\26\u00e7\n\26\f\26\16\26\u00ea\13\26\3\26\3\26\6\26"+
		"\u00ee\n\26\r\26\16\26\u00ef\5\26\u00f2\n\26\3\27\3\27\3\27\5\27\u00f7"+
		"\n\27\3\30\3\30\7\30\u00fb\n\30\f\30\16\30\u00fe\13\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\7\36\u010c\n\36\f\36\16"+
		"\36\u010f\13\36\3\36\3\36\3\37\6\37\u0114\n\37\r\37\16\37\u0115\3\37\3"+
		"\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2"+
		"\35\16\37\17!\2#\2%\2\'\2)\20+\21-\22/\23\61\24\63\25\65\26\67\279\30"+
		";\31=\32\3\2\t\5\2C\\aac|\6\2\62;C\\c|\u0080\u0080\6\2//\62;C\\c|\4\2"+
		"\f\ftt\6\2/\60\62;C\\c|\4\2\f\f\17\17\4\2\"\"vv\2\u012b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\3?\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rQ\3\2\2\2\17"+
		"[\3\2\2\2\21h\3\2\2\2\23r\3\2\2\2\25z\3\2\2\2\27\u0086\3\2\2\2\31\u008e"+
		"\3\2\2\2\33\u0092\3\2\2\2\35\u0094\3\2\2\2\37\u009b\3\2\2\2!\u00ae\3\2"+
		"\2\2#\u00b2\3\2\2\2%\u00d6\3\2\2\2\'\u00d8\3\2\2\2)\u00db\3\2\2\2+\u00f1"+
		"\3\2\2\2-\u00f6\3\2\2\2/\u00f8\3\2\2\2\61\u00ff\3\2\2\2\63\u0101\3\2\2"+
		"\2\65\u0103\3\2\2\2\67\u0105\3\2\2\29\u0107\3\2\2\2;\u0109\3\2\2\2=\u0113"+
		"\3\2\2\2?@\7e\2\2@A\7c\2\2AB\7p\2\2BC\7p\2\2CD\7{\2\2D\4\3\2\2\2EF\7*"+
		"\2\2F\6\3\2\2\2GH\7.\2\2H\b\3\2\2\2IJ\7+\2\2J\n\3\2\2\2KL\7u\2\2LM\7q"+
		"\2\2MN\7d\2\2NO\7g\2\2OP\7n\2\2P\f\3\2\2\2QR\7e\2\2RS\7j\2\2ST\7t\2\2"+
		"TU\7q\2\2UV\7o\2\2VW\7c\2\2WX\7M\2\2XY\7g\2\2YZ\7{\2\2Z\16\3\2\2\2[\\"+
		"\7i\2\2\\]\7c\2\2]^\7w\2\2^_\7u\2\2_`\7u\2\2`a\7k\2\2ab\7c\2\2bc\7p\2"+
		"\2cd\7D\2\2de\7n\2\2ef\7w\2\2fg\7t\2\2g\20\3\2\2\2hi\7i\2\2ij\7t\2\2j"+
		"k\7c\2\2kl\7{\2\2lm\7U\2\2mn\7e\2\2no\7c\2\2op\7n\2\2pq\7g\2\2q\22\3\2"+
		"\2\2rs\7u\2\2st\7j\2\2tu\7c\2\2uv\7t\2\2vw\7r\2\2wx\7g\2\2xy\7p\2\2y\24"+
		"\3\2\2\2z{\7v\2\2{|\7t\2\2|}\7c\2\2}~\7p\2\2~\177\7u\2\2\177\u0080\7n"+
		"\2\2\u0080\u0081\7w\2\2\u0081\u0082\7e\2\2\u0082\u0083\7g\2\2\u0083\u0084"+
		"\7p\2\2\u0084\u0085\7v\2\2\u0085\26\3\2\2\2\u0086\u008a\5\31\r\2\u0087"+
		"\u0089\5\33\16\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3"+
		"\2\2\2\u008a\u008b\3\2\2\2\u008b\30\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008f\t\2\2\2\u008e\u008d\3\2\2\2\u008f\32\3\2\2\2\u0090\u0093\5\31\r"+
		"\2\u0091\u0093\5\35\17\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\34\3\2\2\2\u0094\u0098\t\3\2\2\u0095\u0097\t\4\2\2\u0096\u0095\3\2\2"+
		"\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\36"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009f\5!\21\2\u009c\u009e\5#\22\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\5%\23\2\u00a3"+
		" \3\2\2\2\u00a4\u00af\t\2\2\2\u00a5\u00a6\7\60\2\2\u00a6\u00af\7\61\2"+
		"\2\u00a7\u00af\7\61\2\2\u00a8\u00a9\4c|\2\u00a9\u00aa\7<\2\2\u00aa\u00af"+
		"\7\61\2\2\u00ab\u00ac\4C\\\2\u00ac\u00ad\7<\2\2\u00ad\u00af\7\61\2\2\u00ae"+
		"\u00a4\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae\u00a7\3\2\2\2\u00ae\u00a8\3\2"+
		"\2\2\u00ae\u00ab\3\2\2\2\u00af\"\3\2\2\2\u00b0\u00b3\5!\21\2\u00b1\u00b3"+
		"\5/\30\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3$\3\2\2\2\u00b4"+
		"\u00b5\7\60\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7\7p\2\2\u00b7\u00d7\7i\2"+
		"\2\u00b8\u00b9\7\60\2\2\u00b9\u00ba\7R\2\2\u00ba\u00bb\7P\2\2\u00bb\u00d7"+
		"\7I\2\2\u00bc\u00bd\7\60\2\2\u00bd\u00be\7d\2\2\u00be\u00bf\7o\2\2\u00bf"+
		"\u00d7\7r\2\2\u00c0\u00c1\7\60\2\2\u00c1\u00c2\7D\2\2\u00c2\u00c3\7O\2"+
		"\2\u00c3\u00d7\7R\2\2\u00c4\u00c5\7\60\2\2\u00c5\u00c6\7l\2\2\u00c6\u00c7"+
		"\7r\2\2\u00c7\u00c8\7g\2\2\u00c8\u00d7\7i\2\2\u00c9\u00ca\7\60\2\2\u00ca"+
		"\u00cb\7L\2\2\u00cb\u00cc\7R\2\2\u00cc\u00cd\7G\2\2\u00cd\u00d7\7I\2\2"+
		"\u00ce\u00cf\7\60\2\2\u00cf\u00d0\7l\2\2\u00d0\u00d1\7r\2\2\u00d1\u00d7"+
		"\7i\2\2\u00d2\u00d3\7\60\2\2\u00d3\u00d4\7L\2\2\u00d4\u00d5\7R\2\2\u00d5"+
		"\u00d7\7I\2\2\u00d6\u00b4\3\2\2\2\u00d6\u00b8\3\2\2\2\u00d6\u00bc\3\2"+
		"\2\2\u00d6\u00c0\3\2\2\2\u00d6\u00c4\3\2\2\2\u00d6\u00c9\3\2\2\2\u00d6"+
		"\u00ce\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d7&\3\2\2\2\u00d8\u00d9\4\62;\2"+
		"\u00d9(\3\2\2\2\u00da\u00dc\5\'\24\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de*\3\2\2\2\u00df\u00e1"+
		"\5\'\24\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e8\7\60\2\2\u00e5\u00e7"+
		"\5\'\24\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00f2\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed"+
		"\7\60\2\2\u00ec\u00ee\5\'\24\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00e0"+
		"\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2,\3\2\2\2\u00f3\u00f4\7\17\2\2\u00f4"+
		"\u00f7\7\f\2\2\u00f5\u00f7\t\5\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f5\3\2"+
		"\2\2\u00f7.\3\2\2\2\u00f8\u00fc\t\3\2\2\u00f9\u00fb\t\6\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\60\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7?\2\2\u0100\62\3\2\2\2\u0101"+
		"\u0102\7,\2\2\u0102\64\3\2\2\2\u0103\u0104\7\61\2\2\u0104\66\3\2\2\2\u0105"+
		"\u0106\7-\2\2\u01068\3\2\2\2\u0107\u0108\7/\2\2\u0108:\3\2\2\2\u0109\u010d"+
		"\7%\2\2\u010a\u010c\n\7\2\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u0110\u0111\b\36\2\2\u0111<\3\2\2\2\u0112\u0114\t\b\2\2\u0113\u0112"+
		"\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\b\37\2\2\u0118>\3\2\2\2\24\2\u008a\u008e\u0092"+
		"\u0098\u009f\u00ae\u00b2\u00d6\u00dd\u00e2\u00e8\u00ef\u00f1\u00f6\u00fc"+
		"\u010d\u0115\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}