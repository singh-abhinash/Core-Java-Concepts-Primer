package multithreading.CASExample;

class SharedCounter {
	int counter = 0;
	
	public void increment() {
		counter++;
	}
	
	public int get() {
		return counter;
	}
}

public class CompareAndSwapExample {

	public static void main(String[] args) {
		
		SharedCounter resource = new SharedCounter();
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				resource.increment();	
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 300; i++) {
				resource.increment();	
			}
		});
		
		t1.start();
		t2.start();
		
		// Wait for both threads to complete
		/**
		 * t1.join() and t2.join() make the main thread wait until t1 and t2 complete their execution.
		 * Once both threads have finished, the main thread will print the counter value, reflecting all increments 
		 * made by both threads.
		 */
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		System.out.println("counter value by two thread : " + resource.get());
		
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Inside cpu CAS operation happens. CAS uses CPU to exchange the data.
 * It is lock free mechanism.
 * 
 * How CAS actually work?
 * 
 * CAS(memory, expected value, new value)
 * -> memory will load/read the variable data.
 * -> compare data which is stored in memory and expected value.
 * -> if it is not matching means stamp is change(similar to optimistic approach).
 * -> if it matches the then it will swap(update) new value to the memory.
 * 
 * 
 * What is ABA issue and how we can resolve?
 * 
 * The ABA problem in Compare-and-Swap (CAS) operations is a potential issue that arises in concurrent programming 
 * when multiple threads are working with shared variables. CAS is often used for atomic operations where a thread 
 * tries to update a shared variable only if it hasn't changed from a certain expected value. The ABA issue happens 
 * when the shared variable changes from value A to B and then back to A while the CAS operation is in progress.
 * 
 * In a CAS operation, a thread checks if a variable has a specific expected value (let’s call it A) before updating 
 * it to a new value (say, C). However, if:
 * -> Thread 1 reads the value A from the variable.
 * -> Thread 2 changes the value from A to B and then back to A.
 * -> Thread 1 proceeds with the CAS operation, which sees the value as still A, assumes nothing has changed, and 
 * updates it to C.
 * -> From Thread 1's perspective, the variable has not been modified by any other thread, so it applies its update. 
 * But in reality, the variable went through an intermediate change (to B) which Thread 1 is unaware of. This can 
 * lead to subtle bugs, especially if the value B held some transient significance that Thread 1 would have needed 
 * to know about.
 * 
 * Example Scenario:
 * -> Consider a stack where each element has a pointer to the next element. Suppose two threads, T1 and T2, are 
 * popping elements:
 * -> T1 reads the top of the stack as node A.
 * -> Meanwhile, T2 pops A, processes it, and pushes A back, making A the top of the stack again.
 * -> Now, T1 attempts to CAS its top pointer from A to the next element. CAS succeeds because the value is still A, 
 * even though A has been removed and reinserted by T2.
 * -> In this case, T1 proceeds, oblivious to the fact that A was temporarily removed, which could lead to incorrect 
 * assumptions or processing duplicate data.
 * 
 * Solutions to the ABA Problem:
 * -> Tagged Pointers: Use extra "version" bits with the actual value to detect changes. So, instead of just 
 * storing A, the variable might be A1, where "1" represents the first version. Each modification increments the 
 * version, so even if the value is reverted to A, the version would change, helping detect the ABA condition.
 * -> AtomicStampedReference (Java): This class in Java provides both the reference and a "stamp" (similar to a 
 * version), allowing threads to verify that neither the reference nor the version has changed.
 * -> Garbage Collection Techniques: By ensuring that intermediate states are preserved or reused cautiously, the ABA 
 * issue can sometimes be avoided at the memory management level.
 * 
 * -> The ABA problem is subtle but can lead to significant issues in concurrent applications if not properly managed.
 * 
 * Atomic integer example - int counter = 10;
 * but counter++ is not atomic because it has three operation : load count, increase value by 1, assign back
 * Atomic integer internally use CAS operation.
 * 
 * Output we will get 596, means concurrency occur. to resolve this issue either we use lock mechanism like 
 * synchronized method or lock free mechanism like AtomicInteger.
 * -> Atomic Counter: AtomicInteger ensures that incrementAndGet() is atomic. No two threads will interfere with each 
 * other when incrementing the counter.
 * ->Thread-Safe Increment: Each thread increments the counter 100 times in this example. Because AtomicInteger 
 * handles concurrency internally, we don't need locks or synchronization.-> GO FOR ATMOIC APPROACH ONLY WHEN WE
 * HAVE REQUIREMENT LIKE READ, MODIFY AND UPDATE
 * Atomic is thread safe operation
 * Volatile is no relation with concurrency, it is not thread safe.
 * Volatile make sure that read and write happens from memory not from cache
 */

