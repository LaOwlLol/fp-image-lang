// Generated from imgLang.g4 by ANTLR 4.7.2
package fp.image.lang.parse;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class imgLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, ID_STRING=12, PATH_LITERAL=13, INT=14, FLOAT=15, NEWLINE=16, 
		PATH_STRING=17, EQUAL=18, MULT=19, DIV=20, PLUS=21, MINUS=22, COMMENT=23, 
		WS=24;
	public static final int
		RULE_script = 0, RULE_line = 1, RULE_assignment = 2, RULE_expression = 3, 
		RULE_term = 4, RULE_image = 5, RULE_operation = 6, RULE_id = 7, RULE_path = 8, 
		RULE_value = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "line", "assignment", "expression", "term", "image", "operation", 
			"id", "path", "value"
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

	@Override
	public String getGrammarFileName() { return "imgLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public imgLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ScriptContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(imgLangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(imgLangParser.NEWLINE, i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(20);
				match(NEWLINE);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			line();
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(27);
						match(NEWLINE);
						}
						}
						setState(30); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(32);
					line();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(38);
				match(NEWLINE);
				}
				}
				setState(43);
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

	public static class LineContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				expression(0);
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

	public static class AssignmentContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(imgLangParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			id();
			setState(49);
			match(EQUAL);
			setState(50);
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
	public static class SingleTermContext extends ExpressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SingleTermContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterSingleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitSingleTerm(this);
		}
	}
	public static class PlusContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(imgLangParser.PLUS, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public PlusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitPlus(this);
		}
	}
	public static class MinusContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(imgLangParser.MINUS, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MinusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitMinus(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(53);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(55);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(56);
						match(PLUS);
						setState(57);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(58);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(59);
						match(MINUS);
						setState(60);
						term(0);
						}
						break;
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode DIV() { return getToken(imgLangParser.DIV, 0); }
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public DivContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitDiv(this);
		}
	}
	public static class MultContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULT() { return getToken(imgLangParser.MULT, 0); }
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public MultContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitMult(this);
		}
	}
	public static class ImageTermContext extends TermContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public ImageTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterImageTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitImageTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ImageTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(67);
			image();
			}
			_ctx.stop = _input.LT(-1);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(75);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(69);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(70);
						match(MULT);
						setState(71);
						image();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(72);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(73);
						match(DIV);
						setState(74);
						image();
						}
						break;
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class ImageContext extends ParserRuleContext {
		public ImageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_image; }
	 
		public ImageContext() { }
		public void copyFrom(ImageContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends ImageContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public CallContext(ImageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitCall(this);
		}
	}
	public static class VarContext extends ImageContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public VarContext(ImageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitVar(this);
		}
	}
	public static class LiteralContext extends ImageContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public LiteralContext(ImageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitLiteral(this);
		}
	}

	public final ImageContext image() throws RecognitionException {
		ImageContext _localctx = new ImageContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_image);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				id();
				}
				break;
			case PATH_LITERAL:
				_localctx = new LiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				path();
				}
				break;
			case T__0:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				operation();
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

	public static class OperationContext extends ParserRuleContext {
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GrayScaleContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public GrayScaleContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterGrayScale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitGrayScale(this);
		}
	}
	public static class CannyContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public List<TerminalNode> FLOAT() { return getTokens(imgLangParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(imgLangParser.FLOAT, i);
		}
		public CannyContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterCanny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitCanny(this);
		}
	}
	public static class GaussianBlurContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public TerminalNode INT() { return getToken(imgLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(imgLangParser.FLOAT, 0); }
		public GaussianBlurContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterGaussianBlur(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitGaussianBlur(this);
		}
	}
	public static class SobelContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(imgLangParser.FLOAT, 0); }
		public SobelContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterSobel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitSobel(this);
		}
	}
	public static class ChromaKeyContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public List<TerminalNode> FLOAT() { return getTokens(imgLangParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(imgLangParser.FLOAT, i);
		}
		public ChromaKeyContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterChromaKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitChromaKey(this);
		}
	}
	public static class SharpenContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(imgLangParser.FLOAT, 0); }
		public SharpenContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterSharpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitSharpen(this);
		}
	}
	public static class TranslucentContext extends OperationContext {
		public ImageContext image() {
			return getRuleContext(ImageContext.class,0);
		}
		public TranslucentContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterTranslucent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitTranslucent(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operation);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new CannyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__0);
				setState(86);
				match(T__1);
				setState(87);
				image();
				setState(88);
				match(T__2);
				setState(89);
				match(FLOAT);
				setState(90);
				match(T__2);
				setState(91);
				match(FLOAT);
				setState(92);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new SobelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(T__4);
				setState(95);
				match(T__1);
				setState(96);
				image();
				setState(97);
				match(T__2);
				setState(98);
				match(FLOAT);
				setState(99);
				match(T__3);
				}
				break;
			case T__5:
				_localctx = new ChromaKeyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__5);
				setState(102);
				match(T__1);
				setState(103);
				image();
				setState(104);
				match(T__2);
				setState(105);
				match(FLOAT);
				setState(106);
				match(T__2);
				setState(107);
				match(FLOAT);
				setState(108);
				match(T__2);
				setState(109);
				match(FLOAT);
				setState(110);
				match(T__3);
				}
				break;
			case T__6:
				_localctx = new GaussianBlurContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(T__6);
				setState(113);
				match(T__1);
				setState(114);
				image();
				setState(115);
				match(T__2);
				setState(116);
				match(INT);
				setState(117);
				match(T__2);
				setState(118);
				match(FLOAT);
				setState(119);
				match(T__3);
				}
				break;
			case T__7:
				_localctx = new GrayScaleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				match(T__7);
				setState(122);
				match(T__1);
				setState(123);
				image();
				setState(124);
				match(T__3);
				}
				break;
			case T__8:
				_localctx = new SharpenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				match(T__8);
				setState(127);
				match(T__1);
				setState(128);
				image();
				setState(129);
				match(T__2);
				setState(130);
				match(FLOAT);
				setState(131);
				match(T__3);
				}
				break;
			case T__9:
				_localctx = new TranslucentContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(133);
				match(T__9);
				setState(134);
				match(T__1);
				setState(135);
				image();
				setState(136);
				match(T__3);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(imgLangParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);
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

	public static class PathContext extends ParserRuleContext {
		public TerminalNode PATH_LITERAL() { return getToken(imgLangParser.PATH_LITERAL, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(PATH_LITERAL);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(imgLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(imgLangParser.FLOAT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof imgLangListener ) ((imgLangListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 4:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u0095\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\6\2\37\n\2\r\2\16\2 \3\2"+
		"\7\2$\n\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\5\3\61\n"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16"+
		"\5C\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\3"+
		"\7\3\7\3\7\5\7V\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u008d\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\2"+
		"\4\b\n\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\20\21\2\u009b\2\31\3\2\2\2\4"+
		"\60\3\2\2\2\6\62\3\2\2\2\b\66\3\2\2\2\nD\3\2\2\2\fU\3\2\2\2\16\u008c\3"+
		"\2\2\2\20\u008e\3\2\2\2\22\u0090\3\2\2\2\24\u0092\3\2\2\2\26\30\7\22\2"+
		"\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2"+
		"\2\33\31\3\2\2\2\34%\5\4\3\2\35\37\7\22\2\2\36\35\3\2\2\2\37 \3\2\2\2"+
		" \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"$\5\4\3\2#\36\3\2\2\2$\'\3\2\2\2%#"+
		"\3\2\2\2%&\3\2\2\2&+\3\2\2\2\'%\3\2\2\2(*\7\22\2\2)(\3\2\2\2*-\3\2\2\2"+
		"+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2\2.\61\5\6\4\2/\61\5\b\5\2\60."+
		"\3\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\63\5\20\t\2\63\64\7\24\2\2\64\65"+
		"\5\b\5\2\65\7\3\2\2\2\66\67\b\5\1\2\678\5\n\6\28A\3\2\2\29:\f\4\2\2:;"+
		"\7\27\2\2;@\5\n\6\2<=\f\3\2\2=>\7\30\2\2>@\5\n\6\2?9\3\2\2\2?<\3\2\2\2"+
		"@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CA\3\2\2\2DE\b\6\1\2EF\5\f\7"+
		"\2FO\3\2\2\2GH\f\4\2\2HI\7\25\2\2IN\5\f\7\2JK\f\3\2\2KL\7\26\2\2LN\5\f"+
		"\7\2MG\3\2\2\2MJ\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\13\3\2\2\2QO\3"+
		"\2\2\2RV\5\20\t\2SV\5\22\n\2TV\5\16\b\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2"+
		"V\r\3\2\2\2WX\7\3\2\2XY\7\4\2\2YZ\5\f\7\2Z[\7\5\2\2[\\\7\21\2\2\\]\7\5"+
		"\2\2]^\7\21\2\2^_\7\6\2\2_\u008d\3\2\2\2`a\7\7\2\2ab\7\4\2\2bc\5\f\7\2"+
		"cd\7\5\2\2de\7\21\2\2ef\7\6\2\2f\u008d\3\2\2\2gh\7\b\2\2hi\7\4\2\2ij\5"+
		"\f\7\2jk\7\5\2\2kl\7\21\2\2lm\7\5\2\2mn\7\21\2\2no\7\5\2\2op\7\21\2\2"+
		"pq\7\6\2\2q\u008d\3\2\2\2rs\7\t\2\2st\7\4\2\2tu\5\f\7\2uv\7\5\2\2vw\7"+
		"\20\2\2wx\7\5\2\2xy\7\21\2\2yz\7\6\2\2z\u008d\3\2\2\2{|\7\n\2\2|}\7\4"+
		"\2\2}~\5\f\7\2~\177\7\6\2\2\177\u008d\3\2\2\2\u0080\u0081\7\13\2\2\u0081"+
		"\u0082\7\4\2\2\u0082\u0083\5\f\7\2\u0083\u0084\7\5\2\2\u0084\u0085\7\21"+
		"\2\2\u0085\u0086\7\6\2\2\u0086\u008d\3\2\2\2\u0087\u0088\7\f\2\2\u0088"+
		"\u0089\7\4\2\2\u0089\u008a\5\f\7\2\u008a\u008b\7\6\2\2\u008b\u008d\3\2"+
		"\2\2\u008cW\3\2\2\2\u008c`\3\2\2\2\u008cg\3\2\2\2\u008cr\3\2\2\2\u008c"+
		"{\3\2\2\2\u008c\u0080\3\2\2\2\u008c\u0087\3\2\2\2\u008d\17\3\2\2\2\u008e"+
		"\u008f\7\r\2\2\u008f\21\3\2\2\2\u0090\u0091\7\17\2\2\u0091\23\3\2\2\2"+
		"\u0092\u0093\t\2\2\2\u0093\25\3\2\2\2\r\31 %+\60?AMOU\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}