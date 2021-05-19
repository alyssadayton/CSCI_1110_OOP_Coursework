import java.util.Scanner;

/*
Author: Alyssa Dayton
Date: 05-18-21
Description: (Pattern matching ) Write a program that prompts the user to enter two strings and tests whether
the second string is a substring of the first string. Suppose the neighboring characters in the string are distinct.
(Don’t use the indexOf method in the String class.) Analyze the time complexity of your algorithm.
Your algorithm needs to be at least O(n) time.
 */
public class Exercise22_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter First String: ");
        String s1 = input.nextLine();
        System.out.println("Enter Second String: ");
        String s2 = input.nextLine();

       int index = -1;
       int count = 0;

       for(int i = 0; i < s1.length(); i++) {
           if(s1.charAt(i) == s2.charAt(0) && count == 0) {
               index = i;
               count++;
           } else if (s1.charAt(i) == s2.charAt(count)) {
               count++;
           } else {
               count = 0;
               index = -1;
           }
           if(count == s2.length())
               break;
       }

       if(index > 1) {
           System.out.println("Matched at index " + index);
       } else
           System.out.println("String 2 is not a substring of String 1.");
    }
}
/*  Analyze the time complexity of the program:
    1 single loop = 1.
  4 simple statements = 4.
 T(n) = (c + c + c + c) * n
 T(n) = 4c * n;                                                                *
 T(n) = O(n) Linear time;
 */
