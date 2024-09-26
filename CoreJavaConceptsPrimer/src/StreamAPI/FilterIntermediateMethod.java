package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return ("(" + name + (",") + age + ")");
	}
}

public class FilterIntermediateMethod {

	public static void main(String[] args) {
		//Example 1: Filtering Even Numbers from a List
		//Here’s an example that demonstrates how to filter out even numbers from a list using the filter method.
		List<Integer> list1 = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
		List<Integer> evenNumbers = list1.stream()
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("Even Numbers are -> " + evenNumbers);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		//Example 2: Filtering Strings Based on Length
		//Let's filter out strings with length greater than 3 from a list of strings.
		List<String> list2 = Arrays.asList("My", "Name", "Is", "Abhinash", "Singh");
		List<String> resultString = list2.stream()
				.filter(word -> word.length() > 3)
				.collect(Collectors.toList());
		System.out.println("String having length greater than 3 -> " + resultString);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		//Example 3: Filtering Objects from a List of Custom Objects
		//In this example, let's say we have a list of Person objects, and we want to filter out 
		//all people whose age is above 18.
		List<Person> people = Arrays.asList(
				new Person("Abhi", 25),
				new Person("Singh", 28),
				new Person("Anup", 17),
				new Person("Sushil", 32));
		List<Person> person = people.stream()
				.filter(pepl -> pepl.age > 18)
				.collect(Collectors.toList());
		System.out.println("Person are ->" + person);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
Question - What is the filter method?
Answer - The filter method in Java Stream API is used to select elements from a stream that satisfy a given condition 
(also known as a predicate). It returns a new stream that consists of the elements that match the given condition.

Syntax - Stream<T> filter(Predicate<? super T> predicate)

Key Points about filter:
=> Pure Filtering: The filter method only checks a condition and includes elements that satisfy the condition. 
It doesn't modify the elements.
=> Intermediate Operation: filter is an intermediate operation, which means it returns a new stream and can be 
chained with other stream operations (like map, sorted, etc.).
=> Lazy Evaluation: The operation won’t be performed until a terminal operation (like collect, forEach, etc.) 
is called on the stream.

Question -> Why do we need to override toString()?
Readable Output: By default, when you print an object in Java, the toString() method is called implicitly. 
If you don’t override it, the default implementation (inherited from the Object class) will return a string 
like this:

ClassName@hashcode
This is not very meaningful or readable. For example:

Person@3f0ee7cb

By overriding toString(), you can make the output more human-readable. Instead of showing the class name and 
hashcode, you display relevant object information like the name and age in your example.

Debugging and Logging: During development, it's common to print objects to the console for debugging or 
logging purposes. A well-defined toString() method helps to quickly understand the state of an object.

Custom Representation: You can customize how the object is represented based on your needs. This could include 
all attributes or just the most important ones.

Example Without toString() Override:
Consider the following class:

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println(person);
    }
}
If you run this code, the output would be:
Person@3f0ee7cb

This is the default toString() output, which is not very helpful.

Example With toString() Override:

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println(person);
    }
}
Output:

Alice (30)
Now, with the overridden toString(), you get a clear and meaningful representation of the Person object.

Conclusion:
Overriding the toString() method allows you to customize how your objects are represented as strings, making 
it more readable and helpful for logging, debugging, or simply displaying object information.


*/
