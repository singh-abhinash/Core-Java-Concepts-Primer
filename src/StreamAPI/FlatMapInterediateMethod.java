package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PersonFavBooks{
	private String name;
	private List<String> favoriteBooks;
	
	public PersonFavBooks(String name, List<String> favoriteBooks) {
		this.name = name;
		this.favoriteBooks = favoriteBooks;
	}
	
	public List<String> getPersonsFavBooks() {
		return favoriteBooks;
	}
}

public class FlatMapInterediateMethod {

	public static void main(String[] args) {
		//Example: Flattening a List of Lists
		//Let's say we have a list of lists of numbers and we want to flatten it into a single list of numbers.
		List<List<Integer>> listOfList = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5),
				Arrays.asList(6,7,8));
		List<Integer> result = listOfList.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println(result);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		
		//Example: Splitting Strings and Flattening Them
		//Suppose you have a list of sentences, and you want to split each sentence into words and then collect all 
		//the words into a single list.
		List<String> sentences = Arrays.asList("Hello world", "Java is fun", "Stream API is powerful");
		//For each sentence, sentence.split(" ") splits the sentence into an array of words, and Arrays.stream() 
		//converts this array into a stream of words. The flatMap() method flattens the stream of word arrays into 
		//a single stream of words.
		List<String> words = sentences.stream()
				.flatMap(sentence -> Arrays.stream(sentence.split(" ")))
				.collect(Collectors.toList());
		System.out.println(words);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		
		//Problem Scenario:
		//You have a list of Person objects, and each person has a list of their favorite books. You want to 
		//retrieve a list of all unique book titles from the favorite books of all people.
		List<PersonFavBooks> person = Arrays.asList(
				new PersonFavBooks("Alice", Arrays.asList("The Hobbit", "Harry Potter", "To Kill a Mockingbird")),
				new PersonFavBooks("Bob", Arrays.asList("The Hobbit", "1984", "Moby Dick")),
				new PersonFavBooks("Charlie", Arrays.asList("1984", "The Catcher in the Rye")),
				new PersonFavBooks("Dave", Arrays.asList("The Lord of the Rings", "The Catcher in the Rye", "Harry Potter"))
				);
		List<String> books = person.stream()
				//people.stream() converts the people list into a stream of Person objects.
				//person.getFavoriteBooks() returns a list of books, which is also a collection.
				//However, the flatMap operation works with streams, not collections like List or Set. Therefore, 
				//to process the favorite books of each person, you need to convert that list into a stream.
				.flatMap(p1 -> p1.getPersonsFavBooks().stream())
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Unique favorite books: " + books);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
The flatMap() method in Java Stream API is used to transform each element of a stream into multiple elements, 
and then flatten the result into a single stream. It's especially useful when you need to transform an element 
into a stream of values, such as lists, arrays, or other collections.

Key Points about flatMap():
-> Transformation to Streams: It applies a transformation function that returns a stream for each element and then 
flattens the streams into a single stream.
-> Flattening: The primary difference between map() and flatMap() is that flatMap() flattens the result into a 
single stream, whereas map() creates a stream of streams.
-> Use Case: It’s commonly used when working with lists of lists, arrays of arrays, or collections of collections.
 */
