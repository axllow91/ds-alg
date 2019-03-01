package avl_balanced_binary_tree;

public interface Tree<T> {
    void insert(T data);
    void traverse(); // in-order traversal
    void delete(T delete);
}
