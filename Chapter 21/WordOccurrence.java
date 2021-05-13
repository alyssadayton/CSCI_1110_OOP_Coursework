import java.util.*;
/*
Author: Alyssa Dayton
Date: 05/10/21

Description: The program should display the words in ascending order of occurrence counts.
(Hint: Create a class named WordOccurrence that implements the Comparable interface.
The class contains two fields, word and count. The compareTo method compares the counts.
For each pair in the hash set in Listing 21.9, create an instance of WordOccurrence and store it in an array list.
Sort the array list using the Collections.sort method. What would be wrong if you stored the instances
of WordOccurrence in a tree set?)
 */
public class WordOccurrence {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();
        Set<String> set = new HashSet<>();
        set.add(text);

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
            // Display key and value for each entry
            map.forEach((k, v) -> System.out.println(k + "\t" + v));
            // add numbers to the array list
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < set.hashCode(); j++) {
                list.add(j);
                Collections.sort(list); // sorts array list
            }
    }
}

