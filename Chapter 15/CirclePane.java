package sample;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;

public class CirclePane extends Application {
    private MoveCircle movecircle = new MoveCircle();

    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER);
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");
        hbox.getChildren().addAll(left, right, up, down);

            left.setOnAction(e -> movecircle.left());
            right.setOnAction(e -> movecircle.right());
            up.setOnAction(e -> movecircle.up());
            down.setOnAction(e -> movecircle.down());

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 10, 5, 10));
        pane.setCenter(movecircle);
        pane.setBottom(hbox);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Exercise 15 - 03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
