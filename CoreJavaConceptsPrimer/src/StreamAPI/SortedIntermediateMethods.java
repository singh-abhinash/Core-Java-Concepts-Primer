package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SortPerson{
	private String name;
	private int age;
	
	SortPerson(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
}

public class SortedIntermediateMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//In Java, we can use the Stream API to sort a list of Person objects. Here’s how we can do it 
		//for both ascending and descending orders, assuming you have a Person class with name and age attributes.
		List<SortPerson> people = Arrays.asList(
				new SortPerson("Alice", 30),
	            new SortPerson("Bob", 25),
	            new SortPerson("Charlie", 35)
	            );
		//sorting people in ascending order by name
		List<SortPerson> sortPeopleNameAsc = people.stream()
				.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(sortPeopleNameAsc);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		
		//sorting people in descending order by name
		List<SortPerson> sortPeopleNameDesc = people.stream()
				.sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
				.collect(Collectors.toList());
		System.out.println(sortPeopleNameDesc);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		
		//sorting people in ascending order by age
		List<SortPerson> sortPeoplAgeAsc = people.stream()
				.sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
				.collect(Collectors.toList());
		System.out.println(sortPeoplAgeAsc);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		
		//sorting people in descending order by age
		List<SortPerson> sortPeoplAgeDesc = people.stream()
				.sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
				.collect(Collectors.toList());
		System.out.println(sortPeoplAgeDesc);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
	}

}
