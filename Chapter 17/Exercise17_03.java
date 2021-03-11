import java.io.*;
import java.util.Random;

public class Exercise17_03 {
    public static void main(String[] args) throws IOException{
        int sum = 0;
        try {
            try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat"))) {
                Random random = new Random();
                for (int i = 0; i <= 100; i++) {
                    sum += random.nextInt();
                    output.writeInt(sum);
                }
                new PrintWriter(new FileOutputStream("Exercise17_03.dat", true));
            }
            try (DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_03.dat"))) {
                while (true)
                 System.out.println(sum += input.readInt());
            }
        }
        catch (EOFException ex) {
            System.out.println("The sum of the numbers is: " + sum);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
