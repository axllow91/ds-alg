package bst_binary_search_tree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(30);
        bst.insert(40);
        bst.insert(5);
        bst.insert(1);

        System.out.println("Min: " + bst.getMinValue());
        System.out.println("Max: " + bst.getMaxValue());

        bst.traversal();

        bst.delete(10);

        System.out.println("\nBST after removing element: ");
        bst.traversal();

        System.out.println("\nBinary Search tree String: ");
        BinarySearchTree<String> bsts = new BinarySearchTree<>();
        bsts.insert("Daniel");
        bsts.insert("Suka");
        bsts.insert("Navai");
        bsts.insert("Davai");

        bsts.traversal();
    }
}
