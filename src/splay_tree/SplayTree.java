package splay_tree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private int size;
    private Node<T> rootNode;

    @Override
    public void insert(T data) {

        Node<T> tempNode = this.rootNode;
        Node<T> parentNode = null;

        while(tempNode != null) {

            parentNode = tempNode;

            // go on the left sub tree < rootNode node
            if(tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightNode();
            } else {
                tempNode = tempNode.getLeftNode();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParentNode(parentNode);

        if(parentNode == null) {
            this.rootNode = tempNode;
        } else if(parentNode.getData().compareTo(tempNode.getData()) < 0) {
            parentNode.setRightNode(tempNode);
        } else {
            parentNode.setLeftNode(tempNode);
        }

        splay(tempNode);
        this.size++;

    }

    private void splay(Node<T> node) {

        while(node.getParentNode() != null) {

            /**Zig situation
             * For zig situation we need to make the zig-zag and zig-zig operation over and over again
             * until we are at the top
             * **/
            if(node.getParentNode().getParentNode() == null) { // node is a left child + grandparent is null
                if(node.getParentNode().getLeftNode() == node) {
                    rotateRight(node.getParentNode()); // here node becomes the rootNode after right rotation
                } else { // node is a right child + grandparent is null
                    rotateLeft(node.getParentNode()); // here node becomes the rootNode after left rotation
                }
                /**Zig-Zig situation
                 * node is a left child and the parent is a left child of the grand parent
                 * **/
            } else if(node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()) {
                rotateRight(node.getParentNode().getParentNode()); // right rotation on grandparent makes him a right child
                rotateRight(node.getParentNode()); // rotation on parent makes him the rootNode node
                /**node is a right child and the parent is a right child of the grand parent**/
            } else if(node.getParentNode().getRightNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
                rotateLeft(node.getParentNode().getParentNode()); // left rotation on the grandparent means he is a left child
                rotateLeft(node.getParentNode()); // left rotation on the parent makes him rootNode node

                /** Zig-Zag
                 *  node is a left child and the parent is a right child of grandparent
                 * **/
            } else if(node.getParentNode().getLeftNode() == node
                    && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()) {
                rotateRight(node.getParentNode()); //
                rotateLeft(node.getParentNode());
                /**
                 * here is the other way around (node is right child, parent left child)
                 * **/
            } else {
                rotateLeft(node.getParentNode());
                rotateRight(node.getParentNode());
            }
        }
    }

    private void rotateLeft(Node<T> node) {

        System.out.println("Rotating of the left on node " + node);

        Node<T> tempNode = node.getRightNode();

        if(tempNode != null) {
            node.setRightNode(tempNode.getLeftNode());

            if(tempNode.getLeftNode() != null) {
                tempNode.getLeftNode().setParentNode(node);
            }

            tempNode.setParentNode(node.getParentNode());
        }

        if(node.getParentNode() == null) {
            this.rootNode = tempNode;
        } else if(node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempNode);
        } else {
            node.getParentNode().setRightNode(tempNode);
        }

        if(tempNode != null) {
            tempNode.setLeftNode(node);
        }

        node.setParentNode(tempNode);
    }

    private void rotateRight(Node<T> node) {
        System.out.println("Rotating on the right on node " + node);

        Node<T> tempNode = node.getLeftNode();

        if(tempNode != null) {
            node.setLeftNode(tempNode.getRightNode());

            if(tempNode.getRightNode() != null) {
                tempNode.getRightNode().setParentNode(node);
            }

            tempNode.setParentNode(node.getParentNode());
        }

        if(node.getParentNode() == null) {
            this.rootNode = tempNode;
        } else if(node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempNode);
        } else {
            node.getParentNode().setRightNode(tempNode);
        }

        if(tempNode != null) {
            tempNode.setRightNode(node);
        }

        node.setParentNode(tempNode);
    }

    @Override
    public Node<T> find(T data) {

        Node<T> tempNode = this.rootNode;

        while(tempNode != null) {
            if(tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightNode();
            } else if(tempNode.getData().compareTo(data) > 0) {
                tempNode = tempNode.getLeftNode();
            } else {
                splay(tempNode);
                return tempNode;
            }
        }
        splay(tempNode);

        return null;
    }

    @Override
    public void inOrderTraversal() {
        if (this.rootNode != null) {
            inOrderTraversal(rootNode);
        }
    }

    private void inOrderTraversal(Node<T> node) {

        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }

        System.out.print(node + " ");

        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }

    @Override
    public T getMin() {
        if(this.rootNode != null)
            return getMin(rootNode);

        return null;
    }

    private T getMin(Node<T> node) {
        if(node.getLeftNode() != null) { // if we are at the left subtree
            return getMin(node.getLeftNode()); // go at low as possible to find the minimum data
        } else {
            return node.getData(); // return data if we are at the end of the left subtree
        }
    }

    @Override
    public T getMax() {
        if(this.rootNode != null)
            return getMax(rootNode);

        return null; // return null if empty
    }

    private T getMax(Node<T> node) {
        if(node.getRightNode() != null) {
            return  getMax(node.getRightNode()); // go to the end of the right node (there is the maximum value)
        } else {
            return node.getData(); // return node data if you are at the end
        }
    }

    public void printRoot() {
        System.out.println(rootNode);
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    public int size() {
        return this.size;
    }
}