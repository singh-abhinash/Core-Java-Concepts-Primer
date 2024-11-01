package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DifferentExecutorServiceExample {
	//either public static void main(String[] args) throws InterruptedException or try cache
    public static void main(String[] args) {
        // Example 1: Fixed Thread Pool Executor
        System.out.println("=== Fixed Thread Pool Example ===");
        
        // Creating a Fixed Thread Pool with 3 threads
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        
        // Submitting 5 tasks to the fixed thread pool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedThreadPool.submit(() -> {
                System.out.println("Fixed Thread Pool - Executing Task " + taskId + " on thread: " + Thread.currentThread().getName());
            });
        }
        
        // Shutting down the fixed thread pool after tasks are completed
        fixedThreadPool.shutdown();
        try {
            Thread.sleep(2000);  // Add a delay for clarity in output
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();  // Restore interrupted status
        }
        
        // Example 2: Cached Thread Pool Executor
        System.out.println("\n=== Cached Thread Pool Example ===");
        
        // Creating a Cached Thread Pool (creates new threads as needed and reuses them when available)
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        
        // Submitting 5 tasks to the cached thread pool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedThreadPool.submit(() -> {
                System.out.println("Cached Thread Pool - Executing Task " + taskId + " on thread: " + Thread.currentThread().getName());
            });
        }
        
        // Shutting down the cached thread pool after tasks are completed
        cachedThreadPool.shutdown();
        try {
            Thread.sleep(2000);  // Add a delay for clarity in output
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();  // Restore interrupted status
        }
        
        // Example 3: Single Thread Executor
        System.out.println("\n=== Single Thread Executor Example ===");
        
        // Creating a Single Thread Executor (executes tasks sequentially on a single thread)
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        
        // Submitting 5 tasks to the single thread executor
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleThreadExecutor.submit(() -> {
                System.out.println("Single Thread Executor - Executing Task " + taskId + " on thread: " + Thread.currentThread().getName());
            });
        }
        
        // Shutting down the single thread executor after tasks are completed
        singleThreadExecutor.shutdown();
        try {
            Thread.sleep(2000);  // Add a delay for clarity in output
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();  // Restore interrupted status
        }
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Java program that demonstrates the usage of three different types of ExecutorService: a Fixed Thread Pool, 
 * a Cached Thread Pool, and a Single Thread Executor.
 * 
 * Explanation of Each Example:
 * 
 * 1) Fixed Thread Pool:
 * -> FixedThreadPool creates a fixed number of threads (in this case, 3).
 * -> Any extra tasks beyond the number of available threads wait until a thread becomes free.
 * -> The output shows tasks being executed by up to 3 threads concurrently.
 * 
 * 2) Cached Thread Pool:
 * -> CachedThreadPool creates new threads as needed but reuses previously constructed threads when they’re available.
 * -> There is no limit on the number of threads; it dynamically manages threads based on the tasks.
 * -> Tasks may run on different threads if threads are idle, or on newly created ones if more threads are needed.
 * 
 * 3) Single Thread Executor:
 * -> SingleThreadExecutor uses a single thread to execute tasks in sequence, ensuring only one task runs at a time.
 * -> This is useful for scenarios where you need sequential task execution.
 * -> All tasks are handled by the same thread, which is evident in the output.
 * 
 * RUN THIS ROGRAM YOU AR EABLE TO UNDERSTAND
 */
