package fp.image.lang.app;

import fp.image.lang.Interpreter;
import fp.image.lang.untils.FileHelper;
import javafx.scene.image.Image;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

public class ClientRunner {

    private Duration elapsed;

    ClientRunner() {

    }

    public static void main(String[] args) {
        ClientRunner runner = new ClientRunner();

        if (args.length > 1) {
            if (args[0].equalsIgnoreCase("-f")) {
                try {
                    runner.executeScriptFromFile(Paths.get(args[1]));
                }
                catch (IOException e) {
                    System.err.println("Error reading script!");
                    e.printStackTrace();
                }
            }
            else if (args[0].equalsIgnoreCase("-s")) {
                runner.executeScript( args[1] );
            }
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("-h")) {
                HelpMessage();
            }
            else {
                try {
                    runner.executeScriptFromFile(Paths.get(args[0]));
                }
                catch (IOException e) {
                    System.err.println("Error reading script!");
                    e.printStackTrace();
                }
            }
        }
        else {
            HelpMessage();
        }

        System.out.println("Script took: "+ runner.elapsed.toMillis()/1000.0+" seconds.");
    }

    public static void HelpMessage() {
        System.out.println("fp-image-lang Client Runner:");
        System.out.println("Runs an fp-image-lang script from file or as string.");
        System.out.println("Args:");
        System.out.println("-f <script file>");
        System.out.println("-s <script>");
        System.out.println("default first argument is taken as a script file.");
    }

    public Image executeScriptFromFile(Path script) throws IOException {
        return executeScript(FileHelper.readFile(script.toString()));
    }

    public Image executeScript(String script) {
        Image result;
        Interpreter interp = new Interpreter();
        Instant start = Instant.now();

        result = interp.interp(script.trim()).getImage();

        Duration.between(start, Instant.now());
        return result;
    }
}
