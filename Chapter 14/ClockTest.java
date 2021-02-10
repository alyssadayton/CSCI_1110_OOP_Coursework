import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ClockTest extends Application{

	@Override
	public void start(Stage primaryStage) {
		Clock clock = new Clock((int)(Math.random() * 12),(int)(Math.random() * 30), 0);
		String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		clock.setSecondHandVisible(false);
		Label label = new Label(time);

		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(label);
		BorderPane.setAlignment(label, Pos.TOP_CENTER);

		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("Clock");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
