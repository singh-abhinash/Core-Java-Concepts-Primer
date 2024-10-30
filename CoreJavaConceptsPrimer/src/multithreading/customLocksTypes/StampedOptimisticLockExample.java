package multithreading.customLocksTypes;

import java.util.concurrent.locks.StampedLock;

class SharedComonResource {
	int a = 10;
	public void producer(StampedLock stampedOptimisticLock) {
		long stamp = stampedOptimisticLock.tryOptimisticRead();
		try {
			System.out.println("Taken optimistic lock :" + Thread.currentThread().getName());
			a = 11;
			Thread.sleep(4000);			
			if (stampedOptimisticLock.validate(stamp)) {
				System.out.println("No thread Interrupt in between lock :" + Thread.currentThread().getName());
			} else {
				System.out.println("Thread interrupted in between lock, rolling back changes : " + Thread.currentThread().getName());
				a = 10;
			}
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		}
		
	}
	
	public void consumer(StampedLock stampedOptimisticLock) {
		long stamp = stampedOptimisticLock.writeLock();
		System.out.println("Write Lock aquired by: " + Thread.currentThread().getName());
		try {
			System.out.println("Interrupting in between lock : " + Thread.currentThread().getName());	
			a = 9;
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			stampedOptimisticLock.unlockWrite(stamp);
			System.out.println("Write Lock released by: " + Thread.currentThread().getName());
		}
		
	}
}


public class StampedOptimisticLockExample {

	public static void main(String[] args) {
		
		SharedComonResource resource = new SharedComonResource();
		StampedLock stampedOptimisticLock = new StampedLock();
		
    	Thread t1 = new Thread(() -> {
    		resource.producer(stampedOptimisticLock);
    	});
    	
    	Thread t2 = new Thread(() -> {
    		resource.consumer(stampedOptimisticLock);
    	});
    	
    	t1.start();
    	//comment below statement and observe what output is coming
    	t2.start();
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * if lock.validate(stamp) is true means, koi aur thread beech me ghus kar kaand nahi kiya hai. False means koi aur thread
 * beech me aaya aur kuchh write kark nikal liya.
 * 
 * in tryOptmistic.read() there is nothing like lock and unlock. we use lock.validate(stamp) to check.
 * since we are using same lock for consumer and producer, so we can easily see the interruption using consumer write 
 * lock operation
 * 
 * Optimistic concurrency control is also lock free protcol.
 * Optimistic concurrency control work with db.
 * that stamp is type of version, so whenever stamp update it means version is updating.
 */
