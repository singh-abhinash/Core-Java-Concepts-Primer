package multithreading.customLocksTypes;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
	
	boolean isAvailable = false;
	ReentrantLock reentrantLock = new ReentrantLock();
	
	public void producer() {
		
		try {
			
			reentrantLock.lock();
			System.out.println("Lock aquired by: " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(2000);
			
		} catch(Exception e) {
			
			System.out.println("Exception Occur: " + e.getMessage());
			
		} finally {
			
			reentrantLock.unlock();
			System.out.println("Lock released by: " + Thread.currentThread().getName());
		}
		
	}
}

public class ReentrantLockExample {
    public static void main(String[] args) {
    	SharedResource resource = new SharedResource();
    	
    	Thread t1 = new Thread(() -> {
    		resource.producer();
    	});
    	
    	Thread t2 = new Thread(() -> {
    		resource.producer();
    	});
    	
    	t1.start();
    	t2.start();
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Here we can see without synchronized method, it is working fine. 
 */
