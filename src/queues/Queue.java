package queues;

public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;


    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public int size() {
        return this.count;
    }

    // O(1)
    public void enqueue(T newData) {
        this.count++;

        // this will take the last node
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(newData); // create new node with the data
        this.lastNode.setNextNode(null); // next node will be pointing to a null

        // whether the queue is empty
        // first node will take the last node
        if(isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
            oldLastNode.setNextNode(this.lastNode); // setting the next node to be last node
        }
    }

    // O(1)
    public T dequeue() {
        this.count--;
        T dataToDequeue = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();

        if(isEmpty()) {
            this.lastNode = null;
        }
        return dataToDequeue;
    }
}
