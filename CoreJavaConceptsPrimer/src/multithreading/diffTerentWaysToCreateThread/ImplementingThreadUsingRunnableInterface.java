package multithreading.diffTerentWaysToCreateThread;

class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Number: " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished.");
    }
}

public class ImplementingThreadUsingRunnableInterface {
    public static void main(String[] args) {
        // Creating Runnable objects
        Runnable runnableObj1 = new MyRunnable("Runnable Thread 1");
        Runnable runnableObj2 = new MyRunnable("Runnable Thread 2");

        // Wrapping Runnable objects in Thread objects and starting them
        Thread thread1 = new Thread(runnableObj1);
        Thread thread2 = new Thread(runnableObj2);

        //starting thread
        thread1.start();
        thread2.start();
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Summary:
 * -> Runnable: You pass an object implementing Runnable to Thread because Runnable only defines the task, and 
 * Thread manages the thread creation and execution.
 * -> runnable is functional interface and it has only one abstract method so we can use lambda expression.
 * 
 * -> Thread: When extending Thread, your subclass already has all thread management capabilities, so you create an 
 * instance of your subclass and call start() directly without needing an external object.
 */

/**
 * class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Running in a thread");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable(); // Create an instance of Runnable
        Thread thread = new Thread(runnable);   // Pass Runnable instance to Thread
        thread.start();                         // Start the thread
    }
}

 */

/**
 * Using a lambda expression, we can simplify the code by directly passing the Runnable task without needing to 
 * create a separate class for it. Here's how it would look:
 * 
 * public class Main {
    public static void main(String[] args) {
        // Using a lambda expression to create a Runnable
        Thread thread = new Thread(() -> System.out.println("Running in a thread"));
        
        thread.start(); // Start the thread
    }
}

 */

