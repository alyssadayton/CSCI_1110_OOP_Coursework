/**
 * @Author Alyssa Dayton
 */
import java.io.*;
import java.util.Scanner;

public class Exercise17_14 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter File input name");
        String inFile = input.next();
        System.out.println("Enter File output name");
        String outFile = input.next();

        try (
                RandomAccessFile source = new RandomAccessFile(inFile, "r");
                RandomAccessFile target = new RandomAccessFile(outFile, "rw");
                ) {
            int r = 0;
            source.seek(0);
            while((r = source.read()) != -1) {
                target.write(((byte)r) + 5);
            }
        }
    }
}

