import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Author: Alyssa Dayton
Date: 05/11/21

Description: Rewrite Programming Exercise 8.37 to store pairs of each state and its capital in a map.
Your program should prompt the user to enter a state and should display the capital for the state.
 */
public class GuessCapitalsUsingMaps {
    public static void main(String[] args) {
        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("Alabama", "Montgomery");
        hashmap.put("Alaska", "Juneau");
        hashmap.put("Arizona", "Phoenix");
        hashmap.put("Arkansas", "Little Rock");
        hashmap.put("California", "Sacramento");
        hashmap.put("Colorado", "Denver");
        hashmap.put("Connecticut", "Hartford");
        hashmap.put("Delaware", "Dover");
        hashmap.put("Florida", "Tallahassee");
        hashmap.put("Georgia", "Atlanta");
        hashmap.put("Hawaii", "Honolulu");
        hashmap.put("Idaho", "Boise");
        hashmap.put("Illinois", "Springfield");
        hashmap.put("Indiana", "Indianapolis");
        hashmap.put("Iowa", "Des Moines");
        hashmap.put("Kansas", "Topeka");
        hashmap.put("Kentucky", "Frankfort");
        hashmap.put("Louisiana", "Baton Rouge");
        hashmap.put("Maine", "Augusta");
        hashmap.put("Maryland", "Annapolis");
        hashmap.put("Massachusetts", "Boston");
        hashmap.put("Michigan", "Lansing");
        hashmap.put("Minnesota", "Saint Paul");
        hashmap.put("Mississippi", "Jackson");
        hashmap.put("Missouri", "Jefferson City");
        hashmap.put("Montana", "Helena");
        hashmap.put("Nebraska", "Lincoln");
        hashmap.put("Nevada", "Carson City");
        hashmap.put("New Hampshire", "Concord");
        hashmap.put("New Jersey", "Trenton");
        hashmap.put("New York", "Albany");
        hashmap.put("New Mexico", "Santa Fe");
        hashmap.put("North Carolina", "Raleigh");
        hashmap.put("North Dakota", "Bismarck");
        hashmap.put("Ohio", "Columbus");
        hashmap.put("Oklahoma", "Oklahoma City");
        hashmap.put("Oregon", "Salem");
        hashmap.put("Pennsylvania", "Harrisburg");
        hashmap.put("Rhode Island", "Providence");
        hashmap.put("South Carolina", "Columbia");
        hashmap.put("South Dakota", "Pierre");
        hashmap.put("Tennessee", "Nashville");
        hashmap.put("Texas", "Austin");
        hashmap.put("Utah", "Salt Lake City");
        hashmap.put("Vermont", "Montpelier");
        hashmap.put("Virginia", "Richmond");
        hashmap.put("Washington", "Olympia");
        hashmap.put("West Virginia", "Charleston");
        hashmap.put("Wisconsin", "Madison");
        hashmap.put("Wyoming", "Cheyenne");

        Scanner input = new Scanner(System.in);

        // Prompt the user with a question
        while (!hashmap.isEmpty()) {
            System.out.print("Please Enter a State: ");
            String capital = input.next();
            if (hashmap.containsKey(capital)) {
                System.out.println("The Capital is: " + hashmap.get(capital));
            } else if(capital.equals("Q"))
                System.out.println("All Done");
        }
    }
}

