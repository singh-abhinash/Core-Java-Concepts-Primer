package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List of sentences
        List<String> sentences = Arrays.asList("hello world", "java streams", "map vs flatMap");
       
        // Using map(): Creates a nested structure (list of lists)
        List<List<String>> nestedWords = sentences.stream()
            .map(sentence -> Arrays.asList(sentence.split(" "))) // Transform each sentence into a list of words
            .collect(Collectors.toList());
        
        System.out.println("Using map(): " + nestedWords);
        // Output: Using map(): [[hello, world], [java, streams], [map, vs, flatMap]]

        // Using flatMap(): Creates a flat structure (list of words)
        List<String> flatWords = sentences.stream()
            .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // Flatten the words into a single stream
            .collect(Collectors.toList());
        
        System.out.println("Using flatMap(): " + flatWords);
        // Output: Using flatMap(): [hello, world, java, streams, map, vs, flatMap]
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * map(sentence -> Arrays.stream(sentence.split(" ")))	Stream<Stream<String>>
 * flatMap(sentence -> Arrays.stream(sentence.split(" ")))	Stream<String>
 * 
 * split(" ") → Splits a sentence into an array of words.
 * Arrays.stream(...) → Converts the array into a Stream<String>.
 * map() (Incorrect Approach) → Produces Stream<Stream<String>> (nested streams).
 * flatMap() (Correct Approach) → Flattens Stream<Stream<String>> into Stream<String>.
 * collect(Collectors.toList()) → Collects words into List<String>.
 * 
 * ✅ Rule of Thumb Explanation
Use map() → When one input produces exactly one output
(Transforms elements but keeps the structure the same.)
Use flatMap() → When one input produces multiple outputs
(Flattens nested structures like List<List<T>> into List<T>.)
 */
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 *
Your code is incorrect because map() transforms each element into a stream of words (Stream<String[]>), but you are collecting it as a List<String>, which leads to a type mismatch.

Why is it wrong?
map(sentence -> Arrays.stream(sentence.split(" ")))

This creates a Stream<Stream<String>>, meaning each sentence is converted into a separate stream of words.
But you need a flat list of words (List<String>), not a list of streams.
Incorrect Collection

Collectors.toList() is collecting streams instead of strings.
You need to flatten the inner streams into a single stream using flatMap().
✅ Corrected Code (Using flatMap())

List<String> flatWords = sentences.stream()
    .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // Flatten words into a single stream
    .collect(Collectors.toList()); // Collect as List<String>
🔍 Explanation
map() (Incorrect Approach) → Produces Stream<Stream<String>>
flatMap() (Correct Approach) → Flattens Stream<Stream<String>> into Stream<String>
Example Input

List<String> sentences = Arrays.asList("Hello World", "Java 8 Streams");
Intermediate Steps
Step	Output
map(sentence -> Arrays.stream(sentence.split(" ")))	Stream<Stream<String>>
flatMap(sentence -> Arrays.stream(sentence.split(" ")))	Stream<String>
Correct Output (List<String>)

[ "Hello", "World", "Java", "8", "Streams" ]
⛔ Common Mistake
❌ Using map() instead of flatMap()

java
Copy
List<Stream<String>> incorrect = sentences.stream()
    .map(sentence -> Arrays.stream(sentence.split(" "))) 
    .collect(Collectors.toList()); // ❌ Collects Stream<String>, not List<String>
✅ Rule of Thumb
Use map() → If one input produces one output.
Use flatMap() → If one input produces multiple outputs (e.g., flattening lists, arrays, or streams).
Final Takeaway
🔹 Use flatMap() to merge nested streams into a single stream
🔹 Always check the intermediate stream type to avoid Stream<Stream<T>>
🔹 map() is for 1-to-1 mapping, flatMap() is for 1-to-many mapping
 */
