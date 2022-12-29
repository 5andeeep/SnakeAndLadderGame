package com.example.snake_ladder;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Players {
    private Circle coin;

    private String name;
    private int CoinPosition;

    public Players(int tileSize, Color coinColor, String playerName){
        CoinPosition = 1;
        name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCoinPosition() {
        return CoinPosition;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }
}
