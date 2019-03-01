package splay_tree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> s = new SplayTree<>();

        s.insert(10);
        s.insert(0);
        s.insert(1);
        s.insert(20);
        s.insert(30);

        s.inOrderTraversal();

        // O(1)
        System.out.print("Root node is: ");
        ((SplayTree<Integer>) s).printRoot(); // casting it because is not a part of the tree (we can add it to the interface)
        System.out.println("Max: " + s.getMax());
        System.out.println("Min: " + s.getMin());

        System.out.println("Is SplayTree empty ? " + s.isEmpty());

        System.out.print("Printing the tree in order traversal: ");
        s.inOrderTraversal();

        System.out.println();
        s.find(0);


    }
}
