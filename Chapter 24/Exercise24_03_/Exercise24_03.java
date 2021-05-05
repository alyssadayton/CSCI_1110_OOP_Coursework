package Exercise24_03_;
/*
Author: Alyssa Dayton
Date: 05/05/2021

Description: A doubly linked list enables two-way traversal, To do this, the Node class needs to be modified
to add the new data field name previous to refer to the previous node.
Implement a new class named TwoWayLinkedList that uses a doubly linked list to store elements.
Make edits to the TwoWayLinkedList class where told in the comments (lines 47, 65, 87, and 88).
 */
class Exercise24_03 {
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        java.util.ListIterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        // System.out.print(iterator.next() + " ");

        System.out.println();
        while (iterator.hasPrevious())
            System.out.print(iterator.previous() + " ");
    }
}