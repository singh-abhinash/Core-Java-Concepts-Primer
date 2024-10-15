package BasicFundamentals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implemented Comparator interface with concrete comparator class :
 */

class PersonClassExample {
    String name;
    int age;
    double weight;

    public PersonClassExample(String name, int age, double weight) {
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

/**
 * Comparator by Name:
 * This comparator sorts Person objects alphabetically by their name in Ascending.
 */

class PersonNameComparatorAsc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

/**
 * Comparator by Name:
 * This comparator sorts Person objects alphabetically by their name in Descending.
 */

class PersonNameComparatorDesc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return p2.getName().compareTo(p1.getName());
    }
}

/**
 * Comparator by Age:
 * This comparator sorts Person objects by their age, in ascending order.
 */

class PersonAgeComparatorAsc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return p1.getAge() - p2.getAge();
    }
}

/**
 * Comparator by Age:
 * This comparator sorts Person objects by their age, in descending order.
 */

class PersonAgeComparatorDesc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return p2.getAge() - p1.getAge();
    }
}

/**
 * Comparator by Weight:
 * This comparator sorts Person objects by their weight, in ascending order.
 */

class PersonWeightComparatorAsc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return (int) (p1.getWeight() - p2.getWeight());
    }
}

/**
 * Comparator by Weight:
 * This comparator sorts Person objects by their weight, in descending order.
 */

class PersonWeightComparatorDesc implements Comparator<PersonClassExample> {

    @Override
    public int compare(PersonClassExample p1, PersonClassExample p2) {
        return (int) (p2.getWeight() - p1.getWeight());
    }
}

public class ComparatorInterfaceSeparateClassExample {

	public static void main(String[] args) {
		List<PersonClassExample> people = Arrays.asList(
                new PersonClassExample("Alice", 30, 65.5),
                new PersonClassExample("Bob", 25, 75.0),
                new PersonClassExample("Charlie", 35, 80.0)
        );
        System.out.println("Original people list: " + people);

        Collections.sort(people, new PersonNameComparatorAsc());
        System.out.println("Sorted people list by name: " + people);
        
        Collections.sort(people, new PersonNameComparatorDesc());
        System.out.println("Sorted people list by name: " + people);

        Collections.sort(people, new PersonAgeComparatorAsc());
        System.out.println("Sorted people list by age: " + people);
        
        Collections.sort(people, new PersonAgeComparatorDesc());
        System.out.println("Sorted people list by age: " + people);

        Collections.sort(people, new PersonWeightComparatorAsc());
        System.out.println("Sorted people list by weight: " + people);
        
        Collections.sort(people, new PersonWeightComparatorDesc());
        System.out.println("Sorted people list by weight: " + people);
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Comparator Interface:
 * The Comparator interface in Java provides a way to define multiple ways to compare and sort objects. Unlike the 
 * Comparable interface, which allows only a single natural ordering, Comparator is designed to offer flexibility by 
 * allowing multiple sorting strategies. This makes it particularly useful for scenarios where objects need to be sorted 
 * in different ways.
 * 
 * Overview:
 * -> The Comparator interface defines a single method, compare(), which compares two objects and returns:
 * -> A negative integer if the first object is less than the second object
 * -> Zero if the first object is equal to the second object.
 * -> A positive integer if the first object is greater than the second object.
 * -> This method provides a way to define custom ordering for objects without modifying the class itself.
 * 
 * How Comparator Allows for Multiple Ways of Ordering Objects:
 * -> The Comparator interface allows you to create multiple Comparator instances, each defining a different ordering for 
 * objects. This flexibility means you can sort objects by various attributes or in different orders without altering the 
 * object's class.
 * 
 * Let’s implement multiple Comparator instances for the Person class. We'll define comparators for sorting by name, by age, 
 * and by weight. First, we need to update the Person class to include getters and ensure that attributes are accessible.
 */
