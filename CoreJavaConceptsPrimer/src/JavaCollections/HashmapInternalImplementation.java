package JavaCollections;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("all")
public class HashmapInternalImplementation {
	
    // Custom HashMap class that mimics the internal implementation of a HashMap
	public static class CustomHashMap<K, V> {
		
		// Constructor to initialize the array of LinkedLists (buckets)
	    public CustomHashMap() {
	        initializeArrayOfLinkedList();
	    }
		
		// Nested Node class to store key-value pairs
		private class Node {
			K key; // The key for the node
			V value; // The value corresponding to the key
			
			// Constructor for Node class to initialize key-value pairs
			public Node(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}
		
		private int n; // Number of key-value pairs (nodes) currently stored in the map
		private int N; // Number of buckets (size of the array of LinkedLists)
		private LinkedList<Node> buckets[]; // Array of LinkedLists to store nodes (key-value pairs)
		
		// Initializes the array of buckets with a size of 4 and fills each bucket with an empty LinkedList
		public void initializeArrayOfLinkedList() {
			this.N = 4; // Initial size of bucket array
			this.buckets = new LinkedList[N]; // Array of LinkedLists with size N
			
			// Iterate through each bucket and initialize it as an empty LinkedList
			for (int bi = 0; bi < N; bi++) { // bi = bucket index
				buckets[bi] = new LinkedList<>();
			}
		}
		
		// Generates a bucket index (hash code) for a given key using the hashCode of the key
		private int implementHashFunctionToGenerateHashCode(K key) {
			int bi = key.hashCode(); // Generate hash code for the key
			return Math.abs(bi) % N; // Ensure the index is within bucket array limits (positive and within size N)
		}
		
		
		// Searches the given bucket for a node with the specified key
		// Returns the index of the node in the LinkedList, or -1 if the key is not found
		private int searchinLinkedList(K key, int bi) {
			LinkedList<Node> ll = buckets[bi]; // Get the bucket (LinkedList) at the calculated bucket index bi
			
			// Iterate through the LinkedList to search for the key
			for (int nodeIndex = 0; nodeIndex < ll.size(); nodeIndex++) {
				// Compare the key of each node with the given key using equals() method
				if (ll.get(nodeIndex).key.equals(key)) {
					return nodeIndex; // Return the index if key is found
				}
			}
			
			return -1; // Return -1 if the key is not found
		}
		
		// Performs rehashing when the load factor exceeds a certain threshold (lambda > 2.0)
		private void rehashing() {
			// Store the old buckets before rehashing
			LinkedList<Node> oldBuckets[] = buckets;
			
			// Create a new array of LinkedLists with double the size
			buckets = new LinkedList[N * 2];
			
			// Initialize each bucket in the new array as an empty LinkedList
			for (int bi = 0; bi < N * 2; bi++) {
				buckets[bi] = new LinkedList<>();
			}
			
			// Iterate through the old bucket array and rehash all existing nodes into the new array
			for (int bi = 0; bi < oldBuckets.length; bi++) {
				LinkedList<Node> ll = oldBuckets[bi]; // Get the LinkedList at each bucket in old array
				
				// Reinsert each node (key-value pair) into the new bucket array
				for (int nodeIndex = 0; nodeIndex < ll.size(); nodeIndex++) {
					Node node = ll.get(nodeIndex);
					put(node.key, node.value); // Use put() method to rehash and store the node in the new buckets
				}
			}
		}
		
		// Inserts or updates a key-value pair in the map
		public void put(K key, V value) {
			// Generate the bucket index using hash function
			int bi = implementHashFunctionToGenerateHashCode(key);
			
			// Search for the key in the corresponding bucket (LinkedList)
			int di = searchinLinkedList(key, bi); // di = data index, index of the key in LinkedList
			
			if (di == -1) { // If the key doesn't exist
				// Add a new node (key-value pair) to the LinkedList at the bucket index
				buckets[bi].add(new Node(key, value));
				n++; // Increment the total number of nodes
			} else { // If the key exists
				// Update the value of the existing node
				Node node = buckets[bi].get(di);
				node.value = value;
			}
			
			// Calculate load factor (lambda)
			double lambda = (double)n / N;
			
			// If load factor exceeds 2.0, rehash the map to prevent excessive collisions
			if (lambda > 2.0) {
				rehashing(); // Double the size of the bucket array and redistribute nodes
			}
		}
		
