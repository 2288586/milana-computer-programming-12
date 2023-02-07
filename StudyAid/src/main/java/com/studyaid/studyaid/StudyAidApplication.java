package com.studyaid.studyaid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudyAidApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyAidApplication.class.getResource("study-aid.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        stage.setTitle("Study Aid");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}