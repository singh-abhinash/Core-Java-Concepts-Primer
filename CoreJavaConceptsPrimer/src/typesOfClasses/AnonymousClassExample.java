package typesOfClasses;

public class AnonymousClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Anonymous class starts here
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running inside an anonymous class!");
            }
        };
        
        new Thread(task).start();
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Anonymous class is a class without a name that is declared and instantiated in a single expression. It is typically 
 * used when you need a one-time implementation of an interface or an abstract class.
 * 
 * ✅ Key Points
 * It does not have a name.
 * It is used where a class is needed only once.
 * It is usually declared inside a method or constructor.
 * It can extend a class or implement an interface.
 * It cannot have explicit constructors since it has no name.
 */