package recursion;

//import java.util.LinkedList;
public class Recursion {

    // THE FOLLOWING
    // ARE NOT RECURSIVE
    private static LinkedList add(String value, LinkedList list) {
	// Add value to the front of list. If list is null, create a new LinkedList.
	if (list == null) {
	    LinkedList list2 = new LinkedList();
	    Node node = new Node(value);
	    list2.setHead(node);
	    return list2;
	} else {
	    Node head = list.getHead();
	    Node node = new Node(value);
	    list.setHead(node);
	    node.setNext(head);
	}

	return list;
    }

    private static String first(LinkedList list) {
	// Return the first element (String) in list
	if (list.getHead() != null) {
	    return list.getHead().getValue();
	}

	return null;
    }

    private static LinkedList rest(LinkedList list) {
	// Return all the elements except the first in the list
	Node secondNode = list.getHead().getNext();

	if (secondNode != null) {
	    list.setHead(secondNode);
	    return list;
	}

	return null;
    }

    private static boolean isNull(LinkedList list) {
	// Determine if list is null
	return list == null;
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
	if (list.getHead() == null) {
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
	    // Recursively goes through every element looking for item, once you find item, delete it and stop method
	    if (list.getHead().getValue().equals(delete)) {
		System.out.println("hi");
		
		return list;
	    }
	}
	
	return deleteFirst(delete, rest(list));
    }

    private static LinkedList deleteAll(String delete, LinkedList list) {
	// Returns a list in the same order, but with all occurrences of delete missing.
	// If there is nothing to delete, return the original list.

	return null;
    }

    private static LinkedList reverse(LinkedList list) {
	// Returns the reversed version of list.

	return null;
    }

    //THE FOLLOWING MUST BE RECURSIVE, ASSUME THE USER WILL NEVER INPUT A BLANK LIST,
    //THERE'RE NO REPEATED ELEMENTS, AND THE ORDER OF THE RETURNED LIST DOESN'T MATTER.
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
	printList(append(add("Tic", add("Tac", add("Toe", null))), add("Toe", add("Tic", add("Tac", null)))));
	System.out.println();
	printList(deleteFirst("Tac", append(add("Tic", add("Tac", add("Toe", null))), add("Toe", add("Tic", add("Tac", null))))));
    }
}
