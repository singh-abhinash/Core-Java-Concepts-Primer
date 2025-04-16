package Interview;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums)); // Output: [5, 6, 7, 1, 2, 3, 4]
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        int n = nums.length; // nums = [1,2,3,4,5,6,7]
        reverse(nums, 0, n - k - 1); // nums = [4,3,2,1,5,6,7]
        reverse(nums, n - k, n - 1); // nums = [4,3,2,1,7,6,5]
        reverse(nums, 0, n - 1);     // nums = [5,6,7,1,2,3,4]

        // int n = nums.length; // nums = [1,2,3,4,5,6,7] - rotate k = 3 from left
        // reverse(nums, 0, k - 1);     // nums = [3,2,1,4,5,6,7]
        // reverse(nums, k, n - 1);     // nums = [3,2,1,7,6,5,4]
        // reverse(nums, 0, n - 1);     // nums = [4,5,6,7,1,2,3]
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
