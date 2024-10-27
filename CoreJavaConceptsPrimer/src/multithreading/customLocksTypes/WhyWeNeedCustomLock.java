package multithreading.customLocksTypes;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
}

public class WhyWeNeedCustomLock {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t1 = new Thread(counter1::increment, "Thread 1");
        Thread t2 = new Thread(counter2::increment, "Thread 2");

        t1.start();
        t2.start();
    }
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Question -> why we need custom lock, as we already have monitor lock in synchronized method?
 *                                                OR
 * Question -> If we have multiple object with one one thread each then monitor lock will work?
 * 
 * ANSWER-> No, if you have multiple objects, each with its own thread, the monitor lock on a synchronized method or 
 * block won’t coordinate access between them. This is because each object has its own intrinsic lock, and 
 * synchronized only controls access to methods or blocks within the same object.
 * 
 * In other words, if you have two objects, obj1 and obj2, each with a synchronized method, then:
 * 
 * A thread working on obj1's synchronized method only acquires the lock of obj1, not obj2.
 * Similarly, a thread working on obj2's synchronized method only acquires the lock of obj2.
 * This means that synchronized only prevents concurrent access to the same instance, not across multiple instances.
 * 
 * THIS IS ALREADY DISCUSSED IN multihtreading.basicExample.SynchronizedMethodExample. Check once.
 * IF WE DONT WANT TO ACCESS MULTIPLE THREADS FOR MULTIPLE OBJECTS AT A TIME INSIDE THE METHOD THEN WE HAVE TO USE CUSTOM LOCK.
 * CUSTOM LOCK WILL ALLOW ONLY ONE THREAD AT A TIME TO GO INSIDE THE METHOD IRRESPECTIVE OF MULTIPLE OBJECT.
 * IF WE ARE CREATING CUSTOM LOCK THE NO NEED TO MENTION METHOD AS SYNCHRONIZED.
 * DUE TO ABOVE REASON WE NEED CUSTOM LOCK TO HANDLE THIS TYPE OF SITUATION.
 */
