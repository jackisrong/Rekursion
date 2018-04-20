package recursion;

public class MyDLL {

    private DLLNode head;
    private DLLNode tail;

    public MyDLL() {
	head = null;
	tail = null;
    }

    public void addNode(Integer value) {
	// Inserts node to the end of the linked list
	DLLNode node = new DLLNode(value);

	if (head == null) {
	    head = node;
	    tail = node;
	} else {
	    tail.setNext(node);
	    node.setPrevious(tail);
	    tail = node;
	}
    }

    public void deleteNode(Integer value) {
	// Deletes all nodes with the given value
	DLLNode listHead = head;

	while (listHead != null) {
	    if (listHead.getValue().equals(value)) {
		try {
		    listHead.getPrevious().setNext(listHead.getNext());
		} catch (NullPointerException e) {
		    head = listHead;
		}

		if (listHead.getNext() != null) {
		    listHead.getNext().setPrevious(listHead.getPrevious());
		} else {
		    tail = listHead.getPrevious();
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

	while (listTail != null) {
	    addNode(listTail.getValue());
	    listTail = listTail.getPrevious();
	}
    }

    public void duplicate() {
	// Removes all duplicate nodes in the linked list
	DLLNode referenceNode = head;

	while (referenceNode != null) {
	    int occurence = 0;
	    DLLNode before = null;
	    DLLNode node = head;
	    DLLNode after = head.getNext();
	    while (node != null) {
		if (node.getValue().equals(referenceNode.getValue())) {
		    occurence++;
		}

		if (occurence > 1) {
		    if (before == null) {
			head = after;
		    } else if (after == null) {
			before.setNext(null);
			tail = before;
		    } else {
			after.setPrevious(before);
			before.setNext(after);
		    }
		}

		if (before == null) {
		    before = head;
		} else {
		    before = before.getNext();
		}
		node = node.getNext();
		if (after == null) {
		    break;
		} else {
		    after = after.getNext();
		}
	    }
	    referenceNode = referenceNode.getNext();
	}
    }

    public void alternate(MyDLL list) {
	// Merges the contents of list and this class in alternating order class = 1 2 3,
	// list = 4 4 4 -> alternate = 1 4 2 4 3 4
	MyDLL newList = new MyDLL();
	DLLNode classHead = head;
	DLLNode listHead = list.head;

	while (classHead != null || listHead != null) {
	    // Accounts for different sized lists (in theory)
	    if (classHead != null) {
		newList.addNode(classHead.getValue());
		classHead = classHead.getNext();
	    }

	    if (listHead != null) {
		newList.addNode(listHead.getValue());
		listHead = listHead.getNext();
	    }
	}

	head = newList.head;
	tail = newList.tail;
    }

    public void optiFind(Integer value) {
	// Searches for value and places it at the front of the doubly linked list
	DLLNode before = null;
	DLLNode node = head;
	DLLNode after;
	try {
	    after = head.getNext();
	} catch (NullPointerException e) {
	    after = null;
	}

	while (node != null) {
	    DLLNode listHead = head;
	    if (node.getValue().equals(value)) {
		if (before == null) {
		    // Do nothing
		} else if (after == null) {
		    tail = before;
		    // Move node to front of the list
		    head = node;
		    node.setNext(listHead);
		    node.setPrevious(null);
		    listHead.setPrevious(node);
		    before.setNext(null);
		} else {
		    before.setNext(after);
		    after.setPrevious(before);
		    // Move node to front of the list
		    head = node;
		    node.setNext(listHead);
		    node.setPrevious(null);
		    listHead.setPrevious(node);
		}
		break;
	    }

	    if (before == null) {
		before = head;
	    } else {
		before = before.getNext();
	    }
	    node = node.getNext();
	    if (after == null) {
		break;
	    } else {
		after = after.getNext();
	    }
	}
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
	int insertIndex = Math.round(listLength / 2) - 1;
	int higherLimit = listLength - 1;

	if (listLength == 1) {
	    higherLimit = 1;
	    insertIndex = 0;
	}

	for (int i = 0; i < higherLimit; i++) {
	    if (i == insertIndex) {
		DLLNode node = new DLLNode(value);
		if (listLength == 1) {
		    head = node;
		    node.setNext(before);
		    before.setPrevious(node);
		    break;
		}
		node.setPrevious(before);
		before.setNext(node);
		node.setNext(after);
		after.setPrevious(node);
		break;
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
