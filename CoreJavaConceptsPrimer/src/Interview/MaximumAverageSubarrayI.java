package Interview;

public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Max Average (Example 1): " + findMaxAverage(nums1, k1));  // Output: 12.75

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println("Max Average (Example 2): " + findMaxAverage(nums2, k2));  // Output: 5.0

        int[] nums3 = {-1, -12, -5, -6, -50, -3};
        int k3 = 2;
        System.out.println("Max Average (Example 3): " + findMaxAverage(nums3, k3));  // Output: -4.0
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // Calculate the initial window sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];  // Slide the window
            maxSum = Math.max(maxSum, sum);  // Update max
        }

        return maxSum / k;
    }

}
