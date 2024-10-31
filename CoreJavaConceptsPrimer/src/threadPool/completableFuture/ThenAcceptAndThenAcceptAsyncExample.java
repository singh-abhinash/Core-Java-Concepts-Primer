package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptAndThenAcceptAsyncExample {
    public static void main(String[] args) {
        // Initial task with supplyAsync
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync: Initial task on thread: " + Thread.currentThread().getName());
            return 20; // Returns an integer value
        }).exceptionally(ex -> {
            System.err.println("Exception occurred: " + ex.getMessage());
            return -1; // Fallback value in case of exception
        });

        // Synchronous consumption of result with thenAccept
        CompletableFuture<Void> thenAcceptFuture = future.thenAccept(value -> {
            System.out.println("thenAccept: Consuming value on thread: " + Thread.currentThread().getName() + ", Value: " + value);
        });

        // Asynchronous consumption of result with thenAcceptAsync
        CompletableFuture<Void> thenAcceptAsyncFuture = future.thenAcceptAsync(value -> {
            System.out.println("thenAcceptAsync: Consuming value asynchronously on thread: " + Thread.currentThread().getName() + ", Value: " + value);
        });

        // Ensures main thread waits for all tasks to finish
        thenAcceptFuture.join(); // Waits for synchronous task to finish
        thenAcceptAsyncFuture.join(); // Waits for asynchronous task to finish

        System.out.println("All tasks are completed; now the main thread will execute.");
    }
}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> thenAccept() takes the result of a CompletableFuture and performs an action with it, without returning a new 
 * value (it’s a Consumer action).
 * -> thenAcceptAsync() does the same but runs the action asynchronously in a separate thread.
 */
