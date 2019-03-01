package heap;

/**The heap will be represented as an array**/
public class Heap {
    private Integer[] heap;
    private int currentPosition = -1;

    public Heap(int size) {
        // construct the heap
        this.heap = new Integer[size];
    }

    public void insert(int item) {
        if(isFull()) throw new RuntimeException("Heap is full...");

        // insert element into the next position level
        this.heap[++currentPosition] = item;

        // check for valid heap
        fixUp(currentPosition);
    }

    private void fixUp(int index) {
        int parentIndex = (index - 1) / 2;

        // parent should be a greater heap
        // while this is not true
        // parentIndex >= 0 seems we are not quite at the root node
        while(parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]) {
            // swap elements
            int temp = this.heap[index];
            this.heap[index] = this.heap[parentIndex];
            this.heap[parentIndex] = temp;

            index = parentIndex; // index gets the parent value
            parentIndex = (index - 1) / 2; // parent index becomes one of the children
        }
    }

    public int getMax() {
        int result = this.heap[0]; // maximum item at the 0 index

        this.heap[0] = this.heap[currentPosition--]; // got rid of the root node after we got it
        this.heap[currentPosition + 1] = null; // no root node
        // fix down means we swap the values (root node with the last value)
        fixDown(0, -1);

        return result;
    }

    private void fixDown(int index, int upTo) {
        if(upTo < 0) upTo = currentPosition; // reinitialize upto to the currentPosition index heap

        while(index <= upTo) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if(leftChild <= upTo) {
                int childToSwap;

                if(rightChild > upTo) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                if(heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;

            } else {
                break;
            }
        }
    }

    public void heapSort() {

        for(int i = 0; i <= currentPosition; ++i){

            // swapping the root node
            // with the last item
            int temp = heap[0]; // temp becomes root node
            System.out.print(temp + " "); // print it
            heap[0] = heap[currentPosition - i]; // heap gets the node - i value
            heap[currentPosition - i] = temp; // here temp gets the last (smallest) node value
            fixDown(0, currentPosition - i - 1); // fix heap
        }
    }

    private boolean isFull() {
        return this.currentPosition == this.heap.length;
    }
}
