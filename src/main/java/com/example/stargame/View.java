package com.example.stargame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View {
    private Stage stage;
    private Label messageLabel;
    private Button[] lightButtons;
    private Button restartButton;

    private Model model;

    public View(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;

        restartButton = new Button("Neustart");
        messageLabel = new Label();

        HBox hbox = new HBox();
        lightButtons = new Button[Model.NUMBER_OF_LIGHTS];
        for (int i = 0; i < Model.NUMBER_OF_LIGHTS; i++) {
            Button button = new Button();
            lightButtons[i] = button;
            button.setFont(new Font("Sans", 30));
            hbox.getChildren().add(button);
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(restartButton);
        borderPane.setCenter(hbox);
        borderPane.setTop(getMessageLabel());

        // Layout
        hbox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(restartButton, Pos.CENTER);
        BorderPane.setMargin(messageLabel, new Insets(12, 12, 12, 12));
        BorderPane.setMargin(restartButton, new Insets(12, 12, 12, 12));

        Scene scene = new Scene(borderPane, 750, 200);
        getStage().setScene(scene);

        // Aufruf der Methode, die bei jeder Aenderung am Modell aufgerufen wird, damit die richtigen
        // Daten eingetragen werden.
        update();
    }

    /**
     * Wird bei jeder Aenderung am Modell aufgerufen.
     */
    public void update() {
        for (int i = 0; i < Model.NUMBER_OF_LIGHTS; i++) {
            lightButtons[i].setText(model.getLight(i) ? "★" : "☆");
        }
    }

    public Stage getStage() {
        return stage;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Button getLightButton(int i) {
        return lightButtons[i];
    }

    public Button getRestartButton() {
        return restartButton;
    }
}
