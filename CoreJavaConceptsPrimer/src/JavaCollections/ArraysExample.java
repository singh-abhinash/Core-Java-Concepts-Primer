package JavaCollections;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
    	
        // Creating an array
        int[] numbers = new int[5];

        // Initializing an array
        int[] initializedNumbers = {5, 2, 8, 1, 3};

        // Accessing elements
        System.out.println("Element at index 2: " + initializedNumbers[2]);

        // Modifying elements
        initializedNumbers[2] = 10;
        System.out.println("Modified element at index 2: " + initializedNumbers[2]);

        // Getting the length of the array
        System.out.println("Length of array: " + initializedNumbers.length);

        // Iterating over the array
        System.out.println("Elements in array:");
        for (int num : initializedNumbers) {
            System.out.println(num);
        }

        // Sorting the array in increasing order
        Arrays.sort(initializedNumbers);
        System.out.println("Sorted array increasing: " + Arrays.toString(initializedNumbers));
        //System.out.println("Sorted array: " + initializedNumbers); -> wrong

        /**************
        Arrays.sort(initializedNumbers, Collections.reverseOrder());
        System.out.println("Sorted array increasing: " + Arrays.toString(initializedNumbers));
        this will throw error stating 
        The error you're encountering is because the Arrays.sort() method doesn't directly 
        support sorting int[] arrays using Comparator.reverseOrder(). 
        The Collections.reverseOrder() comparator works with boxed types like Integer, but 
        not with primitive types like int.
        **************/
        // Searching for an element
        int index = Arrays.binarySearch(initializedNumbers, 10);
        System.out.println("Index of element 10: " + index);

        // Copying the array
        int[] copiedArray = Arrays.copyOf(initializedNumbers, initializedNumbers.length);
        System.out.println("Copied array: " + Arrays.toString(copiedArray));

        // Comparing arrays
        boolean areEqual = Arrays.equals(initializedNumbers, copiedArray);
        System.out.println("Are original and copied arrays equal: " + areEqual);

        // Filling the array
        Arrays.fill(numbers, 7);
        System.out.println("Array after filling with 7: " + Arrays.toString(numbers));

        // Converting array to String
        String arrayString = Arrays.toString(initializedNumbers);
        System.out.println("Array as String: " + arrayString);

        // Using Arrays.stream() to work with the array
        int sum = Arrays.stream(initializedNumbers).sum();
        System.out.println("Sum of elements: " + sum);

        // Using Arrays.parallelSort() for large arrays
        Arrays.parallelSort(initializedNumbers);
        System.out.println("Array after parallel sort: " + Arrays.toString(initializedNumbers));
    }
}
