package ru.kpfu.itis;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.ResourceBundle;

public class Multiplayer implements Initializable {

    private int clicks, random1, random2, random3, wins1, wins2, wins3, moves1, moves2, moves3;
    @FXML
    private GridPane grid, gridTable;
    @FXML
    private Button back, next;
    @FXML
    private Label turn, nextTurn, player1, player2, player3, player4, winLabel;
    public ArrayList<ImageView> imageViews,foundCards, seenImageViews;
    public ArrayList<Card> cards, seenCards;
    private String word1,word2;

    @FXML
    public Score score;
    private Label Moves, foundCardsLabel;

    public Boolean cardsMatch;

    private String t,nt,p1,p2,p3,p4;
    private String pl1,pl2,pl3,pl4,you;
    private String playerTurn1,playerTurn2,playerTurn3,playerTurn4,youWin,botWin;
    public int id1,id2,id3;
    public Card card1,card2,card3;

    private ImageView clickedImageView;

    private int[] scoreBots = new int[3];

    private Properties properties = new Properties();
    private Properties properties2 = new Properties();
    private InputStream input = null;
    private OutputStream output = null;

    public ImageView imageView1,imageView2,imageView3;


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

    public void GameStart() {
        createImageViews(grid, imageViews);
        createImages(cards);
        shuffleCards(imageViews);
        setImages(imageViews, cards);

        player();
    }

