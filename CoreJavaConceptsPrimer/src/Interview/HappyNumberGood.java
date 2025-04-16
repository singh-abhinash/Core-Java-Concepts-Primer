package Interview;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberGood {

	public static void main(String[] args) {
        int n1 = 19;
        System.out.println("Is " + n1 + " a happy number? " + isHappy(n1)); // true

        int n2 = 2;
        System.out.println("Is " + n2 + " a happy number? " + isHappy(n2)); // false

        int n3 = 1;
        System.out.println("Is " + n3 + " a happy number? " + isHappy(n3)); // true

        int n4 = 7;
        System.out.println("Is " + n4 + " a happy number? " + isHappy(n4)); // true
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // Cycle detected
            }
            seen.add(n);
            n = sumOfSquares(n);
        }
        return true; // Number is happy
    }

    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

}
