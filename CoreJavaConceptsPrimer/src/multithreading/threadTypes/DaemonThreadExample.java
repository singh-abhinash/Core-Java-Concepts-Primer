package multithreading.threadTypes;

public class DaemonThreadExample {

	public static void main(String[] args) {
		Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread working in background.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread interrupted.");
                    break;
                }
            }
        });

        daemonThread.setDaemon(true); // Set as daemon thread
        daemonThread.start();

        System.out.println("Main thread sleeping for 2 seconds.");
        try {
            Thread.sleep(2000); // Simulate work in main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed.");
        System.out.println("Daemon thread will be completed at the last when all user thread will be completed.");

	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
* -> A daemon thread runs in the background and terminates when all non-daemon threads(non daemon thread means user 
* thread) complete. It’s suitable for background tasks like logging or monitoring.
* -> daemonThread is a daemon thread (set with .setDaemon(true)).
* -> The main thread completes after 2 seconds, causing the daemon thread to stop automatically.
* -> The daemon thread runs a background task but stops immediately when the main thread finishes.
*/
