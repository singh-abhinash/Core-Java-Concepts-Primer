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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * ❌ Not Allowed: Multiple Class Inheritance

class A {
    void show() {
        System.out.println("A");
    }
}

class B {
    void show() {
        System.out.println("B");
    }
}

// ❌ This is illegal in Java
class C extends A, B {
    // Compilation error
}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

To resolve above issue - 1st way

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}

// Now class C implements both interfaces
class C implements A, B {
    // Must override show() to resolve conflict
    public void show() {
        System.out.println("C - resolving show() from A and B");
        A.super.show(); // Optional: call A's version
        B.super.show(); // Optional: call B's version
    }
}

✅ When is InterfaceName.super.method() required?

It is only required if:

You are implementing two or more interfaces that have default methods with the same signature,
and

You want to call one or both of those interface implementations inside the overriding method.

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

2nd way

✅ Using Interfaces with Abstract Methods

interface A {
    void show();  // method declaration
}

interface B {
    void show();  // same method declared
}

// Class C implements both interfaces
class C implements A, B {
    @Override
    public void show() {
        System.out.println("C - implementing show() from A and B");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}

✅ Output:

C - implementing show() from A and B

🧠 Key Notes:
Since both A and B declare the same method show(), there is no conflict — the method is just implemented once in C.

This is how multiple inheritance is safely achieved in Java through interfaces.


 */

