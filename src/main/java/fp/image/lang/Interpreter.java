package fp.image.lang;

import fauxpas.entities.FilterableImage;
import fauxpas.entities.ImageHelper;
import fauxpas.filters.*;
import fp.image.lang.parse.imgLangBaseVisitor;
import fp.image.lang.parse.imgLangLexer;
import fp.image.lang.parse.imgLangParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import java.util.Stack;
import java.util.stream.Stream;

public class Interpreter extends imgLangBaseVisitor {

    private Stack<Integer> loopIter;
    private HashMap<String, BufferedImage> vars;
    private File outputFile;
    private boolean inWrite;
    private boolean looping;
    private FilterableImage convolution;
    private Stack<BufferedImage> imageStack;


    public Interpreter() {
        loopIter = new Stack<>();
        vars = new HashMap<>();
        inWrite = false;
        looping = false;
        imageStack = new Stack();
        //TODO convolution init?
    }

    public void interp(String script) {
        imgLangLexer imgLexer = new imgLangLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(imgLexer);
        imgLangParser imgParser = new imgLangParser(tokens);
        ParseTree tree = imgParser.script();

        this.visit(tree);
    }

    @Override
    public Object visitForeach(imgLangParser.ForeachContext ctx) {

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
                    pushImageLiteral(imagePath.toFile());
                    vars.put(ctx.id().ID().getText(), imageStack.pop());


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

        vars.remove(ctx.id().ID().getText());
        return null;
    }

    @Override
    public Object visitCanny(imgLangParser.CannyContext ctx) {

        visit(ctx.expression());
        if (imageStack.empty()) {
            convolute();
        }

        float f1 = parseFloatCtx( ctx.floatValue(0) );
        float f2 = parseFloatCtx( ctx.floatValue(1) );

        BufferedImage t = imageStack.pop();
        imageStack.push(ImageHelper.ARGBBufferRenderer(
                new CannyFilter(f1, f2).apply(ImageHelper.SampleImage(t), t),
                t.getWidth(),
                t.getHeight()
            )
        );
        return null;
    }

    @Override
    public Object visitSobel(imgLangParser.SobelContext ctx) {

        visit(ctx.expression());
        if (imageStack.empty()) {
            convolute();
        }

        float f1 = parseFloatCtx( ctx.floatValue());

        if (ctx.boolValue().size() == 1) {

            boolean b1 = parseBoolCtx( ctx.boolValue(0) );

            BufferedImage t = imageStack.pop();
            imageStack.push( ImageHelper.ARGBBufferRenderer(
                new SobelFilter(f1, b1).apply(ImageHelper.SampleImage(t), t),
                t.getWidth(),
                t.getHeight()
            ));
        }
        else if (ctx.boolValue().size() > 1) {
            visit(ctx.boolValue(0));
            boolean b1 = parseBoolCtx( ctx.boolValue(0) );

            visit(ctx.boolValue(1));
            boolean b2 = parseBoolCtx( ctx.boolValue(1) );

            BufferedImage t = imageStack.pop();
            imageStack.push( ImageHelper.ARGBBufferRenderer(
                new SobelFilter(f1, b1, b2).apply(ImageHelper.SampleImage(t), t),
                t.getWidth(),
                t.getHeight()
            ));
        }
        else {
            BufferedImage t = imageStack.pop();
            imageStack.push( ImageHelper.ARGBBufferRenderer(
                new SobelFilter(f1).apply(ImageHelper.SampleImage(t), t),
                t.getWidth(),
                t.getHeight()
            ));
        }

        return  null;
    }

    @Override
    public Object visitGaussianBlur(imgLangParser.GaussianBlurContext ctx) {
        int s = parseIntCtx( ctx.intValue() );
        float f = parseFloatCtx( ctx.floatValue() );
        visit(ctx.expression());
        if (imageStack.empty()) {
            convolute();
        }

        BufferedImage t = imageStack.pop();
        imageStack.push( ImageHelper.ARGBBufferRenderer(
            new GaussianBlur(s, f).apply( ImageHelper.SampleImage( t ), t ),
            t.getWidth(),
            t.getHeight()
        ));
        return null;
    }

