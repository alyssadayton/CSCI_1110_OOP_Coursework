import java.util.*;
public class Triangle extends GeometricObject{

	private double s1;
	private double s2;
	private double s3;
	private String color;
	private boolean filled;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Triangle triangle = new Triangle();
		System.out.println("Enter 3 sides of a triangle: ");
		System.out.println("Enter side 1: ");
		double s1 = input.nextDouble();
		triangle.setS1(s1);
		System.out.println("Enter side 2: ");
		double s2 = input.nextDouble();
		triangle.setS2(s2);
		System.out.println("Enter side 3: ");
		double s3 = input.nextDouble();
		triangle.setS3(s3);
		System.out.println("Enter a color: ");
		String color = input.next();
		triangle.setColor(color);
		System.out.println("Is the triangle filled: True or False? ");
		boolean filled = input.nextBoolean();
		triangle.setFilled(filled);

		triangle.printTriangle();
		System.out.println(triangle.toString());
		System.out.println("The color is " + triangle.getColor());
		System.out.println("The Triangle is filled " + triangle.isFilled());
		System.out.printf("The area is %3.2f\n",triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
	}

	public Triangle() {
	}
	public Triangle(double s1, double s2, double s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3= s3;
	}
	public Triangle(double s1, double s2, double s3, String color, boolean filled) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		setColor("");
		setFilled(filled);
	}
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
	}
	public double getPerimeter() {
		return s1 + s2 + s3;
	}
	public String toString() {
		return "Triangle: side 1 = " + s1 + " side 2 = " + s2 + " side 3 = " + s3;
	}
	public void printTriangle() {
		System.out.println("Triangle created on " + getDateCreated());
	}
	public void setS1(double s1) {
		this.s1 = s1;
	}
	public void setS2(double s2) {
		this.s2 = s2;
	}
	public void setS3(double s3) {
		this.s3 = s3;
	}

}


