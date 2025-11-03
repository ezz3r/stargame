package com.example.stargame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

class Main extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new Model();
        View view = new View(model, primaryStage);
        new Controller(model, view);
    }


    public static void main(String[] args) {
        launch();
    }
}
