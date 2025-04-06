package JavaCollections;

public class StringOperationsExample {
    public static void main(String[] args) {
        // 1. Initialization
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "   Java Programming   ";

        // 2. Find Length
        System.out.println("Length of str1: " + str1.length());

        // 3. Concatenate Strings
        String concatenated = str1 + " " + str2;
        System.out.println("Concatenated String: " + concatenated);

        // 4. Character at Specific Index
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        // 5. Compare Strings
        System.out.println("str1 equals str2? " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase 'hello'? " + str1.equalsIgnoreCase("HELLO"));

        // 6. Check if String is Empty
        System.out.println("Is str1 empty? " + str1.isEmpty());

        // 7. Convert to Upper/Lower Case
        System.out.println("str1 in uppercase: " + str1.toUpperCase());
        System.out.println("str1 in lowercase: " + str1.toLowerCase());

        // 8. Substring
        String subStr = concatenated.substring(6); // From index 6 to end
        System.out.println("Substring from concatenated: " + subStr);

        // 9. Replace Characters or Substrings
        String replaced = concatenated.replace('o', 'x');
        System.out.println("Replaced 'o' with 'x': " + replaced);

        // 10. Split String
        String[] words = concatenated.split(" ");
        System.out.println("Split words:");
        for (String word : words) {
            System.out.println(word);
        }

        // 11. Trim Whitespaces
        System.out.println("Trimmed str3: '" + str3.trim() + "'");
        
        String sub = str2.substring(1, 4); // Extract substring from index 1 to 3 (4 is exclusive)
        System.out.println("Substring from 1 to 3: " + sub); // Output: "orl"

        // 12. Check if String Contains Substring
        System.out.println("Does concatenated contain 'World'? " + concatenated.contains("World"));

        // 13. Starts With / Ends With
        System.out.println("Does str1 start with 'He'? " + str1.startsWith("He"));
        System.out.println("Does str2 end with 'ld'? " + str2.endsWith("ld"));

        // 14. Convert to Character Array
        char[] chars = str1.toCharArray();
        System.out.println("Characters in str1:");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 15. Convert Number to String
        int number = 123;
        String numberStr = String.valueOf(number);
        System.out.println("Number as String: " + numberStr);

        // 16. Convert String to Number
        int parsedNumber = Integer.parseInt(numberStr);
        System.out.println("Parsed number: " + parsedNumber);

        // 17. Join Strings
        String joined = String.join(", ", "Apple", "Banana", "Cherry");
        System.out.println("Joined String: " + joined);

        // 18. Reverse a String
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println("Reversed str1: " + reversed);

        // 19. Format String
        String formatted = String.format("My name is %s and my age is %d.", "Alice", 25);
        System.out.println("Formatted String: " + formatted);

        // 20. Find Index of a Character or Substring
        System.out.println("Index of 'o' in str1: " + str1.indexOf('o'));
        System.out.println("Index of 'World' in concatenated: " + concatenated.indexOf("World"));
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * 
 */
