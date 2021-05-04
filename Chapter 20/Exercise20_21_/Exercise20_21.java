package Exercise20_21_;
/*
Author:@Alyssa Dayton
Date: 05/03/2021

Description: Display the sorted elements of list.
*/
import java.util.Comparator;

public class Exercise20_21 {
    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)};

        selectionSort(list, new GeometricObjectComparator());
        System.out.println("Elements Sorted: ");
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i].getArea() + " ");
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        boolean nextpass = true;
        for(int k = 0; k < list.length - 1 && nextpass; k++){
            E temp = list[k];
            int currentindex = k;
          
            for (int i = k + 1; i < list.length; i++) {
                if(comparator.compare(temp, list[i])> 0) {
                    temp = list[i];
                    currentindex = i;
                }
            }
            if(currentindex != k) {
                list[currentindex] = list[k];
                list[k] = temp;
            }
            nextpass = true;
        }
    }
}