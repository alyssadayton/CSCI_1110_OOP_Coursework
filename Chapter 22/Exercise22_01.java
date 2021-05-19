/*
Author: Alyssa Dayton
Date: 05/17/2020
Description: (Maximum consecutive increasingly ordered substring ) Write a program that prompts the user to
enter a string and displays the maximum consecutive increasingly ordered substring. Analyze the time complexity
of your program.
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise22_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.println("Enter a String: ");
        String s = input.nextLine();
        int n = s.length();

        for(int i = 0; i < s.length(); i++) {
            if(list.size() > 1 && s.charAt(i) <= list.getLast() && list.contains(s.charAt(i))) {
                list.clear();
            }
            list.add(s.charAt(i));

            if(list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }

        for(Character ch: max) {
            System.out.print(ch);
        }
        System.out.println();
        System.out.println((largestSubstring(s,n)));
    }

    public static int getEndIndex(String s, int n, int i) {
        i++;
        while(i < n) {
        char curr = s.charAt(i);
        char prev = s.charAt(i - 1);

        if((curr == 'a') && (prev == 'z') || (curr - prev == 1)) {
            i++;
        }else
            break;
        }
        return i - 1;
    }
    public static int largestSubstring(String s, int n) {
        int leng = 0;

        int i = 0;
        while(i < n) {
            int end = getEndIndex(s,n,i);
            leng = Math.max(end - i + 1, leng);
            i = end + 1;
        }
        return leng;
    }
}
