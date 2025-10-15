package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {

    private final TextField articleInput = new TextField();
    private final Button searchButton = new Button("Search");
    private final VBox resultsBox = new VBox(5);
    private final Label redirectLabel = new Label();

    @Override
    public void start(Stage primaryStage) {

        // Create custom font
        Font font = Font.loadFont(getClass().getResourceAsStream("/SquireHawaii.otf"), 20);

        // Create the main layout
        Pane root = new Pane();
        root.setStyle("-fx-padding: 10;");

        // Add a title label
        Label title = new Label("      Thinkin Tods");
        title.setPrefWidth(800);
        title.setPrefHeight(100);
        title.setLayoutX(315);
        title.setLayoutY(30);
        title.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 70px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 6px;" +
                        "-fx-font-weight: bold;"
        );
        root.getChildren().add(title);

        // Load image and set as background
        Image image = new Image(getClass().getResource("/backgroundHome.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
               new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        root.setBackground(new Background(backgroundImage));



        // Create menu buttons
        Button memory = new Button("MEMORY");
        memory.setPrefWidth(200);
        memory.setPrefHeight(75);
        memory.setLayoutX(765);
        memory.setLayoutY(500);
        memory.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        Button colorMatch = new Button("COLOR MATCH");
        colorMatch.setPrefWidth(300);
        colorMatch.setPrefHeight(75);
        colorMatch.setLayoutX(568);
        colorMatch.setLayoutY(350);
        colorMatch.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        Button counting = new Button("COUNTING");
        counting.setPrefWidth(200);
        counting.setPrefHeight(75);
        counting.setLayoutX(315);
        counting.setLayoutY(350);
        counting.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        Button adding = new Button("ADDING");
        adding.setPrefWidth(200);
        adding.setPrefHeight(75);
        adding.setLayoutX(465);
        adding.setLayoutY(500);
        adding.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        Button abc = new Button("ABC'S");
        abc.setPrefWidth(200);
        abc.setPrefHeight(75);
        abc.setLayoutX(915);
        abc.setLayoutY(350);
        abc.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        Button exit = new Button("EXIT");
        exit.setPrefWidth(200);
        exit.setPrefHeight(75);
        exit.setLayoutX(615);
        exit.setLayoutY(675);
        exit.setStyle(
                        "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );

        // Add action for memory


        // Add action for colorMatch


        // Add action for counting


        // Add action for adding


        // Add action for abc


        // Add action for exit
        exit.setOnAction(e -> primaryStage.close());

        // Add buttons to root
        root.getChildren().addAll(memory, adding, colorMatch, counting, abc,  exit);

        // Create scene
        Scene scene = new Scene(root, 1600, 900);

        // Set up stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kids Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
