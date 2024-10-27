package multithreading.threadTypes;

public class CombinedThreadTypeExample {

	public static void main(String[] args) {
		// High-priority, non-daemon thread with join
        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread started.");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker thread - Task " + i);
                try {
                    Thread.sleep(300); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Worker thread finished.");
        });
        workerThread.setPriority(Thread.MAX_PRIORITY); // Set high priority

        // Low-priority, daemon thread
        Thread backgroundThread = new Thread(() -> {
            while (true) {
                System.out.println("Background thread working...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Background thread interrupted.");
                    break;
                }
            }
            System.out.println("Background thread finished.");
        });
        backgroundThread.setDaemon(true); // Set as daemon
        backgroundThread.setPriority(Thread.MIN_PRIORITY); // Set low priority

        // Start both threads
        workerThread.start();
        backgroundThread.start();

        try {
            workerThread.join(); // Main thread waits for worker thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed after worker thread.");
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Explanation:
 * 
 * Worker Thread:
 * -> Has MAX_PRIORITY, so it will likely execute more frequently.
 * -> join() is used on the workerThread, causing the main thread to wait until it finishes.
 * 
 * Background Thread (Daemon):
 * -> Runs in the background with MIN_PRIORITY.
 * -> Since it’s a daemon thread, it will terminate as soon as the main thread finishes.
 * 
 * Execution Order:
 * -> backgroundThread runs in the background and may get fewer chances to run due to its low priority.
 * -> The workerThread finishes all tasks, allowing the main thread to continue.
 * -> After the main thread finishes, the JVM exits, terminating the daemon backgroundThread.
 * 
 * 
 * Question -> In combined example while loop is true then why background thread is not running infinite times?
 * 
 * Answer -> In the combined example, the background thread is set as a daemon thread. Daemon threads in Java are 
 * designed to terminate automatically when all non-daemon threads (such as the workerThread and the main thread) 
 * complete their execution. 
 * 
 * Here’s the sequence that explains why the background thread doesn’t run indefinitely:
 * -> Background Thread Starts: The background thread begins execution in an infinite while loop, printing "Background 
 * thread working..." every 500 milliseconds.
 * -> Worker Thread Completes: The main thread has called workerThread.join(), so it waits for workerThread to finish. 
 * Meanwhile, the background thread keeps printing its message at intervals.
 * -> Main Thread Resumes After Join: When workerThread completes, the main thread resumes execution, prints "Main 
 * thread completed after worker thread", and then finishes.
 * -> JVM Shutdown: At this point, all non-daemon threads have completed. Since the only remaining thread is the 
 * backgroundThread (a daemon thread), the JVM shuts down, which automatically terminates all daemon threads, 
 * including backgroundThread.
 * 
 * So, the backgroundThread doesn’t print its message infinitely because it terminates as soon as the main and worker 
 * threads complete. The JVM doesn’t keep daemon threads running once all non-daemon threads are done.
 */

