package Interview;

import java.util.*;

public class SummaryRangeGood {

	public static void main(String[] args) {
        // Example 1
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums1));  // Output: ["0->2", "4->5", "7"]
        
        // Example 2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums2));  // Output: ["0", "2->4", "6", "8->9"]
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums.length == 0) return result;
        
        int start = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Check if current number is not consecutive to the previous one
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));  // Single number range
                } else {
                    result.add(start + "->" + nums[i - 1]);  // Range
                }
                start = nums[i];  // Start a new range
            }
        }
        
        // Add the last range or number
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }
        
        return result;
    }

}
