package Interview;

/*
 * A peak element is an element that is strictly greater than its neighbors.
 */

public class FindPeakElement {

	public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};

        int peakIndex1 = findPeakElement(nums1);
        int peakIndex2 = findPeakElement(nums2);

        System.out.println("Peak element index in nums1: " + peakIndex1 + ", value: " + nums1[peakIndex1]);
        System.out.println("Peak element index in nums2: " + peakIndex2 + ", value: " + nums2[peakIndex2]);
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // Peak lies in the left half including mid
                right = mid;
            } else {
                // Peak lies in the right half excluding mid
                left = mid + 1;
            }
        }
        return left; // or right, since both will be equal
    }

}
