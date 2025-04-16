package Interview;

import java.util.HashMap;
import java.util.Map;

public class WordPatternGood {

	public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Example 1: " + wordPattern(pattern1, s1)); // true

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Example 2: " + wordPattern(pattern2, s2)); // false

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println("Example 3: " + wordPattern(pattern3, s3)); // false

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println("Example 4: " + wordPattern(pattern4, s4)); // false
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check char -> word mapping
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) {
                return false;
            } else {
                charToWord.put(c, word);
            }
            
          //Due to below reason we can't use one mapping
            /*
            ❌ Failure Scenario (One-way Mapping)
                Let's say:
                pattern = "ab"
                s = "dog dog"
                What happens with only charToWord:
                'a' → "dog" ✅
                'b' → "dog" ✅ ← even though 'b' should map to a different word
            */

            // Check word -> char mapping
            // For checking character != is fine.

            // Check word -> char mapping
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) {
                return false;
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

}
