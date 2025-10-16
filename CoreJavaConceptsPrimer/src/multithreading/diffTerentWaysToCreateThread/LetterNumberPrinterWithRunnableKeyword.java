package multithreading.diffTerentWaysToCreateThread;

public class LetterNumberPrinterWithRunnableKeyword {
	private static final Object lock = new Object(); // shared lock object
    private static boolean isLetterTurn = true;      // flag to control turn

    public static void main(String[] args) {
        Runnable letterTask = new Runnable() {
            public void run() {
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
            }
        };

        Runnable numberTask = new Runnable() {
            public void run() {
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
            }
        };

        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);

        letterThread.start();
        numberThread.start();
    }
}
