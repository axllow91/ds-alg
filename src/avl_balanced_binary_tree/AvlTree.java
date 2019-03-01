package avl_balanced_binary_tree;

public class AvlTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if(node == null)
            return new Node<>(data); // create new node if tree is empty

        // going to the left
        if(data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data)); // setting left node recursively
        } else {
            // going to the right
            node.setRightNode(insert(node.getRightNode(), data));
        }

        // we have to update the height param
        // max((height(l),(height(r))  + 1
        node.setHeight(Math.max(height(node.getLeftNode()), (height(node.getRightNode()))) + 1);

        // check if we need to make some rotation or not
        node = settleViolation(data, node);

        return node;
    }

    private Node<T> settleViolation(T data, Node<T> node) {
        int balance = getBalance(node);

        // doubly left situation
        // left heavy situation
        // Case I
        if(balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0)
            return rightRotation(node);

        // Case II
        // double right situation
        // right-right situation
        else if(balance < -1 && data.compareTo(node.getRightNode().getData()) > 0)
            return leftRotation(node);


        // Case III
        // left-right heavy situation
        if(balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
            // make him a left node
            node.setLeftNode(leftRotation(node.getLeftNode()));

            // move root node to the right
            return rightRotation(node);
        }


        // Cse IV
        // right-left heavy situation
        if(balance < - 1 && data.compareTo(node.getLeftNode().getData()) < 0) {
            // make him go to the right node
            node.setRightNode(rightRotation(node.getRightNode()));

            // move root node to the left
            return leftRotation(node);
        }

        return node;
    }

    @Override
    public void traverse() {
        if(root == null) return;

        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {

        if(node.getLeftNode() != null)
            inOrderTraversal(node.getLeftNode());

        System.out.println(node);

        if(node.getRightNode() != null)
            inOrderTraversal(node.getRightNode());
    }

    public Node<T> rightRotation(Node<T> node) {
        System.out.println("Rotating to the right on node: " + node);

        // This tempLeftNode is going to be the root node
        Node<T> tempLeftNode = node.getLeftNode();
        Node<T> temp = tempLeftNode.getRightNode();
        // this node is the root node of the subtree and we store it to be the right node
        tempLeftNode.setRightNode(node);
        node.setLeftNode(temp); // setting the left child

        // getting the height param
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;
    }

    public Node<T> leftRotation(Node<T> node) {
        System.out.println("Rotating to the left on node: " + node);

        // This tempLeftNode is going to be the root node
        Node<T> tempRightNode = node.getRightNode();
        Node<T> temp = tempRightNode.getRightNode();
        // this node is the root node of the subtree and we store it to be the right node
        tempRightNode.setLeftNode(node);
        node.setRightNode(temp); // setting the left child

        // getting the height param
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }

    private int height(Node<T> node) {
        if(node == null) return -1; // we assign -1 to null pointer, null reference

        return node.getHeight();
    }

    // balance checks either the tree is balanced(>= -1 || <= 1) or unbalanced (< -1 || > 1)
    private int getBalance(Node<T> node) {
        // the difference between left subtree and the right subtree
        if(node == null) return 0;

        // this balance is in the range -1 and 1 it's balance
        // if balance > 1 or < -1 is an unbalanced tree
        return height(node.getLeftNode()) - height(node.getRightNode());
    }


    @Override
    public void delete(T data) {
        if(root != null)
            delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if(node == null) return null; // returning null or node is the same thing

        // first we have to look for the node we want to get rid of
        if(data.compareTo(node.getData()) < 0) { // data is smaller than the given node's data -> go to left recursively
            node.setLeftNode(delete(node.getLeftNode(), data));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRightNode(delete(node.getRightNode(), data)); // data is greater go to right recursively
        } else { // we have found the node we want to remove
            if(node.getLeftNode() == null && node.getRightNode() == null){
                System.out.println("Removing a leaf node...");
                return null;
            }

            // going to remove a right child node knowing the left node is empty
            if(node.getLeftNode() == null) {
                System.out.println("Removing a right child node...");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
                // going to remove a left child node knowing the right node is empty
            } else if(node.getRightNode() == null) {
                System.out.println("Removing a left child node...");
                Node<T> tempNode = node.getLeftNode();
                node = null; // updating reference
                return tempNode;
            }

            // this is the root node
            System.out.println("Removing item with two children...");
            Node<T> tempNode = getPredecessor(node.getLeftNode());

            node.setData(tempNode.getData());
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));

        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);


        // have to check on every delete operation whether the tree has become unbalanced or not !!!
        return settleDeletion(node);
    }

    private Node<T> getPredecessor(Node<T> node) {
        // create predecessor
        Node<T> predecessor = node;

        while(predecessor.getRightNode() != null) {
            predecessor =  predecessor.getRightNode(); // find the maximum value on the right node
        }

        return predecessor;
    }


    private Node<T> settleDeletion(Node<T> node) {

        int balance = getBalance(node);

        // The tree can be heavy but it can be left-right heavy or right-left heavy
        if(balance > 1) {
            // left-right heavy: left rotation on parent + right rotation on the grandparent
            if(getBalance(node.getLeftNode()) < 0) {
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }

            // this is the right rotation on grandparent (if left-left heavy, that's single right rotation is needed)
            return rightRotation(node);
        }

        // we know the tree is right heavy bu it can be left-right heavy or right-right heavy
        if(balance < - 1) {
            // right - left heavy so we need a right rotation( on parent!!!) before rotation
            if(getBalance(node.getRightNode()) > 0) {
                node.setRightNode(rightRotation(node.getRightNode()));
            }

            // left rotation on the grand parent
            return leftRotation(node);
        }

        return node;
    }


}
