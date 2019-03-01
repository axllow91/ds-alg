package splay_tree;

public interface Tree<T extends Comparable<T>> {
    void insert(T data);
    Node<T> find(T data);
    T getMin();
    T getMax();
    boolean isEmpty();
    void inOrderTraversal();
}
