/**
 * Question: Given a list of integers, filter out the even numbers.
 */

package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class InterviewQuestion1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> evenNumbers = numbers.stream()
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		
		System.out.println("Even Numbers : " + evenNumbers);
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//Given a list of strings, write a program to count the number of strings containing a specific character ‘a’ 
		//using Java Stream API.
		List<String> words = Arrays.asList("apple", "banana", "cherry", "grape", "kiwi", "avocado");

        // Count strings containing 'a'
        long count = words.stream()
                          .filter(word -> word.contains("a")) // Filter words containing 'a'
                          .count(); // Count them

        System.out.println("Number of words containing 'a': " + count);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Given a list of integers, write a program to calculate the average of all the numbers using Java Stream API.
        List<Integer> numbers1 = Arrays.asList(10, 20, 30, 40, 50);

        // Calculate average
        OptionalDouble average = numbers1.stream()
                                        .mapToInt(num -> num) // Convert Integer to IntStream
                                        .average(); // Calculate average

        // Print result
        if (average.isPresent()) {
            System.out.println("Average: " + average.getAsDouble());
        } else {
            System.out.println("List is empty");
        }
        // Alternate Solution
//        double average = numbers.stream()
//                .mapToInt(n -> n)
//                .average()
//                .orElse(0.0); // Default value if list is empty
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Given a list of integers, write a program to find and print the second largest number using Java Stream API.
        List<Integer> numbers2 = Arrays.asList(10, 20, 5, 30, 25);

        // Find the second largest number
        Optional<Integer> secondLargest = numbers.stream()
                .distinct()                // Remove duplicates
                .sorted((a, b) -> b - a)   // Sort in descending order
                .skip(1)                   // Skip the first (largest) element
                .findFirst();               // Get the second largest

        // Print result
        if (secondLargest.isPresent()) {
            System.out.println("Second Largest Number: " + secondLargest.get());
        } else {
            System.out.println("List does not have enough elements");
        }
		
	}

}
