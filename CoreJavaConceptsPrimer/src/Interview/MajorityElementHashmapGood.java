package Interview;

import java.util.HashMap;

public class MajorityElementHashmapGood {

	public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1)); // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2)); // Output: 2

        int[] nums3 = {1};
        System.out.println(majorityElement(nums3)); // Output: 1
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // Should never be reached if a majority element is guaranteed
    }
	
}
