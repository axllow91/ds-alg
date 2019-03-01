package bst_binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    public void insert(T data) {
        if(root == null)
            root = new Node<>(data);
        else
            insertNode(data, root); // recursively add new data
    }

    public T getMinValue() {
        if(root == null) return null; // binary search tree is empty

        return getMin(root);
    }

    public T getMaxValue() {
        if(root == null) return null;

        return getMax(root);
    }

    @Override
    public void traversal() {
        if(root != null)
            inOrderTraversal(root);
        System.out.println();
    }

    // starting from the left node->root->right node and so on
    private void inOrderTraversal(Node<T> node) {

        // visit left child
        if(node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild()); // recursively

        // this node can be the root node for the subtree (not the whole node)
        System.out.print(node + " -> ");

        // visit right child
        if(node.getRightChild() != null)
            inOrderTraversal(node.getRightChild()); // recursively

    }

    private void insertNode(T newData, Node<T> node) {
        // check where you'll place this value
        // if smaller got to the left / else to the right
        if(newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild()); // insert data into the left child
            } else {   // if left child is null then create a new node and set it to be the left child
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {  // in case the value is greater than the root node
            if(node.getRightChild() != null) { // if is not null add data recursively to the right child
                insertNode(newData, node.getRightChild());
            } else { //
                Node<T> newNode = new Node<>(newData); // create new node
                node.setRightChild(newNode); // set it to be the right child
            }
        }
    }

    @Override
    public void delete(T data) {
        if(root != null)
            root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {

        if(node == null) return null;

        // consider the left sub tree
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftChild((delete(node.getLeftChild(), data))); // set to delete the left child
        } else if(data.compareTo(node.getData()) > 0){
            // consider the right sub tree
            node.setRightChild((delete(node.getRightChild(), data))); // set to delete the right child
        } else {
            // we have found a node that we want to remove
            // checking if this is a leaf node
            if(node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            // has only a right child
            if(node.getLeftChild() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
                // has only a left child
            } else if(node.getRightChild() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // this is the node with 2 child case!
            System.out.println("Removing item with 2 children");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData()); // swapping the 2 nodes
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
        }

        return node;

    }

    //
    private Node<T> getPredecessor(Node<T> node) {
        // choosing right because the greatest item is in the right sub tree
        if(node.getRightChild() != null)
            return getPredecessor(node.getRightChild()); // call it

        System.out.println("predecessor: " + node);
        return node;
    }


    private T getMax(Node<T> node) {

        if(node.getRightChild() != null)
            return getMax(node.getRightChild()); // recursively keep going on the right child

        return node.getData();
    }

    private T getMin(Node<T> node) {
        if(node.getLeftChild() != null) {
            return getMin(node.getLeftChild()); // keep going on the left child recursively
        }

        return node.getData();
    }
}
