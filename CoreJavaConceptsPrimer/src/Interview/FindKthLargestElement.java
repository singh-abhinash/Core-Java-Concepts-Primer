package Interview;

import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // Keep size at most k
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest
            }
        }

        // Top of the heap is the kth largest
        return minHeap.peek();
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Using sorting

/*

package Interview;

import java.util.Arrays;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array in ascending order
        return nums[nums.length - k]; // Kth largest is at (length - k) index
    }
}

*/
