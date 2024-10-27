package multithreading.threadTypes;

public class ThreadPriorityExample {

	public static void main(String[] args) {
		Thread highPriorityThread = new Thread(() -> {
            System.out.println("High priority thread started.");
            for (int i = 1; i <= 5; i++) {
                System.out.println("High priority thread - " + i);
            }
            System.out.println("High priority thread finished.");
        });

        Thread lowPriorityThread = new Thread(() -> {
            System.out.println("Low priority thread started.");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Low priority thread - " + i);
            }
            System.out.println("Low priority thread finished.");
        });

        // Set priorities
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();

	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
* -> Thread priority affects the order in which threads are scheduled to run, but it’s not guaranteed because 
* scheduling is platform-dependent. The priority range is from MIN_PRIORITY (1) to MAX_PRIORITY (10), with 
* NORM_PRIORITY (5) as the default.
* -> highPriorityThread is given MAX_PRIORITY (10).
* -> lowPriorityThread is given MIN_PRIORITY (1).
* -> Although highPriorityThread may run sooner and more often, priority doesn’t guarantee execution order—it only 
* influences the thread scheduler.
*/
