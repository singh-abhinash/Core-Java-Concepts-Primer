package multithreading.customLocksTypes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ToggleSwitch {
    private boolean isOn = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // Method to turn on the switch
    public void turnOn() {
        lock.lock();
        try {
            isOn = true;
            System.out.println("Toggle is ON");
            condition.signal(); // Notify waiting thread
        } finally {
            lock.unlock();
        }
    }

    // Method to wait until the toggle is on
    public void waitForToggle() {
        lock.lock();
        try {
            while (!isOn) {
                System.out.println("Waiting for toggle to be ON...");
                condition.await(); // Wait until toggle is on
            }
            System.out.println("Toggle is ON, proceeding...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class ConditionLockExample {
    public static void main(String[] args) {
        ToggleSwitch toggleSwitch = new ToggleSwitch();

        // Thread to wait for the toggle to be ON
        Thread waitingThread = new Thread(toggleSwitch::waitForToggle);

        // Thread to turn ON the toggle
        Thread turningOnThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some delay
                toggleSwitch.turnOn();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        waitingThread.start();
        turningOnThread.start();
    }
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * In condition lock we have something call await() and signal() which is similar to wait() and resume().
 * -> wait() and resume() work with monitor lock and await() and signal() work with custom lock
 * 
 * 
 * Explanation of the Flow:
 * -> waitingThread calls waitForToggle() and enters a waiting state because isOn is initially false. It prints 
 * "Waiting for toggle to be ON...".
 * -> turningOnThread waits for a short delay and then calls turnOn(), setting isOn to true and signaling the 
 * condition.
 * -> When waitingThread receives the signal, it resumes, checks that isOn is true, and then proceeds, printing 
 * "Toggle is ON, proceeding...".
 */
