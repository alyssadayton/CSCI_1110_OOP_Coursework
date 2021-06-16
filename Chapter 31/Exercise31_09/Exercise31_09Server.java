package Exercise31_09;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise31_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  DataOutputStream toClient;
  DataInputStream fromClient;
  int port = 8000;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));

    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    taClient.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.ENTER) {
        try {
          String message = taClient.getText().trim();
          toClient.writeUTF(message);
          toClient.flush();
          taClient.setText("");

          taServer.appendText("S: " + message + "\n");
        } catch (IOException ex) {
          System.err.println(ex);
        }
      }
    });

    new Thread(() -> {
      try {
        ServerSocket serverSocket = new ServerSocket(port);

        // Listen for a new connection request
        Socket socket = serverSocket.accept();

        // Create an input stream
        fromClient = new DataInputStream(socket.getInputStream());
        // Create an output stream
        toClient = new DataOutputStream(socket.getOutputStream());

        while (true) {
          String message = fromClient.readUTF();

          Platform.runLater(() -> {
            taServer.appendText("C: " + message + "\n");
          });
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) { launch(args); }
}
