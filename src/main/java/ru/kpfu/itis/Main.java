package ru.kpfu.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
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

        double width = 1280, height = 720;

        File f = new File("config.properties");
        if(f.exists()) {
            InputStream input = new FileInputStream("config.properties");
            properties.load(input);
            width = Double.parseDouble(properties.getProperty("width"));
            height = Double.parseDouble(properties.getProperty("height"));
        }

        Scene scene = new Scene(root, width, height);

        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);

        primaryStage.setTitle("Memory Card Game");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/images/icon.png"));
//        MainController mainController = fxmlLoader.getController();
//        scene.setOnKeyPressed();

        primaryStage.show();
    }
}
