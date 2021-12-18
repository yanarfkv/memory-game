package ru.kpfu.itis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    public VBox vbox;
    @FXML
    private Button exit, highScore;
    @FXML
    private MenuButton playMenu;
    @FXML
    private ImageView flag, cards;
    @FXML
    private AnchorPane mainMenu;
    @FXML
    private MenuItem multiplayerItem;

    private Properties properties1 = new Properties();
    private Properties properties2 = new Properties();
    private OutputStream output = null;

    public MainController() {

    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File f1 = new File("config.properties");
        File f2 = new File("score.properties");

        if (f2.exists()){
            InputStream input2 = null;
            try {
                input2 = new FileInputStream("score.properties");
                properties2.load(input2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            OutputStream output2 = null;
            try {
                output2 = new FileOutputStream("score.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            properties2.setProperty("MultiplayerWins1", "0");
            properties2.setProperty("MultiplayerWins2", "0");
            properties2.setProperty("MultiplayerWins3", "0");
            try {
                properties2.store(output2, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (f1.exists()) {
            InputStream input = null;
            try {
                input = new FileInputStream("config.properties");
                properties1.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int width = Integer.parseInt(properties1.getProperty("width"));
//            if(width == 1280){
//                cards.setFitWidth(531);
//                cards.setFitHeight(205);
//            }
        }
    }

    @FXML
    private void multiplayerClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/multiplayerSettings.fxml"));
        Stage stage = (Stage) playMenu.getScene().getWindow();
        stage.getScene().setRoot(root);
    }

}
