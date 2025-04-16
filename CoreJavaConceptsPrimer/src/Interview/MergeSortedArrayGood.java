package Interview;

import java.util.Arrays;

public class MergeSortedArrayGood {

	public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6, 7, 8};
        int n = 5;

        merge(nums1, m, nums2, n);

        System.out.println("Merged array: " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the last position in nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // No need to copy remaining nums1 elements as they're already in place
    }

    // Time Complexity: O(m + n)
    // Space Complexity: O(1)
	
}
