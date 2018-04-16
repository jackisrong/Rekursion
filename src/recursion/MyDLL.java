package recursion;

public class MyDLL {

    private DLLNode head;
    private DLLNode tail;

    public MyDLL() {
	this.head = null;
	this.tail = null;
    }

    public void addNode(Integer value) {
	// Inserts node to the end of the linked list
	DLLNode node = new DLLNode(value);
	if (head == null) {
	    head = node;
	    tail = node;
	} else {
	    this.tail.setNext(node);
	    node.setPrevious(this.tail);
	    this.tail = node;
	}
    }

    public void deleteNode(Integer value) {
	// Deletes all nodes with the given value
	DLLNode listHead = head;
	while (listHead != null) {
	    if (listHead.getValue().equals(value)) {
		listHead.getPrevious().setNext(listHead.getNext());
		//NULLPOINTER OCCURS WHEN LIST.GETNEXT() IS NULL AT END OF LIST
		if (listHead.getNext() != null) {
		    listHead.getNext().setPrevious(listHead.getPrevious());
		}
	    }
	    listHead = listHead.getNext();
	}
    }

    public void sort() {
	// Sorts the linked list in ascending order
	if (head != null) {
	    DLLNode swapNode = head;
	    while (swapNode != null) {
		DLLNode current = swapNode;
		int smallest = swapNode.getValue();
		DLLNode smallestNode = swapNode;
		while (current != null) {
		    if (current.getValue() < smallest) {
			smallest = current.getValue();
			smallestNode = current;
		    }
		    current = current.getNext();
		}
		smallestNode.value = swapNode.getValue();
		swapNode.value = smallest;
		swapNode = swapNode.getNext();
	    }
	}
    }

    public void reverse() {
	// Reverse the nodes in the linked list.
	DLLNode listTail = tail;
	head = null;
	
	// 55 WAS DELETED
	// BUT IT'S MAGICALLY BACK AGAIN
	// FIX THIS MAN
	while (listTail != null) {
	    addNode(listTail.getValue());
	    listTail = listTail.getPrevious();
	}
    }

    public void duplicate() {
	// Removes all duplicate nodes in the linked list
    }

    public void alternate(MyDLL list) {
	// Merges the contents of list and this class in alternating order class = 1 2 3,
	// list = 4 4 4 -> alternate = 1 4 2 4 3 4
	DLLNode classHead = this.head;
	DLLNode listHead = list.head;
	head = null;

	// IF THE SETS ARE DIFFERENT SIZES
	// THIS DOESN'T PRINT SOME OF THEM
	while (classHead != null && listHead != null) {
	    addNode(classHead.getValue());
	    addNode(listHead.getValue());
	    classHead = classHead.getNext();
	    listHead = listHead.getNext();
	}
    }

    public void optiFind(Integer value) {
	// Searches for value and places it at the front of the doubly linked list
    }

    public void middleAdd(Integer value) {
	// Places the new node in the middle of the list
	int listLength = 0;
	DLLNode listHead = head;

	while (listHead != null) {
	    listLength++;
	    listHead = listHead.getNext();
	}

	DLLNode before = head;
	DLLNode after = head.getNext();
	for (int i = 0; i < listLength - 1; i++) {
	    if (i == Math.round(listLength / 2) - 1) {
		DLLNode node = new DLLNode(value);
		node.setPrevious(before);
		before.setNext(node);
		node.setNext(after);
		after.setPrevious(node);
	    }
	    before = before.getNext();
	    after = after.getNext();
	}
    }

    public void printList() {
	// Prints the contents of the linked list
	DLLNode after = head;

	while (after != null) {
	    System.out.println(after.getValue());
	    after = after.getNext();
	}
    }
}
