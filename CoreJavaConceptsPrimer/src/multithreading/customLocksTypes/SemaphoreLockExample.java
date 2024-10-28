package multithreading.customLocksTypes;

import java.util.concurrent.Semaphore;

class SemaphoreResource {
	boolean isAvaliable = false;
	public void producer(Semaphore lock) {
		try {
			lock.acquire();
			System.out.println("lock aquired :" + Thread.currentThread().getName());
			isAvaliable = true;
			Thread.sleep(4000);			
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			lock.release();
			System.out.println("lock released : " + Thread.currentThread().getName());
		}
		
	}
}

public class SemaphoreLockExample {

	public static void main(String[] args) {
		Semaphore lock = new Semaphore(2); //only two permit
		SemaphoreResource obj = new SemaphoreResource();
		
		Thread t1 = new Thread(() -> {
			obj.producer(lock);
		});
		
		Thread t2 = new Thread(() -> {
			obj.producer(lock);
		});
		
		Thread t3 = new Thread(() -> {
			obj.producer(lock);
		});
		
		Thread t4 = new Thread(() -> {
			obj.producer(lock);
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * It allow number of threads to acquire lock at same time using Semaphore lock = new Semaphore(2)
 * this 2 is nothing but permit to thread to go inside and acquire lock at same time 
 * 
 * Expected output
 * Lock acquired by: Thread-1
 * Lock acquired by: Thread-2
 * Lock released by: Thread-1
 * Lock acquired by: Thread-3
 * Lock released by: Thread-2
 * Lock acquired by: Thread-4
 * Lock released by: Thread-3
 * Lock released by: Thread-4
 * 
 * but getting little different output might be different due to context switching.
 * 
 * Example where to use this lock -> Consider a simple example where we want to control access to a shared printer 
 * resource with only two printers available. We’ll use a semaphore to ensure that no more than two threads can 
 * access the printer at the same time.
 */
