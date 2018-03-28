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
}
