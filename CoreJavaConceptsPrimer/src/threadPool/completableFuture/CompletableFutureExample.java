package threadPool.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Run a task asynchronously and apply a transformation once complete
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Asynchronous task that simulates a calculation
            System.out.println("Performing a long-running calculation on thread: " + Thread.currentThread().getName());
            return 10;  // Simulated result
        })
        .thenApply(result -> {
            // Transform the result of the previous task
            System.out.println("Doubling the result on thread: " + Thread.currentThread().getName());
            return result * 2;
        })
        .exceptionally(ex -> {
            // Handle any exceptions from previous stages
            System.err.println("Exception: " + ex.getMessage() + " on thread: " + Thread.currentThread().getName());
            return -1;  // Fallback value if an exception occurs
        });

        // Blocking call to get the result (for demonstration only)
        int finalResult = future.join();  // join() is similar to get() but doesn't throw checked exceptions
        System.out.println("Final result: " + finalResult + " retrieved on thread: " + Thread.currentThread().getName());
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Explanation:
 * -> supplyAsync(): Runs the initial asynchronous calculation task on a separate thread from the pool, and prints 
 * the current thread name.
 * -> thenApply(): Transforms the result from supplyAsync (doubling it) and prints the thread executing this 
 * transformation.
 * -> exceptionally(): Catches exceptions in any previous stage, printing the error and the thread handling the 
 * exception.
 * -> join(): Retrieves the final result and prints it along with the thread that retrieves it.
 * 
 * CompletableFuture in Java is an extension of the Future interface that provides a more powerful and flexible way 
 * to handle asynchronous programming. It was introduced in Java 8 as part of the java.util.concurrent package to 
 * enable non-blocking, asynchronous programming with functional-style callbacks and chaining operations. 
 * CompletableFuture allows us to easily set up tasks that are executed asynchronously, process their results, and 
 * handle potential errors in a fluent, declarative way.
 * 
 * Key Features of CompletableFuture:
 * -> Non-blocking Async Operations: CompletableFuture allows tasks to run in the background without blocking the main 
 * thread, meaning you can continue executing other tasks while waiting for the async task to complete.
 * -> Callback Support: You can attach callbacks that will execute once the CompletableFuture is complete. For 
 * example, .thenApply(), .thenAccept(), and .thenRun() methods allow chaining operations.
 * -> Combining Multiple Futures: CompletableFuture provides methods for combining multiple asynchronous tasks, such 
 * as thenCombine(), thenCompose(), and allOf(), making it ideal for handling complex async workflows.
 * -> Exception Handling: It provides methods to handle exceptions in async operations gracefully, such as 
 * exceptionally(), handle(), and whenComplete().
 * 
 * supplyAsync()         ->	    Asynchronous      ->	Starts a task asynchronously and returns a result.
 * thenApply()           ->	    Synchronous	      ->    Transforms the result of a CompletableFuture.
 * thenApplyAsync()	     ->     Asynchronous	  ->    Transforms the result in a new thread.
 * thenCompose()	     ->     Synchronous	      ->    Chains dependent tasks, flattening nested CompletableFutures.
 * thenComposeAsync()	 ->     Asynchronous	  ->    Chains dependent tasks asynchronously.
 * thenAccept()	         ->     Synchronous	      ->    Consumes the result without returning anything.
 * thenAcceptAsync()	 ->     Asynchronous	  ->    Consumes the result in a new thread.
 * thenCombine()	     ->     Synchronous	      ->    Combines results from two CompletableFutures.
 * thenCombineAsync()	 ->     Asynchronous	  ->    Combines results asynchronously.
 * 
 */

