package multithreading.diffTerentWaysToCreateThread;

public class LetterNumberPrinterExtendingThread {
	private static final Object lock = new Object(); // shared lock
    private static boolean isLetterTurn = true;      // control flag

    public static void main(String[] args) {
        Thread letterThread = new LetterThread();
        Thread numberThread = new NumberThread();

        letterThread.start();
        numberThread.start();
    }

    // Thread that prints letters A to Z
    static class LetterThread extends Thread {
        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                synchronized (lock) {
                    while (!isLetterTurn) {
                        try {
                            lock.wait(); // wait if not letter's turn
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(ch + " ");
                    isLetterTurn = false; // now it's number's turn
                    lock.notify();        // wake up number thread
                }
            }
        }
    }

    // Thread that prints numbers 1 to 26
    static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    while (isLetterTurn) {
                        try {
                            lock.wait(); // wait if not number's turn
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(i + " ");
                    isLetterTurn = true; // now it's letter's turn
                    lock.notify();       // wake up letter thread
                }
            }
        }
    }
}
