package recursion;

public class LinkedList {
    private Node head;
    private Node before;
    private Node after;

    // MyLinkedList Constructor
    public LinkedList() {
	this.head = null;
	this.before = null;
	this.after = null;
    }

    public Node getHead() {
	return head;
    }
    
    public void setHead(Node head) {
	this.head = head;
    }
    
    /*
    // This method finds the proper place for the new node to be inserted
    // At the end of the method call, before points to the node that will be before 
    // the new node and after points to the node ahead of the new node
    public void search(int value) {
	after = head;
	before = null;

	while (after != null) {
	    if (value > after.getValue()) {
		before = after;
		after = after.getNext();
	    } else {
		break;
	    }
	}
    }
    */

    // This method adds new nodes to the linked list
    public void add(Node node) {
	//search(node.getValue());

	if (after == null) {
	    if (before == null) {
		head = node;
		node.setNext(after);
	    } else {
		node.setNext(null);
		before.setNext(node);
	    }
	} else {
	    if (before == null) {
		node.setNext(after);
		head = node;
	    } else {
		node.setNext(after);
		before.setNext(node);
	    }
	}
    }

    public void remove(Node node) {
	Node current = head;
	before = null;

	while (current != null) {
	    if (node.getValue() != current.getValue()) {
		before = current;
		current = current.getNext();
	    } else {
		break;
	    }
	}

	if (current == null) {
	    System.out.println("Node not found.");
	    return;
	}

	if (before == null) {
	    head = current.getNext();
	} else {
	    before.setNext(current.getNext());
	}
    }

    // This method prints the contents of the linked list
    public void display() {
	
    }
}
