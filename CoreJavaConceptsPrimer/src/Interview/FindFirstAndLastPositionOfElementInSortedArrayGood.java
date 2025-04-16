package Interview;

public class FindFirstAndLastPositionOfElementInSortedArrayGood {

	public static void main(String[] args) {
        // Test cases
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = searchRange(nums1, target1);
        System.out.println("First and Last Position of 8: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = searchRange(nums2, target2);
        System.out.println("First and Last Position of 6: [" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = searchRange(nums3, target3);
        System.out.println("First and Last Position of 0: [" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        // Find the first and last position of the target
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        
        return result;
    }

    // Helper function to find the first position of the target
    private static int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int firstPosition = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                firstPosition = mid; // Potential first position found
                right = mid - 1;     // Move left to find an earlier occurrence
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return firstPosition;  // Return -1 if target is not found
    }

    // Helper function to find the last position of the target
    private static int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int lastPosition = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                lastPosition = mid;  // Potential last position found
                left = mid + 1;      // Move right to find a later occurrence
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastPosition;  // Return -1 if target is not found
    }

}
