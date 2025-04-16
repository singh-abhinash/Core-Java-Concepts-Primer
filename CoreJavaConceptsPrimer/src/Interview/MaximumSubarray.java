package Interview;

public class MaximumSubarray {

	public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);  // Output should be 6
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;

        // maximumSum will store the final answer (maximum sub array sum)
        // currSumSubarray will store the maximum sum sub array ending at the current index
        int maximumSum = Integer.MIN_VALUE;
        int currSumSubarray = 0;

        for (int i = 0; i < n; i++) {
            // If currSumSubarray is negative, we reset it to 0 before adding current element
            currSumSubarray = Math.max(currSumSubarray, 0) + nums[i];

            // Update the maximum sum encountered so far
            maximumSum = Math.max(maximumSum, currSumSubarray);
        }

        return maximumSum;
    }

}
