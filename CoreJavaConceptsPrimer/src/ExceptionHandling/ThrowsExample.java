package ExceptionHandling;

public class ThrowsExample {
	
	// Method that declares it may throw an ArithmeticException
	public static int devide(int numerator, int denominator) throws ArithmeticException {
		return numerator / denominator; // This can throw an ArithmeticException if denominator is zero
	}

	public static void main(String[] args) {
		try {
			// Calling the divide method
			int result = devide(10, 0);	// This will cause exception
			System.out.println("Result : " + result);
		} catch (ArithmeticException e){
			// Handling the ArithmeticException
			System.out.println("Error : cannot devided by zero");
		}
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * without this "throws ArithmeticException" also it is it is showing output as "Error : cannot devided by zero".
 * 
 * 
 * 1. throw
Purpose: Used to explicitly throw an exception from a method or block of code.
Usage: Inside the method body.
Exception Object: Requires an instance of a subclass of Throwable to be thrown.
Scope: Immediate; it interrupts the normal flow of execution.

Example:
public class ThrowExample {
    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void checkNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be non-negative."); // Explicitly throwing an exception
        }
    }
}


2. throws
Purpose: Used in the method signature to declare exceptions that the method might throw.
Usage: In the method declaration.
Exception Declaration: Specifies the type of exceptions a method might throw.
Scope: Informative; it alerts the calling method to handle or declare the exception.

Example:
public class ThrowsExample {
    public static void main(String[] args) {
        try {
            riskyMethod(); // Must handle or propagate the exception
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // Declaring that this method might throw an exception
    public static void riskyMethod() throws Exception {
        throw new Exception("Something went wrong."); // Exception is actually thrown here
    }
}

When to Use:
Use throw: When you need to throw an exception explicitly.
Use throws: When you need to inform the caller that your method might throw an exception, enabling the caller to handle or propagate it.
 */

