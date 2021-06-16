package Exercise31_01;// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exercise31_01Server extends Application {
  int port = 8000;

  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);

    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    new Thread(() -> connectToClient()).start();
  }

  public void connectToClient() {
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(port);
      Platform.runLater(() -> {
        ta.appendText("Exercise31_01Server started at " + new Date() + "\n");
      });
      // Listen for a new connection request
      Socket socket = serverSocket.accept();

      // Create a data input and output streams
      // Create an input stream
      DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
      // Create an output stream
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

      // Ready to create a session
      while (true) {
        Date dateClientConnected = new Date();

        // Receive loan information from the client
        double annualInterestRate = inputFromClient.readDouble();
        int numberOfYears = inputFromClient.readInt();
        double loanAmount = inputFromClient.readDouble();
        Loan l = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Compute monthly payment and total payment
        double monthlyPayment = l.getMonthlyPayment();
        double totalPayment = l.getTotalPayment();

        // Send monthly payment and total payment back to the client
        outputToClient.writeDouble(monthlyPayment);
        outputToClient.writeDouble(totalPayment);

        Platform.runLater(() -> {
          ta.appendText("Connected to a client at " +
                  dateClientConnected + '\n');
          ta.appendText("Annual Interest Rate: " +
                  annualInterestRate + '\n');
          ta.appendText("Number Of Years: " + numberOfYears + '\n');
          ta.appendText("Loan Amount: " + loanAmount + '\n');
          ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
          ta.appendText("totalPayment: " + totalPayment + '\n');
        });
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) { launch(args); }
}
