package ru.kpfu.itis.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ru.kpfu.itis.Card;
import ru.kpfu.itis.Score;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private Button backCard;
    @FXML
    public ArrayList<ImageView> imageViews, foundCards;
    @FXML
    public ArrayList<Card> cards;
    private int clicks;
    public int id1, id2;

    public ImageView imageView;
    public Card card;

    private ImageView clickedImageView;

    private Properties properties = new Properties();
    private OutputStream outputStream = null;
    private String word1, word2;
    public Score score;
    private Boolean cardsMatch;
    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() throws IOException{
        File f = new File("config.properties");

//        if(f.exists()) {
//            InputStream input = new FileInputStream("config.properties");
//            properties.load(input);
//
//            String lang = properties.getProperty("flag");
//            loadLang(lang);
//
//            if(lang.equals("el")) {
//                goldfish = "Χρυσόψαρο";
//                kangaroo = "Καγκουρό";
//                elephant = "Ελέφαντας";
//            }
//            else if(lang.equals("en")) {
//                goldfish = "Goldfish";
//                kangaroo = "Kangaroo";
//                elephant = "Elephant";
//            }
//
//            double width = Double.parseDouble(properties.getProperty("width"));
//            boolean fullScreen = Boolean.parseBoolean(properties.getProperty("fullScreen"));
//
//            if(width == 800 || fullScreen || width == 1280){
//                redImage.setScaleX(1.5);
//                redImage.setScaleY(1.5);
//                blackImage.setScaleX(1.5);
//                blackImage.setScaleY(1.5);
//                normalMode.setScaleX(2);
//                normalMode.setScaleY(2);
//                doubleMode.setScaleX(2);
//                doubleMode.setScaleY(2);
//                trioMode.setScaleX(2);
//                trioMode.setScaleY(2);
//            }
//            if(fullScreen){
//                redImage.setScaleX(2);
//                redImage.setScaleY(2);
//                blackImage.setScaleX(2);
//                blackImage.setScaleY(2);
//            }
//        }
//
//        multiplayer.setDisable(true);
//        normal.setSelected(true);
//        red.setSelected(true);
//        normalMode.setEffect(glow);
//        redImage.setEffect(glow);
    }

    public GameController() {
        clicks = 0;
        clickedImageView = null;
    }

    public void gameStart() {

    }



    private void loadLang(String lang) {
        Locale locale = new Locale(lang);
        ResourceBundle bundle = ResourceBundle.getBundle("lang", locale);


    }

    public void backClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("fxml/play.fxml"));
        Stage stage = (Stage) backCard.getScene().getWindow();
        stage.getScene().setRoot(root);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
