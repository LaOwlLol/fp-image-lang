package fp.image.lang;

import fauxpas.entities.FilterableImage;
import fauxpas.filters.*;
import fp.image.lang.parse.imgLangBaseVisitor;
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

public class Interpreter extends imgLangBaseVisitor<FilterableImage> {

    private FilterableImage last;
    //private Stack<FilterableImage> images;
    private Stack<Integer> intArgs;
    private Stack<Float> floatArgs;
    private Stack<Boolean> boolArgs;
    private HashMap<String, FilterableImage> vars;
    boolean inWrite;
    private File outputFile;

    public Interpreter() {
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

        return this.visit(tree);
    }

    @Override
    public FilterableImage visitCanny(imgLangParser.CannyContext ctx) {

        visit(ctx.floatValue(0));
        Float f1 = floatArgs.pop();
        visit(ctx.floatValue(1));
        Float f2 = floatArgs.pop();
        FilterableImage r = visit(ctx.image());
        r.applyFilter(new CannyFilter(f1, f2));
        return r;
    }

    @Override
    public FilterableImage visitSobel(imgLangParser.SobelContext ctx) {


        visit(ctx.floatValue());
        Float f1 = floatArgs.pop();
        FilterableImage r = visit(ctx.image());


        if (ctx.boolValue().size() == 1) {
            visit(ctx.boolValue(0));
            boolean b1 = boolArgs.pop();

            r.applyFilter(new SobelFilter(f1, b1));
        }
        else if (ctx.boolValue().size() > 1) {
            visit(ctx.boolValue(0));
            boolean b1 = boolArgs.pop();

            visit(ctx.boolValue(1));
            boolean b2 = boolArgs.pop();

            r.applyFilter(new SobelFilter(f1, b1, b2));
        }
        else {
            r.applyFilter(new SobelFilter(f1));
        }

        return  r;
    }

    @Override
    public FilterableImage visitChromaKey(imgLangParser.ChromaKeyContext ctx) {

        visit( ctx.intValue(0) );
        Integer r = intArgs.pop();
        visit( ctx.intValue(1) );
        Integer g = intArgs.pop();
        visit( ctx.intValue(2) );
        Integer b = intArgs.pop();
        visit( ctx.floatValue() );
        Float t = floatArgs.pop();

        FilterableImage re = visit(ctx.image());
        re.applyFilter(new ChromaKeyFilter(Color.rgb(r, g, b), t));
        return re;
    }

    @Override
    public FilterableImage visitGaussianBlur(imgLangParser.GaussianBlurContext ctx) {

        visit(ctx.intValue());
        Integer s = intArgs.pop();
        visit(ctx.floatValue());
        Float f = floatArgs.pop();
        FilterableImage r = visit(ctx.image());
        r.applyFilter(new GaussianBlur(s, f));
        return r;
    }

    @Override
    public FilterableImage visitGrayScale(imgLangParser.GrayScaleContext ctx) {

        FilterableImage r = visit(ctx.image());

        if (ctx.floatValue().size() > 0) {

            visit(ctx.floatValue(0));
            visit(ctx.floatValue(1));
            visit(ctx.floatValue(2));

            float bl = floatArgs.pop();
            float gn = floatArgs.pop();
            float rd = floatArgs.pop();
            r.applyFilter(new GrayscaleFilter(rd, gn, bl));
        }
        else {
            r.applyFilter(new GrayscaleFilter());
        }

        return r;
    }

    @Override
    public FilterableImage visitRedist(imgLangParser.RedistContext ctx) {

        visit(ctx.floatValue());
        Float f = floatArgs.pop();
        FilterableImage r = visit(ctx.image());
        r.applyFilter(new RedistributionFilter(f));
        return r;
    }

    @Override
    public FilterableImage visitTranslucent(imgLangParser.TranslucentContext ctx) {

        FilterableImage r = visit(ctx.image());
        r.applyFilter(new TranslucentFilter());
        return r;

    }

    @Override
    public FilterableImage visitWrite(imgLangParser.WriteContext ctx) {

        inWrite = true;
        visit(ctx.path());
        FilterableImage r = visit(ctx.expression());
        try {
            writeImageToFile( r.getImage() , outputFile);
        } catch (IOException e) {
            System.err.println("Failed to write image: " + ctx.expression().toString());
            System.err.println("\t reason: " + e.getMessage());
        }

        return r;
    }

    @Override
    public FilterableImage visitMinus(imgLangParser.MinusContext ctx) {

        BlendFilter f = new BlendFilter();
        return new FilterableImage(f.apply( visit(ctx.expression()).getImage(), visit(ctx.expression()).getImage() ));
    }

    @Override
    public FilterableImage visitPlus(imgLangParser.PlusContext ctx) {

        SumFilter f = new SumFilter();
        return new FilterableImage(f.apply( visit(ctx.expression()).getImage() , visit(ctx.term()).getImage() ));
    }

    @Override
    public FilterableImage visitMult(imgLangParser.MultContext ctx) {

        ReflectionFilter f = new ReflectionFilter();
        return new FilterableImage(f.apply( visit( ctx.term() ).getImage(), visit(ctx.image()).getImage() ));
    }

    @Override
    public FilterableImage visitAssignment(imgLangParser.AssignmentContext ctx) {

        FilterableImage r = visit(ctx.expression());
        vars.put(ctx.id().ID().getText(), r);
        last = r;
        return r;
    }

    @Override
    public FilterableImage visitPath(imgLangParser.PathContext ctx) {
        super.visitPath(ctx);
        if (inWrite) {

            outputFile = new File(ctx.PATH_LITERAL().getText());
            //outputFile.mkdirs();
            inWrite = false;

            return null;
        }
        else {
            try {
                return getImageLiteral(ctx.PATH_LITERAL().getText());
            } catch (IOException e) {
                //System.err.print("Line: "+ );
                System.err.println("Unknown image file: " + ctx.PATH_LITERAL().getText());
                //e.printStackTrace();
                //TODO how to actually handle errors.
                return new FilterableImage( 0,0 );
            }
        }
    }

    @Override
    public FilterableImage visitIntValue(imgLangParser.IntValueContext ctx) {
        super.visitIntValue(ctx);
        intArgs.push(Integer.parseInt( ctx.INT().getText() ) );
        return null;
    }

    @Override
    public FilterableImage visitFloatValue(imgLangParser.FloatValueContext ctx) {
        super.visitFloatValue(ctx);
        floatArgs.push( Float.parseFloat( ctx.FLOAT().getText() ) );
        return null;
    }

    @Override
    public FilterableImage visitBoolValue(imgLangParser.BoolValueContext ctx) {
        super.visitBoolValue(ctx);
        boolArgs.push( ctx.BOOL().getText().equals("#true") );
        return null;
    }

    @Override
    public FilterableImage visitVar(imgLangParser.VarContext ctx) {
        return vars.get(ctx.id().ID().getText());
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
