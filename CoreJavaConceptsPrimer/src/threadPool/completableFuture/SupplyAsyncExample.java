package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncExample {
    public static void main(String[] args) {
        // Creating an asynchronous task with supplyAsync
        CompletableFuture<Integer> supplyTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync: Initial task on thread: " + Thread.currentThread().getName());
            return 20; // Returns an integer value
        }).exceptionally(ex -> {
            System.err.println("Exception occurred: " + ex.getMessage());
            return -1; // Fallback value in case of exception
        });

        // Block the main thread until the task completes
        int result = supplyTask.join(); // This will ensure the main thread waits for the task to finish
        System.out.println("Result from SupplyAsync: " + result); // Print the result from the asynchronous task

        // Indicate that the main thread has completed execution after the task
        System.out.println("Thread task is completed; now the main thread will execute.");
    }
}


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> supplyAsync() runs a task asynchronously and returns a CompletableFuture that holds the result of that task.
 * -> It’s useful for initiating a computation that produces a result (like fetching data from an API).
 * 
 * Code Explanation:
 * 
 * Creating an Asynchronous Task:
 * -> CompletableFuture<Integer> supplyTask = CompletableFuture.supplyAsync(() -> { ... });
 * -> A CompletableFuture object named supplyTask is created.
 * -> The supplyAsync method is called, which executes the provided lambda expression asynchronously. This means the 
 * task will run in a separate thread, managed by the Java thread pool.
 * -> Inside the lambda expression, it prints the current thread name using Thread.currentThread().getName() and 
 * returns the integer value 20.
 * -> the task inside supplyAsync() runs asynchronously, and the result (20) is stored in the CompletableFuture 
 * object, future.
 * 
 * Blocking the Main Thread:
 * supplyTask.join();
 * -> This line causes the main thread (the thread executing the main method) to block and wait until the supplyTask 
 * is completed.
 * -> The join method is a blocking call that ensures that the main thread will not proceed until the asynchronous 
 * task has finished execution. It is similar to calling get() on the CompletableFuture, but join() does not throw 
 * checked exceptions.
 */
