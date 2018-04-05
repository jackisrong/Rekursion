package recursion;

public class DLLNode {

    public String value;
    public DLLNode previous;
    public DLLNode next;

    public DLLNode(String value) {
	this.value = value;
	this.previous = null;
	this.next = null;
    }

    public String getValue() {
	return value;
    }
    
    public DLLNode getPrevious() {
	return previous;
    }

    public void setPrevious(DLLNode node) {
	previous = node;
    }
    
    public DLLNode getNext() {
	return next;
    }
    
    public void setNext(DLLNode node) {
	next = node;
    }
}
