package multithreading.diffTerentWaysToCreateThread;

public class LetterNumberPrinterWithoutLambda {

    private static final Object lock = new Object(); // shared lock
    private static boolean isLetterTurn = true;      // true -> letter's turn

    public static void main(String[] args) {
        Thread letterThread = new Thread(new LetterPrinter());
        Thread numberThread = new Thread(new NumberPrinter());

        letterThread.start();
        numberThread.start();
    }

    // Thread to print letters A to Z
    public static class LetterPrinter implements Runnable {
        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                synchronized (lock) {
                    while (!isLetterTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(ch + " ");
                    isLetterTurn = false;
                    lock.notify();
                }
            }
        }
    }

    // Thread to print numbers 1 to 26
    public static class NumberPrinter implements Runnable {
        public void run() {
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    while (isLetterTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(i + " ");
                    isLetterTurn = true;
                    lock.notify();
                }
            }
        }
    }
}

