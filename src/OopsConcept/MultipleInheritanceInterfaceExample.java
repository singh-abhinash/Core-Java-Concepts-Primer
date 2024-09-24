package OopsConcept;

//Define the first interface
interface CanFly {
	public void fly();
}

//Define the second interface
interface CanSwim {
	public void swim();
}

//Define a class that implements both interfaces
class Duck implements CanFly, CanSwim {
	@Override
	public void fly() {
		System.out.println("Duck is flying");
 }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
 }
 
}

//Main class to test the multiple inheritance example
public class MultipleInheritanceInterfaceExample {
	
	public static void main(String[] args) {
		Duck duck = new Duck();
		duck.fly();  // Output: Duck is flying
		duck.swim(); // Output: Duck is swimming
 }
}

