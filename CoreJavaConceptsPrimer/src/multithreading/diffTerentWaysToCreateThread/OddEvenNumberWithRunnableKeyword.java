package multithreading.diffTerentWaysToCreateThread;

public class OddEvenNumberWithRunnableKeyword {
	private static final Object lock = new Object();
	private static boolean isOddNumberTurn = true;
	
	public static void main (String[] args) {
		int max = 20;
		
		Runnable oddNumber = new Runnable() {
			public void run() {
				for (int i = 1; i <= max; i += 2) {
					synchronized (lock) {
						while (!isOddNumberTurn) {
							try {
								lock.wait();
								//Thread.sleep(1000);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
						System.out.println("Odd Thread: " + i);
						isOddNumberTurn = false;
						lock.notify();
					}
				}
			}
		};
		
		Runnable evenNumber = new Runnable() {
			public void run() {
				for (int i = 2; i <= max; i += 2) {
					synchronized (lock) {
						while (isOddNumberTurn) {
							try {
								lock.wait();
								//Thread.sleep(1000);
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
							}
						}
						System.out.println("Even Thread: " + i);
						isOddNumberTurn = true;
						lock.notify();
					}
				}
			}
		};
		
		Thread oddNumberThread = new Thread(oddNumber);
		Thread evenNumberThread = new Thread(evenNumber);
		
		oddNumberThread.start();
		evenNumberThread.start();
	}
}
