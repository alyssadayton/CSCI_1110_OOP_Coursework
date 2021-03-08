package StopWatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Watch extends Application {
    protected Media media = new Media(
            "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
    protected MediaPlayer mediaPlayer = new MediaPlayer(media);
    protected TextField text = new TextField();
    protected Timeline animation;

    @Override
    public void start(Stage primaryStage) {

        text.setAlignment(Pos.CENTER);
        text.setFont(Font.font(60));
        text.setPrefColumnCount(4);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        StackPane pane = new StackPane(text);

        animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> run()));
        animation.setCycleCount(Timeline.INDEFINITE);

        text.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                animation.play();
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("StopWatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void run() {
        if (Integer.parseInt(text.getText()) > 0) {
            mediaPlayer.pause();
            mediaPlayer.seek(Duration.ZERO);
            text.setText(String.valueOf(
                    Integer.parseInt(text.getText()) - 1));
        }
        if (text.getText().equals("0")) {
            animation.pause();
            mediaPlayer.play();
        }
    }
}