    @Override
    public Object visitMinus(imgLangParser.MinusContext ctx) {
        visit(ctx.expression());
        //if parsing last expression did not result in push to image stack we  must process the filters.
        if (imageStack.empty()) {
            convolute();
        }

        visit( ctx.term() );
        //If parsing the last expression did not add a second image to the stack we must process the filters..
        if (imageStack.size() < 2) {
            convolute();
        }

        CompositeFilter f = new CompositeFilter();
        int w = imageStack.peek().getWidth();
        int h = imageStack.peek().getHeight();
        imageStack.push( ImageHelper.ARGBBufferRenderer(
            f.apply( ImageHelper.SampleImage( imageStack.pop() ), imageStack.pop() ),
            w,
            h ));
        return null;
    }

    @Override
    public Object visitPlus(imgLangParser.PlusContext ctx) {

        visit(ctx.expression());
        //if parsing last expression did not result in push to image stack we  must process the filters.
        if (imageStack.empty()) {
            convolute();
        }

        visit( ctx.term() );
        //If parsing the last expression did not add a second image to the stack we must process the filters..
        if (imageStack.size() < 2) {
            convolute();
        }

        SumFilter f = new SumFilter();
        int w = imageStack.peek().getWidth();
        int h = imageStack.peek().getHeight();
        imageStack.push( ImageHelper.ARGBBufferRenderer(
            f.apply( ImageHelper.SampleImage( imageStack.pop() ), imageStack.pop() ),
            w,
            h ));
        return null;
    }

    @Override
    public Object visitMult(imgLangParser.MultContext ctx) {
        visit(ctx.image());
        //if parsing last expression did not result in push to image stack we  must process the filters.
        if (imageStack.empty()) {
            convolute();
        }

        visit( ctx.term() );
        //If parsing the last expression did not add a second image to the stack we must process the filters..
        if (imageStack.size() < 2) {
            convolute();
        }

        ReflectionFilter f = new ReflectionFilter();
        int w = imageStack.peek().getWidth();
        int h = imageStack.peek().getHeight();
        imageStack.push( ImageHelper.ARGBBufferRenderer(
            f.apply( ImageHelper.SampleImage( imageStack.pop() ), imageStack.pop() ),
            w,
            h ));
        return null;
    }

    @Override
    public Object visitDiff(imgLangParser.DiffContext ctx) {
        visit(ctx.expression(1));

        //if parsing last expression did not result in push to image stack we  must process the filters.
        if (imageStack.empty()) {
            convolute();
        }

        visit(ctx.expression(0));

        //If parsing the last expression did not add a second image to the stack we must process the filters..
        if (imageStack.size() < 2) {
            convolute();
        }

        float threshold = parseFloatCtx(ctx.floatValue());

        DifferenceFilter filter;

        if (ctx.intValue().size() > 7) {
            filter = new DifferenceFilter(
                new Color(parseIntCtx(ctx.intValue(0)), parseIntCtx(ctx.intValue(1)),
                    parseIntCtx(ctx.intValue(2)), parseIntCtx(ctx.intValue(3)) ),
                new Color(parseIntCtx(ctx.intValue(4)), parseIntCtx(ctx.intValue(5)),
                    parseIntCtx(ctx.intValue(6)), parseIntCtx(ctx.intValue(7))),
                threshold, parseBoolCtx(ctx.boolValue())
            );
        }
        else {
            filter = new DifferenceFilter(threshold, parseBoolCtx(ctx.boolValue()));
        }

        int w = imageStack.peek().getWidth();
        int h = imageStack.peek().getHeight();
        imageStack.push(
            ImageHelper.ARGBBufferRenderer(
                filter.apply( ImageHelper.SampleImage( imageStack.pop() ), imageStack.pop()), w, h)
        );

        return null;
    }

    @Override
    public FilterableImage visitChromaKey(imgLangParser.ChromaKeyContext ctx) {

        visit(ctx.expression(0));

        if ( ctx.expression().size() == 2 ) {
            visit(ctx.expression(1));               //this expression should end with an image push on stack

            pushFilter(new ChromaKeyFilter(new Color(
                parseIntCtx(ctx.intValue(0)),
                parseIntCtx(ctx.intValue(1)),
                parseIntCtx(ctx.intValue(2))
            ), imageStack.pop(), parseFloatCtx(ctx.floatValue())));
        }
        else if (ctx.intValue().size() > 3 ) {

            pushFilter(new ChromaKeyFilter(new Color(
                parseIntCtx(ctx.intValue(0)),
                parseIntCtx(ctx.intValue(1)),
                parseIntCtx(ctx.intValue(2))
            ),
                new Color(
                    parseIntCtx(ctx.intValue(3)),
                    parseIntCtx(ctx.intValue(4)),
                    parseIntCtx(ctx.intValue(5)),
                    parseIntCtx(ctx.intValue(6))
                ), parseFloatCtx(ctx.floatValue())));
        }
        else {
            pushFilter(new ChromaKeyFilter(new Color(
                parseIntCtx(ctx.intValue(0)),
                parseIntCtx(ctx.intValue(1)),
                parseIntCtx(ctx.intValue(2))
            ), parseFloatCtx(ctx.floatValue())));
        }

        return null;
    }

