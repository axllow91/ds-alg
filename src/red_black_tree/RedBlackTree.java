package red_black_tree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    @Override
    public void insert(T data) {
        Node<T> node = new Node<>(data);

        root = insert(root, node);

        fixViolation(node);
    }

    private Node<T> insert(Node<T> root, Node<T> node) {

        // if empty
        if (root == null) return node;

        // if is smaller than the root node data get me on the left sub tree
        if (node.getData().compareTo(root.getData()) < 0) {
            // set the new inserted node into the left node
            root.setLeftChild(insert(root.getLeftChild(), node));
            root.getLeftChild().setParent(root);
        } else if (node.getData().compareTo(root.getData()) > 0) {
            // visit the right sub tree in the recursively method
            root.setRightChild(insert(root.getRightChild(), node));
            root.getRightChild().setParent(root);
        }

        return root;
    }

    // check for violation of rb trees
    private void fixViolation(Node<T> node) {

        Node<T> parentNode;
        Node<T> grandParentNode;

        // if is not the root and has the red color
        while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {

            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();

            if (parentNode == grandParentNode.getLeftChild()) {

                Node<T> uncle = grandParentNode.getRightChild();

                // given node x's parent is a left child + uncle is red --> only recoloring
                if (uncle != null && uncle.getColor() == NodeColor.RED) { // case 1 & case 4
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {

                    if (node == parentNode.getRightChild()) { // case 2: uncle is black right child is red
                        leftRotation(parentNode);
                        node = parentNode; // update reference
                        parentNode = node.getParent();
                    }

                    rightRotation(grandParentNode);   // -> case 3: uncle has a black color
                    NodeColor tempColor = parentNode.getColor();  // swapping colors
                    parentNode.setColor(grandParentNode.getColor()); // parent gets the grandparent color
                    grandParentNode.setColor(tempColor); // grandparent getting the parent color
                    node = parentNode; // node becomes the parent
                }
            } else { // uncle is the left child and has the red color

                Node<T> uncle = grandParentNode.getLeftChild();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {

                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;

                } else {

                    // case 2:  // left child of a right child
                    if (node == parentNode.getLeftChild()) { // node inserted is a left child
                        rightRotation(parentNode);
                        node = parentNode;  // node becomes the parent
                        parentNode = node.getParent(); // parent becomes the grandchild
                    }

                    leftRotation(grandParentNode); // case 3: right child of a right child
                    System.out.println("Recoloring " + parentNode +  " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }

        if(root.getColor() == NodeColor.RED)
            System.out.println("Recoloring the root " + root + " to black...");
            root.setColor(NodeColor.BLACK); // root node must be black
    }


    private void rightRotation(Node<T> node) {

        System.out.println("Rotating to the right on node " + node);

        Node<T> tempLeftNode = node.getLeftChild();
        node.setLeftChild(tempLeftNode.getRightChild());

        if (node.getLeftChild() != null)
            node.getLeftChild().setParent(node);

        tempLeftNode.setParent(node.getParent());

        // means that is the root node
        if (tempLeftNode.getParent() == null)
            root = tempLeftNode;
        else if (node == node.getParent().getLeftChild())
            node.getParent().setLeftChild(tempLeftNode);
        else
            node.getParent().setRightChild(tempLeftNode);

        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);

    }

    private void leftRotation(Node<T> node) {

        System.out.println("Rotating to the left on node " + node);

        Node<T> tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());

        if (node.getRightChild() != null)
            node.getRightChild().setParent(node);

        tempRightNode.setParent(node.getParent());

        // means that is the root node
        if (tempRightNode.getParent() == null)
            root = tempRightNode;
        else if (node == node.getParent().getRightChild())
            node.getParent().setRightChild(tempRightNode);
        else
            node.getParent().setLeftChild(tempRightNode);

        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);
    }

    @Override
    public void traverse() {
        if (root != null)
            inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        // in order traversal we traverse the left subtree first
        // then the right subtree then the root node
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild()); // recursively going on the left subtree
        }

        System.out.println(node + " with color " + node.getColor()
                                + " LeftNode: " + node.getLeftChild()
                                + " - RightChild " + node.getRightChild());

        // going on the right subtree
        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild()); // recursively going on the right subtree
        }
    }
}
