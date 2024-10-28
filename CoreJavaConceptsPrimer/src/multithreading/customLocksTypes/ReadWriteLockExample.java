package multithreading.customLocksTypes;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedCommResource {
	
	boolean isAvailable = false;
	
	public void producer(ReadWriteLock readWriteLock) {
		try {
			readWriteLock.readLock().lock();
			System.out.println("Read Lock aquired by: " + Thread.currentThread().getName());
			Thread.sleep(8000);			
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			readWriteLock.readLock().unlock();
			System.out.println("Read Lock released by: " + Thread.currentThread().getName());
		}
		
	}
	
	public void consumer(ReadWriteLock readWriteLock) {
		try {
			readWriteLock.writeLock().lock();
			System.out.println("Write Lock aquired by: " + Thread.currentThread().getName());
			isAvailable = true;		
		} catch(Exception e) {
			System.out.println("Exception Occur: " + e.getMessage());	
		} finally {
			readWriteLock.writeLock().unlock();
			System.out.println("Write Lock released by: " + Thread.currentThread().getName());
		}
		
	}
}

public class ReadWriteLockExample {

	public static void main(String[] args) {
		SharedCommResource resource = new SharedCommResource();
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		
    	Thread t1 = new Thread(() -> {
    		resource.producer(readWriteLock);
    	});
    	
    	Thread t2 = new Thread(() -> {
    		resource.producer(readWriteLock);
    	});
    	
    	Thread t3 = new Thread(() -> {
    		resource.consumer(readWriteLock);
    	});
    	
    	t1.start();
    	t2.start();
    	t3.start();
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
/**
 * READ lock is same as SHARED lock and WRITE lock is called EXCLUSIVE lock.
 * 
 * Suppose we have two thread t1 and t2.
 * -> If t1 will put shared lock(means it is only read) on a particular resource then t2 can also put shared lock 
 * because t2 will read only.
 * -> If t1 will put shared lock read then t2 cannot acquire exclusive lock(read and write both) on same resource 
 * because t1 will read only.
 * 
 * -> If t1 will put exclusive lock(means it is read and write) on a particular resource then t2 cannot put shared lock 
 * because t1 maybe updating(writing).
 * -> If t2 will put exclusive lock then t2 cannot acquire exclusive lock(read and write both) on same resource 
 * because t1 might be writing something at that time only.
 * 
 * -> We will use readWriteLock when read is very high compare to write
 * 
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * -> Threads 0 and 1 both acquire the read lock without blocking each other.
 * -> Thread-2 attempts to acquire the write lock but must wait until both read locks are released.
 * -> The sequence in which the read locks are released depends on the order in which they finish (controlled by the Thread.sleep(4000) in the producer method).
 * -> Once both read locks are released, Thread-2 immediately acquires the write lock and proceeds.
 * -> Thread-2 releases the write lock, and then the final read lock (from Thread-1) releases.
 * 
 * Clarifying the Sequence
 * -> Although the output may seem to suggest that Thread-2 acquires the write lock before all read locks are 
 * released, it actually waits until both are released before proceeding. The order of printed output can sometimes 
 * appear interleaved, especially due to the timing of context switching, but rest assured that ReentrantReadWriteLock 
 * enforces this synchronization properly under the hood.
 * 
 */
