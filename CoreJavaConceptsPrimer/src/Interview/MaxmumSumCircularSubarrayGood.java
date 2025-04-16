package Interview;

public class MaxmumSumCircularSubarrayGood {

	public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2, 5, -8, 3};
        int result = maxSubarraySumCircular(nums);
        System.out.println("Maxmum Sum Circular Subarray is: " + result);
    }

    public static int maxSubarraySumCircular(int[] nums) {
    	int maxSumSubArr = Integer.MIN_VALUE;
        int minSumSubArr = Integer.MAX_VALUE;
        int currMaxSumSubArr = 0;
        int currMinSumSubArr = 0;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Kadane's algorithm for maximum sum sub array
            currMaxSumSubArr = Math.max(currMaxSumSubArr, 0) + nums[i];
            maxSumSubArr = Math.max(maxSumSubArr, currMaxSumSubArr);

            // Kadane's algorithm for minimum sum sub array
            currMinSumSubArr = Math.min(currMinSumSubArr, 0) + nums[i];
            minSumSubArr = Math.min(minSumSubArr, currMinSumSubArr);

            totalSum += nums[i];
        }

        // If the total sum is equal to the minimum sum, then return the maximum sum
        // because that means all the elements are negative and wrapping is not helpful
        if (minSumSubArr == totalSum) {
            return maxSumSubArr;
        } else {
            // The result will be the maximum of:
            // 1. The maximum sum sub array (Kadane's normal)
            // 2. The total sum minus the minimum sum sub array (circular sum)
            return Math.max(maxSumSubArr, totalSum - minSumSubArr);
        }
    }

}
