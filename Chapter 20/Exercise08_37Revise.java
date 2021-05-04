/**
@Author: Alyssa Dayton
 04/29/21

 Revising Exercise 8-37 to store states and capitals and display them randomly.
 */
import java.util.*;

public class Exercise08_37Revise {
    protected static List<String> states = new ArrayList<>();
    protected static List<String> capitals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        getStateCapital();

        int count = 0;

        for (int i = 0; i < states.size(); i++) {
            System.out.println("What is the Capital of " + states.get(i) + " ?");
                String capital = input.nextLine();

            if (isEqual(capitals.get(i), capital)) {
                    System.out.println("You are correct");
                    count++;
                } else {
                System.out.println("Correct answer is " + capitals.get(i));
            }
        }
        System.out.println("You got " + count + " right");
    }

    public static boolean isEqual(String c, String s) {
            if(c.length() != s.length())
                return false;
            for(int i = 0; i < c.length(); i++) {
                if(c.charAt(i) != s.charAt(i))
                    return false;
            }
            return true;
    }

    public static void getStateCapital() {
        String[][] sc = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"},
                {"California", "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"},
                {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"}, {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"}, {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"}, {"New York", "Albany"}, {"New Mexico", "Santa Fe"},
                {"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"}, {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}};

        for(int i = 0; i < sc.length; i++) {
            states.add(sc[i][0]);
            capitals.add(sc[i][1]);
        }

        Collections.shuffle(states, new Random(40));
        Collections.shuffle(capitals, new Random(40));
    }
}

