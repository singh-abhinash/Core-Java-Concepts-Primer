package Interview;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 20; // Example input
        int result = climbStairs(n);  // Directly calling the static method
        System.out.println("Number of distinct ways to climb " + n + " stairs: " + result);
    }

    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] distinctWaysToClimb = new int[46]; // up to n = 45
        distinctWaysToClimb[1] = 1;
        distinctWaysToClimb[2] = 2;

        for (int i = 3; i <= n; i++) {
            distinctWaysToClimb[i] = distinctWaysToClimb[i - 1] + distinctWaysToClimb[i - 2];
        }

        return distinctWaysToClimb[n];
    }
}