    public void setImages (ArrayList<ImageView> imageViews, ArrayList<Card> cards) {
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setImage(cards.get(i).getBackground());
        }
    }

    public void player() {
        for (int i = 0; i < imageViews.size(); i++) {
            final ImageView imageView = imageViews.get(i);
            final Card card = cards.get(i);
            imageViews.get(i).setOnMouseClicked(event -> clickEvent(imageView, card));
        }
    }

    public void clickEvent(ImageView imageView, Card card) {
        cardsMatch = false;
        clicks++;
        imageView.setDisable(true);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.4), imageView);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(-1);
        scaleTransition.play();
        scaleTransition.setOnFinished(event -> {imageView.setScaleX(1);imageView.setImage(card.getValue());});

        if(clicks == 1){
            id1 = card.getId();
            imageView1 = imageView;
            card1 = card;
            if(!seenImageViews.contains(imageView1)) {
                seenImageViews.add(imageView1);
                seenCards.add(card1);
            }
        }
        if(clicks == 2) {
            id2 = card.getId();
            imageView2 = imageView;
            card2 = card;
            if(!seenImageViews.contains(imageView2)) {
                seenImageViews.add(imageView2);
                seenCards.add(card2);
            }
        }
    }

    public void createImages(ArrayList<Card> cards) {
        int times = 0;
        int j = 0;
        for (int i = 1; i < gameMode.getSize(); i++) {
            if (i % gameMode.getSelectCards() == 1) {
                times++;
                j++;
            }
            Image value = new Image("images/cards/" + j + ".png");
            Card image2 = new Card(value, times);
            cards.add(image2);
        }
    }

    public void shuffleCards(ArrayList<ImageView> imageViews) {
        Collections.shuffle(imageViews);
    }

    public void backClicked() throws IOException {
        clicks = 0;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/play.fxml"));
        Stage stage = (Stage) back.getScene().getWindow();
        stage.getScene().setRoot(root);
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

    @FXML
    private void multiplayerClicked() throws IOException{
//        theme = new Image("images/cards/card-03.png");


        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getClassLoader().getResource("fxml/play.fxml"));
        Loader.load();
        Multiplayer multi = Loader.getController();
//        Stage stage = (Stage) getScene().getWindow();
//        multi.setMode(mode,theme);
//        multi.fixLang();
//        multi.multiplayerStart();
//        stage.getScene().setRoot(Loader.getRoot());
    }

    @FXML
    private void nextClicked() {

    }

    private void multiplayerInitialize() {
        if (foundCards.size() == gameMode.getSize()) {
            System.out.println("STOPPED");
            return;
        }
        if (clicks == 0) {
            turn.setText(t + playerTurn1 + you);
            nextTurn.setText(nt + playerTurn2 + "(" + p2 + ")");
            enableAll();
            player();
        } else if (clicks == 1) enable(clickedImageView);
        else if(clicks == 2) {
            turn.setText(t + playerTurn2 + "(" + p2 + ")");
            nextTurn.setText(nt + playerTurn3 + "(" + p3 + ")");

            Timeline bot = new Timeline(new KeyFrame(Duration.seconds(1.5),event1 -> {multi();}));
            bot.play();
            clicks = clicks + 2;
            if(gameMode.getRivalsNumber() == 1){
                nextTurn.setText(nt + playerTurn1 + you);
                clicks = 0;
            }
        }
        else if(clicks == 4){
            turn.setText(t + playerTurn3 + "(" + p3 + ")");
            nextTurn.setText(nt + playerTurn4 + "(" + p4 + ")");

            Timeline bot = new Timeline(new KeyFrame(Duration.seconds(1.5),event1 -> {multi();}));
            bot.play();
            clicks = clicks +2;
            if(gameMode.getRivalsNumber() == 2){
                nextTurn.setText(nt + playerTurn1 + you);
                clicks = 0;
            }
        }
        else if(clicks == 6){
            turn.setText(t + playerTurn4 + "(" + p4 + ")");
            nextTurn.setText(nt + playerTurn1 + you);

            Timeline bot = new Timeline(new KeyFrame(Duration.seconds(1.5),event1 -> multi()));
            bot.play();
            clicks = clicks +2;
            if(gameMode.getRivalsNumber() == 3){
                clicks = 0;
            }
        }
    }

    private void findWinner() {
        int count = 0;
        boolean playerWon = false;

        for(int i = 0;i<scoreBots.length;i++){
            if(score.getFoundCards()> scoreBots[i]){
                count++;
            }
        }
        if(count == 3){
            playerWon = true;
            wins2++;
            properties2.setProperty("MultiplayerWins2",Integer.toString(wins2));

            wins3++;

            winLabel.setText(youWin);
        }
        else{
            int max = scoreBots[0], pos = 0;
            for(int i = 0;i<scoreBots.length;i++){
                if(max<scoreBots[i]){
                    pos = i;
                    max = scoreBots[i];
                }
            }
            if(pos == 0){
                winLabel.setText(playerTurn2 +" " +botWin);
            }
            else if(pos ==1){
                winLabel.setText(playerTurn3 +" "+ botWin);
            }
            else if(pos == 2){
                winLabel.setText(playerTurn4 +" "+ botWin);
            }
        }
    }

    public void disableAll(){
        for(int i = 0;i<imageViews.size();i++){
            imageViews.get(i).setDisable(true);
        }
    }

    public void multi(){
        if(foundCards.size() == gameMode.getSize()) {
            findWinner();
            return;
        }
        disableAll();
        boolean flag = false;
        ImageView seenImageView1 = imageViews.get(0);
        ImageView seenImageView2 = imageViews.get(0);
        Card seenCard1 = cards.get(0);
        Card seenCard2 = cards.get(0);

        for(int i =0; i<seenCards.size();i++){
            for(int j = 0; j< seenCards.size();j++){
                if(j!=i && seenCards.get(i).getId() == seenCards.get(j).getId()){
                    seenImageView1 = seenImageViews.get(i);
                    seenImageView2 = seenImageViews.get(j);
                    seenCard1 = seenCards.get(i);
                    seenCard2 = seenCards.get(j);
                    flag = true;
                    break;
                }
            }
        }
        final ImageView i1 = seenImageView1;
        final ImageView i2 = seenImageView2;
        final Card c1 = seenCard1;
        final Card c2 = seenCard2;

        if(flag){
            if((clicks == 4 || clicks == 0)){
                scoreBots[0]++;
                player2.setText(pl2+scoreBots[0]);
            }
            else if(clicks == 6 || gameMode.getRivalsNumber() == 2){
                scoreBots[1]++;
                player3.setText(pl3+scoreBots[1]);
            }
            seenImageViews.remove(i1);
            seenImageViews.remove(i2);
            seenCards.remove(c1);
            seenCards.remove(c2);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.6),event -> {
                findAnimation(i1, i2, c1, c2);
                foundCards.add(i1);
                foundCards.add(i2);
            }));
            timeline.play();
            timeline.setOnFinished(event -> {
                new Timeline(new KeyFrame(Duration.seconds(2.5),event2 -> {
                    multi();
                })).play();
            });
        }
    }

    private void findAnimation(ImageView imageView1,ImageView imageView2,Card card1,Card card2){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5),imageView1);
        scaleTransition.setFromX(1);
        scaleTransition.setToX(-1);
        scaleTransition.play();
        scaleTransition.setOnFinished(event -> {
            imageView1.setScaleX(1);
            imageView1.setImage(card1.getValue());
            imageView1.setDisable(true);
            imageView1.setOpacity(0.6);
        });

        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(0.5),imageView2);
        scaleTransition2.setFromX(1);
        scaleTransition2.setToX(-1);
        scaleTransition2.play();
        scaleTransition2.setOnFinished(event -> {
            imageView2.setScaleX(1);
            imageView2.setImage(card2.getValue());
            imageView2.setDisable(true);
            imageView2.setOpacity(0.6);
        });
    }



    public void enableAll() {
        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setDisable(false);
        }
        for(int i = 0; i < foundCards.size(); i++) {
            foundCards.get(i).setDisable(true);
        }
    }

    private void enable(ImageView imageView){
        enableAll();
        imageView.setDisable(true);
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

//    public void createImages(ArrayList<Card> cards) {
//        int times = 0;
//        int j = 0;
//        for(int i =1; i <= size;i++) {
//            if(i % gameMode.getSelectCards() == 1){
//                times++;
//                j++;
//            }
//            Image value = new Image("Images/Cards/" + j + ".png");
////            Card image2 = new Card(value,theme,times);
////            cards.add(image2);
//        }
//    }


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
