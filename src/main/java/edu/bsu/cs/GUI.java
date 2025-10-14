package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {

    private final TextField articleInput = new TextField();
    private final Button searchButton = new Button("Search");
    private final VBox resultsBox = new VBox(5);
    private final Label redirectLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        // Create the main layout
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        // Add a title label
        Label title = new Label("Kids Game");
        root.getChildren().add(title);

        // ✅ Load and set the background image
        //Image image = new Image("file:" + System.getProperty("user.dir") + "/src/edu/bsu/cs/backgroundHome.png");
        Image image = new Image(getClass().getResource("/edu/bsu/cs/backgroundHome.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
               new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        root.setBackground(new Background(backgroundImage));

        // Create the scene
        Scene scene = new Scene(root, 1600, 900);

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kids Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
