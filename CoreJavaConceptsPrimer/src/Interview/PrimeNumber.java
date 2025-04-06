package Interview;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        if (isPrime(num)) {
            System.out.println(num + " is a Prime Number.");
        } else {
            System.out.println(num + " is NOT a Prime Number.");
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;  // Prime numbers start from 2
        for (int i = 2; i <= Math.sqrt(num); i++) {  // Loop till square root of num
            if (num % i == 0) return false;  // If divisible, not prime
        }
        return true;
    }
}

