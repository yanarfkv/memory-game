package ru.kpfu.itis;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.kpfu.itis.controller.MainSceneController;

import java.awt.*;
import java.io.InputStream;

public class Main extends Application {

    private static final String FXML_FILE_NAME = "/fxml/main.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream(FXML_FILE_NAME));
        Scene scene = new Scene(root);

        MainSceneController sceneController = fxmlLoader.getController();
//        scene.setOnKeyPressed(sceneController.);

        primaryStage.setTitle("Memory Game");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);

//        GridPane.setHalignment(XNodeSet, HPos.CENTER);
        InputStream iconStream = getClass().getResourceAsStream("/images/icon.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
