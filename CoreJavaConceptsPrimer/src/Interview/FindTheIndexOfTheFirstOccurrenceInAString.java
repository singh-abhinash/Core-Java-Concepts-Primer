package Interview;

/*
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if 
 * needle is not part of haystack.
 */

public class FindTheIndexOfTheFirstOccurrenceInAString {

	public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1)); // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2)); // Output: -1
    }

    public static int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
    	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Either use above or below
    	int h = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= h - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
