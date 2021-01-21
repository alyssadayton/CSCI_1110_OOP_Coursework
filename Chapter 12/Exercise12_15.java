import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class Exercise12_15 {
	public static void main(String[] args) throws IOException {
		
		java.io.File file = new java.io.File("Exercise12.15.txt");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		try (
			java.io.PrintWriter output = new java.io.PrintWriter(file);	
		) {
			int[] list = new int[100];
			for(int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random() * 100);		
			}
			Arrays.sort(list);
		}catch (Exception ex) {
			System.out.println("Invalid");
		}
	}
}


