package JavaCollections;

import java.util.HashSet;
import java.util.Set;

public class HashSetImplementsSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Initialization
        HashSet<String> set = new HashSet<>();
        //Set<String> set1 = new HashSet<>();

        // 2. Add elements
        set.add("Alice");
        set.add("Bob");
        set.add("Charlie");

        // 3. Remove an element
        set.remove("Bob");
        System.out.println("After removing Bob: " + set);

        // 4. Check if an element exists
        System.out.println("Is Alice in the set? " + set.contains("Alice"));

        // 5. Get size of the set
        System.out.println("Size of the set: " + set.size());

        // 6. Check if the set is empty
        System.out.println("Is the set empty? " + set.isEmpty());

        // 7. Iterate over elements
        System.out.println("Elements in the set:");
        for (String element : set) {
            System.out.println(element);
        }

        // 8. Clear all elements
        set.clear();
        System.out.println("After clearing the set: " + set);
	}

}
