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
 * 
 * A ReentrantLock in multithreading is a specialized implementation of a lock provided by the java.util.concurrent.locks package in Java. It allows threads to reacquire the same lock multiple times without causing a deadlock. This capability is particularly useful when a thread already holding a lock needs to reenter a critical section that is guarded by the same lock.

Key Characteristics of ReentrantLock:
Reentrancy:

If a thread acquires the lock, it can reacquire the same lock without being blocked.
The lock keeps track of the number of times it has been acquired by the same thread. The thread must release the lock the same number of times before other threads can acquire it.
Flexibility:

Provides more control over the locking mechanism than the synchronized block.
You can use methods like lock(), tryLock(), and unlock() to control the lock explicitly.
Fairness:

Can be configured to be a fair lock by passing true to the constructor (new ReentrantLock(true)), which ensures that threads acquire the lock in the order they requested it (FIFO).
By default, the lock is not fair, meaning it doesn't guarantee any specific access order.
Interruptible Locking:

Allows a thread to respond to interrupts while waiting for a lock using the lockInterruptibly() method.
Performance:

May perform better than synchronized in some high-contention scenarios.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

A deadlock is a situation in multithreading or multiprocessing where two or more threads (or processes) are unable to 
proceed because each is waiting for the other to release a resource. This leads to a cycle of dependency, and no thread 
can make progress, effectively halting execution.

Deadlock Example:
Consider two threads (Thread-1 and Thread-2) and two resources (Resource-1 and Resource-2):

Thread-1 acquires Resource-1 and waits for Resource-2.
Thread-2 acquires Resource-2 and waits for Resource-1.
Neither thread can release its currently held resource until the other thread releases the one it is waiting for, resulting in a deadlock.

Four Necessary Conditions for Deadlock:
Deadlocks can occur when these four conditions hold simultaneously:

Mutual Exclusion: At least one resource is non-shareable (can only be held by one thread at a time).
Hold and Wait: A thread holding at least one resource is waiting to acquire additional resources held by other threads.
No Preemption: Resources cannot be forcibly taken from a thread; they must be released voluntarily.
Circular Wait: A cycle of threads exists, where each thread is waiting for a resource held by the next thread in the cycle.
 */
