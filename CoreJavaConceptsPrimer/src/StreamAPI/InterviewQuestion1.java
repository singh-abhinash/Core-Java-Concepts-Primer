/**
 * Question: Given a list of integers, filter out the even numbers.
 */

package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQuestion1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> evenNumbers = numbers.stream()
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		
		System.out.println("Even Numbers : " + evenNumbers);
	}

}
