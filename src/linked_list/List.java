package linked_list;

/**Define the operation**/
public interface List<T> {
    void insert(T data);
    void remove(T data);
    void traverseList();
    int size();
}