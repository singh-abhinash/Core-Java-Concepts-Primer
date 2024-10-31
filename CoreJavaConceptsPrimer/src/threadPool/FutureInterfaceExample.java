package threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureInterfaceExample {

    public static void main(String[] args) {
        // Creating a Callable task that will be executed asynchronously
        Callable<Integer> callableTask = () -> {
            System.out.println("Executing task...");
            TimeUnit.SECONDS.sleep(2);  // Simulate some work
            return 42;  // Return a result
        };

        // Wrapping the Callable task in a FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        // Creating a thread pool to execute the FutureTask
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(futureTask);

        // Demonstrating Future interface methods
        try {
            // 1. isDone() - Checks if the task is complete
            System.out.println("Is task done? " + futureTask.isDone());

            // 2. get() - Waits for the task to complete and returns the result
            System.out.println("Waiting for the result...");
            int result = futureTask.get();  // This will block until the task completes
            System.out.println("Result of the task: " + result);

            // 3. isDone() - After get(), task should be done
            System.out.println("Is task done? " + futureTask.isDone());

            // 4. isCancelled() - Checks if the task was canceled
            System.out.println("Was task canceled? " + futureTask.isCancelled());

            // 5. cancel() - Attempts to cancel the task
            boolean cancelResult = futureTask.cancel(true);  // If the task is already completed, cancel() has no effect
            System.out.println("Task cancellation attempted: " + cancelResult);

            // 6. get(long timeout, TimeUnit unit) - Tries to get the result within the specified time
            System.out.println("Trying to get result with timeout...");
            Integer timedResult = futureTask.get(1, TimeUnit.SECONDS);  // Adjust timeout as needed
            System.out.println("Timed result: " + timedResult);

        } catch (InterruptedException e) {
            System.err.println("Task was interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Exception occurred during task execution: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Timed out or other exception: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> In Java 8, the Future interface is used to represent the result of an asynchronous computation, a task that is 
 * running in the background and will return a result at some point. Java 8 introduced a related feature called 
 * CompletableFuture, which makes working with asynchronous tasks easier, adding several improvements over Future 
 * alone. Here’s a simple breakdown of what CompletableFuture brings:
 * 
 * -> Whenever we will do poolExecutor.submit() then it always return future object
 * Future<?> futureObj = poolExecutor.submit();
 * -> Using this future object we can know the status of thread.
 * 
 * -> Suppose thread1 and thread2 is calling from main() which is caller thread, now what if caller wants to know the 
 * status of thread1 and thread2, whether its completed or failed. To the solution future comes into picture. 
 * 
 * -> An asynchronous task is a task that runs independently of the main program flow, allowing the program to continue 
 * executing other tasks without waiting for the asynchronous task to finish. In other words, it's a task that 
 * doesn’t block the main thread (or calling code) while it's running. Once the task is complete, it typically 
 * returns a result or notifies the main thread.
 * 
 * -> For example - Imagine you're baking a cake (an asynchronous task) and decide to go for a walk (the main program) 
 * while the cake is baking. You don’t need to stand in the kitchen and wait. Once the cake is ready, your timer 
 * (callback) goes off to notify you to come back and take the cake out.
 * 
 * -> In Java, a CompletableFuture allows asynchronous programming:
 * CompletableFuture<Void> asyncTask = CompletableFuture.runAsync(() -> {
 *   	try {
 *      	Thread.sleep(2000); // Simulate a long-running task
 *      	System.out.println("Task completed!");
 *  	} 	catch (InterruptedException e) {
 *       	e.printStackTrace();
 *  	}
 * });
 * 
 * System.out.println("Main program keeps running!");
 * asyncTask.join(); // Wait for asyncTask to complete if needed
 * 
 * 
 * -> Asynchronous tasks make programs more efficient by allowing parallel processing of tasks without waiting on 
 * each one to finish before starting the next.
 * 
 */
