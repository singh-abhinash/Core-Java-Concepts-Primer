package threadPool;

import java.util.concurrent.*;

//Define a Task class that implements Runnable for each task to be executed
class Task implements Runnable {
 private final String taskName;

 // Constructor to initialize the task with a specific name
 public Task(String name) {
     this.taskName = name;
 }
 
 public String getTaskName() {
     return taskName;
 }

 @Override
 public void run() {
     // Display the thread executing this task
     System.out.println(Thread.currentThread().getName() + " is executing task: " + taskName);
     try {
         // Simulate some work with a sleep period
         Thread.sleep(4000);
     } catch (InterruptedException e) {
         // Handle the case where the task is interrupted
         System.out.println(taskName + " was interrupted.");
     }
     // Display when task execution is completed
     System.out.println(Thread.currentThread().getName() + " completed task: " + taskName);
 }
}

public class ThreadPoolExecutorExample {
 public static void main(String[] args) {
     // Define the core pool size, minimum number of threads always kept alive
     int corePoolSize = 3;

     // Define the maximum pool size, the limit of active threads allowed
     int maxPoolSize = 5;

     // Define the keep-alive time, idle time before threads are released
     long keepAliveTime = 1;

     // Define the unit of keep-alive time (seconds here)
     TimeUnit unit = TimeUnit.SECONDS;

     // Define a blocking queue with a capacity of 5 to hold tasks when all threads are busy
     BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);

