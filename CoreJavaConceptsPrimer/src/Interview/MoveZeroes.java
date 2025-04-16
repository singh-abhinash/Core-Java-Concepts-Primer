package Interview;

public class MoveZeroes {

	public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        moveZeroes(nums);
        System.out.print("Output: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Move non-zero values to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with 0s
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

}
