package BasicFundamentals;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface // This annotation is optional but indicates that the interface is for a lambda.
interface Sum {
	public int add(int a, int b);
}

interface Calculation {
	public int subtract(int a, int b);
	
	public int multiply(int a, int b);
}

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "{name='" + name + "', age=" + age + "}";
	}
}



public class LambdaExpressionExample {

	public static void main(String[] args) {
		Sum sum = (a, b) -> a + b;
		System.out.println("Addition of 3 and 4 is -> " + sum.add(3, 4));
		
		Calculation cal = new Calculation() {
			
			@Override
			public int subtract(int a, int b) {
				return a - b;
			}
			
			@Override
			public int multiply(int a, int b) {
				return a * b;
			}
		};
		
		System.out.println("Subtraction of 23 and 15 is -> " + cal.subtract(23, 15));
		System.out.println("Multiplication of 3 and 5 is -> " + cal.multiply(3, 5));
		
		//Creating list of Person object
		List<Person> man = Arrays.asList(
				new Person("Alice", 24),
				new Person("Bob", 43),
				new Person("John", 32),
				new Person("Charlie", 23)
				);
		
		//Sorting persons in ascending order with their names
		
		/**
		 * man.sort((p1, p2) -> String.compare(p1.getName(), p2.getName()));
		 * Above statement is wrong because reason man.sort((p1, p2) -> String.compare(p1.getName(), p2.getName())); is incorrect is because String is a class, and there is no method compare() that is directly callable on the String class in this way.
		 */
		
		man.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("Sorting persons in ascending order with their names:\n" + man);
		System.out.println("\n");
		
		//Sorting persons in descending order with their names
		man.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
		System.out.println("Sorting persons in descending order with their names:\n" + man);
		System.out.println("\n");
		
		//Sorting persons in ascending order with their age
		man.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		System.out.println("Sorting persons in ascending order with their age:\n" + man);
		System.out.println("\n");
		
		//Sorting persons in descending order with their age
		man.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));
		System.out.println("Sorting persons in descending order with their age:\n" + man);
		System.out.println("\n");
		
	}

}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
/**
 * A functional interface is an interface that contains a single abstract method. Functional interfaces are used extensively 
 * in Java to represent functions and Lambdas.
 * 
 * Lambda expression is used to implement functional interface. We can implement functional interface using implements keyword,
 * anonymous class and LAMBDA EXPRESSION. Using lambda expression we don't need to write override, method and other verbos.
 * 
 * When using Lambda expressions to create functional interfaces, the Lambda expression is used to define the implementation
 * of the abstract method. The Lambda expression takes the same parameters as the abstract method, and returns a value that 
 * represents the result of the method.
 */
