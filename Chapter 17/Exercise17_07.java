/**
 *
 * @author Alyssa Dayton
 */
import java.io.*;

    public class Exercise17_07 {
        public static void main(String[] args) throws ClassNotFoundException, IOException {
            Loan loan1 = new Loan();
            Loan loan2 = new Loan(1.8, 10, 10000);
            try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"))
            ){
                output.writeObject(loan1);
                output.writeObject(loan2);
            }
            outputData();
        }
            public static void outputData() {
                int total = 0;
                int count = 0;
                try (
                        ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Exercise17_07.dat")))
                ) {
                    while (true) {
                        Loan loan = (Loan) (input.readObject());
                        total += loan.getLoanAmount();
                        count++;
                    }
                } catch (EOFException e) {
                    System.out.println("Total loans: " + count);
                    System.out.println("Total Loan Amount: " + total);
                } catch (Exception e) {
                    System.out.println(e);
                }
        }
}
