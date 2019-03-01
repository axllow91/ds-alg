package heap;

import linked_list.Person;

import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(1);
        heap.insert(23);
        heap.insert(56);
        heap.insert(3);
        heap.insert(10);
        heap.insert(-5);

        heap.heapSort();

        System.out.println("\n" + heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());


        /* **java.util.
         * PriorityQueue
         * add() -> adds element into the queue
         * peek() -> returns the head element without removing it
         * element() -> the same as the peek() method but if queue is empty throws and exception
         * poll() -> retrieves and removes the head of this queue, or return null if queue is empty
         * **/
        Queue<Person> queue = new PriorityQueue<>();

        queue.add(new Person("Me", 23));
        queue.add(new Person("You", 10));
        queue.add(new Person("Self", 15));
        queue.add(new Person("NotBorn", -1));

        System.out.println("Peeked at: ");
        System.out.println(queue.peek());
        System.out.println(queue.element());


        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
