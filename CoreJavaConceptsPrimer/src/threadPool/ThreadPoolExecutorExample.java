package threadPool;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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







 */
