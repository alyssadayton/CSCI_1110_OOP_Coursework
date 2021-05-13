/*
Author: Alyssa Dayton
Date: 05/11/21
Description: Write a program that enables the user to select a year, gender, and enter a name to display the
ranking of the name for the selected year and gender.
To achieve the best efficiency, create two arrays for boy’s names and girl’s names, respectively.
Each array has 10 elements for 10 years. Each element is a map that stores a name and its ranking in a pair
with the name as the key.
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise21_11 extends Application {
    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();
    Map<String, Integer>[] mapForBoy = new HashMap[10];
    Map<String, Integer>[] mapForGirl = new HashMap[10];

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Create and register handle
        btFindRanking.setOnAction(e -> getRank());

        getNames();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);
        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");
    }

    /* Returns selected rank of name */
    private void getRank() {
        int year = cboYear.getSelectionModel().getSelectedItem();
        String gender = cboGender.getSelectionModel().getSelectedItem();
        String name = tfName.getText().trim();

        if (gender.equals("Male")) {
            if (mapForBoy[year - 2001].containsKey(name)) {
                lblResult.setText(gender + " Name " + name + " is ranked # " +
                        mapForBoy[year - 2001].get(name) + " " + " in the year " + year + ".");
            } else
                lblResult.setText("Name " + name + " is not in the year " + year);
        } else {
                if (gender.equals("Female")) {
                    if (mapForGirl[year - 2001].containsKey(name)) {
                        lblResult.setText(gender + " Name " + name + "is ranked # " +
                                mapForGirl[year - 2001].get(name) + " " + " in the year " + year + ".");
                    } else
                            lblResult.setText("Name " + name + " is not in the year " + year);
                    }
            }
        }

    private void getNames() {
        // Read data from url
        for (int i = 0; i < 9; i++) {
            try {
                URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2001 + i) + ".txt");
                Scanner input = new Scanner(url.openStream());
                mapForBoy[i] = new HashMap<>();
                mapForGirl[i] = new HashMap<>();

                while (input.hasNext()) {
                    int ranking = input.nextInt();
                    String boyname = input.next();
                    input.nextInt(); // Skips the number of boys names
                    String girlsnames = input.next();
                    input.nextInt(); // Skips the number of girls names

                    mapForBoy[i].put(boyname, ranking);
                    mapForGirl[i].put(girlsnames, ranking);
                }
            } catch (MalformedURLException e) {
                System.out.println("Not a correct Name.");
            } catch (IOException e) {
                System.out.println("Please try again");
            }
        }
    }
        /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

