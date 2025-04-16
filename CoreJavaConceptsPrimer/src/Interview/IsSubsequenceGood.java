package Interview;

public class IsSubsequenceGood {

	public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Is Subsequence (Example 1): " + isSubsequence(s1, t1)); // true

        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Is Subsequence (Example 2): " + isSubsequence(s2, t2)); // false

        String s3 = "";
        String t3 = "anything";
        System.out.println("Is Subsequence (Example 3): " + isSubsequence(s3, t3)); // true
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) 
        	return true; // Empty string is always a subsequence
        
        int i = 0, j = 0;

        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) 
                	return true; // If we've matched the whole 's', return true
            }
            j++;
        }

        return false;
    }

}
