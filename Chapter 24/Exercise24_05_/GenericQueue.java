package Exercise24_05_;
/*
Author: Alyssa Dayton
Date: 05/05/2021

Description:(Implement GenericQueue using inheritance) In Section 24.5, GenericQueue is implemented using composition.
This means that a LinkedList object is created inside of the class and then is used to access LinkedList's methods.
Another way of creating GenericQueue is using inheritance. Instead of creating an instance of LinkedList in the object
class, GenericQueue can extend LinkList and access its methods that way.
Create a new GenericQueue class that uses inheritance. Create a test method that uses both the enqueue and
dequeue methods and prints how the queue is affected.
 */
public class GenericQueue<E> {
    private java.util.LinkedList<E> list
            = new java.util.LinkedList<>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }
}
