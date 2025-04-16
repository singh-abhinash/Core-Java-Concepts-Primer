package Interview;

import java.util.HashMap;

public class RomanToIntegerGood {

	public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // Output: 3
        System.out.println(romanToInt("LVIII"));    // Output: 58
        System.out.println(romanToInt("MCMXCIV"));  // Output: 1994
    }

    public static int romanToInt(String s) {
        // Step 1: Map Roman numerals to their integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        // Step 2: Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            int currentVal = romanMap.get(s.charAt(i));

            // Step 3: Look ahead if next character exists
            if (i + 1 < s.length()) {
                int nextVal = romanMap.get(s.charAt(i + 1));

                // If current value is less than next, it's a subtractive combination
                if (currentVal < nextVal) {
                    result -= currentVal;
                } else {
                    result += currentVal;
                }
            } else {
                result += currentVal; // Last character
            }
        }

        return result;
    }

}
