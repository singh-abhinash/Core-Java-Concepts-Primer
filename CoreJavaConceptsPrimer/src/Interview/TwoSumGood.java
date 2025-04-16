package Interview;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumGood {

	public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Output: [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Indices: " + Arrays.toString(twoSum(nums2, target2))); // Output: [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Indices: " + Arrays.toString(twoSum(nums3, target3))); // Output: [0, 1]
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[] {map.get(difference), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1, -1}; // In case no two numbers found
    }

}
