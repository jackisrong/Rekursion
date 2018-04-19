package recursion;

public class DLLNode {

    public Integer value;
    public DLLNode previous;
    public DLLNode next;

    public DLLNode(Integer value) {
		this.value = value;
		this.previous = null;
		this.next = null;
    }

    public Integer getValue() {
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
