package recursion;

//import java.util.LinkedList;
public class Recursion {

    // THE FOLLOWING
    // ARE NOT RECURSIVE
    private static LinkedList add(String value, LinkedList list) {
	// Add value to the front of list. If list is null, create a new LinkedList.
	if (list == null || list.getHead() == null) {
	    LinkedList list2 = new LinkedList();
	    Node node = new Node(value);
	    list2.setHead(node);
	    return list2;
	} else {
	    LinkedList newList = rest(list);
	    String previousHeadValue = list.getHead().getValue();
	    Node newHead = new Node(value);
	    Node previousHead = new Node(previousHeadValue);
	    previousHead.setNext(newList.getHead());
	    newHead.setNext(previousHead);
	    newList.setHead(newHead);
	    return newList;
	}
    }

    private static String first(LinkedList list) {
	// Return the first element (String) in list
	if (!isNull(list)) {
	    return list.getHead().getValue();
	}
	return null;
    }

    private static LinkedList rest(LinkedList list) {
	// Return all the elements except the first in the list
	if (isNull(list)) {
	    return null;
	}

	Node secondNode = list.getHead().getNext();
	LinkedList newLinkedList = new LinkedList();
	
	while (secondNode != null) {
	    if (newLinkedList.getHead() == null) {
		newLinkedList.setHead(new Node(secondNode.getValue()));
	    } else {
		Node currentNode = newLinkedList.getHead();
		while (currentNode.getNext() != null) {
		    currentNode = currentNode.getNext();
		}
		currentNode.setNext(new Node(secondNode.getValue()));
	    }
	    secondNode = secondNode.getNext();
	}

	return newLinkedList;
    }

    private static boolean isNull(LinkedList list) {
	// Determine if list is null
	return list == null || list.getHead() == null;
    }

    private static boolean isEqual(String s1, String s2) {
	// Determine if two Strings are equal
	return s1.equals(s2);
    }

    private static void printList(LinkedList list) {
	// Print each item in list on a new line
	Node after = list.getHead();

	while (after != null) {
	    System.out.println(after.getValue());
	    after = after.getNext();
	}
    }

    private static LinkedList append(LinkedList list1, LinkedList list2) {
	if (isNull(list1)) {
	    return list2;
	} else {
	    return add(first(list1), append(rest(list1), list2));
	}
    }

    // THE FOLLOWING
    // MUST BE RECURSIVE
    private static boolean isMember(String member, LinkedList list) {
	// Returns true if member is an item in the list.
	if (isNull(list)) {
	    return false;
	} else if (isEqual(member, first(list))) {
	    return true;
	}

	return isMember(member, rest(list));
    }

    private static LinkedList deleteFirst(String delete, LinkedList list) {
	// Returns a list in the same order, but with delete missing.
	// If there is nothing to delete, return the original list.
	if (!isMember(delete, list)) {
	    return list;
	} else {
	    if (first(list).equals(delete)) {
		return rest(list);
	    }
	}

	return append(add(first(list), null), deleteFirst(delete, rest(list)));
    }

    private static LinkedList deleteAll(String delete, LinkedList list) {
	// Returns a list in the same order, but with all occurrences of delete missing.
	// If there is nothing to delete, return the original list.
	if (!isMember(delete, list)) {
	    return list;
	} else {
	    if (first(list).equals(delete)) {
		return deleteFirst(delete, rest(list));
	    }
	}

	return append(add(first(list), null), deleteAll(delete, rest(list)));
    }

    private static LinkedList reverse(LinkedList list) {
	// Returns the reversed version of list.
	if (isNull(list)) {
	    return list;
	} else if (list.getHead().getNext() == null) {
	    return list;
	}

	return append(reverse(rest(list)), add(first(list), null));
    }

    // THE FOLLOWING MUST BE RECURSIVE, ASSUME THE USER WILL NEVER INPUT A BLANK LIST,
    // THERE'RE NO REPEATED ELEMENTS, AND THE ORDER OF THE RETURNED LIST DOESN'T MATTER.
    private static LinkedList difference(LinkedList list1, LinkedList list2) {
	// Returns a list of the difference between list1 and list2

	return null;
    }

    private static LinkedList union(LinkedList list1, LinkedList list2) {
	// Returns a list of the union between list1 and list2.

	return null;
    }

    private static LinkedList intersect(LinkedList list1, LinkedList list2) {
	// Returns a list of the intersection between list1 and list2.

	return null;
    }

    private static boolean subset(LinkedList list1, LinkedList list2) {
	// Returns true if list1 is a subset of list2. Otherwise it returns false.

	return true;
    }

    private static boolean equalSets(LinkedList list1, LinkedList list2) {
	// Returns true if list1 and list2 are equal, but not necessarily in the same order.
	// Otherwise it returns false.

	return true;
    }

    public static void main(String[] args) {
	System.out.println("Testing append():");
	printList(append(add("Tic", add("Tac", add("Toe", null))), add("Toe", add("Tic", add("Tac", null)))));

	System.out.println("\nTesting deleteFirst() with LinkedList with multiple Toe occurences:");
	printList(deleteFirst("Toe", append(add("Tic", add("Tac", add("Toe", null))), add("Toe", add("Tic", add("Tac", null))))));

	System.out.println("\nTesting deleteFirst() with LinkedList with single Toe occurences:");
	printList(deleteFirst("Toe", add("Tic", add("Tac", add("Toe", null)))));

	System.out.println("\nTesting deleteAll() with LinkedList with multiple Tic occurences:");
	printList(deleteAll("Tic", append(add("Tic", add("Tac", add("Toe", null))), add("Toe", add("Tic", add("Tac", null))))));

	System.out.println("\nTesting deleteAll() with LinkedList with single Tic occurences:");
	printList(deleteAll("Tic", add("Tic", add("Tac", add("Toe", null)))));

	System.out.println("\nTesting reverse():");
	printList(reverse(add("Tic", add("Tac", add("Toe", null)))));
    }
}
