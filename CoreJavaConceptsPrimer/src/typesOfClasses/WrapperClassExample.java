package typesOfClasses;

public class WrapperClassExample {
    public static void main(String[] args) {
        
        // 1. Primitive data type
        int num = 10; 
        // This is a primitive data type in Java (int).

        // 2. Wrapping primitive int into Integer object
        Integer wrappedNum = Integer.valueOf(num); 
        // The primitive int is wrapped into an Integer object using the valueOf() method.
        // This is an example of wrapping or boxing (converting primitive to an object).

        // 3. Auto-boxing (Java automatically wraps primitive to object)
        Integer autoBoxedNum = num; 
        // Java automatically wraps the primitive int into an Integer object.
        // This is called auto-boxing (automatic conversion of primitive to wrapper class).

        // 4. Unwrapping Integer object to primitive int
        int unwrappedNum = wrappedNum.intValue(); 
        // The intValue() method is used to unwrap the Integer object back into a primitive int.
        // This is an example of unwrapping or unboxing (converting object to primitive).

        // 5. Auto-unboxing (Java automatically unwraps object to primitive)
        int autoUnboxedNum = unwrappedNum; 
        // Java automatically unwraps the Integer object into a primitive int.
        // This is called auto-unboxing (automatic conversion of wrapper class to primitive).

        // 6. Printing out the results
        System.out.println("Primitive int: " + num);
        // Output: Primitive int: 10

        System.out.println("Wrapped Integer object: " + wrappedNum);
        // Output: Wrapped Integer object: 10

        System.out.println("Auto-boxed Integer: " + autoBoxedNum);
        // Output: Auto-boxed Integer: 10

        System.out.println("Unwrapped int: " + unwrappedNum);
        // Output: Unwrapped int: 10

        System.out.println("Auto-unboxed int: " + autoUnboxedNum);
        // Output: Auto-unboxed int: 10
    }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * A wrapper class in Java provides an object representation of primitive data types. Each primitive type in Java 
 * (such as int, char, double, etc.) has a corresponding wrapper class, allowing primitives to be treated as objects.
 * 
 * Purpose of Wrapper Classes:
 * Object-Oriented Context: Java is an object-oriented language, but primitives like int, char, boolean, etc., 
 * are not objects. Wrapper classes help in situations where objects are required, such as in:
 * Collections (e.g., ArrayList, HashMap) that can only store objects.
 * Frameworks and libraries that expect object types (like the Reflection API).
 * 
 * Utility Methods: Wrapper classes provide several utility methods to perform conversions and operations on 
 * primitive values. For example, Integer provides methods like parseInt(), valueOf(), toString(), etc.
 * 
 * Boxing and Unboxing: Wrapper classes allow boxing (converting primitive types to objects) and unboxing 
 * (converting objects back to primitives), which Java can handle automatically.
 */