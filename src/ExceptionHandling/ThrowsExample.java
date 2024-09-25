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
 */

