package JavaCollections;

import java.util.HashMap;
import java.util.Map;

public class HashMapImplementsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Initialization
        // Map<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();

        // 2. Add key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // 3. Get value by key
        System.out.println("Alice's age: " + map.get("Alice"));

        // 4. Remove a key-value pair
        map.remove("Bob");
        System.out.println("After removing Bob: " + map);

        // 5. Check if a key exists
        System.out.println("Is Alice in the map? " + map.containsKey("Alice"));

        // 6. Check if a value exists
        System.out.println("Is age 30 in the map? " + map.containsValue(30));

        // 7. Get size of the map
        System.out.println("Size of the map: " + map.size());

        // 8. Check if the map is empty
        System.out.println("Is the map empty? " + map.isEmpty());

        // 9. Iterate over keys
        System.out.println("Keys in the map:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // 10. Iterate over values
        System.out.println("Values in the map:");
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        // 11. Iterate over key-value pairs
        System.out.println("Key-Value pairs in the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 12. Clear all entries
        map.clear();
        System.out.println("After clearing the map: " + map);
	}

}
