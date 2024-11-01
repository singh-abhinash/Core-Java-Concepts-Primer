package threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating a ScheduledThreadPoolExecutor with a pool size of 2 threads
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(2);
        
        // Atomic counter to track executions
        AtomicInteger counter = new AtomicInteger(1);

        // Example of schedule(Runnable, delay, TimeUnit)
        scheduler.schedule(() -> {
            System.out.println("Single delayed task executed on: " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        // Example of schedule(Callable, delay, TimeUnit)
        ScheduledFuture<Integer> resultFuture = scheduler.schedule(() -> {
            System.out.println("Single delayed Callable executed on: " + Thread.currentThread().getName());
            return 42;  // Returns a result after delay
        }, 5, TimeUnit.SECONDS);

        // Example of scheduleAtFixedRate(Runnable, initial delay, period, TimeUnit)
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Fixed rate task (every 2 seconds) executed on: " + Thread.currentThread().getName() +
                    ", Execution count: " + counter.getAndIncrement());
        }, 1, 2, TimeUnit.SECONDS);

        // Example of scheduleWithFixedDelay(Runnable, initial delay, delay, TimeUnit)
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed delay task (2 seconds after last execution) executed on: " + Thread.currentThread().getName() +
                    ", Execution count: " + counter.getAndIncrement());
        }, 1, 2, TimeUnit.SECONDS);

        // Blocking to retrieve result from Callable
        Integer result = resultFuture.get();
        System.out.println("Result from scheduled Callable: " + result);

        // Letting tasks run for a while before shutting down
        Thread.sleep(10000);  // Keep main thread alive for 10 seconds to observe periodic tasks
        scheduler.shutdown();
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * The ScheduledThreadPoolExecutor in Java is a thread pool specifically designed for scheduling tasks to run at a 
 * future time or periodically. It provides various methods to execute tasks after a delay or on a fixed schedule, 
 * making it ideal for time-based tasks.
 * 
 * Here's an explanation of each scheduling method with an example:
 * -> schedule(Runnable, delay, time unit): Runs a Runnable task once after a specified delay.
 * -> schedule(Callable, delay, time unit): Runs a Callable task once after a specified delay and returns a result.
 * -> scheduleAtFixedRate(Runnable, initial delay, period, time unit): Starts running a Runnable task after the initial 
 * delay, then repeats it at fixed intervals.
 * -> scheduleWithFixedDelay(Runnable, initial delay, delay, time unit): Starts a Runnable task after the initial delay, 
 * then repeats it with a fixed delay between the end of one execution and the start of the next.
 * 
 * Explanation of Each Code Part:
 * 
 * 1) schedule(Runnable, delay, TimeUnit):
 * -> This method schedules a Runnable to execute once after a delay of 3 seconds.
 * -> It will print the message once and show the thread name executing this task.
 * 
 * 2) schedule(Callable, delay, TimeUnit):
 * -> Schedules a Callable to run once after a delay of 5 seconds.
 * -> This method returns a result (42 in this example) which can be retrieved using get().
 * 
 * 3) scheduleAtFixedRate(Runnable, initialDelay, period, TimeUnit):
 * -> Runs a Runnable after an initial delay of 1 second and then repeats every 2 seconds.
 * -> This is useful for tasks that need to run at precise, fixed intervals.
 * 
 * 4) scheduleWithFixedDelay(Runnable, initialDelay, delay, TimeUnit):
 * -> Runs a Runnable after an initial delay of 1 second, then waits 2 seconds after each execution before running 
 * again.
 * -> This is useful when you want a consistent delay between the end of one execution and the start of the next.
 * 
 * *************8VERY VERY IMPORTANT************
 * 
 * The main difference between scheduleAtFixedRate and scheduleWithFixedDelay lies in how they handle the timing 
 * between executions:
 * 
 * -> scheduleAtFixedRate: This method schedules tasks at a fixed interval. The next execution begins at a set 
 * interval from the start of the previous execution, regardless of whether the previous execution has finished.
 * 
 * -> scheduleWithFixedDelay: This method schedules tasks with a fixed delay between the end of one execution and 
 * the start of the next one. The next execution only starts after the previous execution finishes and a delay 
 * interval has passed.
 * 
 * Real-life Example: Imagine a security guard who patrols different buildings in a company:
 * 
 * Using scheduleAtFixedRate:
 * -> The guard is instructed to start a patrol every 30 minutes, no matter how long each patrol takes. So, if a 
 * patrol takes 20 minutes, there’s a 10-minute break before the next patrol starts. But if it takes 40 minutes, 
 * the next patrol starts immediately without any break. This is a fixed rate schedule, ensuring a patrol starts 
 * exactly every 30 minutes, even if that means some patrols overlap slightly due to delays.
 * 
 * Using scheduleWithFixedDelay:
 * -> The guard is instructed to wait 30 minutes after each patrol finishes before starting the next one. If one 
 * patrol takes 20 minutes, they’ll start the next patrol 50 minutes after starting the first one 
 * (20 minutes to complete patrol + 30-minute delay). If it takes 40 minutes, the next patrol starts 70 minutes 
 * after starting the first (40 minutes for patrol + 30-minute delay). This is a fixed delay schedule, allowing time 
 * between tasks to prevent overlap and ensuring enough break time after each patrol.
 * 
 * In short:
 * -> Fixed rate (scheduleAtFixedRate) is like a recurring alarm clock set to go off every 30 minutes, no matter what.
 * -> Fixed delay (scheduleWithFixedDelay) is like waiting for a set rest period after each patrol, ensuring a break 
 * between tasks.
 */

