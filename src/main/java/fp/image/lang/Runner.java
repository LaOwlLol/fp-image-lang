/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fp.image.lang;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;


public class Runner extends Application {

    private Instant start;
    private File script_file;

    public Runner() {
        start = Instant.now();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("imgLang ITE");
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(6));

        ImageView image_view = new ImageView();
        image_view.setFitWidth(1024);
        image_view.setFitHeight(768);
        root.setCenter(image_view);

        HBox botBar = new HBox();
        botBar.setSpacing(10);
        botBar.setDisable(true);
        root.setBottom(botBar);

        HBox topBar = new HBox();
        topBar.setSpacing(10);
        root.setTop(topBar);

        Label script_lbl = new Label("Selected:");
        topBar.getChildren().add(script_lbl);

        Button selectScript_btn = new Button("Select");
        selectScript_btn.setOnMouseClicked( (event -> {
            FileChooser fileChooser = new FileChooser();
            script_file =  fileChooser.showOpenDialog(selectScript_btn.getScene().getWindow());
            if (script_file != null) {
                script_lbl.setText("Selected: "+script_file.getPath());
                botBar.setDisable(false);
            }
        }));
        topBar.getChildren().add(selectScript_btn);

        Button execute_btn = new Button("run");
        execute_btn.setOnMouseClicked( (event -> {
            Thread process = new Thread(() -> {

                Interpreter interp = new Interpreter();
                start = Instant.now();
                try {
                    image_view.setImage(interp.interp(readFile(script_file.getPath())).getImage());
                } catch (IOException e) {
                    System.err.println("Error reading script!");
                    e.printStackTrace();
                }
                System.out.println("Script took: "+Duration.between(start, Instant.now()).toMillis()/1000.0+" seconds.");
            });
            process.start();
        }));
        botBar.getChildren().add(execute_btn);

        primaryStage.setScene(new Scene(root, 1024, 850));
        primaryStage.show();
    }

    static String readFile(String path) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }
}
