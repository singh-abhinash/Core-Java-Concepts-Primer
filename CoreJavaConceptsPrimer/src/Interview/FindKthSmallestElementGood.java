package Interview;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthSmallestElementGood {

	public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthSmallest(nums, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }

    public static int findKthSmallest(int[] nums, int k) {
        // Max-heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);

            // Keep size at most k
            if (maxHeap.size() > k) {
                maxHeap.poll();  // Remove the largest
            }
        }

        // Top of the heap is the kth smallest
        return maxHeap.peek();
    }
	
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Using sorting
/*

package Interview;

import java.util.Arrays;

public class FindKthSmallestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthSmallest(nums, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }

    public static int findKthSmallest(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array in ascending order
        return nums[k - 1]; // Return the (k-1)th element
    }
}

*/
