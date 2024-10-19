package BasicFundamentals;

//Superclass (Airplane)
class Airplane {
	String planeName = "Boeing";  // Superclass field

	// Superclass constructor
	Airplane(String planeName) {
		this.planeName = planeName;
		System.out.println("Aeroplane Constructor: " + planeName);
	}

	// Superclass method
	void makeSound() {
		System.out.println("Aeroplane makes sound");
	}
}

//Subclass (FighterPlane)
class FighterPlane extends Airplane {
	String planeName = "SGF54";  // Subclass field
	int manufacturedYear;

	// Subclass constructor
	FighterPlane(String planeName, int manufacturedYear) {
		super(planeName);  // Calls Airplane's constructor
		this.manufacturedYear = manufacturedYear;
		System.out.println("FighterPlane Constructor: " + this.planeName + ", manufacturedYear: " + this.manufacturedYear);
	}

	// Subclass method overriding the superclass method
	@Override
	void makeSound() {
		super.makeSound();  // Calls Airplane's makeSound()
		System.out.println("Fighterplane also make sound");
	}

	// Method to print both superclass and subclass fields
	void printNames() {
		System.out.println("Subclass name: " + planeName);         // Subclass field
		System.out.println("Superclass name: " + super.planeName); // Superclass field using 'super'
	}
}

//Main class to demonstrate all uses of super
public class SuperKeywordExample {
	
	
	public static void main(String[] args) {
		// Create a Fighter plane object
		FighterPlane fplane = new FighterPlane("SURYA65", 2008);

		// Call the overridden method
		fplane.makeSound();

		// Access fields from both subclass and superclass
		fplane.printNames();
	}
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * The super keyword in Java is used in object-oriented programming to refer to the superclass (parent class) 
 * of the current object. It allows the subclass to access properties, methods, and constructors of its 
 * superclass. Here are the main reasons why we use the super keyword:
 * 
 * Summary of super Usage:
 * Calling Superclass Constructor: super() is used to invoke a constructor in the superclass. It’s often 
 * necessary when the superclass has custom constructors that require initialization.
 * 
 * Calling Superclass Method: super.methodName() allows a subclass to call a method from its superclass, 
 * often to extend or reuse the original behavior.
 * 
 * Accessing Superclass Fields: super.fieldName is used to reference a field in the superclass if the 
 * subclass has a field with the same name (field shadowing).
 * 
 * Overall Flow in Subclasses:
 * Constructors: The subclass can use super() to call and initialize the parent class’s constructor.
 * Methods: The subclass can override parent methods and use super.method() to invoke the original behavior.
 * Fields: The subclass can access parent class fields using super.field even if it shadows the field with the same name.
 * 
 * Using super ensures that subclasses can effectively inherit functionality, customize it, and maintain 
 * clarity in their interactions with the parent class, preserving the integrity of the object-oriented 
 * structure.
 */

