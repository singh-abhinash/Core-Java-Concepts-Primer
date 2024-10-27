package multithreading.basicExample;

class Counter {
    private int count = 0;
    //private static int staticCount = 0;

    public synchronized void increment() {
        count++;
        //staticCount++;
        System.out.println(Thread.currentThread().getName() + ": " + count);
        //System.out.println(Thread.currentThread().getName() + ": " + staticCount);
    }
}

public class SynchronizedMethodExample {

	public static void main(String[] args) {
		Counter counter1 = new Counter(); // First object
        Counter counter2 = new Counter(); // Second object

        Thread t1 = new Thread(() -> counter1.increment(), "Thread 1");
        Thread t2 = new Thread(() -> counter2.increment(), "Thread 2");

        t1.start();
        t2.start();
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * QUESTION -> Does a synchronized method ensure thread safety when two threads operate on the same method in two 
 * separate objects of the same class? If not, why, and how would you modify the code to ensure synchronized access 
 * across multiple instances?
 * 
 * ANSWER -> First we will understand how synchronized Methods Work?
 * A synchronized method in Java works by locking on the instance (object) level:
 * When a thread calls a synchronized method, it "acquires a lock" on the specific object instance.
 * This lock prevents other threads from calling any other synchronized methods on the same instance until the lock 
 * is released.
 * => Multiple Objects and synchronized
 * If you have two separate objects of the same class, each has its own instance lock. When two threads each work 
 * with a different object, they’re locking different instances, so they don’t interfere with each other. 
 * This means:
 * Thread 1 on Object A can execute a synchronized method.
 * Thread 2 on Object B can execute the same synchronized method at the same time.
 * Since the objects are separate, the locks on these objects are independent, so the synchronized keyword does not 
 * prevent simultaneous access across multiple instances of a class.
 * 
 * 
 * IF i WILL RUN THIS CODE THEN WE WILL GET OUTPUT LIKE:
 *             Thread 2: 1
 *             Thread 1: 1 
 * WHY?
 * In this code, each Counter object (counter1 and counter2) has its own separate count variable initialized to 0. 
 * When Thread 1 and Thread 2 each call the increment() method, they increment the count variable on their respective
 * Counter instances independently.
 * 
 * Why the Output is:
 * Thread 2: 1
 * Thread 1: 1
 * 
 * Here’s the explanation:
 * Separate Instances: Since counter1 and counter2 are separate objects, each Counter object has its own count 
 * variable.
 * Synchronized on Different Instances: The synchronized keyword only synchronizes access to the increment method per 
 * instance. Since counter1 and counter2 are independent, synchronized only prevents concurrent access to increment() 
 * on the same object, not across different objects.
 * 
 * Independent Increments:
 * Thread 1 increments the count of counter1 from 0 to 1.
 * Thread 2 increments the count of counter2 from 0 to 1.
 * 
 * 
 * Solution to Ensure a Shared count
 * If you want both threads to increment a single shared count variable, you could:
 * Make count a static variable.
 * Use a shared lock object.
 * 
 * Here's an example with count as static:
 * 
 * class Counter {
 * 		private static int count = 0;
 * 		public synchronized void increment() {
 * 			count++;
 * 			System.out.println(Thread.currentThread().getName() + ": " + count);
 * 		}
 * }
 * 
 * With this modification, count will be shared across all Counter instances, so each thread will increment the same 
 * variable, resulting in a cumulative output like:
 * 
 * Thread 1: 1
 * Thread 2: 2
 */
