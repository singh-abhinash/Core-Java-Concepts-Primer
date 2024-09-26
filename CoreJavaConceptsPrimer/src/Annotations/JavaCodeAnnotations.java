package Annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//The @FunctionalInterface annotation is used to indicate that an interface is intended to be a functional interface. 
//Functional interfaces have exactly one abstract method and can be used as the target for lambda expressions or method 
//references.

@FunctionalInterface
interface Bird {
	void canEat();
	//uncomment below statement and see what will happen
	//void canFly();
}

interface OldCalculator {
	int add(int a, int b);
	int sum(int a, int b);
}

class Calculator implements OldCalculator {
	@Deprecated
	//The @Deprecated annotation indicates that a method, field, or class should no longer be used, and it's often 
	//accompanied by comments explaining the alternative.
	public int add(int a, int b) {
		return a + b;
	}
	
	public int sum(int a, int b) {
		return a + b;
	}
}

class Parent{
	public void display() {
		System.out.println("this is inside Parent class");
	}
}

class Child extends Parent {
	@Override
	//The @Override annotation is used to indicate that a method overrides a method in a superclass.
	public void display() {
		System.out.println("this is inside Child class");
	}
}

@SuppressWarnings("all")
//either we can use @SuppressWarnings("all") which will suppress all types of warnings we are getting
//or we can use separate separate annotation for each warning @SuppressWarnings("unchecked"), @SuppressWarnings("rawtypes")
//@SuppressWarnings("unused")
class CheckingSupressAnnotaion {
	//@SuppressWarnings("unused")
	//The @SuppressWarnings annotation is used to suppress compiler warnings for certain operations, like unchecked 
	//unused, (all).....type operations.
	public void applySupressAnnotation() {
		int x;
	}
	//@SuppressWarnings("unchecked")
	public void addElements() {
        //@SuppressWarnings("rawtypes")
		List rawList = new ArrayList(); // Raw use of generics
        rawList.add("Hello");
        rawList.add(100);
    }
}

class CheckSafevarargs {
	//READ ABOUT HEAP POLLUTION IN @Safevarargs annotation
		//below is actually heap polluted example in which we will use @SafeVarargs annotation so that it will not show warning 
		//related to heap pollution but we should not use because it will not show any warning message during compile
		//time and during runtime it will throw error.
		//We should always use @SafeVarargs annotation when we are 100% sure it is not heap polluted and it will give 
		//result during runtime.
		//if we will hover mouse on 78 statement lists then it will throw warnings that
		//Type safety: Potential heap pollution via varargs parameter lists and also it will show some fix to prevent
		//from this warning like use @SafeVarargs or use @SuppressWarnings...etc
		
		
		//Once we will put @SafeVarargs annotation we are not able to see any warnings. So make sure we should use this
		//annotation when we are confimed that it will not throw any error during runtime.
		@SafeVarargs
	 	public static void printAllIntegerElements(List<Integer>...lists) {
	 		Object[] integerValueList = lists;
	 		List<String> newStringList = Arrays.asList("Ram","Shyam","ghanshyam");
	 		integerValueList[0] = newStringList;
	 	}
		
		/*
		 *BELOW STATEMENT WILL THROW ERROR BECAUSE WE ARE USING List<T> WHICH WILL TAKE SAME TYPE OF LIST
		 *USE LIKE STAteMENT 107
		@SafeVarargs
	 	public static <T> void printAllElements(List<T>...lists) {
			for (List<? extends T> list : lists) {
				for (T element : list) {
					System.out.println(element);
				}
			}
	 	}
		*/
		
		
		
		@SafeVarargs
	 	public static <T> void printAllElements(List<? extends T>...lists) {
			for (List<? extends T> list : lists) {
				for (T element : list) {
					System.out.println(element);
				}
			}
	 	}
}



public class JavaCodeAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Double> prices = Arrays.asList(10.99, 20.99, 30.99);

        // Calling the @SafeVarargs method
        CheckSafevarargs.printAllElements(fruits, numbers, prices); // Safe usage of varargs
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
     // Using @Deprecated method (will show a warning)
        Calculator oldCalc = new Calculator();
        int deprecatedResult = oldCalc.add(10, 5); // Deprecated usage
        //method is deprecated but still it is printing how?
        System.out.println("Deprecated method result: " + deprecatedResult);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        // Using @Override annotation
        Parent child = new Child();
        child.display(); // Output from Child class
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        // Using @SuppressWarnings to suppress unchecked operations
        CheckingSupressAnnotaion warningExample = new CheckingSupressAnnotaion();
        warningExample.addElements(); // No unchecked warning
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
