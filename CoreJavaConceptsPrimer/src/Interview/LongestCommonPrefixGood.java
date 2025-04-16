package Interview;

public class LongestCommonPrefixGood {

	public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2)); // Output: ""
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // Check index out of bounds or character mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != current) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0]; // All characters matched for the shortest string
    }

}