    @Override
    public Object visitGrayScale(imgLangParser.GrayScaleContext ctx) {

        visit(ctx.expression());

        if (ctx.floatValue().size() > 0) {

            float bl = parseFloatCtx( ctx.floatValue(0) );
            float gn = parseFloatCtx( ctx.floatValue(1) );
            float rd = parseFloatCtx( ctx.floatValue(2) );
            pushFilter(new GrayscaleFilter(rd, gn, bl));
        }
        else {
            pushFilter(new GrayscaleFilter());
        }

        return null;
    }

    @Override
    public Object visitRedist(imgLangParser.RedistContext ctx) {
        visit(ctx.expression());
        pushFilter(new RedistributionFilter(parseFloatCtx( ctx.floatValue() )));
        return null;
    }

    @Override
    public Object visitChromaLum(imgLangParser.ChromaLumContext ctx) {

        visit(ctx.expression());
        if (ctx.floatValue().size() == 3) {
            pushFilter( new ChromaLuminanceFilter( new GrayscaleFilter(parseFloatCtx(ctx.floatValue(0)),
                parseFloatCtx(ctx.floatValue(1)), parseFloatCtx(ctx.floatValue(2))) ) );
        }
        else {
            pushFilter(new ChromaLuminanceFilter());

        }
        return null;
    }

    @Override
    public Object visitTransparency(imgLangParser.TransparencyContext ctx) {
        visit(ctx.expression());
        pushFilter( new TransparencyFilter( parseIntCtx(ctx.intValue()) ) );
        return null;
    }

    @Override
    public Object visitWrite(imgLangParser.WriteContext ctx) {

        inWrite = true;
        visit(ctx.path());
        visit(ctx.expression());
        if (imageStack.empty()) {
            convolute();
        }

        try {
            writeImageToFile( imageStack.pop() , outputFile);
        } catch (IOException e) {
            System.err.println("Failed to write image: " + ctx.expression().toString());
            System.err.println("\t reason: " + e.getMessage());
        }

        return null;
    }

    @Override
    public Object visitAssignment(imgLangParser.AssignmentContext ctx) {

        visit(ctx.expression());
        if (imageStack.empty()) {
            convolute();
        }

        vars.put(ctx.id().ID().getText(), imageStack.pop());
        return null;
    }

    @Override
    public Object visitPath(imgLangParser.PathContext ctx) {

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
                pushImageLiteral(ctx.PATH_LITERAL().getText());
                return null;
            } catch (IOException e) {
                //System.err.print("Line: "+ );
                System.err.println("Error for: " + ctx.PATH_LITERAL().getText());
                e.printStackTrace();
                //TODO how to actually handle errors.
                return null;
            }
        }
    }

    @Override
    public Object visitVar(imgLangParser.VarContext ctx) {
        imageStack.push(vars.get(ctx.id().ID().getText()));
        return null;
    }

    private void pushImageLiteral(String path) throws IOException {
        pushImageLiteral(Paths.get(path).toFile());
    }

    private void pushImageLiteral(File file) throws IOException {
        if (file.isFile()) {
            if (isImage(file)) {
                imageStack.push(ImageIO.read(file));
            }
            else {
                throw new IOException();
            }
        }
        else {
            throw new IOException();
        }
    }

    static private void writeImageToFile(BufferedImage img, File file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getPath());

        ImageIO.write(img, extension, file);
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

    static private float parseFloatCtx(imgLangParser.FloatValueContext fctx) {
        return Float.parseFloat(fctx.FLOAT().toString());
    }

    static private int parseIntCtx(imgLangParser.IntValueContext ictx) {
        return Integer.parseInt( ictx.INT().getText() );
    }

    static private boolean parseBoolCtx(imgLangParser.BoolValueContext bctx) {
        return bctx.BOOL().getText().equals("#true");
    }

    private void pushFilter(Filter f) {
        if (convolution == null) {
            convolution = new FilterableImage(imageStack.pop());
        }

        convolution.addFilter(f);
    }

    private void convolute() {
        if (convolution != null) {
            imageStack.push(convolution.render());
            convolution = null;
        }
    }
}
