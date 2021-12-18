package ru.kpfu.itis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameMode {
    private int size;
    private int columns,rows;
    private int selectCards;
    private String globalMode,rival1,rival2,rival3;
    private Properties properties = new Properties();
    private int width,rivalsNumber;
    private double imWidth = 90,imHeight = 130;

    public GameMode(){
        rival1 = "None";
        rival2 = "None";
        rival3 = "None";
        rivalsNumber = 0;
    }

    public void CreateMode() {
        size = 24;
        columns = 6;
        rows = 4;
        selectCards = 2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSelectCards() {
        return selectCards;
    }

    public void setSelectCards(int selectCards) {
        this.selectCards = selectCards;
    }

    public String getGlobalMode() {
        return globalMode;
    }

    public void setGlobalMode(String globalMode) {
        this.globalMode = globalMode;
    }

    public String getRival1() {
        return rival1;
    }

    public void setRival1(String rival1) {
        this.rival1 = rival1;
    }

    public String getRival2() {
        return rival2;
    }

    public void setRival2(String rival2) {
        this.rival2 = rival2;
    }

    public String getRival3() {
        return rival3;
    }

    public void setRival3(String rival3) {
        this.rival3 = rival3;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getRivalsNumber() {
        return rivalsNumber;
    }

    public void setRivalsNumber(int rivalsNumber) {
        this.rivalsNumber = rivalsNumber;
    }

    public double getImWidth() {
        return imWidth;
    }

    public void setImWidth(double imWidth) {
        this.imWidth = imWidth;
    }

    public double getImHeight() {
        return imHeight;
    }

    public void setImHeight(double imHeight) {
        this.imHeight = imHeight;
    }
}
