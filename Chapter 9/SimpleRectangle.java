
public class SimpleRectangle {

	public static void main(String[] args) {

		SimpleRectangle rec1 = new SimpleRectangle(4, 40);
		System.out.printf("The width of the rectangle 1 is %3.1f, the height is %3.1f. The area is %3.2f and the perimeter is %3.2f.",rec1.width, rec1.height, rec1.getArea(), rec1.getPerimeter());
		SimpleRectangle rec2 = new SimpleRectangle(3.5, 35.9);
		System.out.printf("\nThe width of the rectangle 2 is %3.1f, the height is %3.1f. The area is %3.2f and the perimeter is %3.2f.",rec2.width, rec2.height, rec2.getArea(), rec2.getPerimeter());

	}
	double width;
	double height;

	public SimpleRectangle() {
		width = 1;
		height = 1;
	}
	public SimpleRectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}	
	double getArea() {
		return width * height;
	}
	double getPerimeter() {
		return 2 * width * height;
	}
}


