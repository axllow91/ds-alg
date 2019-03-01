package red_black_tree;

public class App {
    public static void main(String[] args) {
        RedBlackTree<Integer> rdb = new RedBlackTree<>();

        // right right heavy
        // rdb.insert(10);
        // rdb.insert(20);
        // rdb.insert(30);

        rdb.insert(10);
        rdb.insert(15);
        rdb.insert(13);


        rdb.traverse();


    }
}
