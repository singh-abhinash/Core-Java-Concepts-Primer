package Interview;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Index of target: " + search(nums1, target1)); // Output: 4

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Index of target: " + search(nums2, target2)); // Output: -1

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Index of target: " + search(nums3, target3)); // Output: -1
    }

    // Function to search the target element in the rotated sorted array
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int pivot = 0;

        // Step 1: Find the pivot (smallest element) in the rotated array
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                pivot = mid;
                break;
            } else if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Step 2: Perform binary search in the appropriate half of the array
        int val = BinarySearch(0, pivot - 1, nums, target);
        if (val != -1)
            return val;

        return BinarySearch(pivot, n - 1, nums, target);
    }
    
 // Function to perform Binary Search
    public static int BinarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
