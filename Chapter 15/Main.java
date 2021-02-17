package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle(0,0,25,50);
        rectangle.setFill(Color.BLUE);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();

        final double WIDTH = 200, HEIGHT = 250;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
           double radius = Math.min(WIDTH, HEIGHT) * 0.4;
   // Add points to the polygon list
        for (int i = 0; i < 5; i++) {
          list.add(centerX + radius * Math.cos(2 * i * Math.PI / 5));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 5));
             }

        pane.getChildren().add(polygon);
        pane.getChildren().add(rectangle);
        pane.setRotate(55);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(3000));
        FadeTransition ft =
                new FadeTransition(Duration.millis(3000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        pt.setPath(polygon);
        pt.setNode(rectangle);
        pt.setOrientation( PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.play();
        pt.play();

        pane.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.PRIMARY) {
                        pt.pause();
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        pt.play();
                    }
                });

            Scene scene = new Scene(pane, 300, 300);
            primaryStage.setTitle("Exercise 15 Animation");
            primaryStage.setScene(scene);
            primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


