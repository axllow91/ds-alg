package queues;

import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        q.enqueue(10); // f in -> f out
        q.enqueue(100);
        q.enqueue(1000);
        q.enqueue(10000);
        q.enqueue(100000); // l in -> l out

        System.out.println("Queue size: " + q.size());

        while(!q.isEmpty())
            System.out.println(q.dequeue());

        // Linked list of the queue implementation
        // java build in
        // LinkedList and PriorityQueue extends AbstractQueue and this class implements the Queue interface
        // PriorityQueue adds element into a natural order (means is ordered)

        System.out.println("\nUsing build in Queue interface");

        java.util.Queue<String> q1 = new PriorityQueue<>(); // PriorityQueue is the concrete implementation
        q1.add("Samuel");
        q1.add("Aiden");
        q1.add("Sub-Zero");
        q1.add("SeeMoro");

        /*
        * Retrieves, but does not remove, the head of this queue.
        * This method differs from peek only in that it throws an exception if this queue is empty.
        * */
        System.out.println("Peek at the head of the queue: " + q1.element() + "\n");

        ((PriorityQueue<String>) q1).comparator();

        while(!q1.isEmpty()) {
            System.out.println(q1.remove());
        }
    }
}
