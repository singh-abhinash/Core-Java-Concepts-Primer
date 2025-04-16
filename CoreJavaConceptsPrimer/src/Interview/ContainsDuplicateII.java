package Interview;

import java.util.HashMap;

/*
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the 
 * array such that nums[i] == nums[j] and abs(i - j) <= k.
 */

public class ContainsDuplicateII {

	public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1)); // Output: true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // Output: true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // Output: false
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(nums[i])) {
                if (i - numIndexMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            numIndexMap.put(nums[i], i);
        }
        return false;
    }

}
