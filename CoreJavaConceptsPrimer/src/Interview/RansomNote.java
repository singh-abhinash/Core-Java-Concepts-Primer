package Interview;

/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters 
 * from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 */

public class RansomNote {

	public static void main(String[] args) {
        // Test cases
        System.out.println(canConstruct("a", "b"));  // Output: false
        System.out.println(canConstruct("aa", "ab"));  // Output: false
        System.out.println(canConstruct("aa", "aab"));  // Output: true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] countLetters = new int[26];
        
        // Count each letter in the magazine
        for (char ch : magazine.toCharArray()) {
            countLetters[ch - 'a']++;
        }
        
        // Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (--countLetters[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