		// Checks if the map contains the specified key
		public boolean containsKey(K key) {
			// Generate the bucket index using hash function
			int bi = implementHashFunctionToGenerateHashCode(key);
			
			// Search for the key in the corresponding bucket (LinkedList)
			int di = searchinLinkedList(key, bi); // di = data index
			
			// If di is -1, the key doesn't exist; otherwise, it exists
			return di != -1;
		}
		
		// Removes the key-value pair corresponding to the specified key
		public V remove(K key) {
			// Generate the bucket index using hash function
			int bi = implementHashFunctionToGenerateHashCode(key);
			
			// Search for the key in the corresponding bucket (LinkedList)
			int di = searchinLinkedList(key, bi); // di = data index
			
			if (di == -1) { // If key doesn't exist
				return null;
			} else { // If key exists
				// Remove the node (key-value pair) from the LinkedList and decrement the node count
				Node node = buckets[bi].remove(di);
				n--;
				return node.value; // Return the value of the removed node
			}
		}
		
		// Retrieves the value corresponding to the specified key
		public V get(K key) {
			// Generate the bucket index using hash function
			int bi = implementHashFunctionToGenerateHashCode(key);
			
			// Search for the key in the corresponding bucket (LinkedList)
			int di = searchinLinkedList(key, bi); // di = data index
			
			if (di == -1) { // If key doesn't exist
				return null;
			} else { // If key exists
				// Retrieve the value from the node in the LinkedList
				Node node = buckets[bi].get(di);
				return node.value;
			}
		}
		
		// Returns an ArrayList containing all the keys in the map
		public ArrayList<K> keySet() {
			ArrayList<K> keys = new ArrayList<>();
			
			// Iterate through each bucket (LinkedList) in the array
			for (int bi = 0; bi < buckets.length; bi++) {
				LinkedList<Node> ll = buckets[bi]; // Get the LinkedList at each bucket
				
				// Iterate through each node in the LinkedList to extract the keys
				for (int nodeIndex = 0; nodeIndex < ll.size(); nodeIndex++) {
					Node node = ll.get(nodeIndex);
					keys.add(node.key); // Add the key to the ArrayList
				}
			}
			
			return keys; // Return the list of keys
		}
		
		// Checks if the map is empty
		public boolean isEmpty() {
			return n == 0; // Returns true if the map contains no key-value pairs
		}
	}

	public static void main(String[] args) {
	    // Creating an instance of CustomHashMap with String keys and Integer values
	    CustomHashMap<String, Integer> map = new CustomHashMap<>();
	    
	    // Adding some key-value pairs to the map
	    System.out.println("Inserting key-value pairs:");
	    map.put("India", 190);
	    map.put("China", 200);
	    map.put("US", 50);
	    map.put("Germany", 80);
	    
	    // Fetching and printing all key-value pairs
	    System.out.println("\nPrinting all key-value pairs:");
	    ArrayList<String> keys = map.keySet();
	    for (int i = 0; i < keys.size(); i++) {
	        System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
	    }
	    
	    // Checking if certain keys exist using containsKey()
	    System.out.println("\nChecking if certain keys exist:");
	    System.out.println("Contains 'India': " + map.containsKey("India"));
	    System.out.println("Contains 'France': " + map.containsKey("France"));
	    
	    // Fetching the value for a specific key
	    System.out.println("\nFetching values for specific keys:");
	    System.out.println("Value for 'US': " + map.get("US"));
	    System.out.println("Value for 'China': " + map.get("China"));
	    
	    // Removing a key-value pair
	    System.out.println("\nRemoving 'India' and checking its value:");
	    map.remove("India");
	    System.out.println("Value for 'India' after removal: " + map.get("India")); // Should return null
	    
	    // Checking if the map is empty
	    System.out.println("\nIs the map empty? " + map.isEmpty()); // Should return false
	    
	    // Removing all elements from the map
	    System.out.println("\nRemoving all elements:");
	    map.remove("China");
	    map.remove("US");
	    map.remove("Germany");
	    
	    // Checking if the map is empty after removing all elements
	    System.out.println("Is the map empty after removing all elements? " + map.isEmpty()); // Should return true
	    
	    // Attempt to fetch a key from the empty map
	    System.out.println("\nFetching value for 'Germany' from empty map: " + map.get("Germany")); // Should return null
	}

}
