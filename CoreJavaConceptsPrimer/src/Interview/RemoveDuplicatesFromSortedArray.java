package Interview;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("Length: " + k1); // Output: 2
        printArray(nums1, k1); // Output: 1 2

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = removeDuplicates(nums2);
        System.out.println("Length: " + k2); // Output: 5
        printArray(nums2, k2); // Output: 0 1 2 3 4
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int currIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[currIndex] = nums[i];
                currIndex++;
            }
        }
        return currIndex;
    }

    private static void printArray(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
	
}
