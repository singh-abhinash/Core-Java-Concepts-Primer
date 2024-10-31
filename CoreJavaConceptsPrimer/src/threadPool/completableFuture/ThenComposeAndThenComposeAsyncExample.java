package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenComposeAndThenComposeAsyncExample {
    public static void main(String[] args) {
        // Initial task with supplyAsync
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync: Initial task on thread: " + Thread.currentThread().getName());
            return 20; // This is the result of the initial task
        });

        // Synchronous chaining of dependent task with thenCompose
        CompletableFuture<Integer> dependentFuture = future.thenCompose(value -> {
            System.out.println("thenCompose: Creating dependent task on thread: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> value * 2); // Returns a new CompletableFuture with result 40
        });

        // Asynchronous chaining of dependent task with thenComposeAsync
        CompletableFuture<Integer> asyncDependentFuture = future.thenComposeAsync(value -> {
            System.out.println("thenComposeAsync: Creating dependent task asynchronously on thread: " + Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> value * 2); // Also returns a new CompletableFuture with result 40
        });

        // Waits until the synchronous dependent task is complete
        int result = dependentFuture.join();  // Waits for the completion of the dependent task
        System.out.println("Result from synchronous dependent task: " + result); // This would print 40

        // Waits until the asynchronous dependent task is complete
        int asyncResult = asyncDependentFuture.join();  // Waits for the completion of the async dependent task
        System.out.println("Result from asynchronous dependent task: " + asyncResult); // This would also print 40
    }
}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> thenCompose() is used when you have a CompletableFuture that depends on another CompletableFuture. It flattens 
 * two CompletableFutures into one, making it easier to chain tasks.
 * -> thenComposeAsync() does the same but executes the dependent task asynchronously in a separate thread.
 */