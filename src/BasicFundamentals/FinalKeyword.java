package BasicFundamentals;

public class FinalKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
 * Final Classes
A class declared as final cannot be subclassed. This is useful for creating immutable classes or for 
security reasons to prevent alteration of the class's behavior through inheritance.
public final class ImmutableClass {
    private final int value;

    public ImmutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
------------------------------
Final Methods
A method declared as final cannot be overridden by subclasses. This is useful for preventing alteration 
of the method's behavior in subclasses.
public class BaseClass {
    public final void display() {
        System.out.println("This is a final method.");
    }
}

public class DerivedClass extends BaseClass {
    // This would cause a compile-time error
    // public void display() {
    //     System.out.println("Attempting to override.");
    // }
}
----------------------------------------
Final Variables
Variables declared as final cannot be reassigned once they are initialized. This is useful for creating 
constants or ensuring that a variable's value remains constant throughout its lifetime.
public class MyClass {
    private final int maxValue;

    public MyClass(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
------------------------------------------

 */
