import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Exercise17_15 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter encrypted file name");
         String inFile = input.next();
        System.out.println("Enter decrypted file name");
        String outFile = input.next();

        try (
             RandomAccessFile encrypted = new RandomAccessFile(inFile, "r");
             RandomAccessFile decrypted = new RandomAccessFile(outFile, "rw");
        ) {

            int r = 0;
            encrypted.seek(0);
            while((r = encrypted.read()) != -1) {
            decrypted.write(((byte) r) - 5);
            }
        }
    }
}
