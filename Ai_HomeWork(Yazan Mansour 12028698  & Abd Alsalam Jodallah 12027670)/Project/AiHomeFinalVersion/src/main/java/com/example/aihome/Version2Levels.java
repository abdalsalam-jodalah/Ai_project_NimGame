package com.example.aihome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Version2Levels extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Version2Levels.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 418, 551);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}
