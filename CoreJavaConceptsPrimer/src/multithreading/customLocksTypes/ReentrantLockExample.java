package multithreading.customLocksTypes;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
	
	boolean isAvailable = false;
	
	public void producer(ReentrantLock reentrantLock) {
		
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
    	ReentrantLock reentrantLock = new ReentrantLock();
    	
    	Thread t1 = new Thread(() -> {
    		resource.producer(reentrantLock);
    	});
    	
    	Thread t2 = new Thread(() -> {
    		resource.producer(reentrantLock);
    	});
    	
    	t1.start();
    	t2.start();
    }
}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Here we can see without synchronized method, it is working fine using custom reentrant lock. 
 */
