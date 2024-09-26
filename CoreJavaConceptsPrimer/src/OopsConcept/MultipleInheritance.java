/*
 * Multiple Inheritance is a feature of an object-oriented concept, where a class can 
 * inherit properties of more than one parent class. The problem occurs when there 
 * exist methods with the same signature in both the superclasses and subclass. 
 * On calling the method, the compiler cannot determine which class method to be called 
 * and even on calling which class method gets the priority. 

Note: Java doesn’t support Multiple Inheritance. Multiple inheritance is not supported 
in Java because it can lead to ambiguity and complexity, commonly referred to 
as the "Diamond Problem."
 */
package OopsConcept;

class A {
	public void motivation() {
		System.out.println("never give up");
	}
}

class B {
	public void motivation() {
		System.out.println("never demotivate");
	}
}

/*class C extends A, B {//not allowed due to extending two class
	public void confidence() {
		System.out.println("confident");
	}
}*/

public class MultipleInheritance {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*C obj = new C();
		obj.motivation();*/
		
		
		System.out.println("uncomment class C(26) and C obj(36) to see the error due to extending A, B in class C");
				
				
		///here it will confuse that which method needs to call
		//whether its class A or class B....so compiler will confuse
		//that is why mutiple inheritence is not possible
	}

}

/*
 * In Java, multiple inheritance is achieved through interfaces. This allows a 
 * class to inherit from multiple sources while avoiding the complexities and ambiguities 
 * associated with multiple inheritance of classes. Below is an example that demonstrates 
 * how to use multiple interfaces to achieve multiple inheritance in Java:
 */
