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
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import java.util.Stack;
import java.util.stream.Stream;

public class Interpreter extends imgLangBaseVisitor<FilterableImage> {

    private Stack<Integer> loopIter;
    private HashMap<String, FilterableImage> vars;
    private File outputFile;
    private boolean inWrite;
    private boolean looping;


    public Interpreter() {
        loopIter = new Stack<>();
        vars = new HashMap<>();
        inWrite = false;
        looping = false;
    }

    public FilterableImage interp(String script) {
        imgLangLexer imgLexer = new imgLangLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(imgLexer);
        imgLangParser imgParser = new imgLangParser(tokens);
        ParseTree tree = imgParser.script();

        return this.visit(tree);
    }

    @Override
    public FilterableImage visitForeach(imgLangParser.ForeachContext ctx) {

        //check the id given.
        if (vars.containsKey(ctx.id().ID().getText())) {
            System.err.println("Foreach ID: "+ctx.id().ID().getText() +
                    "\n ID is already a variable name. Skipping for each...");
            return new FilterableImage(1,1);
        }

        //check directory
        Path p = Paths.get(ctx.dir().DIR_LITERAL().getText());
        if (!isExistingDirectory(p)) {
            //error
            System.err.println("Foreach in DIR: "+ctx.dir().DIR_LITERAL().getText() +
                    "\n DIR is not an existing directory.  Skipping foreach...");
            return new FilterableImage(1, 1);
        }

        looping = true;
        loopIter.push(0);
        try (Stream<Path> list = Files.list(p).sorted() ) {
            list.filter( dirItem -> isImage(dirItem.toFile()) ).forEach( imagePath -> {
                try {
                    FilterableImage image = getImageLiteral(imagePath.toFile());
                    vars.put(ctx.id().ID().getText(), image);


                    visit(ctx.body());
                    loopIter.push(loopIter.pop() + 1 );

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } );
        }
        catch (IOException e) {

        }
        loopIter.pop();
        looping = false;

        return vars.remove(ctx.id().ID().getText());
    }

    @Override
    public FilterableImage visitCanny(imgLangParser.CannyContext ctx) {

        float f1 = parseFloatCtx( ctx.floatValue(0) );
        float f2 = parseFloatCtx( ctx.floatValue(1) );
        FilterableImage r = visit(ctx.expression());
        r.applyFilter(new CannyFilter(f1, f2));
        return r;
    }

    @Override
    public FilterableImage visitSobel(imgLangParser.SobelContext ctx) {


        float f1 = parseFloatCtx( ctx.floatValue());
        FilterableImage r = visit(ctx.expression());

        if (ctx.boolValue().size() == 1) {

            boolean b1 = parseBoolCtx( ctx.boolValue(0) );

            r.applyFilter(new SobelFilter(f1, b1));
        }
        else if (ctx.boolValue().size() > 1) {
            visit(ctx.boolValue(0));
            boolean b1 = parseBoolCtx( ctx.boolValue(0) );

            visit(ctx.boolValue(1));
            boolean b2 = parseBoolCtx( ctx.boolValue(1) );

            r.applyFilter(new SobelFilter(f1, b1, b2));
        }
        else {
            r.applyFilter(new SobelFilter(f1));
        }

        return  r;
    }

    @Override
    public FilterableImage visitChromaKey(imgLangParser.ChromaKeyContext ctx) {

        int r = parseIntCtx( ctx.intValue(0) );
        int g = parseIntCtx( ctx.intValue(1) );
        int b = parseIntCtx( ctx.intValue(2) );
        float t = parseFloatCtx( ctx.floatValue() );

        FilterableImage target = visit(ctx.expression(0));

        if ( ctx.expression().size() == 2 ) {
            target.applyFilter(new ChromaKeyFilter(Color.rgb(r, g, b), visit(ctx.expression(1)).getImage(), t));
        }
        else if (ctx.intValue().size() > 3 ) {
            int sr = parseIntCtx( ctx.intValue(3) );
            int sg = parseIntCtx( ctx.intValue(4) );
            int sb = parseIntCtx( ctx.intValue(5) );

            target.applyFilter(new ChromaKeyFilter(Color.rgb(r, g, b), Color.rgb(sr, sg, sb), t));
        }
        else {
            target.applyFilter(new ChromaKeyFilter(Color.rgb(r, g, b), t));
        }

        return target;
    }

    @Override
    public FilterableImage visitGaussianBlur(imgLangParser.GaussianBlurContext ctx) {


        int s = parseIntCtx( ctx.intValue() );
        float f = parseFloatCtx( ctx.floatValue() );
        FilterableImage r = visit(ctx.expression());
        r.applyFilter(new GaussianBlur(s, f));
        return r;
    }

    @Override
    public FilterableImage visitGrayScale(imgLangParser.GrayScaleContext ctx) {

        FilterableImage r = visit(ctx.expression());

        if (ctx.floatValue().size() > 0) {

            float bl = parseFloatCtx( ctx.floatValue(0) );
            float gn = parseFloatCtx( ctx.floatValue(1) );
            float rd = parseFloatCtx( ctx.floatValue(2) );
            r.applyFilter(new GrayscaleFilter(rd, gn, bl));
        }
        else {
            r.applyFilter(new GrayscaleFilter());
        }

        return r;
    }

    @Override
    public FilterableImage visitRedist(imgLangParser.RedistContext ctx) {

        float f = parseFloatCtx( ctx.floatValue() );
        FilterableImage r = visit(ctx.expression());
        r.applyFilter(new RedistributionFilter(f));
        return r;
    }

    @Override
    public FilterableImage visitTranslucent(imgLangParser.TranslucentContext ctx) {

        FilterableImage r = visit(ctx.expression());
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

        CompositeFilter f = new CompositeFilter();
        return new FilterableImage(f.apply( visit(ctx.expression()).getImage(), visit(ctx.term()).getImage() ));
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
        return r;
    }

    @Override
    public FilterableImage visitPath(imgLangParser.PathContext ctx) {

        if (inWrite) {

            //super hack for iterating.
            if (looping) {
                int extBegin = ctx.PATH_LITERAL().getText().lastIndexOf('.');
                String body = ctx.PATH_LITERAL().getText().substring(0, extBegin);
                String ext = ctx.PATH_LITERAL().getText().substring(extBegin);
                outputFile = new File( body + "_"+loopIter.peek() + ext );
            }
            else {
                outputFile = new File(ctx.PATH_LITERAL().getText());
            }

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
    public FilterableImage visitVar(imgLangParser.VarContext ctx) {
        return vars.get(ctx.id().ID().getText());
    }

    private FilterableImage getImageLiteral(String path) throws IOException {
        return getImageLiteral(new File(path));
    }

    private FilterableImage getImageLiteral(File file) throws IOException {
        if (file.isFile()) {
            if (isImage(file)) {
                return new FilterableImage(new Image(file.toURI().toString()));
            }
        }

        throw new IOException();
    }

    private void writeImageToFile(Image img, File file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getPath());

        ImageIO.write(SwingFXUtils.fromFXImage(img, null), extension, file);
    }

    static private boolean isImage(File file) {
        try {
            return (Files.probeContentType(file.toPath()).split("/")[0]).equals("image");
        } catch (IOException e) {
            return false;
        }
    }

    static private boolean isExistingDirectory(Path dir) {
        return Files.exists(dir) && Files.isDirectory(dir);
    }

    private float parseFloatCtx(imgLangParser.FloatValueContext fctx) {
        return Float.parseFloat(fctx.FLOAT().toString());
    }

    private int parseIntCtx(imgLangParser.IntValueContext ictx) {
        return Integer.parseInt( ictx.INT().getText() );
    }

    private boolean parseBoolCtx(imgLangParser.BoolValueContext bctx) {
        return bctx.BOOL().getText().equals("#true");
    }
}
