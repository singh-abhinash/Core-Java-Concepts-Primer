//
package multithreading.customLocksTypes;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

class SharedCommonResource {
	
	boolean isAvailable = false;
	
	public void producer(StampedLock stampedReadWriteLock) {
		long stamp = stampedReadWriteLock.readLock();
		try {
			System.out.println("Read Lock aquired by: " + Thread.currentThread().getName());
			Thread.sleep(8000);			
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			stampedReadWriteLock.unlockRead(stamp);;
			System.out.println("Read Lock released by: " + Thread.currentThread().getName());
		}
		
	}
	
	public void consumer(StampedLock stampedReadWriteLock) {
		long stamp = stampedReadWriteLock.writeLock();
		try {
			System.out.println("Write Lock aquired by: " + Thread.currentThread().getName());
			isAvailable = true;		
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			stampedReadWriteLock.unlockWrite(stamp);
			System.out.println("Write Lock released by: " + Thread.currentThread().getName());
		}
		
	}
}

public class StampedReadWriteLockExample {

	public static void main(String[] args) {
		SharedCommonResource resource = new SharedCommonResource();
		StampedLock stampedReadWriteLock = new StampedLock();
		
    	Thread t1 = new Thread(() -> {
    		resource.producer(stampedReadWriteLock);
    	});
    	
    	Thread t2 = new Thread(() -> {
    		resource.producer(stampedReadWriteLock);
    	});
    	
    	Thread t3 = new Thread(() -> {
    		resource.consumer(stampedReadWriteLock);
    	});
    	
    	t1.start();
    	t2.start();
    	t3.start();

	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Stamped lock support read/Write only and also support optimistic read.
 * All shared lock/exclusive lock called ressesmistic lock.
 * 
 * Stamp is use to provide unique id which helps to prevent concurrency during lock. It is efficient way to lock thread.
 */
