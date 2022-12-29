package com.example.snake_ladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 50, height = 10, width = 10;
    int lowerline = tileSize*height+10;
    int diceValue;
    Label rolledDiceValueLabel;

    boolean firstPlayerTurn = true, secondPlayerTurn = false, gameStarted = false;

    Button startGameButton;

    Players firstPlayer = new Players(tileSize-10, Color.BLACK, "Sonu");
    Players secondPlayer = new Players(tileSize-10, Color.BLUE, "Monu");

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+110);
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }

        Image image = new Image("C:\\Users\\Sandeep\\IdeaProjects\\Snake_Ladder\\src\\main\\resources\\SnakeLadderBoard12Nov.jpg");
        ImageView boardimage = new ImageView();
        boardimage.setImage(image);
        boardimage.setFitWidth(tileSize*width);
        boardimage.setFitHeight(tileSize*height);

        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(0);
        playerOneButton.setTranslateY(lowerline);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(firstPlayerTurn){
                        setDiceValue();
                        firstPlayer.movePlayer(diceValue);
                        if(firstPlayer.playerWon()!=null){
                            rolledDiceValueLabel.setText(firstPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start Game");
                        }
                        firstPlayerTurn = false;
                        secondPlayerTurn = true;
                    }
                }

            }
        });


        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(427);
        playerTwoButton.setTranslateY(lowerline);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(secondPlayerTurn){
                        setDiceValue();
                        secondPlayer.movePlayer(diceValue);
                        if(secondPlayer.playerWon()!=null){
                            rolledDiceValueLabel.setText(secondPlayer.playerWon());
                            firstPlayerTurn = true;
                            secondPlayerTurn = false;
                            gameStarted = false;
                            startGameButton.setDisable(false);
                            startGameButton.setText("Start Game");
                        }
                        secondPlayerTurn = false;
                        firstPlayerTurn = true;
                    }
                }
            }
        });

        startGameButton = new Button("Start Game");
        startGameButton.setTranslateX(220);
        startGameButton.setTranslateY(lowerline+40);
        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted = true;
                startGameButton.setText("Ongoing Game");
                startGameButton.setDisable(true);
            }
        });


        rolledDiceValueLabel = new Label("Start the game");
        rolledDiceValueLabel.setTranslateX(220);
        rolledDiceValueLabel.setTranslateY(lowerline);

        root.getChildren().addAll(boardimage, playerOneButton,playerTwoButton,
                firstPlayer.getCoin(), secondPlayer.getCoin(), rolledDiceValueLabel,
                startGameButton
        );
        return root;
    }

    private void setDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        rolledDiceValueLabel.setText("Dice Value : "+diceValue);
    }




    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake&Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}