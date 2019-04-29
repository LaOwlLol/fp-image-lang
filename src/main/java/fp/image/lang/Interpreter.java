package fp.image.lang;

import fauxpas.entities.FilterableImage;
import fauxpas.filters.BlendFilter;
import fauxpas.filters.SumFilter;
import fp.image.lang.parse.imgLangBaseListener;
import fp.image.lang.parse.imgLangLexer;
import fp.image.lang.parse.imgLangParser;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
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

    private Stack<FilterableImage> images;
    private HashMap<String, FilterableImage> vars;

    public Interpreter() {
        images = new Stack<>();
        vars = new HashMap<>();
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

        vars.put(ctx.id().ID().getText(), images.pop());
    }

    @Override
    public void exitMinus(imgLangParser.MinusContext ctx) {
        super.exitMinus(ctx);

        Image i1 = images.pop().getImage();
        Image i2 = images.pop().getImage();
        BlendFilter f = new BlendFilter();
        FilterableImage r = new FilterableImage(i1);
        r.applyFilter( f.apply( i -> i2, i -> i1 ) );
        images.push( r );
    }

    @Override
    public void exitPlus(imgLangParser.PlusContext ctx) {
        super.exitPlus(ctx);

        Image i1 = images.pop().getImage();
        Image i2 = images.pop().getImage();
        SumFilter f = new SumFilter();
        FilterableImage r = new FilterableImage(i1);
        r.applyFilter( f.apply( i -> i2, i -> i1 ) );
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
        try {
            images.push(getImageLiteral(ctx.PATH_LITERAL().getText()));
        } catch (IOException e) {
            //System.err.print("Line: "+ );
            System.err.println("Unknown image file: "+ ctx.PATH_LITERAL().getText());
            //e.printStackTrace();
        }
    }

    private FilterableImage getResult() {
        return images.pop();
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
            if((Files.probeContentType(file.toPath()).split("/")[0]).equals("image"))
                return true;
            else
                return false;
        } catch (IOException e) {
            return false;
        }
    }

}
