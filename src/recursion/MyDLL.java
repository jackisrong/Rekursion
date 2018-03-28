package recursion;

public class MyDLL {

    private DLLNode head;
    private DLLNode before;
    private DLLNode after;
    private DLLNode tail;
    
    public MyDLL(DLLNode head, DLLNode before, DLLNode after, DLLNode tail) {
	this.head = head;
	this.before = before;
	this.after = after;
	this.tail = tail;
    }
    
    public void addNode(Integer value) {
	// Inserts node to the end of the linked list
    }

    public void deleteNode(Integer value) {
	// Deletes all nodes with the given value
    }

    public void sort() {
	// Sorts the linked list in ascending order
    }

    public void reverse() {
	// Reverse the nodes in the linked list.
    }

    public void duplicate() {
	// Removes all duplicate nodes in the linked list
    }

    public void alternate(MyDLL list) {
	// Merges the contents of list and this class in alternating order class = 1 2 3,
	// list = 4 4 4  alternate = 1 4 2 4 3 4
    }

    public void optiFind(Integer value) {
	// Searches for value and places it at the front of the doubly linked list
    }

    public void middleAdd(Integer value) {
	// Places the new node in the middle of the list
    }

    public void printList() {
	// Prints the contents of the linked list
    }
}
