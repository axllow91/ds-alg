package stacks.stack_with_array;

public class Stack<T> {

    private T[] stack;
    private int numbOfItems;

    public Stack() {
        this.stack = (T[]) new Object[1]; // java doesnt support generic arrays
    }

    public void push(T newData) {
        // if stack is full while trying to add element
        // then double the size of the stack
        if (numbOfItems == this.stack.length) {
            resize(2 * this.stack.length);
        }

        this.stack[numbOfItems++] = newData; // if it's not full
    }

    private void resize(int capacity) {
        T[] stackCopy = (T[]) new Object[capacity];

        for (int i = 0; i < numbOfItems; i++)
            stackCopy[i] = this.stack[i]; // copy elem from old stack to new stack

        this.stack = stackCopy;
    }

    public T pop() {
        T itemToPop = this.stack[--numbOfItems];

        if(numbOfItems > 0 && numbOfItems == this.stack.length / 4) {
            resize(this.stack.length / 2); // resize to half of the stack
        }

        return itemToPop;
    }

    public boolean isEmpty() {
        return this.numbOfItems == 0;
    }

    public int size() {
        return this.numbOfItems;
    }


}
