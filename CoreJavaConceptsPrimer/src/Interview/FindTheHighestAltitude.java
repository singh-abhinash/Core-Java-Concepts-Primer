package Interview;

public class FindTheHighestAltitude {

	 public static void main(String[] args) {
	        int[] gain1 = {-5, 1, 5, 0, -7};
	        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};

	        System.out.println("Highest altitude (Example 1): " + largestAltitude(gain1)); // Output: 1
	        System.out.println("Highest altitude (Example 2): " + largestAltitude(gain2)); // Output: 0
	    }

	    public static int largestAltitude(int[] gain) {
	        int maxAltitude = 0;
	        int currentAltitude = 0;

	        for (int g : gain) {
	            currentAltitude += g;
	            maxAltitude = Math.max(maxAltitude, currentAltitude);
	        }

	        return maxAltitude;
	    }

}
