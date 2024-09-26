package Interview;
import java.util.Arrays;


public class Solution {

	public static int returnSmallest(int[] num, int n) {
		Arrays.sort(num);
		return num[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,4,5,6,3,8,7};
		int size = num.length;
		int smallestValue = returnSmallest(num, 3);
		System.out.println(smallestValue);
	}

}


