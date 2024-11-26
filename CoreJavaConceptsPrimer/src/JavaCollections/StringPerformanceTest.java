package JavaCollections;

public class StringPerformanceTest {
    public static void main(String[] args) {
        long startTime, endTime;

        // String
        startTime = System.nanoTime();
        String s = "Hello";
        for (int i = 0; i < 10000; i++) {
            s += " World";
        }
        endTime = System.nanoTime();
        System.out.println("String Time: " + (endTime - startTime) + " ns");

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < 10000; i++) {
            sbf.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder("Hello");
        for (int i = 0; i < 10000; i++) {
            sbd.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * 1. String
-> Nature: Immutable (cannot be modified once created).
-> Thread Safety: Thread-safe because it's immutable.
-> Performance: Slower for operations that involve frequent modifications (e.g., concatenation, insertion).
-> Use Case: When the value of the string won't change or for operations where immutability is required (e.g., as a key in HashMap).

Example:
String s1 = "Hello";
s1 = s1 + " World";  // Creates a new object, original object remains unchanged
System.out.println(s1);  // Output: Hello World

2. StringBuffer
-> Nature: Mutable (can be modified after creation).
-> Thread Safety: Thread-safe; all methods are synchronized.
-> Performance: Slower compared to StringBuilder due to synchronization overhead.
-> Use Case: When the string will be modified frequently in a multithreaded environment.

Example:
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");  // Modifies the existing object
System.out.println(sb);  // Output: Hello World

3. StringBuilder
-> Nature: Mutable (can be modified after creation).
-> Thread Safety: Not thread-safe; methods are not synchronized.
-> Performance: Faster than StringBuffer because it doesn't have synchronization overhead.
-> Use Case: When the string will be modified frequently in a single-threaded environment.

Example:
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // Modifies the existing object
System.out.println(sb);  // Output: Hello World

Key Differences:
-------------------------------------------------------------------------------------------------------------------
    Feature:	   |       String:	            |      StringBuffer:	         |     StringBuilder:
-> Mutability	   |      Immutable	            |        Mutable	             |        Mutable
-> Thread Safety   |   Thread-safe (Immutable)	|     Thread-safe (Synchronized) |	   Not thread-safe
-> Performance	   |   Slower for modifications	|  Slower due to synchronization |	Faster (No synchronization)
-> Usage	       |   For immutable operations	|    Multithreaded environment	 |  Single-threaded environment
-------------------------------------------------------------------------------------------------------------------
 */

