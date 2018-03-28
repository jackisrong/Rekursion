package recursion;

import java.util.LinkedList;

public class Recursion {

    // THE FOLLOWING
    // ARE NOT RECURSIVE
    private static LinkedList add(String value, LinkedList list) {
	// Add value to the front of list. If list is null, create a new LinkedList.

	return null;
    }

    private static String first(LinkedList list) {
	// Return the first element (String) in list

	return null;
    }

    private static LinkedList rest(LinkedList list) {
	// Return all the elements except the first in the list

	return null;
    }

    private static boolean isNull(LinkedList list) {
	// Determine if list is null

	return true;
    }

    private static boolean isEqual(String s1, String s2) {
	// Determine if two Strings are equal

	return true;
    }

    private static void printList(LinkedList list) {
	// Print each item in list on a new line
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

	return true;
    }

    private static LinkedList deleteFirst(String delete, LinkedList list) {
	// Returns a list in the same order, but with delete missing.
	//If there is nothing to delete, return the original list.

	return null;
    }

    private static LinkedList deleteAll(String delete, LinkedList list) {
	// Returns a list in the same order, but with all occurrences of delete missing.
	//If there is nothing to delete, return the original list.

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
    }
}
