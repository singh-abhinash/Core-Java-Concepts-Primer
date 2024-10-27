package multithreading.threadTypes;

public class ThreadJoinExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started.");
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 finished.");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started.");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 finished.");
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // Main thread waits for t1 to finish
            t2.join(); // Main thread waits for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed after t1 and t2.");
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * The Thread.join() method makes the calling thread wait until the thread on which join() was called completes 
 * its execution.
 * 
 * Explanation:
 * -> Thread t1 and Thread t2 start independently.
 * -> The main thread calls t1.join() and t2.join(), then main() thread will wait until both t1 and t2 finish execution.
 * -> After both threads are complete, the main thread prints its final message.
 */
