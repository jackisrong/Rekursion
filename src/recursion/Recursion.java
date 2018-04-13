package recursion;

//import java.util.LinkedList;
public class Recursion {

    // THE FOLLOWING
    // ARE NOT RECURSIVE
    private static LinkedList add(String value, LinkedList list) {
	// Add value to the front of list. If list is null, create a new LinkedList.
	if (list == null || list.getHead() == null) {
	    LinkedList newList = new LinkedList();
	    Node node = new Node(value);
	    newList.setHead(node);
	    return newList;
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
	} else if (first(list).equals(delete)) {
	    return rest(list);
	}

	return append(add(first(list), null), deleteFirst(delete, rest(list)));
    }

    private static LinkedList deleteAll(String delete, LinkedList list) {
	// Returns a list in the same order, but with all occurrences of delete missing.
	// If there is nothing to delete, return the original list.
	if (!isMember(delete, list)) {
	    return list;
	} else if (first(list).equals(delete)) {
	    return deleteFirst(delete, rest(list));
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

	// I THINK DIFFERENCE MEANS ALL THE ELEMENTS IN LIST1 THAT AREN'T IN LIST2 BUT I'M NOT SURE
	if (isNull(list2)) {
	    return list1;
	} else if (isMember(list2.getHead().getValue(), list2)) {
	    list1 = deleteAll(list2.getHead().getValue(), list1);
	}

	return difference(list1, rest(list2));
    }

    private static LinkedList union(LinkedList list1, LinkedList list2) {
	// Returns a list of the union between list1 and list2.

	// I THINK UNION IS BOTH LISTS TOGETHER, EXCEPT DUPLICATES ONLY APPEAR ONCE
	if (isNull(list2)) {
	    return list1;
	} else if (!isMember(list2.getHead().getValue(), list1)) {
	    list1 = add(list2.getHead().getValue(), list1);
	}

	return union(list1, rest(list2));
    }

    private static LinkedList intersect(LinkedList list1, LinkedList list2) {
	// Returns a list of the intersection between list1 and list2.

	// I THINK INTERSECT IS THE MIDDLE PART OF A VEN DIAGRAM
	if (isNull(list2)) {
	    return list1;
	} else if (!isMember(list2.getHead().getValue(), list1)) {
	    // THIS DOESN'T FUCKING WORK, IT SHOULD RETURN 2 AND 4
	}

	return intersect(list1, rest(list2));
    }

    private static boolean subset(LinkedList list1, LinkedList list2) {
	// Returns true if list1 is a subset of list2. Otherwise it returns false.

	// I THINK THIS WOULD CHECK IF ALL ELEMENTS IN LIST1 BELONG TO LIST2
	if (isNull(list1)) {
	    return true;
	} else if (!isMember(list1.getHead().getValue(), list2)) {
	    return false;
	}

	return subset(rest(list1), list2);
    }

    private static boolean equalSets(LinkedList list1, LinkedList list2) {
	// Returns true if list1 and list2 are equal, but not necessarily in the same order.
	// Otherwise it returns false.

	if (isNull(list2)) {
	    return true;
	} else if (!isMember(list2.getHead().getValue(), list1)) {
	    return false;
	    // I'M NOT 100% SURE IF THIS METHOD WORKS YET
	    // ACTUALLY I'M NOT SURE IF ANY OF THE METHODS WORK YET
	}

	return equalSets(list1, rest(list2));
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

	System.out.println("\nTesting difference():");
	printList(difference(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting union():");
	printList(union(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting intersect():");
	printList(intersect(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting subset():");
	System.out.println(subset(add("1", add("2", add("3", null))), add("1", add("2", add("3", add("4", add("5", null)))))));
	System.out.println(subset(add("1", add("2", add("6", null))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting equalSets():");
	System.out.println(equalSets(add("1", add("2", add("3", add("4", add("5", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));
	System.out.println(equalSets(add("1", add("2", add("6", null))), add("1", add("2", add("3", add("4", add("5", null)))))));
    }
}
