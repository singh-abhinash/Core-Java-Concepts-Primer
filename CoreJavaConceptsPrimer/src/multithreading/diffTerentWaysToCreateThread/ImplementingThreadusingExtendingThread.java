package multithreading.diffTerentWaysToCreateThread;

class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
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

public class ImplementingThreadusingExtendingThread {
    public static void main(String[] args) {
        // Creating Thread objects and starting them
        MyThread thread1 = new MyThread("Extended Thread 1");
        MyThread thread2 = new MyThread("Extended Thread 2");

        thread1.start();
        thread2.start();
    }
}
