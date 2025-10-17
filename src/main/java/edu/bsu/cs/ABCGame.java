package edu.bsu.cs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class ABCGame {

    private final Random random = new Random();
    private int score = 0;

    public void start(Stage stage, Font font, Scene mainMenuScene, BackgroundImage backgroundImage) {
        VBox root = new VBox(25);
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(new Background(backgroundImage));

        // Title
        Label title = new Label("ABC's Game");
        title.setStyle(
                "-fx-font-family: '" + font.getFamily() + "';" +
                        "-fx-font-size: 75px;" +
                        "-fx-font-weight: bold;"
        );

        // Score and
        Label scoreLabel = new Label("Score: 0");
        Label seqLabel = new Label("");
        scoreLabel.setStyle(
                "-fx-font-size: 28px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-text-fill: #2d3436;"
        );
        seqLabel.setStyle(
                "-fx-font-size: 28px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-text-fill: #2d3436;"
        );

        //Question label
        Label questionLabel = new Label("Click 'NEXT' to start!");
        questionLabel.setStyle(
                "-fx-font-size: 26px; " +
                        "-fx-font-weight: bold;"
        );
        questionLabel.setAlignment(Pos.CENTER);
        questionLabel.setMaxWidth(600);

        // TextField for answer
        TextField answerInput = new TextField();
        answerInput.setPromptText("Enter your answer here");
        answerInput.setMaxWidth(200);
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

        //New Sequence
        Button rollButton = new Button("NEXT");
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
        final int[] state = {0};
        final int[] start = {0};

        // Roll action
        rollButton.setOnAction(e -> {
            state[0] = 1;
            start[0] = random.nextInt(21) + 1;
            seqLabel.setText(getLetter(start[0]) + "   " + getLetter(start[0] + 1) + "   _   " + getLetter(start[0] + 3) + "   " + getLetter(start[0] + 4));
            questionLabel.setText("What is the missing letter?");
            answerInput.clear();
            answerInput.requestFocus();
        });

        // Submit action
        submitButton.setOnAction(e -> {
            if (state[0] == 0) {
                questionLabel.setText("Please click 'Next' first!");
                return;
            }
            try {
                String userAnswer = (answerInput.getText().toUpperCase());
                String correct = getLetter(start[0] + 2);
                if (userAnswer.equals(correct)) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                    questionLabel.setText("✅ Correct!");
                    state[0]= 0;
                } else {
                    questionLabel.setText("❌ Oops! The answer was " + correct);
                }
                answerInput.clear();
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
                seqLabel,
                questionLabel,
                answerArea,
                rollButton,
                backButton
        );

        Scene scene = new Scene(root, 1450, 900);
        stage.setScene(scene);
        stage.show();
    }
    private String getLetter(int num){
        String letter = "";
        switch(num){
            case 1:
                letter = "A";
                break;
            case 2:
                letter = "B";
                break;
            case 3:
                letter = "C";
                break;
            case 4:
                letter = "D";
                break;
            case 5:
                letter = "E";
                break;
            case 6:
                letter = "F";
                break;
            case 7:
                letter = "G";
                break;
            case 8:
                letter = "H";
                break;
            case 9:
                letter = "I";
                break;
            case 10:
                letter = "J";
                break;
            case 11:
                letter = "K";
                break;
            case 12:
                letter = "L";
                break;
            case 13:
                letter = "M";
                break;
            case 14:
                letter = "N";
                break;
            case 15:
                letter = "O";
                break;
            case 16:
                letter = "P";
                break;
            case 17:
                letter = "Q";
                break;
            case 18:
                letter = "R";
                break;
            case 19:
                letter = "S";
                break;
            case 20:
                letter = "T";
                break;
            case 21:
                letter = "U";
                break;
            case 22:
                letter = "V";
                break;
            case 23:
                letter = "W";
                break;
            case 24:
                letter = "X";
                break;
            case 25:
                letter = "Y";
                break;
            case 26:
                letter = "Z";
                break;
        }

        return letter;
    }
}
