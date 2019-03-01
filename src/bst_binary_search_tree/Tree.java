package bst_binary_search_tree;

public interface Tree<T> {
    void traversal();
    void insert(T data);
    void delete(T data);
    T getMaxValue();
    T getMinValue();
}
