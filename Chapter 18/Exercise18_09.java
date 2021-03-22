package Exercises;

public class Exercise18_09 {
    public static void main(String[] args) {
        String s = "moon";
       reverseDisplay(s);
    }

    public static void reverseDisplay(String s) {
        if(s.length() > 0) {
            System.out.print(s.charAt(s.length() - 1));
            reverseDisplay(s.substring(0, s.length() - 1));
        }
    }
}
