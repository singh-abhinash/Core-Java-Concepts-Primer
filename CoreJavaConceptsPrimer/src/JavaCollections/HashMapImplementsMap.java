package JavaCollections;

import java.util.HashMap;
import java.util.Map;

public class HashMapImplementsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Initialization
        // Map<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map = new HashMap<>();
		//also correct - HashMap<String, Integer> map = new HashMap<String, Integer>();

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
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int[] numbers = {1, 2, 2, 3, 4, 5, 1, 3, 2, 4, 5, 5};

        // Create a HashMap to store the count of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Loop through the array to count occurrences
        for (int num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Print the occurrences
        for (Integer key : countMap.keySet()) {
            System.out.println("Number " + key + " occurs " + countMap.get(key) + " times.");
        }
        
        System.out.println("+++++++++++++++++ putIfAbsent +++++++++++++++++++");

        Map<String, String> capitalMap = new HashMap<>();
        capitalMap.put("India", "Delhi");
        capitalMap.putIfAbsent("USA", "Washington D.C.");
        capitalMap.putIfAbsent("India", "New Delhi"); // won't update

        System.out.println(capitalMap);

        System.out.println("+++++++++++++++++ computeIfAbsent +++++++++++++++++++");

        Map<String, StringBuilder> memoMap = new HashMap<>();
        memoMap.computeIfAbsent("ChatGPT", k -> new StringBuilder()).append(" is smart!");
        memoMap.computeIfAbsent("Java", k -> new StringBuilder()).append(" is powerful!");

        System.out.println(memoMap);

        System.out.println("+++++++++++++++++ computeIfPresent +++++++++++++++++++");

        Map<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 1);
        voteMap.put("Bob", 2);

        voteMap.computeIfPresent("Alice", (k, v) -> v + 1);
        voteMap.computeIfPresent("Charlie", (k, v) -> v + 1); // not present, does nothing

        System.out.println(voteMap);
        
        System.out.println("+++++++++++++++++ getOrDefault +++++++++++++++++++");

        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("India", "Delhi");
        countryCapital.put("USA", "Washington D.C.");

        // Using getOrDefault
        String capital1 = countryCapital.getOrDefault("India", "Not Found");
        String capital2 = countryCapital.getOrDefault("UK", "Not Found");

        System.out.println("Capital of India: " + capital1);  // Delhi
        System.out.println("Capital of UK: " + capital2);     // Not Found
	}

}
