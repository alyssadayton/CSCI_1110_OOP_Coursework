import java.util.*;
public class Triangle extends GeometricObject implements Colorable {

	private double s1;
	private double s2;
	private double s3;

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
		setColor(color);
		setFilled(filled);
	}

	public double getS1() 
	{
		return s1;
	}
	
	public void setS1(double s1) {
		this.s1 = s1;
	}
	
	public double getS2() {
		return s2;
	}
	
	public void setS2(double s2) {
		this.s2 = s2;
	}
	
	public double getS3() {
		return s3;
	}
	
	public void setS3(double s3) {
		this.s3 = s3;
	}
	
	@Override
	public double getArea() {
		double p = getPerimeter() / 2;
		return Math.sqrt(p * (p - s1) * (p - s2) * (p - s3));
	}
	
	@Override
	public double getPerimeter() {
		return s1 + s2 + s3;
	}
	
	@Override
	public String howtocolor() {
		return "Color all three sides";
	}
	@Override
	public String toString() {
		return super.toString() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
	}
}


