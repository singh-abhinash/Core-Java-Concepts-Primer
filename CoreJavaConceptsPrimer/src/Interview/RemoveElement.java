package Interview;

public class RemoveElement {

	public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = removeElement(nums, val);
        System.out.println("New length after removal: " + result);
        System.out.print("Array after removal: ");
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
	
}
