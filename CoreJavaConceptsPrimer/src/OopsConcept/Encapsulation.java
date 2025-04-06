package OopsConcept;

//creating a public Person class
/*if we will give like below statement
 * public class Person {
 * 
 * }
 * then we will get below error
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The public type Person must be defined in its own file
	at OopsConcept.Person.<init>(Encapsulation.java:4)
	at OopsConcept.Encapsulation.main(Encapsulation.java:51)
	
	The error you're seeing is because in Java, each public class must be defined in its 
	own file with the same name as the class. This means you need to separate the 
	Person class and the Encapsulation class into two different files.
    Here is how you can organize your code:
    Person.java (defines the Person class)  
    Encapsulation.java (contains the main method)
*/

/*
 * 
Question:
Implement a Java program to demonstrate encapsulation by following these steps:

Class (Person):
Create a class Person with private fields name and age.
Add a public constructor to initialize the fields. Ensure the age is positive; otherwise, print an error message.
Provide getter and setter methods for the name and age fields. Ensure the setter for age checks for positive values.
Add a method displayInfo() to print the person's details.
Main Class (Encapsulation):

In the main method, create instances of Person and demonstrate setting and getting the name and age fields.
Show the use of displayInfo() to print the person's details.
Test the validation logic for the age field by attempting to set a negative value.
 */
class Person {
	
	//private fields(attribute) of Person class
	private String name;
	private int age;
	
	//public constructor to create a new person object
	public Person(String name,  int age) {
		this.name = name;
		if (age > 0) {
			this.age = age;	
		} else {
			System.out.println("please enter valid age");
		}
	}
	
	//this getter method will return name attribute
	String getName() {
		return name;
	}
	//COMMENT OUT ONE BY ONE AND CHECK WHAT ERROR YOU ARE GETTING
	//PRIVATE WILL NOT WORK HERE BECAYSE THIS GETNAME METHOD IN PERSON CLASS AND YOU ARE TRYING TO
	//ACCESS IT FROM MAIN CLASS 
	/*protected String getName() {
		return name;
	}*/
	
	/*private String getName() {
		return name;
	}*/
	//this setter method will set name attribute
	public void setName(String name) {
		this.name = name;
	}
	
	//this getter method will return age attribute
	public int getAge() {
		return age;
	}
	
	//this setter method will set age attribute
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;	
		} else {
			System.out.println("please enter valid age");
		}
	}
	
	// Method to display the person's details
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
}

public class Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person("Abhinash Singh", 24);
		
		person.displayInfo();
		
		person.setName("Anup Singh");
		person.displayInfo();
		
		person.setAge(20);
		person.displayInfo();
		
		person.setName("Sushil Singh");
		person.setAge(30);
		person.displayInfo();
		
		int sushilAge = person.getAge();
		String sushilName = person.getName();
		
		System.out.println("name : " + sushilName + " age : " + sushilAge);
		
		Person person1 = new Person("Abhinash Singh", -3);
		person1.displayInfo();
		Animal animal = new Animal("Maxi");
		System.out.println("animal name is -> " + animal.getAnimalName());
	}
	
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
Key Points to Remember about Encapsulation in OOP:
Definition:

Encapsulation is one of the fundamental principles of object-oriented programming (OOP). 
It involves bundling the data (variables) and the methods (functions) that operate on the 
data into a single unit, or class.
Binding data and methods into single unit.
It restricts direct access to some of an object's components, which means that the 
internal representation of an object is hidden from the outside.

Access Modifiers:
Private: Fields are declared private to prevent direct access from outside the class.
Public: Methods (getters and setters) are usually public to allow controlled access to 
the private fields.

Getters and Setters:
Getters: Methods that return the value of a private field.
Setters: Methods that set or update the value of a private field, often with validation 
checks.

Advantages:
Improves Modularity: Encapsulation allows individual parts of the program to be developed, 
tested, and maintained separately.
Enhances Security: By restricting access to the internal state of an object, encapsulation 
protects the object from unintended interference and misuse.
Facilitates Maintenance and Flexibility: Changes to the internal implementation of a 
class can be made with minimal impact on the rest of the program.

*/
/*CONSTRUCTOR 
 * Purpose:

The primary purpose of a constructor is to initialize the newly created object.
Name:

The name of the constructor must be the same as the class name.
No Return Type:

Constructors do not have a return type, not even void.
Types of Constructors:

Default Constructor: A constructor with no parameters.
Parameterized Constructor: A constructor that takes one or more parameters.
Default Constructor Provided by Compiler:

If no constructor is explicitly defined in a class, the Java compiler provides a default no-argument constructor.
Overloading Constructors:

A class can have multiple constructors with different parameter lists (constructor overloading). This allows the creation of objects in different ways.
Calling Another Constructor:

Within a constructor, you can call another constructor of the same class using the this keyword. This is known as constructor chaining.
Superclass Constructor:

The constructor of a subclass can call a constructor of its superclass using the super keyword.
Initialization Blocks:

Initialization blocks can be used for common initialization code shared by all constructors.
Access Modifiers:

Constructors can have access modifiers (public, protected, private, or package-private) to control the visibility of the constructor.
 */