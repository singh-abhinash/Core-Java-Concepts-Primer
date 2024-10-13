package BasicFundamentals;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Bird {
	public void canFly();
	//if we will uncomment below statement 8 then we will get error like "Invalid '@FunctionalInterface' annotation; Bird is 
	//not a functional interface"
	//public void canEat();
}

@FunctionalInterface 
interface Animal {
	public void dog();
	
	/*
	 * public void cat() {
	 * 
	 * }
	 * if we will write like above then we will get error :
	 * Abstract methods do not specify a body
	 * change 'cat' to 'default' or change 'cat' to 'static'
	 * It means we cant declare two method in functional interface without static and default
	 */
	
	public static void cat() {
		System.out.println("we can add cat mehtod as static inside functional interface\n");
	}
	
	public default void lion() {
		System.out.println("we can add lion mehtod as default inside functional interface\n");
	}
}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		
		// Implementing the functional interface 'Animal' using a lambda expression
        Animal animal = () -> System.out.println("Implementing 'dog' method using lambda inside main method\n");
        animal.dog(); // Call to overridden method (via lambda)
        
        // Accessing static method of the interface directly via interface name
        Animal.cat(); // Calling the static method
        
        // Calling default method via instance of the functional interface
        animal.lion(); // Calling the default method
        
        // Implementing the functional interface 'Bird' using lambda expression
        Bird bird = () -> System.out.println("Bird can fly!");
        bird.canFly(); // Call to overridden method (via lambda)
        
        // Supplier: Provides an object without taking any input
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println("Supplier result: " + supplier.get());

        // Consumer: Consumes an object and performs some operation without returning any result
        Consumer<String> consumer = (message) -> System.out.println("Consumer received: " + message);
        consumer.accept("Hello from Consumer!");

        // Function: Takes an input and returns an output
        Function<Integer, String> function = (age) -> {
            if (age >= 18) {
                return "Eligible for voting";
            } else {
                return "Not eligible for voting";
            }
        };
        System.out.println("Function result: " + function.apply(20));

        // Predicate: Evaluates an input and returns a boolean result
        Predicate<Integer> predicate = (number) -> number > 10;
        System.out.println("Predicate result (is 15 > 10?): " + predicate.test(15));
        System.out.println("Predicate result (is 5 > 10?): " + predicate.test(5));
	}

}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
/**
 * In functional interface we have only one abstract method but we can also add default method and static method at same time
 * but we cannot add two method which is not default and static
 * 
 * Explanation of Functional Interfaces Type:
 * 
 * Supplier:
 * Does not accept any arguments but returns a result
 * In the example: Supplier<String> supplier = () -> "Hello from Supplier!";
 * It provides a message "Hello from Supplier!" without taking any inputs.
 * 
 * Consumer:
 * Accepts a single input and performs some operations but doesn't return any result.
 * In the example: consumer.accept("Hello from Consumer!");
 * It prints the received message but doesn't return anything.
 * 
 * Function:
 * Takes one argument and returns a result.
 * In the example: Function<Integer, String> function = (age) -> { ... }
 * It checks whether the given age is eligible for voting and returns a message accordingly.
 * 
 * Predicate:
 * Takes one argument and returns a boolean result.
 * In the example: Predicate<Integer> predicate = (number) -> number > 10;
 * It evaluates whether a given number is greater than 10 and returns true or false.
 */