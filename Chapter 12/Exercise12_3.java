import java.util.*;
public class Exercise12_3 {

	public static void main(String[] args) {
		
		int[] list = new int[100];
		for(int i = 0; i < list.length; i++) {
		list[i] = (int)(Math.random() * 100);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 0 - 99: ");
		try {
			int number = input.nextInt();
			System.out.println("array " + number + list[number]);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Number is out of bounds.");
		} catch (Exception ex) {
			System.out.println("Invalid Input");
		}
	}
}




