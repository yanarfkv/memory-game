package ru.kpfu.itis;

import javafx.scene.image.Image;

public class Card {
    private Image value;
    private int id;
    private Image background;

    public void setValue(Image value) {
        this.value = value;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public Card(Image value, int id){
        this.value = value;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getValue() {
        return value;
    }

    public int getId() {
        return id;
    }
}
