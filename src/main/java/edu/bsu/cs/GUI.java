package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Load custom font
        Font font = Font.loadFont(getClass().getResourceAsStream("/SquireHawaii.otf"), 20);

        // Create the main menu layout
        Pane root = new Pane();
        root.setStyle("-fx-padding: 10;");

        // Background image
        Image image = new Image(getClass().getResource("/backgroundHome.png").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        root.setBackground(new Background(backgroundImage));

        // Title
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

        // Buttons
        Button memory = createMenuButton("MEMORY", 765, 500, 200, font);
        Button colorMatch = createMenuButton("COLOR MATCH", 568, 350, 300, font);
        Button counting = createMenuButton("COUNTING", 315, 350, 200, font);
        Button adding = createMenuButton("ADDING", 465, 500, 200, font);
        Button abc = createMenuButton("ABC'S", 915, 350, 200, font);
        Button exit = createMenuButton("EXIT", 615, 675, 200, font);

        // Exit action
        exit.setOnAction(e -> primaryStage.close());

        // Add buttons to root
        root.getChildren().addAll(memory, adding, colorMatch, counting, abc, exit);

        // Create main menu scene
        Scene menuScene = new Scene(root, 1600, 900);

        // Connect to the Adding Game
        AddingGame addingGame = new AddingGame();
        adding.setOnAction(e -> addingGame.start(primaryStage, font, menuScene, backgroundImage));

        //Create Exit Screen scene
        Pane secondLayout = new Pane();
        secondLayout.setBackground(new Background(backgroundImage));
        Scene exitScene = new Scene(secondLayout, 1600, 900);
        exit.setOnAction(e -> primaryStage.setScene(exitScene));

        //Exit Screen header
        Label exitHeader = new Label("      ARE YOU SURE");
        exitHeader.setPrefWidth(660);
        exitHeader.setPrefHeight(100);
        exitHeader.setLayoutX(380);
        exitHeader.setLayoutY(80);
        exitHeader.setStyle(
                "-fx-background-radius: 25;" +
                        "-fx-background-color: #ebc334;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 50px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 6px;" +
                        "-fx-font-weight: bold;"
        );
        secondLayout.getChildren().add(exitHeader);

        //"NO" button (relaunches Menu)
        Button backButton = new Button("NO");
        backButton.setPrefWidth(200);
        backButton.setPrefHeight(75);
        backButton.setLayoutX(850);
        backButton.setLayoutY(500);
        backButton.setStyle(
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
        backButton.setOnAction(e -> primaryStage.setScene(menuScene));

        //"YES" button (Exits application)
        Button quit = new Button("YES");
        quit.setPrefWidth(200);
        quit.setPrefHeight(75);
        quit.setLayoutX(360);
        quit.setLayoutY(500);
        quit.setStyle(
                "-fx-background-radius: 25;" +
                        "-fx-background-color: #eb4634;" +
                        "-fx-padding: 10 20 10 20;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 20px;" +
                        "-fx-border-radius: 20;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-weight: bold;"
        );
        quit.setOnAction(e -> primaryStage.close());

        secondLayout.getChildren().addAll(backButton, quit);

        // Set up stage
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Kids Game");
        primaryStage.show();
    }

    /**
     * Helper method to create styled menu buttons
     */
    private Button createMenuButton(String text, double x, double y, double W, Font font) {
        Button button = new Button(text);
        button.setPrefWidth(W);
        button.setPrefHeight(75);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setStyle(
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
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
