package com.example.snake_ladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 40, height = 10, width = 10;
    int lowerline = tileSize*height+10;

    Players firstPlayer = new Players(tileSize-10, Color.BLACK, "Sonu");
    Players secondPlayer = new Players(tileSize-20, Color.WHITE, "Monu");

    Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+100);
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
        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(327);
        playerTwoButton.setTranslateY(lowerline);

        root.getChildren().addAll(boardimage, playerOneButton,playerTwoButton,
                firstPlayer.getCoin(), secondPlayer.getCoin()
        );
        return root;
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