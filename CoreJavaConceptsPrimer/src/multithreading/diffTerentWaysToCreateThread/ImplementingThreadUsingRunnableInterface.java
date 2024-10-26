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

