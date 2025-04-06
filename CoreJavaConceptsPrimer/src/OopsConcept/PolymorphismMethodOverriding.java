package OopsConcept;

class Parent {
    void show() {
        System.out.println("Parent's show");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child's show");
    }

    void childSpecificMethod() {
        System.out.println("Child's specific method");
    }
}


public class PolymorphismMethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent obj = new Child();  // Upcasting
        obj.show();                // Calls Child's overridden show() method
        
        //***VERY IMPORTANT
        //obj.childSpecificMethod(); // Compile-time error
        
        Child obj1 = new Child();
        obj1.show();
        obj1.childSpecificMethod();
        Parent obj3 = new Parent();
        obj3.show();
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * QUESTION -> Even though the actual object is of type Child, you cannot call methods 
 * that are specific to the Child class (like childSpecificMethod()) directly using the 
 * Parent reference....why? or why obj.childSpecificMethod() is throwing compile time error?
 * 
 * ANSWER -> The reason you cannot call methods that are specific to the Child class 
 * (like childSpecificMethod()) using a Parent reference is due to how type checking and 
 * method resolution work in Java.
 * 
 * Detailed Explanation:
 * Compile-Time Type Checking ->
 * Java performs type checking at compile time. When you declare a reference variable of type 
 * Parent, the compiler only knows about the methods that are defined in the Parent class or 
 * its ancestors. It does not have information about methods that are defined in the 
 * Child class.
 * 
 * Reference Type vs. Object Type ->
 * Reference Type: This is the type used when declaring the variable. In Parent obj = new Child();, 
 * the reference type is Parent.
 * Object Type: This is the actual type of the object that the reference points to. 
 * In Parent obj = new Child();, the object type is Child.
 * 
 * The compiler uses the reference type to determine what methods can be called on the object. 
 * The actual method implementation that gets executed is determined at runtime based on the 
 * object type.
 * 
 * Key Differences
Aspect							Method Overloading							Method Overriding
Class							Same class									Subclass and superclass
Parameters						Different									Same
Return Type						Can differ									Must be the same or covariant
Access Modifier					No restrictions								Cannot be more restrictive
Binding							Compile-time (static)						Runtime (dynamic)
Annotations						Not required								Uses @Override for clarity
Polymorphism					Static polymorphism							Dynamic polymorphism

 */
