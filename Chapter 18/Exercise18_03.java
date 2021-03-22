package Exercises; /**
 * @Alyssa Dayton
 */

import java.util.*;

public class Exercise18_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 2 numbers");
        int m = input.nextInt();
        int n = input.nextInt();
        System.out.printf("The Greatest Common Divisor is " + factorial(m,n));
    }
        public static long factorial(int m, int n) {
            if (m % n == 0) {
                return n;
            } else
                return factorial(n, m % n);
    }
}

