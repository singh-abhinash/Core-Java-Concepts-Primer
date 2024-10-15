/**
 * For more details read this medium article - https://medium.com/@ganesh.shah/comparator-vs-comparable-java-8-940a83f53bd3
 * For more details read this medium article - https://ashutoshkrris.medium.com/comparable-vs-comparator-explained-in-java-0aabaedf8d47
 * IN THIS CLASS WE WILL IMPLEMENT USING LAMBDA EXPRESSION
 */

package BasicFundamentals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implement Comparator interface using lambda expression :
 */

class PersonClassLambdaExample {
    String name;
    int age;
    double weight;

    public PersonClassLambdaExample(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", weight=" + weight + " kgs]";
    }
}

public class ComparatorInterfaceLambdaExample {
	
	public static void main(String[] args) {
		List<PersonClassLambdaExample> people = Arrays.asList(
                new PersonClassLambdaExample("Alice", 30, 65.5),
                new PersonClassLambdaExample("Bob", 25, 75.0),
                new PersonClassLambdaExample("Charlie", 35, 80.0)
        );
        System.out.println("Original people list: " + people);

        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Sorted people list by name: " + people);
        
        people.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));
        System.out.println("Sorted people list by name: " + people);

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Sorted people list by age: " + people);
        
        people.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));
        System.out.println("Sorted people list by age: " + people);

        people.sort((p1, p2) -> Double.compare(p1.getAge(), p2.getAge()));
        System.out.println("Sorted people list by weight: " + people);
        
        people.sort((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()));
        System.out.println("Sorted people list by weight: " + people);
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * In Java, Comparator and Comparable are interfaces used for sorting objects, but they serve different purposes:
 * 
 * Comparator Interface:
 * The Comparator interface provides a way to define custom ordering for objects that may not have a natural ordering or for 
 * cases where you want to define multiple sorting criteria.
 * 
 * It contains two methods: compare(Object obj1, Object obj2) and equals(Object obj).
 * 
 * The compare() method compares two objects for ordering.
 * 
 * The equals() method checks whether the Comparator is equal to another Comparator.
 * 
 * Comparator allows for flexible sorting strategies and is often used when you want to sort objects in different ways or 
 * 
 * when sorting objects of classes that you cannot modify (e.g., sorting a list of objects of a library class).
 * 
 * ****VERY VERY IMPORTANT****
 * Using the Comparator Interface: This allows us to either create separate concrete classes or lambda expressions to define multiple 
 * ways of comparing objects.But according to me lambda expression will be good way to to implement.
 */
