package recursion;

public class DLLNode {
    public String value;
    public Node previous;
    public Node next;
    
    public DLLNode(String value) {
	this.value = value;
	this.previous = null;
	this.next = null;
    }
}
