package fp.image.lang;

import fauxpas.entities.FilterableImage;
import fauxpas.filters.*;
import fp.image.lang.parse.imgLangBaseListener;
import fp.image.lang.parse.imgLangLexer;
import fp.image.lang.parse.imgLangParser;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

import java.util.Stack;

public class Interpreter extends imgLangBaseListener {

    private FilterableImage last;
    private Stack<FilterableImage> images;
    private Stack<Integer> intArgs;
    private Stack<Float> floatArgs;
    private Stack<Boolean> boolArgs;
    private HashMap<String, FilterableImage> vars;
    boolean inWrite;
    private File outputFile;

    public Interpreter() {
        images = new Stack<>();
        intArgs = new Stack<>();
        floatArgs = new Stack<>();
        boolArgs = new Stack<>();
        vars = new HashMap<>();
        inWrite = false;
    }

    public FilterableImage interp(String script) {
        imgLangLexer imgLexer = new imgLangLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(imgLexer);
        imgLangParser imgParser = new imgLangParser(tokens);
        ParseTree tree = imgParser.script();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);

        return getResult();
    }

    @Override
    public void exitAssignment(imgLangParser.AssignmentContext ctx) {
        super.exitAssignment(ctx);
        last = images.pop();
        vars.put(ctx.id().ID().getText(), last);
    }

    @Override
    public void exitCanny(imgLangParser.CannyContext ctx) {
        super.exitCanny(ctx);
        Float f1 = floatArgs.pop();
        Float f2 = floatArgs.pop();
        FilterableImage r = images.pop();
        r.applyFilter(new CannyFilter(f1, f2));
        images.push( r );
    }

    @Override
    public void exitSobel(imgLangParser.SobelContext ctx) {
        super.exitSobel(ctx);
        Float f1 = floatArgs.pop();
        FilterableImage r = images.pop();
        boolean both = false;
        Boolean b1;
        Boolean b2;
        if (boolArgs.empty()) {
            b1 = false;
            b2 = false;
        }
        else {
            b1 = boolArgs.pop();
            if (boolArgs.empty()) {
                b2 = false;
            }
            else {
                b2 = boolArgs.pop();
                both = true;
            }
        }

        if (both) {
            r.applyFilter(new SobelFilter(f1, b2, b1));
        }
        else {
            r.applyFilter(new SobelFilter(f1, b1));
        }
        images.push( r );
    }

    @Override
    public void exitChromaKey(imgLangParser.ChromaKeyContext ctx) {
        super.exitChromaKey(ctx);

        Integer r = intArgs.pop();
        Integer g = intArgs.pop();
        Integer b = intArgs.pop();
        Float t = floatArgs.pop();
        FilterableImage re = images.pop();
        re.applyFilter(new ChromaKeyFilter(Color.rgb(r, g, b), t));
        images.push( re );
    }

    @Override
    public void exitGaussianBlur(imgLangParser.GaussianBlurContext ctx) {
        super.exitGaussianBlur(ctx);

        Integer s = intArgs.pop();
        Float f = floatArgs.pop();
        FilterableImage r = images.pop();
        r.applyFilter(new GaussianBlur(s, f));
        images.push( r );
    }

    @Override
    public void exitGrayScale(imgLangParser.GrayScaleContext ctx) {
        super.exitGrayScale(ctx);
        FilterableImage r = images.pop();

        if (!floatArgs.empty()) {
            float bl = floatArgs.pop();
            float gn = floatArgs.pop();
            float rd = floatArgs.pop();
            r.applyFilter(new GrayscaleFilter(rd, gn, bl));
        }
        else {
            r.applyFilter(new GrayscaleFilter());
        }

        images.push( r );
    }

    @Override
    public void exitRedist(imgLangParser.RedistContext ctx) {
        super.exitRedist(ctx);
        Float f = floatArgs.pop();
        FilterableImage r = images.pop();
        r.applyFilter(new RedistributionFilter(f));
        images.push( r );
    }

    @Override
    public void exitTranslucent(imgLangParser.TranslucentContext ctx) {
        super.exitTranslucent(ctx);
        FilterableImage r = images.pop();
        r.applyFilter(new TranslucentFilter());
        images.push( r );
    }

    @Override
    public void enterWrite(imgLangParser.WriteContext ctx) {
        super.enterWrite(ctx);
        inWrite = true;
    }

    @Override
    public void exitWrite(imgLangParser.WriteContext ctx) {
        super.exitWrite(ctx);
        FilterableImage i = images.pop();

        try {
            writeImageToFile(i.getImage() , outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exitMinus(imgLangParser.MinusContext ctx) {
        super.exitMinus(ctx);

        Image i1 = images.pop().getImage();
        Image i2 = images.pop().getImage();
        BlendFilter f = new BlendFilter();
        FilterableImage r = new FilterableImage(f.apply( i2, i1 ));
        images.push( r );
    }

    @Override
    public void exitPlus(imgLangParser.PlusContext ctx) {
        super.exitPlus(ctx);

        Image i1 = images.pop().getImage();
        Image i2 = images.pop().getImage();
        SumFilter f = new SumFilter();
        FilterableImage r = new FilterableImage(f.apply( i2, i1 ));
        images.push( r );
    }

    @Override
    public void exitMult(imgLangParser.MultContext ctx) {
        super.exitMult(ctx);

        Image i1 = images.pop().getImage();
        Image i2 = images.pop().getImage();
        ReflectionFilter f = new ReflectionFilter();
        FilterableImage r = new FilterableImage(f.apply( i2, i1 ));
        images.push( r );
    }

    @Override
    public void exitVar(imgLangParser.VarContext ctx) {
        super.exitVar(ctx);
        try {
            images.push(getImageVariable(ctx.id().ID().getText()));
        } catch (NoSuchFieldException e) {
            //System.err.print("Line: "+ );
            System.err.println("Unknown image variable: "+ ctx.id().ID().getText());
            //e.printStackTrace();
        }
    }

    @Override
    public void exitPath(imgLangParser.PathContext ctx) {
        super.exitPath(ctx);
        if (inWrite) {

            outputFile = new File(ctx.PATH_LITERAL().getText());
            //outputFile.mkdirs();
            inWrite = false;
        }
        try {
            images.push(getImageLiteral(ctx.PATH_LITERAL().getText()));
        } catch (IOException e) {
            //System.err.print("Line: "+ );
            System.err.println("Unknown image file: "+ ctx.PATH_LITERAL().getText());
            //e.printStackTrace();
        }
    }

    @Override
    public void exitIntValue(imgLangParser.IntValueContext ctx) {
        super.exitIntValue(ctx);
        intArgs.push(Integer.parseInt( ctx.INT().getText() ) );
    }

    @Override
    public void exitFloatValue(imgLangParser.FloatValueContext ctx) {
        super.exitFloatValue(ctx);
        floatArgs.push( Float.parseFloat( ctx.FLOAT().getText() ) );
    }

    @Override
    public void exitBoolValue(imgLangParser.BoolValueContext ctx) {
        super.enterBoolValue(ctx);
        boolArgs.push( ctx.BOOL().getText().equals("#true") );
    }

    private FilterableImage getResult() {
        if (images.empty()) {
            return last;
        }
        else {
            return images.pop();
        }
    }

    private FilterableImage getImageVariable(String id) throws NoSuchFieldException {

        if (vars.containsKey(id)) {
            return vars.get(id);
        }

        throw new NoSuchFieldException();
    }

    private FilterableImage getImageLiteral(String path) throws IOException {

        File file = new File(path);
        if (file.isFile()) {
            if (isImage(file)) {
                return new FilterableImage(new Image(file.toURI().toString()));
            }
        }

        throw new IOException();

    }

    private void writeImageToFile(Image img, File file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getPath());

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), extension, file);
        } catch (IOException e) {
            throw e;
        }
    }

    static private boolean isImage(File file) {
        try {
            return (Files.probeContentType(file.toPath()).split("/")[0]).equals("image");
        } catch (IOException e) {
            return false;
        }
    }

}
