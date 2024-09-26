/*
 * Question:
Implement a Java program to demonstrate abstraction by following these steps:

Abstract Class (Shape):
Create an abstract class Shape with an abstract method area().
Add a method displayArea() that prints the area of the shape by calling the area() method.
Concrete Class (Circle):

Create a class Circle that extends Shape.
Add a private field radius and a constructor to initialize it.
Implement the area() method to calculate the area of the circle.
Concrete Class (Rectangle):

Create a class Rectangle that extends Shape.
Add private fields length and breadth, and a constructor to initialize them.
Implement the area() method to calculate the area of the rectangle.
Main Class (DataAbstraction):

In the main method, create instances of Circle and Rectangle.
Call the area() method on each instance and print the result.
Use the displayArea() method on instances of Circle and Rectangle created using the Shape reference type.
 */

package OopsConcept;

//abstract class  to represent generic shape
abstract class Shape {
	//abstract method area which will be implemented by subclass
	public abstract double area();
	
	//method to display area 
	public void displayArea() {
		System.out.println("Area is : " + area());
	}
}

//concrete class Circle that extends Shape
class Circle extends Shape {
	private double radius;
	
	//created Circle constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//implementation of abstract method
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
}

//concrete class Circle that extends Shape
class Rectangle extends Shape {
	private double length;
	private double breadth;
	
	//created Rectangle constructor
	public Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	//implementation of abstract method
	@Override
	public double area() {
		return length * breadth;
	}
	
}

public class DataAbstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle obj = new Circle(5);
		Rectangle obj1 = new Rectangle(3, 4);
		
		double x = obj.area();
		System.out.println("area of circle : " + x);
		
		double y = obj1.area();
		System.out.println("area of rectangle : " + y);
		
		Shape circle = new Circle(7);//this is called upcasting
		//Upcasting is the process of casting a subclass object to a superclass reference. 
		//In the statement -> Shape circle = new Circle();, Circle is a subclass of Shape, 
		//and the object of Circle is being referenced by a variable of type Shape.
		Shape rectangle = new Rectangle(10, 20);
		
		circle.displayArea();
		rectangle.displayArea();
		
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * 
Abstract Classes:
Use the abstract keyword to declare a class as abstract.
Can have both abstract methods (without body) and concrete methods (with body).
Provide a common base class for other classes to extend.

Interfaces:
Use the interface keyword to declare an interface.
Can only have abstract methods (until Java 8, which introduced default and static methods 
in interfaces).
Allow classes to implement multiple interfaces, enabling multiple inheritance.

Why Use Upcasting?
1) Polymorphism: It allows you to use polymorphism, where a single variable of a parent 
type can refer to objects of multiple child types. This makes your code more flexible and 
extensible.
2) Code Generalization: It enables writing more generic and reusable code. For example, you 
can write methods that operate on Parent type references, and those methods can work with 
any subclass of Parent.

EXAMPLE ->
Parent obj = new Child();

Let's break down this statement:

-> Parent obj: This declares a reference variable named obj of type Parent.
-> new Child(): This creates a new object of type Child.
-> =: This assigns the newly created Child object to the Parent reference variable obj.
-> The reference type is Parent and The object type is Child.

What Happens Internally : 

1) Type of the Reference Variable (Parent obj):
	-> The type of the reference variable (Parent) determines what methods can be called on the 
object.
	-> obj can only call methods that are defined in the Parent class (or inherited from its 
ancestors).
2) Type of the Actual Object (new Child()):
	-> The type of the actual object created is Child.
	-> The methods that are executed when obj calls a method are determined by the type of 
	the actual object, not the reference type. This means that if the method show() is 
	overridden in Child, the overridden version in Child will be executed.
 */
