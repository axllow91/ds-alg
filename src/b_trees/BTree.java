package b_trees;

public class BTree<Key extends Comparable<Key>, Value> {
    // max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;

    private Node root; // root of the B-Tree
    private int height;  // height of the B-Tree
    private int n; // number of key-value pairs in the B-Tree

    // helper B-Tree node data type
    private static final class Node {

        private int m;    // number of children
        private Entry[] children = new Entry[M];   // the array of children

        private Node(int m) {
            this.m = m;
        }
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value
    private static class Entry {

        private Comparable key;
        private final Object val;
        private Node next; // helper field to iterate over array entries

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // initialize an empty B-Tree
    public BTree() {
        root = new Node(0);
    }

    /**Returns true if this symbol table is empty**/
    public boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return n;
    }

    /**Returns the height of this B-Tree**/
    public int height() {
        return height;
    }

    /**Returns the value associated with the given key**/
    public Value get(Key key) {
        if(key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    private Value search(Node node, Key key, int height) {

        Entry[] children = node.children;

        // external node
        if(height == 0) {
            for(int j = 0; j < node.m; j++) { // iterate through all children inside a node
                if(eq(key, children[j].key))  // if the key is the same
                    return (Value) children[j].val; // return it
            }
        }
        // internal node
        else {
            for(int j = 0; j < node.m; j++) {
                if(j + 1 == node.m || less(key, children[j + 1].key)) // if my key is less than the next children key
                    return search(children[j].next, key, height - 1); // return node, the key and decrease the height
            }
        }
        return null;
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    // comparing function - make comparable instead of key to avoid casts
    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    public void put(Key key, Value val) {
        // if null throw error message
        if(key == null) throw new IllegalArgumentException("argument key to put() is null");

        // create node and insert it
        Node u = insert(root, key, val, height);
        n++; // increase the number of key
        if(u == null) return;

        // Need to split root
        Node t = new Node(2);
        // first value added to the entry node (key, null value, root)
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(root.children[1].key, null, u);
        root = t;
        height++;

    }

    private Node insert(Node node, Key key, Value val, int height) {
        int j;

        Entry t = new Entry(key, val, null);

        //external node
        if(height == 0) {
            for(j = 0; j < node.m; j++) {
                if(less(key, node.children[j].key)) break;
            }
        }

        // internal node
        else {
            for(j = 0; j < node.m; j++) {
                if((j + 1 == node.m) || less(key, node.children[j + 1].key)) {
                    Node u = insert(node.children[j++].next, key, val, height - 1);
                    if(u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for(int i = node.m; i > j; i--)
            node.children[i] = node.children[i - 1];
        node.children[j] = t;
        node.m++;
        if(node.m < M) return null;
        else           return split(node);
    }

    private Node split(Node node) {
        Node t = new Node(M/2);
        node.m = M / 2;
        for(int j = 0; j < M / 2; j++)
            t.children[j] = node.children[M/2+j];
        return t;
    }

    @Override
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node node, int height, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = node.children;

        if(height == 0) {
            for(int j = 0; j < node.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        } else {
            for(int j = 0; j < node.m; j++) {
                if(j > 0) s.append(indent + "(" + children[j].key + ")" + "\n");
                s.append(toString(children[j].next, height - 1, indent));
            }
        }

        return s.toString();
    }
}
