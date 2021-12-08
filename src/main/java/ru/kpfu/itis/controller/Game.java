package ru.kpfu.itis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import ru.kpfu.itis.Card;
import ru.kpfu.itis.Score;

import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Game {

    private Button backCard;
    public ArrayList<ImageView> imageViews, foundCards;
    public ArrayList<Card> cards;

    private Image theme;
    private int clicks = 0,moves1, moves2;
    public int id1, id2;

    public ImageView imageView1, imageView2;
    public Card card1, card2;

    private Properties properties1 = new Properties();
    private Properties properties2 = new Properties();
    private OutputStream outputStream = null;
    private String word1, word2;

    private GridPane grid;
    public Score score;

    private Label Moves, foundCardsLabel;

    public Boolean cardsMatch;
    private MediaPlayer mediaPlayer;

    public Game() {
        imageViews = new ArrayList<>();
        cards = new ArrayList<>();
        foundCards = new ArrayList<>();
        score= new Score();
        cardsMatch = false;
    }

    @FXML
    private void initialize() throws IOException {
        File f1 = new File("config.properties");
        File f2 = new File("score.properties");


    }
}
