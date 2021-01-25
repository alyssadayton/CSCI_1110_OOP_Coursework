import java.util.Date;
import java.util.Scanner;

public abstract class GeometricObject {	
	private String color = "White";
	private boolean filled;
	private Date dateCreated;

	protected GeometricObject() {
	}
	protected  GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	@Override
	public String toString() {
		return getColor() + isFilled() + getDateCreated();
	}
	public abstract double getArea();
	
	public abstract double getPerimeter();
}