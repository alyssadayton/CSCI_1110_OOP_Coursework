
public class Exercise13_07 {
	public static void main(String[] args) {

		GeometricObject[] triangles = {new Triangle(4,5,4), new Triangle(5,3,2), new Triangle(4,8,6),
				new Triangle(2,1,4), new Triangle(6,2,3)};


		for(int i = 0; i < 5; i++) {
			System.out.println("\nTriangle #" + (i +1));
			System.out.println("Area is: "+ triangles[i].getArea());
			System.out.println("How to color: " + ((Triangle)triangles[i]).howtocolor());
		}
	}
}
