package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AllTerminalOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have multiple terminal operations like
		//forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch()
		//findFirst(), findAny();
		
		List<Integer> num = Arrays.asList(5,2,7,3,4,6,9,1,8);
		
		num.stream()
		.filter(val -> val >= 7)
		.forEach(val -> System.out.println(val));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//why without argument, .toArray is returning object and with argument .toArray is returning array?..read below
		Object[] objResult = num.stream()
				.filter(val -> val <= 5)
				.toArray();
		//why I am using toString to print?...read below
		System.out.println(Arrays.toString(objResult));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		Integer[] intResult = num.stream()
				.filter(val -> val <= 5)
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intResult));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		/*below is wrong...read below doc
		 * Integer reduceValue = num.stream()
				.reduce((num1,  num2) -> num1+num2);*/
		
		//either use below for reduce
		Integer reduceValue = num.stream()
			    .reduce(0, (num1, num2) -> num1 + num2);
		System.out.println("sum: " + reduceValue);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//or use below for reduce
		Optional<Integer> reduceValue1 = num.stream()
			    .reduce((num1, num2) -> num1 + num2);
		reduceValue1.ifPresent(result -> System.out.println("Sum: " + result));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//for min() it is working as a first()
		Optional<Integer> minValue = num.stream()
				.min((val1, val2) -> (val1 - val2));
		System.out.println("minimum value is -> " + minValue.get());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//for min() it is working as a first()
		Optional<Integer> minValue1 = num.stream()
				.min((val1, val2) -> (val2 - val1));
		System.out.println("minimum value is -> " + minValue1.get());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//for max() it is working as a first()
		Optional<Integer> maxValue = num.stream()
				.max((val1, val2) -> (val1 - val2));
		System.out.println("maximum value is -> " + maxValue.get());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
		//for max() it is working as a first()
		Optional<Integer> maxValue1 = num.stream()
				.max((val1, val2) -> (val2 - val1));
		System.out.println("maximum value is -> " + maxValue1.get());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//findFirst()
		//5,2,7,3,4,6,9,1,8 for this example findFirst() will give 5
		//7,2,1,3,5,6,9,4,8 for this example findFirst() will give 7 think about it?????
		Optional<Integer> findFirstNum = num.stream()
				.filter(val -> val > 3)
				.findFirst();
		System.out.println("First value is -> " + findFirstNum.get());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		List<Integer> num1 = Arrays.asList(7,2,1,3,5,6,9,4,8);
		//.findFirst will always search from first index
		Optional<Integer> findFirstNum1 = num1.stream()
				.filter(val -> val > 3)
				.findFirst();
		System.out.println("First value is -> " + findFirstNum1.get());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		//count()
		long countNum = num.stream()
				.count();
		System.out.println("Count is -> " + countNum);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//anyMatch()
		boolean match = num.stream()
				.anyMatch(val -> val > 5);
		System.out.println(match);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
Incorrect Code:
	Integer[] intResult = num.stream()
	    .filter(val -> val <= 5)
	    .toArray(new Integer[0]);  // This throws an error
	Why It Throws an Error:
	.toArray(new Integer[0]) is trying to pass an array directly, but the Stream.toArray() method expects 
	a generator function that can create arrays of the needed type, not an actual array object itself.
	
	Correct Code:
	Instead, you should use the method reference Integer[]::new, which tells toArray() how to create a 
	new Integer[] array of the appropriate size:

	Integer[] intResult = num.stream()
	    .filter(val -> val <= 5)
	    .toArray(Integer[]::new);  // Correct usage
	Explanation:
	Integer[]::new is a method reference that acts as a function (a constructor) to generate arrays of 
	the correct type (Integer[]), which toArray() needs.
	Alternatively, you can collect the results into a list and then convert it to an array, like this:

	Alternative Solution:
	List<Integer> intList = num.stream()
	    .filter(val -> val <= 5)
	    .collect(Collectors.toList());

	Integer[] intResult = intList.toArray(new Integer[0]);
	In this case:

	First, you collect the filtered results into a list using Collectors.toList().
	Then, you convert the list to an array using toArray(new Integer[0]), which works because List.toArray(T[] a) 
	can accept an array as a parameter.
	Both solutions will work, but using Integer[]::new is the preferred approach when working with streams.
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//=================================================================================================================
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 Object[] objResult = num.stream()
				.filter(val -> val <= 5)
				.toArray();
		System.out.println(objResult);
		
		Integer[] intResult = num.stream()
				.filter(val -> val <= 5)
				.toArray(Integer[]::new);
		System.out.println(intResult);
		
