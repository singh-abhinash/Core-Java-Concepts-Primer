package threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableAndCallableExample {

    public static void main(String[] args) {
        // Creating a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Runnable task: A simple logging operation (no return value)
        Runnable logTask = () -> {
            System.out.println("Logging information from: " + Thread.currentThread().getName());
        };

        // Submitting the Runnable task to the executor
        executorService.submit(logTask);

        // Callable task: A calculation that returns a result (return type Integer)
        Callable<Integer> calculationTask = () -> {
            System.out.println("Calculating in: " + Thread.currentThread().getName());
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        };

        // Submitting the Callable task to the executor and getting a Future to retrieve the result
        Future<Integer> futureResult = executorService.submit(calculationTask);

        // Retrieving the result of the Callable task
        try {
            int result = futureResult.get();  // This will block until the result is available
            System.out.println("Result of calculation task: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("Exception occurred during task execution: " + e.getMessage());
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Here’s a point-by-point comparison between Runnable interface and Callable interface:
 * 
 * Return Type:
 * -> Runnable: Does not return any result (void).
 * -> Callable: Returns a result of type T (uses Future<T> to retrieve it).
 * 
 * Method Signature:
 * -> Runnable: Has a run() method with no return value.
 * -> Callable: Has a call() method that returns a result.
 * 
 * Exception Handling:
 * -> Runnable: Cannot throw checked exceptions.
 * -> Callable: Can throw checked exceptions, making it more flexible for error-prone tasks.
 * 
 * Usage with Executors:
 * -> Runnable: submit(Runnable task) method in executors, which returns a Future<?> but isn’t often used to retrieve results.
 * -> Callable: submit(Callable<T> task) returns a Future<T>, which allows retrieval of the result.
 * 
 * Common Purpose:
 * -> Runnable: Suited for tasks that do not require a result, such as logging or status updates.
 * -> Callable: Ideal for tasks that return a computed result, such as calculations or fetching data.
 * 
 * Result Retrieval:
 * -> Runnable: Results, if needed, must be handled through side effects or shared variables.
 * -> Callable: Allows direct result retrieval through Future.get().
 * 
 * In short, Runnable is for tasks with no return value, while Callable is for tasks where you need a result or to 
 * handle exceptions.
 * 
 * -> FutureTask<?>: Here, FutureTask<?> is used to wrap the Runnable task, indicating that no specific result type is 
 * expected (<?> represents any type(String, Integer....) or none).
 * -> New FutureTask<>(Runnable, null): The second parameter is null because there's no meaningful result expected from 
 * this Runnable task.
 * -> Using futureTask.get(): Although the Runnable doesn’t produce a result, get() will still block until the task 
 * completes, which can be helpful for checking task completion.
 */