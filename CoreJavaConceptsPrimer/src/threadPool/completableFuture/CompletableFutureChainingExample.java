package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureChainingExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Start an asynchronous task to fetch a number (e.g., 20)
        CompletableFuture<Void> futureChain = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching initial value on thread: " + Thread.currentThread().getName());
            return 20; // Initial value
        })
        // First transformation: Double the number
        .thenApply(value -> {
            System.out.println("Doubling value: " + value + " on thread: " + Thread.currentThread().getName());
            return value * 2; // Double the value
        })
        // Second transformation: Add 10 to the result
        .thenApply(value -> {
            System.out.println("Adding 10 to doubled value: " + value + " on thread: " + Thread.currentThread().getName());
            return value + 10; // Add 10
        })
        // Combine with another asynchronous task: fetch a multiplier and multiply the current result
        .thenCombine(
            CompletableFuture.supplyAsync(() -> {
                System.out.println("Fetching additional multiplier (3) on thread: " + Thread.currentThread().getName());
                return 3; // Fetch a multiplier
            }),
            (currentResult, multiplier) -> {
                int finalResult = currentResult * multiplier; // Multiply the results
                System.out.println("Multiplying current result with additional multiplier: " + finalResult 
                                   + " on thread: " + Thread.currentThread().getName());
                return finalResult; // Return the final result
            }
        )
        // Ensure that the last transformation is still returning Integer
        .thenApply(finalResult -> {
            System.out.println("Finalizing result: " + finalResult + " on thread: " + Thread.currentThread().getName());
            return finalResult; // Return the integer result
        })
        // Final step: Print the result
        .thenAccept(result -> System.out.println("Final result after chaining: " + result 
                                                 + " on thread: " + Thread.currentThread().getName()));

        // Wait for all tasks to complete
        futureChain.get(); // Wait for the final result
    }
}
