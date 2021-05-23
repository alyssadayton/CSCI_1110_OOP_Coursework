/*
Author: Alyssa Dayton
Date: 05/19/21
Description: (Generic quick sort) Write the following two generic methods using quick sort.
The first method sorts the elements using the Comparable interface and the second uses the Comparator interface.
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());

    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }

  /** Sorts the elements using the Comparable interface **/
  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
  }

  /** Helper Method **/
  public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

 /** Uses Comparator interface **/
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
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

  public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
      E pivot = list[first]; // Choose the first element as the pivot
      int low = first + 1; // index for forward search
        int high = last; // index for backward search
        while (high > low) {
          // search forward from left
          while (low <= high && list[low].compareTo(pivot) <= 0)
            low++;

          // search backward from right
          while (low <= high && list[high].compareTo(pivot) > 0)
            high--;

          //swap two elements in the list
          if (high > low) {
            E temp = list[high];
            list[high] = list[low];
            list[low] = temp;
          }
        }
        while (high > first && list[high].compareTo(pivot) >= 0)
          high--;

        //swap pivot with list[high]
        if (pivot.compareTo(list[high]) >= 0) {
          list[first] = list[high];
          list[high] = pivot;
          return high;
        }
        else {
          return first;
        }
      }
  }