output for above is not correct:
[Ljava.lang.Object;@eed1f14
+++++++++++++++++++++++++++++++++++++++++++++++++++++
[Ljava.lang.Integer;@776ec8df
+++++++++++++++++++++++++++++++++++++++++++++++++++++

The output you're seeing:
[Ljava.lang.Object;@eed1f14
+++++++++++++++++++++++++++++++++++++++++++++++++++++
[Ljava.lang.Integer;@776ec8df
+++++++++++++++++++++++++++++++++++++++++++++++++++++
indicates that the toArray() method is returning arrays, but when you print them directly, you’re getting the 
default toString() behavior for arrays in Java, which prints the array's type and its memory address, 
rather than the elements of the array.

Problem:
Java does not automatically print the contents of an array when you pass the array directly to 
System.out.println(). Instead, it prints the internal object reference, which is why you're 
seeing @eed1f14 and similar values.

Solution:
To print the actual contents of the array, you need to use Arrays.toString().

Here’s the corrected code:

import java.util.Arrays;

Object[] objResult = num.stream()
    .filter(val -> val <= 5)
    .toArray();
System.out.println(Arrays.toString(objResult));

Integer[] intResult = num.stream()
    .filter(val -> val <= 5)
    .toArray(Integer[]::new);
System.out.println(Arrays.toString(intResult));

Explanation:
Arrays.toString(objResult) and Arrays.toString(intResult) convert the array into a readable String representation 
of its contents.
This will print the actual values inside the array, not just the reference information.
Expected Output:
If num contains values like [1, 2, 6, 5, 3], and you are filtering for values less than or equal to 5, the output 
will be something like:

[1, 2, 5, 3]
+++++++++++++++++++++++++++++++++++++++++++++++++++++
[1, 2, 5, 3]
+++++++++++++++++++++++++++++++++++++++++++++++++++++
This will display the filtered elements instead of the array's memory reference.

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//################################################################################################################
why it is throwing error?
Integer reduceValue = num.stream()
				.reduce((num1,  num2) -> num1+num2);

The error in your code arises because the reduce method in streams has two forms, and you're using the form 
that returns an Optional. Here's what's going wrong in your specific case:

Problem:
You're using the reduce method like this:

Integer reduceValue = num.stream()
    .reduce((num1, num2) -> num1 + num2);  // This can throw an error

The issue is that the reduce operation without an identity value returns an Optional since the result could 
potentially be empty (for example, when the stream is empty).

So, the correct code would be:

Optional<Integer> reduceValue = num.stream()
    .reduce((num1, num2) -> num1 + num2);

Explanation:
reduce((num1, num2) -> num1 + num2) returns an Optional<Integer> because if the stream is empty, there won't be 
any values to reduce, and the result could be empty.
You cannot directly assign an Optional to an Integer without unwrapping it.

How to Fix It:
1. Using Optional (Safe)
If you're okay with handling the case where the stream could be empty, use Optional:

java
Copy code
Optional<Integer> reduceValue = num.stream()
    .reduce((num1, num2) -> num1 + num2);

reduceValue.ifPresent(result -> System.out.println("Sum: " + result));
In this case:
reduceValue is an Optional, and you can use methods like ifPresent(), orElse(), or orElseThrow() to handle 
empty results safely.


2. Using an Identity Value (Simpler)
If you want to directly get an Integer result, you should provide an identity value to reduce(). The identity value 
is the starting value for the reduction (like 0 for a sum):

Integer reduceValue = num.stream()
    .reduce(0, (num1, num2) -> num1 + num2);

System.out.println("Sum: " + reduceValue);
Explanation:
The reduce(0, (num1, num2) -> num1 + num2) form provides an identity value (0 in this case), ensuring that the result 
will always be an Integer, even if the stream is empty.
When the stream is empty, the result will be the identity value (0 for summing).
Summary of Fixes:
Use Optional<Integer> to handle potentially empty streams.
Provide an identity value (like 0) in reduce() if you want an Integer result directly and want to avoid dealing with 
Optional.
Both solutions are valid depending on whether you need to handle the case where the stream might be empty.
*/