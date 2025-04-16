package Interview;

import java.util.*;

public class ReverseVowelsOfAString {

	public static void main(String[] args) {
        String result = reverseVowels("IceCreAm");
        System.out.println("Reversed Vowels: " + result);  // Output: "holle"
    }

    public static String reverseVowels(String s) {
        // Set of vowels (both lower case and upper case)
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Convert the string into a character array for easy manipulation
        char[] chars = s.toCharArray();
        // StringBuilder sb = new StringBuilder(s); // we can also use this instead
        /*
         * In Java, String objects are immutable, meaning that once a String is created, it cannot be changed. Any operation 
         * that appears to modify a string actually creates a new string object with the desired changes.
         * 
         * In the case of swapping characters (such as vowels in this case), directly modifying a string would require 
         * creating a new string each time a change is made, which can be inefficient.
         * 
         * However, arrays (like char[]) are mutable, meaning you can modify their content directly. This allows us to 
         * efficiently perform operations like swapping characters without creating new string objects.
         * 
         * Mutability: StringBuilder is mutable, which means you can modify its contents without creating new objects each 
         * time. It allows you to change the string in place (e.g., by adding, removing, or updating characters).
         */
        int left = 0, right = chars.length - 1;

        // Use two-pointer technique to reverse vowels
        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Move right pointer to the previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move both pointers inward
            left++;
            right--;
        }

        // Return the modified string after reversing vowels
        return new String(chars);
    }

}
