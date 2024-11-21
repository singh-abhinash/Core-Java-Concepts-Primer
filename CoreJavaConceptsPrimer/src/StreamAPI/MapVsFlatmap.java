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
