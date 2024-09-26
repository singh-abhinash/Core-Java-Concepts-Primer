package Reflection;

public class NewPerson implements PersonInterface{
	private String name;
	private int age;
	
	//public constructor
	public NewPerson() {
		this.name = "Default constructor";
		this.age = -1;
	}
	
	//private constructor -> Using reflection to bypass access control and invoke the private constructor
	private NewPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	
	private void printDetails() {
		System.out.println("Name is -> " + name + ", Age is -> " + age);
	}
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
In Java, making a constructor private restricts the instantiation of the class from outside of that class. 
However, through reflection, it is possible to invoke a private constructor and create an instance of the class.

Let’s modify the Person class to make one of the constructors private and then use reflection to invoke it.

Step-by-Step Example:
Make the constructor private.
Use reflection to bypass access control and invoke the private constructor.
*/
