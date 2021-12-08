package ru.kpfu.itis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {

    @FXML
    private MenuButton playMenu;

    @FXML
    private void playClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/SingleModeSettings.fxml"));
        Stage stage = (Stage) playMenu.getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}
