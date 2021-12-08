package ru.kpfu.itis;

public class Score {
    private int moves;
    private int foundCards;

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getFoundCards() {
        return foundCards;
    }

    public void setFoundCards(int foundCards) {
        this.foundCards = foundCards;
    }

    public void updateMoves(){
        moves++;
    }

    public void updateFoundCards(){
        foundCards++;
    }
}
