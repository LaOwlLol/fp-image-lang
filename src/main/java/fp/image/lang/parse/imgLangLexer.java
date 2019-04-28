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
		ID=1, STRING=2, EQUAL=3, MULT=4, DIV=5, PLUS=6, MINUS=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "VALID_ID_START", "VALID_ID_CHAR", "IMAGE_EXTENSION", "STRING", 
			"EQUAL", "MULT", "DIV", "PLUS", "MINUS", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "STRING", "EQUAL", "MULT", "DIV", "PLUS", "MINUS", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n]\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\5\3$\n\3\3"+
		"\4\3\4\5\4(\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5\3\6\3\6\7"+
		"\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6"+
		"\fX\n\f\r\f\16\fY\3\f\3\f\2\2\r\3\3\5\2\7\2\t\2\13\4\r\5\17\6\21\7\23"+
		"\b\25\t\27\n\3\2\6\6\2\60\61C\\aac|\6\2\62;C\\c|\u0080\u0080\6\2/\60\62"+
		";C\\c|\5\2\13\f\17\17\"\"\2b\2\3\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2"+
		"\2\2\5#\3\2\2\2\7\'\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rL\3\2\2\2\17N\3\2"+
		"\2\2\21P\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27W\3\2\2\2\31\35\5\5\3\2\32"+
		"\34\5\7\4\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36"+
		" \3\2\2\2\37\35\3\2\2\2 !\5\t\5\2!\4\3\2\2\2\"$\t\2\2\2#\"\3\2\2\2$\6"+
		"\3\2\2\2%(\5\5\3\2&(\5\13\6\2\'%\3\2\2\2\'&\3\2\2\2(\b\3\2\2\2)*\7\60"+
		"\2\2*+\7r\2\2+,\7p\2\2,D\7i\2\2-.\7\60\2\2./\7R\2\2/\60\7P\2\2\60D\7I"+
		"\2\2\61\62\7\60\2\2\62\63\7d\2\2\63\64\7o\2\2\64D\7r\2\2\65\66\7\60\2"+
		"\2\66\67\7D\2\2\678\7O\2\28D\7R\2\29:\7\60\2\2:;\7l\2\2;<\7r\2\2<=\7g"+
		"\2\2=D\7i\2\2>?\7\60\2\2?@\7L\2\2@A\7R\2\2AB\7G\2\2BD\7I\2\2C)\3\2\2\2"+
		"C-\3\2\2\2C\61\3\2\2\2C\65\3\2\2\2C9\3\2\2\2C>\3\2\2\2D\n\3\2\2\2EI\t"+
		"\3\2\2FH\t\4\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\f\3\2\2\2KI"+
		"\3\2\2\2LM\7?\2\2M\16\3\2\2\2NO\7,\2\2O\20\3\2\2\2PQ\7\61\2\2Q\22\3\2"+
		"\2\2RS\7-\2\2S\24\3\2\2\2TU\7/\2\2U\26\3\2\2\2VX\t\5\2\2WV\3\2\2\2XY\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\b\f\2\2\\\30\3\2\2\2\t\2\35#\'"+
		"CIY\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}