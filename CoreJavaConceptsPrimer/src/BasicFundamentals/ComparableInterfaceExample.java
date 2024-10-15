/**
 * For more details read this medium article - https://medium.com/@ganesh.shah/comparator-vs-comparable-java-8-940a83f53bd3
 * For more details read this medium article - https://ashutoshkrris.medium.com/comparable-vs-comparator-explained-in-java-0aabaedf8d47
 * 
 * 
 * Question -> can we implement comparable interface using lambda expression
 * 
 * Answer -> No, we cannot directly implement the Comparable interface using lambda expressions because the Comparable 
 * interface contains only one method, compareTo(), and it is tied to the object itself, requiring access to this. Lambda 
 * expressions in Java cannot reference the current object (this) in the way that is necessary for compareTo().
 * 
 * In this implementation, the compareTo() method compares the age attribute of the current PersonV2 object with the age 
 * attribute of the specified PersonV2 object by subtracting one age from the other. By using the 
 * expression this.age - other.age, we’re effectively implementing this logic as follows:
 * 
 * If this.age is less than other.age, the result will be negative.
 * If this.age is equal to other.age, the result will be zero.
 * If this.age is greater than other.age, the result will be positive.
 * 
 * Note: We can also use Integer.compare(this.age, other.age) instead of performing the arithmetic operation manually.
 */

package BasicFundamentals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PersonComparableExample implements Comparable<PersonComparableExample> {
    String name;
    int age;
    double weight;

    public PersonComparableExample(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PersonV2 [name=" + name + ", age=" + age + ", weight=" + weight + " kgs]";
    }

    @Override
    public int compareTo(PersonComparableExample other) {
        return this.age - other.age;
    }
}

public class ComparableInterfaceExample {

	public static void main(String[] args) {
		List<PersonComparableExample> people = Arrays.asList(
                new PersonComparableExample("Alice", 30, 65.5),
                new PersonComparableExample("Bob", 25, 75.0),
                new PersonComparableExample("Charlie", 35, 80.0)
        );
        System.out.println("Original people list: " + people);

        Collections.sort(people);
        System.out.println("Sorted people list: " + people);
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * In Java, Comparator and Comparable are interfaces used for sorting objects, but they serve different purposes:
 * 
 * Comparable Interface:
 * The Comparable interface is implemented by a class to define its natural ordering.
 * 
 * It contains a single method compareTo(Object obj) which compares the object with another object.
 * 
 * By implementing Comparable, a class indicates that its instances can be sorted using the natural ordering.
 * 
 * For example, classes like String, Integer, and Date implement Comparable to define their natural ordering.
 * 
 * Implementing the Comparable Interface: This allows a class to define its natural ordering by implementing the compareTo 
 * method.
 * 
 * 
 * 
 * *****Limitations of Comparable:****
 * -> While the Comparable interface provides a way to define a natural ordering for objects, it has several limitations 
 * that can restrict its use in practical applications. Understanding these limitations can help us determine when to use 
 * other mechanisms, such as the Comparator interface, to achieve more flexible sorting.
 * 
 * --> Single Natural Ordering: The primary limitation of Comparable is that it allows only one natural ordering for the objects 
 * of a class. When you implement Comparable, you define a single way to compare objects, which is used whenever the objects 
 * are sorted or compared. This can be restrictive if you need to sort objects in multiple ways.
 * --> Inflexibility: If you need to sort objects by different attributes or in different orders, you will have to modify the 
 * class or create new implementations of Comparable. This inflexibility can lead to a proliferation of comparison methods 
 * and can make the code harder to maintain.
 * 
 * *****BELOW STATEMENT IS VERY VERY IMPORTANT********
 * --> Non-Adaptable: Once a class implements Comparable, the natural ordering is fixed and cannot be easily changed. 
 * For instance, if your PersonV2 class initially sorts by age but later you need to sort by weight or name, you have to 
 * either change the compareTo() method or create a new version of the class.
 * 
 * This is where the Comparator interface comes into play. To define multiple ways of comparing objects, we can use the 
 * Comparator interface, which we will explore in the next section.
 */
