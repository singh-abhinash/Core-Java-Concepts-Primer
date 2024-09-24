package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class PersonNameAge{
	private String name;
	private int age;
	
	public PersonNameAge(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return name + "(" + ")" + age;
	}
}

public class MixedIntermediateMethods {

	public static void main(String[] args) {
		// THIS WILL CONTAINS Java Stream API to complete these tasks, combining operations such as 
		//distinct(), sorted(), peek(), skip(), limit(), and map().
		/*Question:
			You are given a list of Person objects, where each person has a name and an age. Your task is to 
			perform the following operations:

			1) Extract the ages of all persons.
			2) Ensure that the ages are unique (no duplicates).
			3) Sort the unique ages in descending order.
			3) print all
			3) Sort the unique ages in ascending order.
			3) print all
			4) Skip the first two smallest ages.
			5) Limit the result to only the next three ages after skipping.
			6) For each remaining age, find and return the first person with that age.
			7) Display the results.*/
		List<PersonNameAge> people = Arrays.asList(
				new PersonNameAge("Alice", 34),
	            new PersonNameAge("Bob", 28),
	            new PersonNameAge("Charlie", 23),
	            new PersonNameAge("David", 34),
	            new PersonNameAge("Eve", 29),
	            new PersonNameAge("Frank", 28),
	            new PersonNameAge("Grace", 40),
	            new PersonNameAge("Hank", 40),
	            new PersonNameAge("Ivy", 45));
		List<PersonNameAge> results = people.stream()
				.map(ag -> ag.getAge())
				.distinct()
				.sorted(Comparator.reverseOrder())
				.peek(age -> System.out.println("processing descending age -> " + age))
				.sorted()
				.peek(age -> System.out.println("processing ascending age -> " + age))
				.skip(2)
				.limit(3)
				.map(age -> people.stream().filter(p -> p.getAge() == age).findFirst().orElse(null))
                .collect(Collectors.toList());
		System.out.println(results);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
