
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Exercise17_01 {

        public static void main(String[] args) throws IOException {

            try (
                    FileOutputStream output = new FileOutputStream("Exercise17_01.txt")
            ) {
                Random random = new Random();
                for (int i = 0; i <= 100; i++) {
                    int x = 1 + random.nextInt();
                    output.write(x);
                }
                new PrintWriter(new FileOutputStream("Exercise17_01.txt", true));
            }
            try (
                    FileInputStream input = new FileInputStream("Exercise17_01.txt")
            ) {
                int value;
                while ((value = input.read()) != -1)
                    System.out.print(value + " ");
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


