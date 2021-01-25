import java.util.Scanner;

public class Exercise13_1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three sides of the triangle: ");
		double s1 = input.nextDouble();
		double s2 = input.nextDouble();
		double s3 = input.nextDouble();
		
		System.out.print("Enter a color: ");
		String color = input.next();
		
		System.out.print("\nIs the triangle filled (true/ false): ");
		boolean filled = input.nextBoolean();
		
		
		Triangle triangle = new Triangle(s1, s2, s3, color, filled);
		
		System.out.println(triangle);
		
	}

}
