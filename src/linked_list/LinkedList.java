package linked_list;

/**We are extending comparable because we need to compare those items**/
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++sizeOfList;
        if(this.root == null) {
            this.root = new Node<>(data);
        } else {
            insertAtBeginning(data);
        }
    }

    // O(1)
    private void insertAtBeginning(T data) {
        // create new node to add at the beginning
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode; // update references
    }

    // O(N)
    private void insertAtTheEnd(T data, Node<T> node) {
        if(node.getNextNode() != null) { // not at the end
            insertAtTheEnd(data, node.getNextNode()); // recursively get me at the end of the list
        } else {
            Node<T> newNode = new Node<>(data); // create new Node
            node.setNextNode(newNode); // update reference
        }
    }

    @Override
    public void remove(T data) {
        if(this.root == null) return;
        --sizeOfList;

        // check to see if values are equal
        if(this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
        if(actualNode != null) {
            if(actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
            }
        }
        previousNode = actualNode;
        actualNode = actualNode.getNextNode();
    }

    @Override
    public void traverseList() {
        if(this.root == null) return;

        Node<T> actualNode = this.root;
        while(actualNode != null) {
            System.out.print(actualNode + " -> ");
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return sizeOfList;
    }
}