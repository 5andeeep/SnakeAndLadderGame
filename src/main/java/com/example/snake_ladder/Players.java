package com.example.snake_ladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Players {
    private Circle coin;

    private String name;
    private int CoinPosition;

    private static Board gameBoard = new Board();

    public Players(int tileSize, Color coinColor, String playerName){
        CoinPosition = 1;
        name = playerName;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(SnakeLadder.tileSize/2);
        coin.setTranslateY(SnakeLadder.tileSize*SnakeLadder.height - (SnakeLadder.tileSize)/2);
    }

    public void movePlayer(int diceValue){
        if(CoinPosition + diceValue <= 100){
            CoinPosition += diceValue;
//            coin.setTranslateX(gameBoard.getXCoordinate(CoinPosition));
//            coin.setTranslateY(gameBoard.getYCoordinate(CoinPosition));
            translatePlayer();
            int newPosition = gameBoard.getNextPosition(CoinPosition);
            if(newPosition != CoinPosition){
                CoinPosition = newPosition;
                translatePlayer();
            }
        }
    }

    public String playerWon(){
        if(CoinPosition==100){
            return name + " won the game";
        }
        return null;
    }

    private void translatePlayer(){
        TranslateTransition move = new TranslateTransition(Duration.millis(1000), this.coin);
        move.setToX(gameBoard.getXCoordinate(CoinPosition));
        move.setToY(gameBoard.getYCoordinate(CoinPosition));
        move.setAutoReverse(false);
        move.play();
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
