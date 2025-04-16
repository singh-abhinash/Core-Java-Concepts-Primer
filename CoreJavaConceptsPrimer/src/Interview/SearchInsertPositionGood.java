package Interview;

public class SearchInsertPositionGood {

	public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 9};

        int target1 = -1;
        int target2 = 5;
        int target3 = 8;

        System.out.println("Insert position of " + target1 + " is: " + searchInsert(nums, target1));  // Output: 2
        System.out.println("Insert position of " + target2 + " is: " + searchInsert(nums, target2));  // Output: 1
        System.out.println("Insert position of " + target3 + " is: " + searchInsert(nums, target3));  // Output: 4
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int first = 0, last = n - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                first = mid + 1;
            else
                last = mid - 1;
        }

        return last + 1;
    }

}
