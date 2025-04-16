package Interview;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
        // Test cases
        System.out.println(isIsomorphic("egg", "add"));  // Output: true
        System.out.println(isIsomorphic("foo", "bar"));  // Output: false
        System.out.println(isIsomorphic("paper", "title"));  // Output: true
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Check s -> t mapping
            if (mapST.containsKey(chS) && mapST.get(chS) != chT) {
                return false;
            } else {
                mapST.put(chS, chT);
            }

            // Check t -> s mapping
            if (mapTS.containsKey(chT) && mapTS.get(chT) != chS) {
                return false;
            } else {
                mapTS.put(chT, chS);
            }
        }

        return true;
    }

}
/*
 Example of Why Both-Side Mapping is Necessary:
Consider the strings:

s = "ab"

t = "aa"

Let's break down why a single mapping won't work here:

Left-to-right mapping (s -> t):

'a' in s maps to 'a' in t.

'b' in s maps to 'a' in t.

This works so far, but there’s a problem when we check the reverse.

Right-to-left mapping (t -> s):

'a' in t can map to either 'a' or 'b' in s, but in this case, it must map to 'a' (since 'a' in s mapped to 'a' in t). 
However, we already have 'b' in s mapping to 'a' in t.

This creates a conflict, so the strings are not isomorphic.

In this case, if we had only checked one side of the mapping, we wouldn't have detected the conflict.
*/
