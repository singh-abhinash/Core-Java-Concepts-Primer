package OopsConcept;

/*class Animals {
	public void play() {
		System.out.println("Animal is playing");
	}
	
	public void eat() {
		System.out.println("Animal is sleeping");
	}
}

class Cats extends Animals {
	public void play() {
		System.out.println("cat is playing");
	}
}
public class IsARelationship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animals obj = new Cats();
		obj.play();
	}

}*/


interface Pet {
    public void play();
}

class Rat implements Pet {
	@Override
    public void play() {
        System.out.println("The rat plays.");
    }
}

public class IsARelationship {
    public static void main(String[] args) {
    	Pet p = new Rat();
        p.play();
        Rat rat = new Rat();
        rat.play();
    }
}

/*
 * Is-a Relationship (IS-A relationship is not association)
The "is-a" relationship represents inheritance or implementation and is a way to establish a 
parent-child relationship between classes. It is characterized by the extends keyword for 
classes and the implements keyword for interfaces. It implies that the child class (subclass) 
is a type of the parent class (superclass).

Inheritance (extends)
Inheritance is used when a class derives from another class, inheriting its fields and methods.

Interface Implementation (implements)
An interface implementation defines a contract that a class must follow.

Represented by inheritance (extends) or interface implementation (implements).
Models a parent-child relationship.
Example: Dog extends Animal (Dog is an Animal), Cat implements Pet (Cat is a Pet).
*/
