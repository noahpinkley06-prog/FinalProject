package edu.bsu.cs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class AddingGame {

    private final Random random = new Random();
    private int score = 0;

    public void start(Stage stage, Font font, Scene mainMenuScene, BackgroundImage backgroundImage) {
        VBox root = new VBox(25);
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(new Background(backgroundImage));

        // Title
        Label title = new Label("Adding Game ");
        title.setStyle(
                "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 75px;" +
                        "-fx-font-weight: bold;"
        );

        // Score
        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle(
                "-fx-font-size: 28px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-text-fill: #2d3436; "
                        //+ "-fx-font-family: '" + font.getFamily() + "';"
        );

        // Dice and question
        Label dice1Label = new Label("Die 1: 🎲");
        Label dice2Label = new Label("Die 2: 🎲");
        Label questionLabel = new Label("Click ROLL to start!");
        questionLabel.setAlignment(Pos.CENTER);
        questionLabel.setStyle(
                "-fx-font-size: 26px; " +
                        "-fx-font-weight: bold;"
                         //+ "-fx-font-family: '" + font.getFamily() + "';"
        );

        // TextField for answer
        TextField answerInput = new TextField();
        answerInput.setPromptText("enter answer here");
        answerInput.setMaxWidth(250);
        answerInput.setVisible(true);
        answerInput.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-padding: 8;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-background-color: white;" +
                        "-fx-border-color: black;" +
                        "-fx-border-radius: 10;" +
                        "-fx-background-radius: 10;"
        );

        // Submit button
        Button submitButton = new Button("SUBMIT");
        submitButton.setPrefSize(150, 50);
        submitButton.setStyle(
                "-fx-background-color: #55efc4;" +
                        "-fx-border-color: black;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-border-width: 3px;" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        answerInput.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                submitButton.fire();
            }
        });

        // Roll button
        Button rollButton = new Button("ROLL DICE");
        rollButton.setPrefSize(200, 75);
        rollButton.setStyle(
                "-fx-background-color: #ebc334;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;"
        );

        // Back button
        Button backButton = new Button("BACK TO MENU");
        backButton.setPrefSize(250, 60);
        backButton.setStyle(
                "-fx-background-color: #ff7675;" +
                        "-fx-border-color: black;" +
                        "-fx-border-width: 3px;" +
                        "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-background-radius: 20;" +
                        "-fx-border-radius: 20;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        final int[] dice1 = {0};
        final int[] dice2 = {0};
        final int[] state = {0};

        // Roll action
        rollButton.setOnAction(e -> {
            state[0] = 1;
            dice1[0] = random.nextInt(6) + 1;
            dice2[0] = random.nextInt(6) + 1;
            dice1Label.setText("Die 1: " + dice1[0]);
            dice2Label.setText("Die 2: " + dice2[0]);
            questionLabel.setText("What is " + dice1[0] + " + " + dice2[0] + "?");
            answerInput.clear();
            answerInput.requestFocus();
        });

        // Submit action
        submitButton.setOnAction(e -> {
            if (state[0] == 0) {
                questionLabel.setText("Please roll the dice first!");
                return;
            }
            try {
                int userAnswer = Integer.parseInt(answerInput.getText());
                int correct = dice1[0] + dice2[0];
                if (userAnswer == correct) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                    questionLabel.setText("✅ Correct! Roll again!");
                } else {
                    questionLabel.setText("❌ Oops! The answer was " + correct);
                }
                answerInput.clear();
                state[0] = 0;
            } catch (NumberFormatException ex) {
                questionLabel.setText("Please enter a valid number!");
            }
        });

        // Back button action
        backButton.setOnAction(e -> {
            score = 0;
            stage.setScene(mainMenuScene);
        });

        // Answer area (forces visibility)
        VBox answerArea = new VBox(10, answerInput, submitButton);
        answerArea.setAlignment(Pos.CENTER);
        answerArea.setVisible(true);
        answerArea.setManaged(true);

        // Add everything
        root.getChildren().addAll(
                title,
                scoreLabel,
                dice1Label,
                dice2Label,
                questionLabel,
                answerArea,
                rollButton,
                backButton
        );

        Scene scene = new Scene(root, 1450, 900);
        stage.setScene(scene);
        stage.show();
    }
}
