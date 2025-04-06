package ExceptionHandling;

public class ExceptionExample {

	public static void main(String[] args) {
		ExceptionExample obj = new ExceptionExample();
		/**
		 *UNCOMMENT BELOW STATEMENTS AND SEE THE ERRORS OR EXCEPTIONS
		 */
		//obj.method1();
		//obj.outOfMemoryErrorExample();
		//obj.StackOverflowErrorExample();
		//obj.classCastExceptionExample();
		//obj.arithmaticExceptionExample();
		obj.arrayIndexOutOfBoundExceptionExample();
		//obj.stringIndexOutOfBoundExceptionExample();
		//obj.nullPointerExceptionExample();
		//obj.illegalArgumentExceptionExample();
		
	    /**
		 * Below statement will throw error. Cannot make a static reference to the non-static method method1() from 
		 * the type ExceptionExample.
		 * 
		 * method1();
		 */
	}
	
	private void method1() {
		method2();
	}
	
	private void method2() {
		method3();
	}
	
	private void method3() {
		int num = 3/0;
	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//############################################################################################################

//ERRORS AND IT'S EXAMPLE:
	
	/**
	 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	 * at ExceptionHandling.ExceptionExample.outOfMemoryErrorExample(ExceptionExample.java:38)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:8)
	 * 
	 * BELOW CODE WILL THROW ABOVE ERROR
	 */
	public void outOfMemoryErrorExample() {
		String[] example = new String[900000000*900000000*900000000];
	}
	
	/**
	 * It will throw StackOverflowError
	 */
	public void StackOverflowErrorExample() {
		int count = 0;
		while (true) {
			count = count + 1;
		}
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//############################################################################################################

//-> UNCHECKED/RUNTIME EXCEPTIONS AND IT'S EXAMPLE:
	
	//ClassCastException
	/**
	 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	 * Cannot cast from int to String
	 * at ExceptionHandling.ExceptionExample.classCastExceptionExample(ExceptionExample.java:56)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:10)

	 */
	public void classCastExceptionExample() {
		int num = 5;
		//uncomment below and see run the program
		//System.out.println("string value is : " + (String)num);
	}
	
	
	//ArithmaticException
	/**
	 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	 * at ExceptionHandling.ExceptionExample.arithmaticExceptionExample(ExceptionExample.java:71)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:11)
	 */
	public void arithmaticExceptionExample() {
		int num = 5/0;
	}
	
	//ArrayIndexOutOfBoundException
	/**
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	 * at ExceptionHandling.ExceptionExample.arrayIndexOutOfBoundExceptionExample(ExceptionExample.java:84)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:12)
	 */
	public void arrayIndexOutOfBoundExceptionExample() {
		int[] val = new int[2];
		System.out.println("value at index 3 :" + val[3]);
	}
	
	//StringIndexOutOfBoundException
	/**
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	 * at ExceptionHandling.ExceptionExample.stringIndexOutOfBoundExceptionExample(ExceptionExample.java:95)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:13)
	 */
	public void stringIndexOutOfBoundExceptionExample() {
		String val = "Abhi";
		System.out.println("value at index 3 :" + val.charAt(4));
	}
	
	//NullPointerException
	/**
	 * Exception in thread "main" java.lang.NullPointerException
	 * at ExceptionHandling.ExceptionExample.nullPointerExceptionExample(ExceptionExample.java:107)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:14)
	 */
	public void nullPointerExceptionExample() {
		String val = null;
		System.out.println("it will throw null pointer :" + val.charAt(1));
	}
	
	//IllegalArgumentException
	/**
	 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	 * String literal is not properly closed by a double-quote
	 * at ExceptionHandling.ExceptionExample.illegalArgumentExceptionExample(ExceptionExample.java:118)
	 * at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:15)
	 */
	public void illegalArgumentExceptionExample() {
		//uncomment below staement and see the exception
		//int val = Integer.parseInt("abc");
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//#######################################################################################################

//-> CHECKED/COMPILE TIME EXCEPTION: CLASS NOT FOUND EXCEPTION, SYNTAX ERROR

	//************IMPORTANT******************
/**
 * QUESTIONS -> WHAT IS THROWS?
 * ANSWER -> IT TELLS THAT THIS METHOD MIGHT THROW THIS EXCEPTION OR MIGHT NOT SO PLEASE GO TO CALLER METHOD 
 * AND THAT CALLER METHOD WILL HANDLE IT.	
 */

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * If we will run above code we will get Exception like:
 * 
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at ExceptionHandling.ExceptionExample.method3(ExceptionExample.java:26)
	at ExceptionHandling.ExceptionExample.method2(ExceptionExample.java:22)
	at ExceptionHandling.ExceptionExample.method1(ExceptionExample.java:18)
	at ExceptionHandling.ExceptionExample.main(ExceptionExample.java:7)
	
 * Whenever we will get any exception we will get 3 things:
 * 1) Exception Type : In the above exception, exception type is "java.lang.ArithmeticException".
 * 2) Exception Message : In the above exception, exception message is "/ by zero".
 * 3) Stacktrace : The Place from where exception started and till the place where actual exception handle.
 * In above example started at 26 and handled at 7.
 */
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Question -> Difference between Errors and Exception?
 * Answer -> Errors can be handle by JVM. We cannot handle it. Error is a type of unchecked/runtime error
 * Example -> OutOfMemoryError(Heap memory out of flow), StackOverflowError(stack memory out of flow), 
 * InternalError, VirtualMachineError
 * 
 * Exception is of two types:
 * 1) checked/compile time
 * 2) unchecked/runtime
 * 
 */
