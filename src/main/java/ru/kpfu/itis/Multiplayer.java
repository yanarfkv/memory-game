package ru.kpfu.itis;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class Multiplayer implements Initializable {

    private int clicks, random1, random2, random3, wins1, wins2, wins3;
    @FXML
    private GridPane grid, gridTable;
    @FXML
    private Button back, next;
    @FXML
    private Label turn, nextTurn, player1, player2, player3, player4, winLabel;

    private String t,nt,p1,p2,p3,p4;
    private String pl1,pl2,pl3,pl4,you;
    private String playerTurn1,playerTurn2,playerTurn3,playerTurn4,youWin,botWin;

    private ImageView clickedImageView;

    private int[] scoreBots = new int[3];

    private Properties properties = new Properties();
    private Properties properties2 = new Properties();
    private InputStream input = null;
    private OutputStream output = null;

    int size = 24;
    int columns = 6;
    int rows = 4;
    int selectCards = 2;

    GameMode gameMode;

    private double imWidth = 90,imHeight = 130;

    public Multiplayer() {
        clicks = 0;
        clickedImageView = null;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File f =new File("score.properties");
        File f2 =new File("config.properties");

        if(f2.exists()) {
            try {
                input = new FileInputStream("config.properties");
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(f.exists()){
            InputStream input2 = null;
            try {
                input2 = new FileInputStream("score.properties");
                properties2.load(input2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wins1 = Integer.parseInt(properties2.getProperty("MultiplayerWins1"));
            wins2 = Integer.parseInt(properties2.getProperty("MultiplayerWins2"));
            wins3 = Integer.parseInt(properties2.getProperty("MultiplayerWins3"));
        }
    }

    public void createImageViews(GridPane grid, ArrayList<ImageView> imageViews){
        grid.setHgap(10);
        grid.setVgap(10);

        for(int i = 0; i < rows; i++){
            RowConstraints row = new RowConstraints(imHeight);
            row.setMinHeight(Double.MIN_VALUE);
            row.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(row);
        }
        for(int i = 0; i < columns; i++){
            ColumnConstraints column = new ColumnConstraints(imWidth);
            column.setMinWidth(Double.MIN_VALUE);
            column.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(column);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) {
                ImageView imageView = new ImageView();
                imageView.setPreserveRatio(true);
                imageView.setFitWidth(imWidth);
                imageView.setFitHeight(imHeight);
                grid.add(imageView, j, i);
                imageViews.add(imageView);
            }
        }
    }

    public void createImages(ArrayList<Card> cards) {
        int times = 0;
        int j = 0;
        for(int i =1; i <= size;i++) {
            if(i % gameMode.getSelectCards() == 1){
                times++;
                j++;
            }
            Image value = new Image("Images/Cards/" + j + ".png");
//            Card image2 = new Card(value,theme,times);
//            cards.add(image2);
        }
    }


//    public void multiplayerStart(){
//        createImageViews(grid, imageViews);
//        createImages(cards);
//        shuffleCards(imageViews);
//        setImages(imageViews,cards);
//
//        player();
//        turn.setText(t + playerTurn1 + you);
//        nextTurn.setText(nt + playerTurn2 + "(" + p2 + ")");
//    }
//
//    public void clickEvent(ImageView imageView, Card card) {
//        if(foundCards.size() == gameMode.getSize()) {
//            findWinner();
//            return;
//        }
//    }
}
