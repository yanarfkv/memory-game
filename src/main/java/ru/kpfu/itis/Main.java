package ru.kpfu.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Main extends Application {

    private final String FXML_FILE_NAME = "/fxml/main.fxml";
    private Properties properties = new Properties();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream(FXML_FILE_NAME));

        Scene scene = new Scene(root);

        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        primaryStage.setTitle("Memory Card Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/images/icon.png"));

        primaryStage.show();
    }
}
