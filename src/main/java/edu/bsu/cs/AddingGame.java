package edu.bsu.cs;

package edu.bsu.cs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class AddingGame {

    private final Random random = new Random();
    private int score = 0;

    public void start(Stage stage, Font font, Scene mainMenuScene) {
        VBox root = new VBox(25);
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #f6e58d; -fx-padding: 40;");

        // Title
        Label title = new Label("🎲 Adding Game 🎲");
        title.setStyle(
                "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 60px;" +
                        "-fx-font-weight: bold;"
        );
// Score
        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2d3436;");
