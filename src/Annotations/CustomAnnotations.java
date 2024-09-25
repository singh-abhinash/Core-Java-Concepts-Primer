/*
 * Question:
 * 
 * Create a custom annotation in Java called @MyAnnotation that can be applied to methods. The annotation should 
 * have two elements:
 * 		value of type String with a default value of "Default Value".
 * 		number of type int with a default value of 1.
 * 
 * Then, apply this annotation to two methods:
 * 		One method should override the default values.
 * 		The other method should use the default values.
 * 
 * Additionally, use reflection to check if a method is annotated with @MyAnnotation and print the values of the 
 * annotation elements.
 * 
 * Write the complete Java code for this problem, including defining the custom annotation and using reflection to 
 * process it at runtime.
 */

package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CustomAnnotations {
	
	// Defining a custom annotation that can be applied to methods
	@Target(ElementType.METHOD)  // Specifies that the annotation is applied for methods
	@Retention(RetentionPolicy.RUNTIME)  // Specifies that the annotation will be available at runtime means reflection is possible
	public @interface MyAnnotation {
	    String value() default "Default Value";  // Annotation element with a default value
	    int number() default 1;                  // Another annotation element with a default value
	}
	
	// Applied the custom annotation to a method
	@MyAnnotation(value = "Custom Value", number = 5)
	public void customMethod() {
		System.out.println("This is custom annotation");
		System.out.println("+++++++++++++++++++++++++++++");
	}
	
	// Applied the custom annotation using default values
    @MyAnnotation
	public void defaultMethod() {
		System.out.println("This is default annotation");
		System.out.println("++++++++++++++++++++++++++++++++");
	}
    
    //creating one method without custom annotation
    private void withoutCustomAnnotation() {
    	System.out.println("Not using custom annotation");
    	System.out.println("+++++++++++++++++++++++++++++++++");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomAnnotations annotationObject = new CustomAnnotations();
		annotationObject.customMethod();
		annotationObject.defaultMethod();
		annotationObject.withoutCustomAnnotation();
		
		// Reflection method to process the annotation and getting all methods of the class
		Method[] methods = annotationObject.getClass().getDeclaredMethods();
		
		for (Method method : methods) {
			/*
			 * Class Object Representation:
			 * MyAnnotation.class refers to the Class object for the MyAnnotation annotation.
			 * This Class object is used by the Java reflection API to inspect the metadata of methods, classes, 
			 * or fields.
			 */
			// Check if the method has the custom annotation
			if (method.isAnnotationPresent(MyAnnotation.class)) {
				System.out.println("*****Inside if condition when annotation is present on the method*****");
				MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
				System.out.println("Method name : " + method.getName());
				System.out.println("Method modifier type : " + Modifier.toString(method.getModifiers()));
				System.out.println("Method return type : " + method.getReturnType());
				if (annotation != null) {
					System.out.println("*****Inside annotation != null conditionwhich is checking whether annotation is present or not above that method*****");
					System.out.println("Annotation value : " + annotation.value());
					System.out.println("Annotation value : " + annotation.number());	
				}
			} else {
				System.out.println("*****Inside else condition when annotation is not present on the method*****");
				MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
				System.out.println("Method name : " + method.getName());
				System.out.println("Method modifier type : " + Modifier.toString(method.getModifiers()));
				System.out.println("Method return type : " + method.getReturnType());
				if (annotation != null) {
					System.out.println("*****Inside annotation != null conditionwhich is checking whether annotation is present or not above that method*****");
					System.out.println("Annotation value : " + annotation.value());
					System.out.println("Annotation value : " + annotation.number());	
				}
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	}

}
