package multithreading.diffTerentWaysToCreateThread;

public class LetterNumberPrinterWithLambda {
	private static final Object lock = new Object(); // shared lock object
    private static boolean isLetterTurn = true;      // flag to control turn

    public static void main(String[] args) {
        Thread letterThread = new Thread(() -> {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                synchronized (lock) {
                    while (!isLetterTurn) {
                        try {
                            lock.wait(); // wait if it's not letter's turn
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(ch + " "); // print letter
                    isLetterTurn = false;       // set turn to number
                    lock.notify();              // wake up number thread
                }
            }
        });

        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    while (isLetterTurn) {
                        try {
                            lock.wait(); // wait if it's not number's turn
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(i + " "); // print number
                    isLetterTurn = true;       // set turn to letter
                    lock.notify();             // wake up letter thread
                }
            }
        });

        // Start both threads
        letterThread.start();
        numberThread.start();
    }
}
