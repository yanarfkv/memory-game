package ru.kpfu.itis.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    private static final String LOGO = "src/main/resources/images/icon.png";

    @FXML
    public Button closeButton;

    @FXML
    public Button playButton;

    @FXML
    public ImageView logoView;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            Image logo = new Image(new FileInputStream(LOGO));
            logoView.setImage(logo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void playClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/play.fxml"));
        Stage stage = (Stage) playButton.getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}
