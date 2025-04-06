package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Mapperson{
	String name;
	int age;
	
	public Mapperson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
}

public class MapIntermediateMethod {

	public static void main(String[] arg) {
		//Example: Converting a List of Strings to Uppercase
		List<String> list1 = Arrays.asList("abhi", "anup", "singh");
		List<String> upperCaseAtring = list1.stream()
				.map(word -> word.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(upperCaseAtring);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//Another Example: Mapping an Object's Field
		//Suppose you have a list of Person objects and you want to create a list of their names.
		List<Mapperson> list2 = Arrays.asList(
				new Mapperson("Abhi", 15),
				new Mapperson("Abhinash", 28),
				new Mapperson("Anup", 16),
				new Mapperson("Singh", 22));
		List<String> names = list2.stream()
				.filter(ag -> ag.age > 18)
				.map(name -> name.getName())
				.collect(Collectors.toList());
		System.out.println(names);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
In Java Stream API, the map() method is used to transform each element of a stream. 
It takes a Function as an argument, which is applied to each element in the stream, and it returns a new 
stream of the transformed elements.

Key Points about map():
=> Transformation: map() is primarily used for transforming the elements in a stream into another type or form.
=> Non-terminal Operation: The map() method is an intermediate operation, which means it doesn�t execute until a terminal operation like collect() or forEach() is called.
=> Non-destructive: It doesn�t modify the original data but instead returns a new stream with transformed elements.
 */
