package JavaCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListImplementsListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Creating a LinkedList
        LinkedList<String> list = new LinkedList<>();
        int size;
        // 2. Adding elements to the LinkedList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Date"); // Adding at a specific position

        // 3. Accessing elements
        String firstElement = list.getFirst(); // Retrieves the first element
        String lastElement = list.getLast(); // Retrieves the last element
        String elementAtIndex = list.get(2); // Retrieves the element at index 2
        System.out.println("********values in linkedList*********");
        System.out.println(list);

        // 4. Removing elements
        list.removeFirst(); // Removes the first element
        list.removeLast(); // Removes the last element
        list.remove(1); // Removes the element at index 1
        list.remove("Banana"); // Removes the first occurrence of "Banana"
        System.out.println("********values in linkedList and size of list*********");
        System.out.println(list);
        size = list.size();
        System.out.println("*****Size of LinkedList: " + size);

        // 5. Adding elements to the beginning and end
        list.addFirst("Elderberry"); // Adds to the beginning
        list.addLast("Fig"); // Adds to the end
        System.out.println("********values in linkedList*********");
        System.out.println(list);

        // 6. Checking if the list contains an element
        boolean containsApple = list.contains("Apple");

        // 7. Size of the LinkedList
        size = list.size();

        // 8. Iterating over elements
        System.out.println("******Iterating using iterator:******");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("******Iterating using for-each loop:*******");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 9. Clearing the LinkedList
        list.clear();

        // 10. Checking if the LinkedList is empty
        boolean isEmpty = list.isEmpty();

        // Output results
        System.out.println("******Output results:*******");
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at Index 2: " + elementAtIndex);
        System.out.println("Contains Apple: " + containsApple);
        System.out.println("Size of LinkedList: " + size);
        System.out.println("Is LinkedList Empty: " + isEmpty);
	}

}
