package JavaCollections;
//import java.util.*; -> either use this or use below two
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListImplementsListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        System.out.println("******Added elements using .add() method******");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        //using lambda expression
        System.out.println("******printing elements using .forEach() method, using lambda expression******");
        fruits.forEach(fruit -> {
        	System.out.print(fruit + " ");
        });
        
        System.out.println();

        // Adding element at specific index
        System.out.println("******Added element at specific index******");
        fruits.add(1, "Mango");

        //using lambda expression
        System.out.println("******printing elements using .forEach() method, using lambda expression******");
        fruits.forEach(fruit -> {
        	System.out.println(fruit + " ");
        });
        
        // Accessing elements
        System.out.println("******Accessing elements at index 1******");
        System.out.println("Element at index 1: " + fruits.get(1));
        
        
        // Modifying elements
        System.out.println("******Modifying elements at index 2******");
        fruits.set(2, "Grapes");
        
        // Accessing elements
        System.out.println("******Accessing elements at index 2******");
        System.out.println("Element at index 2: " + fruits.get(2));

        // Removing elements
        System.out.println("******Removing Banana element******");
        //fruits.remove("Banana");
        fruits.remove(0);
        
        // Iterating over the elements
        System.out.println("******printing elements using .forEach() method, using lambda expression******");
        fruits.forEach(fruit -> {
        	System.out.println(fruit + " ");
        });

        // Checking if list contains an element
        System.out.println("******Checking if list contains an element******");
        boolean containsGrapes = fruits.contains("Grapes");
        System.out.println("Contains Grapes: " + containsGrapes);

        // Getting the index of an element
        System.out.println("******Getting the index of an element******");
        int indexOfOrange = fruits.indexOf("Orange");
        System.out.println("Index of Orange: " + indexOfOrange);
        
        // Getting the index of an element
        System.out.println("******Getting the index of an element******");
        int indexOfBanana = fruits.indexOf("Banana");
        System.out.println("Index of Banana: " + indexOfBanana);

        // Getting the size of the ArrayList
        System.out.println("******Getting the size of the ArrayList******");
        int size = fruits.size();
        System.out.println("Size of ArrayList: " + size);

        // Iterating over the elements
        System.out.println("******Elements in ArrayList:******");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Clearing the ArrayList
        System.out.println("******Clearing the ArrayList******");
        fruits.clear();
        System.out.println("ArrayList after clearing: " + fruits);

        // Adding multiple elements
        System.out.println("******Adding multiple elements at a time******");
        Collections.addAll(fruits, "Watermelon", "Pineapple", "Cherry");
        System.out.println("Sorted ArrayList: " + fruits);
        
        // Sorting the ArrayList
        System.out.println("******Sorting the ArrayList in incresing order******");
        Collections.sort(fruits);
        System.out.println("Sorted ArrayList: " + fruits);
        
        System.out.println("******Sorting the ArrayList in decreasing order******");
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("Sorted ArrayList in decreasing: " + fruits);

        // Checking if the list is empty
        System.out.println("******Checking if the list is empty******");
        boolean isEmpty = fruits.isEmpty();
        System.out.println("Is ArrayList empty: " + isEmpty);

        // Cloning the ArrayList
        System.out.println("******Cloning the ArrayList******");
        //ArrayList<String> clonedFruits = fruits.clone(); -> type mismatch: cannot convert from Object to ArrayList<String>
        ArrayList<String> clonedFruits = (ArrayList<String>) fruits.clone();
        System.out.println("Cloned ArrayList: " + clonedFruits);

        // Converting ArrayList to an array
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("******Array from ArrayList:*******");
        System.out.println("Printing Array: "+Arrays.toString(fruitsArray));  
        System.out.println("Printing List: "+fruits);  

        // Creating an ArrayList from another collection
        System.out.println("******Creating an ArrayList from another collection*******");
        ArrayList<String> moreFruits = new ArrayList<>(clonedFruits);
        System.out.println("New ArrayList from another collection: " + moreFruits);
        
     // Initialization with Arrays.asList()
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));

        // Printing the ArrayList
        System.out.println("ArrayList: " + list);
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 *-> Java ArrayList implements list.
 *-> Java ArrayList class can contain duplicate elements.
 *-> Java ArrayList class maintains insertion order. 
 *-> Java ArrayList class is non synchronized.
 *-> Java ArrayList allows random access because the array works on an index basis.
 *-> In ArrayList, manipulation is a little bit slower than the LinkedList in Java 
 *   because a lot of shifting needs to occur if any element is removed from the array list.
 *-> We can not create an array list of the primitive types, such as int, float, char, etc.
 *   It is required to use the required wrapper class in such cases. For example:
 *	 ArrayList<int> al = ArrayList<int>(); // does not work
 *   ArrayList<Integer> al = new ArrayList<Integer>(); // works fine
 *-> Java ArrayList gets initialized by the size. The size is dynamic in the array list, 
 *   which varies according to the elements getting added or removed from the list.
 *   
 *   
 *   *******This example demonstrates:********

Creating an ArrayList.
Adding elements using add().
Accessing elements using get().
Modifying elements using set().
Removing elements using remove().
Checking if an element exists using contains().
Getting the index of an element using indexOf().
Getting the size of the ArrayList using size().
Iterating over the ArrayList using a for-each loop.
Clearing the ArrayList using clear().
Adding multiple elements using Collections.addAll().
Sorting the ArrayList using Collections.sort().
Checking if the ArrayList is empty using isEmpty().
Cloning the ArrayList using clone().
Converting the ArrayList to an array using toArray().
Creating an ArrayList from another collection.
This covers a wide range of ArrayList methods that are commonly used.
 */   