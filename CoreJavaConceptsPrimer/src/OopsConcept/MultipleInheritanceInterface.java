/*package OopsConcept;

interface A {
	void display();
}

interface B {
	void display();
}

interface C implements A, B {
	@Override
	public void display() {
		System.out.println("we can achieve multiple inheritance by declaring display mehtod in A and B and defining in C");
	}
}
above code will throw error because Interfaces Can't Extend Other Interfaces with 
 * the implements Keyword: Interfaces extend other interfaces using the extends 
 * keyword, not implements.

class C implements A, B {
	
	@Override
	public void display() {
		System.out.println("we can achieve multiple inheritance by declaring display mehtod in A and B and defining in C");
	}
}

public class MultipleInheritanceInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
package OopsConcept;

/*// Define interface A
interface A {
    public void display();
}

// Define interface B
interface B {
    public void display();
}*/

//Define interface D
interface D {
 public void display();
}

//Define interface E
interface E {
 public void display();
}

// Class C implements both A and B
class C implements D, E {
    // Provide implementation for the display method
    @Override
    public void display() {
        System.out.println("We can achieve multiple inheritance by defining the display method in A and B and implementing it in C");
        System.out.println("Uncomment line 40 to 48 and see you will get error because we already defined A and B class in MultipleInheritance.java class");
    }
    
    public void displayA() {
        System.out.println("display interface A");
    }
    
    public void displayB() {
        System.out.println("display interface B");
    }
}

public class MultipleInheritanceInterface {
	
    public static void main(String[] args) {
        // Create an instance of class C
        C obj = new C();
        obj.display(); // This will call the display method implemented in class C
        obj.displayA();
        obj.displayB();
    }
}
