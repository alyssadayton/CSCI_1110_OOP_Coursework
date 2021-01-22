import java.io.*;
import java.util.*;

public class Exercise12_15 {
	public static void main(String[] args) throws Exception {

		File file = new File("Exercise12_15.txt");
		if(!file.exists()) {
			try (
					PrintWriter output = new PrintWriter(file);
					) {
				for(int i = 0; i < 100; i++) {
					output.print((int)(Math.random() * 100) + " ");
				}
			}
		}
		Scanner input = new Scanner(file);
		int[] list = new int[100];
		for(int i = 0; i < 100; i++) {
			list[i] = input.nextInt();
		}
		Arrays.sort(list);
		for (int i = 0; i < 100; i++) {
			System.out.print(list[i] + " ");
		}
	}
}


