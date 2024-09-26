/*
 * Question:
Implement a Java program to demonstrate multilevel inheritance by following these steps:
Base Class (Animal):
The Animal class has a private field name, a constructor to initialize the name, 
and two methods: eat and sleep.

Derived Class (Dog):
The Dog class extends the Animal class, inheriting its fields and methods.
The Dog class adds an additional field breed and a method bark.
The Dog constructor calls the superclass constructor using super(name) to 
initialize the inherited name field.

Further Derived Class (Puppy):
The Puppy class extends the Dog class, inheriting its fields and methods.
The Puppy class adds an additional field age and a method play.
The Puppy constructor calls the superclass constructor using super(name, breed) 
to initialize the inherited name and breed fields.

Main Class (MultilevelInheritanceExample):
In the main method, an instance of Puppy is created.
The inherited methods eat, sleep, and bark are called on the Puppy instance.
The play method, which is specific to the Puppy class, is also called.
Additional attributes (breed and age) are displayed using their respective getter methods.
 */
package OopsConcept;

//base class or super class or parent class
class Animal {
	private String name;
	
	//Constructor to set animal name
	public Animal(String name) {
		this.name = name;
	}
	
	//getter method to return animal name
	public String getAnimalName() {
		return name;
	}
	
	public void eat() {
		System.out.println(name + " could be vagan and non vegan");
	}
	
	public void sleep() {
		System.out.println(name + " can sleep anytime");
	}
}

//derived class or sub class or child class
class Dog extends Animal {
	private String breed;
	
	public Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	public void bark() {
		System.out.println(breed + " " + getAnimalName() +" bark very loudly");
	}
	
	public String getBreed() {
        return breed;
    }
}

class Cat extends Animal {
	private String breed;
	
	public Cat(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	public void meow() {
		System.out.println(breed + " " + getAnimalName() +" meowing");
	}
	
	public String getBreed() {
        return breed;
    }
}

class Puppy extends Dog {
	private int age;
	
	public Puppy(String name, String breed, int age) {
		super(name, breed);
		this.age = age;
	}
	
	public void play() {
		System.out.println(getBreed() + " " + getAnimalName() + " is playing and age is " + age);
	}
}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal1 = new Dog("Goldiee", "Rot Whieler");
		//dog1.bark(); -> this will throw error because this method is not defined in 
		//Animal class
		System.out.println("animal name is -> " + animal1.getAnimalName());
		animal1.eat();
		animal1.sleep();
		
		Animal animal2 = new Cat("silver", "American Cat");
		System.out.println("animal name is -> " + animal2.getAnimalName());
		animal2.eat();
		animal2.sleep();
		
		Animal animal3 = new Puppy("Gold", "Golden Retriever", 1);
		System.out.println("animal name is -> " + animal3.getAnimalName());
		animal3.eat();
		animal3.sleep();
		
		Animal animal = new Animal("Maxi");
		System.out.println("animal name is -> " + animal.getAnimalName());
		Person person1 = new Person("Abhinash Singh", -3);
		System.out.println("person name -> " + person1.getName());
		animal3.eat();
		animal3.sleep();
		//todo -> if you have any doubt you can check with some example like above
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * *
Capability of a class to inherit properties from their parent class.
* It can inherit both functions and variables so that we don't
have for write them again in the child class .
* Can be achieved using extends keyword or through interface .
* Types of inheritance : -
-
Single Inheritance
-
Multilevel Inheritance
-
Hierarchical Inheritance
-
Multiple Inheritance (Not actually supported by Java due
to diamond problem but through interface , we can solve
the Diamond problem.
* Advantages Of Inheritance
-
Code reusability - We can achieve polymorphism using inheritance
 */
