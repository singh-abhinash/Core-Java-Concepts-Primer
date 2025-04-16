package Interview;

public class ValidAnagram {

	public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Example 1: " + isAnagram(s1, t1)); // true

        String s2 = "rat", t2 = "car";
        System.out.println("Example 2: " + isAnagram(s2, t2)); // false

        String s3 = "listen", t3 = "silent";
        System.out.println("Example 3: " + isAnagram(s3, t3)); // true

        String s4 = "a", t4 = "ab";
        System.out.println("Example 4: " + isAnagram(s4, t4)); // false
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // For 'a' to 'z'

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for s
            count[t.charAt(i) - 'a']--; // Decrement for t
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

}
