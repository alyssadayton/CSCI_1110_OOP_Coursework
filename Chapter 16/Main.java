package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Main extends Application {
    protected Text text = new Text(50,50,"Programming is fun");

    protected BorderPane borderPane() {
        HBox paneForButton = new HBox(20);
        Button btleft = new Button("<=");
        Button btright = new Button("=>");
        paneForButton.getChildren().addAll(btleft, btright);
        paneForButton.setAlignment(Pos.BOTTOM_CENTER);
        paneForButton.setStyle("-fx-border-color: Black");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButton);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        text.setFont(Font.font("Times", 20));
        pane.setCenter(paneForText);
        btleft.setOnAction(e -> text.setX(text.getX() - 10));
        btright.setOnAction(e -> text.setX(text.getX() + 10));

         HBox paneForButtons = new HBox(20);
        paneForButtons.setPadding(new Insets(5,5,5,5));
        paneForButtons.setStyle("-fx-border-color: black");
        paneForButtons.setStyle("-fx-border-width: 2px; -fx-border-color: black");
        RadioButton btRed = new RadioButton("Red");
        RadioButton btYellow = new RadioButton("Yellow");
        RadioButton btBlack = new RadioButton("Black");
        RadioButton btOrange = new RadioButton("Orange");
        RadioButton btGreen = new RadioButton("Green");
            paneForButtons.getChildren().addAll(btRed, btYellow, btBlack, btOrange, btGreen);
            pane.setTop(paneForButtons);

    ToggleGroup group = new ToggleGroup();
            btRed.setToggleGroup(group);
            btYellow.setToggleGroup(group);
            btBlack.setToggleGroup(group);
            btOrange.setToggleGroup(group);
            btGreen.setToggleGroup(group);
            btRed.setOnAction(e -> {
        if(btRed.isSelected()) {
            text.setFill(Color.RED);
        }
    });
            btYellow.setOnAction(e -> {
        if(btYellow.isSelected()) {
            text.setFill(Color.YELLOW);
        }
    });
            btBlack.setOnAction(e -> {
        if(btBlack.isSelected()) {
            text.setFill(Color.BLACK);
        }
    });
            btOrange.setOnAction(e -> {
        if(btOrange.isSelected()) {
            text.setFill(Color.ORANGE);
        }
    });
            btGreen.setOnAction(e -> {
        if(btGreen.isSelected()) {
            text.setFill(Color.GREEN);
        }
    });
            return pane;
}
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(borderPane(),400, 250);
        primaryStage.setTitle("RadioButton Exercise");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
