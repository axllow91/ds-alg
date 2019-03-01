package avl_balanced_binary_tree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> avl = new AvlTree<>();

        // testing all 4 cases

        // hard - right
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(14);

        avl.delete(5);

        avl.traverse();

        /**Using **/

    }
}
