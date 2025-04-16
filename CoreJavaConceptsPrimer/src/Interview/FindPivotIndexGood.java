package Interview;

/*
 * Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all 
the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

public class FindPivotIndexGood {

	public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};   // Output: 3
        int[] nums2 = {1, 2, 3};            // Output: -1
        int[] nums3 = {2, 1, -1};           // Output: 0

        System.out.println("Pivot Index (Example 1): " + pivotIndex(nums1));
        System.out.println("Pivot Index (Example 2): " + pivotIndex(nums2));
        System.out.println("Pivot Index (Example 3): " + pivotIndex(nums3));
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - nums[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
