package threadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class WorkStealingPoolExample {
    public static void main(String[] args) {
        // Create a work-stealing pool
        ForkJoinPool pool = new ForkJoinPool();

        // Example task to compute the sum of numbers from 1 to 1000
        SumTask task = new SumTask(1, 1000);

        // Execute the task and get the result
        int result = pool.invoke(task);

        System.out.println("Sum from 1 to 1000 is: " + result);
    }
}

class SumTask extends RecursiveTask<Integer> {
    private final int start;
    private final int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int threshold = 10; // If the task is small enough, complete it directly

        if ((end - start) <= threshold) {
            // Calculate sum directly if the range is small
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // Otherwise, split the task
            int mid = (start + end) / 2;

            SumTask leftTask = new SumTask(start, mid);
            SumTask rightTask = new SumTask(mid + 1, end);

            // Fork both subtasks to be processed in parallel
            leftTask.fork();
            rightTask.fork();

            // Join and combine results from both subtasks
            return leftTask.join() + rightTask.join();
        }
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> A Work-Stealing Pool is a type of executor service designed for handling multiple parallel tasks efficiently. 
 * It works by allowing idle threads to "steal" tasks from busy threads, helping to balance the workload automatically. 
 * This way, each thread can stay productive rather than sitting idle, which improves overall performance, especially 
 * for tasks that can be split into smaller pieces.
 * 
 * ForkJoinPool is an implementation of a work-stealing pool, and it’s one of the core classes used for creating and 
 * managing parallel tasks with the work-stealing approach. When you use a ForkJoinPool, Java automatically enables 
 * work-stealing, allowing threads to dynamically balance the workload across the pool without manual configuration.
 * 
 * How ForkJoinPool Implements Work-Stealing:
 * 
 * Task Queues:
 * -> Each worker thread in a ForkJoinPool has its own deque (double-ended queue) to hold tasks.
 * -> When a thread creates a new task (using fork()), it places this task at the bottom of its deque.
 * 
 * Task Execution:
 * -> Each thread primarily works on tasks from its own deque. It picks tasks from the bottom of its deque to 
 * maximize cache locality (since recent tasks are likely related to previous ones).
 * 
 * Work-Stealing:
 * -> If a thread’s deque is empty, it will attempt to "steal" tasks from the top of other threads' deques.
 * -> Stealing from the top allows the other thread to keep working on more recent tasks (those at the bottom of the 
 * deque), preserving some degree of locality.
 * 
 * RecursiveTask and RecursiveAction:
 * -> The ForkJoinPool is typically used with tasks that extend RecursiveTask (for tasks that return results) or 
 * RecursiveAction (for tasks that don’t return results).
 * -> When these tasks are divided into smaller subtasks (using the compute method), they are forked and can be processed in parallel by different threads.
 * 
 */
