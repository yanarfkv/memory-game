package ru.kpfu.itis;

public class Score {
    private int movies;
    private int foundCards;

    public int getMovies() {
        return movies;
    }

    public void setMovies(int movies) {
        this.movies = movies;
    }

    public int getFoundCards() {
        return foundCards;
    }

    public void setFoundCards(int foundCards) {
        this.foundCards = foundCards;
    }

    public void updateMoves() {
        movies++;
    }

    public void updateFoundCards() {
        foundCards++;
    }
}
