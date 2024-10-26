package multithreading.basicExample;

class PrintNumber extends Thread {
	private String threadName;
	
	public PrintNumber(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(threadName + "number - " + i);
			try {
				Thread.sleep(2000);
				//comment above and uncomment below and see the output
				//System.out.println("Inside try");
			} catch (Exception e) {
				System.out.println("Exception Occur" + e.getMessage());
			}
			 
		}
		System.out.println(threadName + " Thread work finished...");
	}
	
}

public class MultithreadingExample2 {

	public static void main(String[] args) {
		PrintNumber thread1 = new PrintNumber("Thread1");
		PrintNumber thread2 = new PrintNumber("Thread2");
		
		//starting thread
		thread1.start();
		thread2.start();
	}

}
