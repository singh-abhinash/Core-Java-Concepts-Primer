package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenApplyAndThenApplyAsyncExample {
    public static void main(String[] args) {
        // Initial task with supplyAsync
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync: Initial task on thread: " + Thread.currentThread().getName());
            return 20; // This is the result of the initial task
        });

        // Synchronous transformation using thenApply
        CompletableFuture<Integer> synchronousFuture = future.thenApply(value -> {
            System.out.println("thenApply: Doubling value on thread: " + Thread.currentThread().getName());
            return value * 2; // This will double the value
        });

        // Asynchronous transformation using thenApplyAsync
        CompletableFuture<Integer> asynchronousFuture = future.thenApplyAsync(value -> {
            System.out.println("thenApplyAsync: Doubling value asynchronously on thread: " + Thread.currentThread().getName());
            return value * 2; // This will double the value asynchronously
        });

        // Wait for the completion of the synchronous transformation
        int syncResult = synchronousFuture.join(); // Waits for the synchronous task to complete
        System.out.println("Result from synchronous transformation: " + syncResult); // Prints the result from the synchronous task

        // Wait for the completion of the asynchronous transformation
        int asyncResult = asynchronousFuture.join(); // Waits for the asynchronous task to complete
        System.out.println("Result from asynchronous transformation: " + asyncResult); // Prints the result from the asynchronous task

        // Ensures the main thread waits until all tasks are complete
        System.out.println("All threads' tasks are completed, and now the main thread will execute the task.");
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * thenApply() and thenApplyAsync():
 * -> thenApply() is used to transform the result of a CompletableFuture once it completes. It applies a function to 
 * the result and returns a new CompletableFuture with the transformed result.
 * -> thenApplyAsync() does the same thing, but it runs the transformation asynchronously in a separate thread.
 */