     // Define a custom handler for tasks that are rejected when the pool and queue are full
     RejectedExecutionHandler handler = new RejectedExecutionHandler() {
         @Override
         public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
             // Print out a message if a task is rejected
             System.out.println("Task rejected: " + ((Task) r).getTaskName());
         }
     };

     // Create the ThreadPoolExecutor with the defined configurations
     ThreadPoolExecutor executor = new ThreadPoolExecutor(
             corePoolSize,        // Minimum threads in pool
             maxPoolSize,         // Maximum threads in pool
             keepAliveTime,       // Time to keep extra threads alive when idle
             unit,                // Time unit for keepAliveTime
             workQueue,           // Queue for holding waiting tasks
             handler              // Handler for rejected tasks
     );

     // Submit 11 tasks to the pool, simulating a workload that exceeds pool and queue capacity
     // Change this range and see how it is working
     for (int i = 1; i <= 5; i++) {
         // Create a task with a unique name
         Task task = new Task("Task-" + i);
         // Log the submission of the task
         System.out.println("Submitting " + task.getTaskName());
         // Submit the task to the executor
         executor.execute(task);
     }

     // Initiate a graceful shutdown, stopping new tasks from being accepted
     executor.shutdown();

     try {
         // Wait for tasks to complete for up to 10 seconds
         if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
             // Force shutdown if tasks do not complete in the given time
             System.out.println("Forcing shutdown as tasks did not finish in time.");
             executor.shutdownNow(); // This interrupts any running tasks
         }
     } catch (InterruptedException e) {
         // If the await is interrupted, proceed with a forced shutdown
         executor.shutdownNow();
     }

     // Confirm that all tasks have completed and the executor is shut down
     System.out.println("All tasks completed, executor shut down.");
 }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * SCENARIO BASED QUESTION:
 * QUESTION -> Consider a scenario where a ThreadPoolExecutor is configured with the following parameters: a core 
 * pool size of 3, a maximum pool size of 5, and a task queue capacity of 5. You have a total of 11 tasks to be 
 * executed. Describe in detail how the ThreadPoolExecutor would handle each task under these conditions, addressing 
 * how the pool scales, how tasks are queued, and how the executor responds when both the queue and the thread pool 
 * reach their maximum capacities.
 * 
 * ANSWER -> Let’s walk through this scenario step-by-step, focusing on how ThreadPoolExecutor handles tasks given 
 * the configuration:
 * 
 * Total Tasks: 11 tasks
 * Queue Capacity: 5
 * Core Pool Size (Minimum Threads): 3
 * Maximum Pool Size: 5
 * 
 * 1. Initial Pool State (Start)
 * -> When tasks begin, ThreadPoolExecutor first attempts to use the core pool size (minimum threads) of 3 threads to 
 * handle incoming tasks. If more tasks arrive than these threads can handle, the executor will use its queue to 
 * store tasks.
 * 
 * 		Tasks 1 to 3:
 * 		-> The executor starts with 3 threads and assigns the first three tasks to these threads.
 * 		-> Pool State: 3 active threads, queue has 0 tasks.
 * 
 * 		Tasks 4 to 8:
 * 		-> As tasks arrive, the executor enqueues them in the queue until the queue reaches its capacity of 5.
 * 		-> Pool State: 3 active threads, queue has 5 tasks (full).
 * 		-> There are two types of queue, bounded queue and unbounded queue. We generally use bounded queue.
 * 
 * 2. Scaling Beyond Core Pool Size (Maxing Out the Pool)
 * -> When new tasks continue arriving after the queue is full, ThreadPoolExecutor begins to scale up the pool beyond 
 * its core size (up to the maximum).
 * 
 * 		Tasks 9 and 10:
 * 		-> The executor has exhausted its queue, so it adds additional threads to the pool to accommodate these tasks 
 * directly, up to the maximum pool size of 5 threads.
 * 		-> Pool State: 5 active threads (handling 5 tasks), queue has 5 tasks (full).
 * 
 * 3. Task Rejection (When Limits Are Exceeded)
 * -> When the pool has reached its maximum thread capacity and the queue is full, new tasks are rejected.
 * 
 * 		Task 11:
 * 		-> At this point, both the queue and the pool are at their configured limits (5 tasks in queue, 5 threads running tasks).
 * 		-> Result: Task 11 is rejected because the ThreadPoolExecutor cannot add any more threads or queue the task.
 * 
 * Summary of Execution Process:
 * -> The first 3 tasks start immediately in the core threads.
 * -> Tasks 4 to 8 enter the queue, filling it to its capacity.
 * -> Tasks 9 and 10 cause the executor to increase the pool size to the maximum (5 threads).
 * -> Task 11 is rejected as neither the queue nor the pool can expand further.
 * 
 * This configuration shows how ThreadPoolExecutor manages tasks by trying to utilize threads efficiently within the 
 * core pool, then using the queue, and finally scaling the pool up to a maximum before rejecting excess tasks.
 * 
 */
//#####################################################################################################################
/**
 * ThreadPoolExecutor Life Cycle:
 * -> RUNNING: Initially, the executor is in the Running state. In this state, it actively accepts new tasks and 
 * processes tasks from the queue.
 * 
 * -> SHUTDOWN INITIATED: When shutdown() is called, the executor stops accepting new tasks but continues to execute 
 * any already submitted or queued tasks. This allows tasks to finish gracefully.
 * 
 * -> TERMINATE: After all tasks complete and the queue is empty, the executor enters the Terminating state, where 
 * it waits for all threads to finish their work.
 * 
 * -> TERMINATED: Once all tasks have finished executing and the threads have terminated, the executor enters the 
 * Terminated state, where all resources (like threads) are released, and it no longer processes any tasks.
 * 
 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Question: Difference Between shutdown() and stop()?
 * -> shutdown(): Initiates a shutdown where the executor stops taking new tasks but completes the ongoing 
 * and queued tasks. This is safer and ensures that tasks are not interrupted, minimizing the risk of incomplete 
 * operations or data inconsistency.
 * 
 * -> stop() (often achieved with shutdownNow() in Java): Immediately halts all running and queued tasks, interrupting 
 * the threads. This method is more abrupt and can lead to incomplete tasks or interrupted operations. Use it 
 * carefully if you need an immediate shutdown.
 */