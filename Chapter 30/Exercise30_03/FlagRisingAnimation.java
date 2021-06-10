package Exercise30_03;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();

		// Add an image view and add it to pane
		ImageView imageView = new ImageView("Exercise30_03/image/us.gif");
		pane.getChildren().add(imageView);

		// Create a path transition
		PathTransition pt = new PathTransition(Duration.millis(10000),
				new Line(100, 200, 100, 0), imageView);
		pt.setCycleCount(5);
		pt.play();

		imageView.setX(40);
		imageView.setY(10);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				while (true) {
					Platform.runLater(() -> imageView.setY(imageView.getX() - 1)); // Start animation
					Thread.sleep(200);
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}