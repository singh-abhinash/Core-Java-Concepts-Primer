package Interview;

/*
The Boyer-Moore Voting Algorithm is a linear time, constant space algorithm used to find the majority element 
in a list — that is, the element that appears more than ⌊n/2⌋ times.
*/

public class MajorityElementBoyreMooreGood {

	public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1)); // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2)); // Output: 2

        int[] nums3 = {1};
        System.out.println(majorityElement(nums3)); // Output: 1
    }

    // Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int count = 1;
        int majorityNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityNumber) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorityNumber = nums[i];
                    count = 1;
                }
            }
        }

        return majorityNumber;
    }
	
}
