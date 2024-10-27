package multithreading.monitorLockExample;

class BankAccount {
	
	private int balance = 0;
	
	// Synchronized method to deposit money
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Current Balance: " + balance);
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ", but insufficient balance.");
        }
    }
    
    public int getBalance() {
        return balance;
    }
	
}

public class MonitorLockExample {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		
		// Creating two threads that operate on the same BankAccount object
		Thread t1 = new Thread(() -> {
			account.deposit(500);
			account.withdraw(50);
		}, "Thread 1");
		
		Thread t2 = new Thread(() -> {
			account.deposit(200);
			account.withdraw(100);
		}, "Thread 2");
		
		t1.start();
		t2.start();
	}

}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * ******Thread generally put monitor lock on "object" when it goes inside synchronized method.*********
 * 
 * Explanation:
 * 
 * 1) synchronized Methods:
 * -> Both deposit and withdraw methods are synchronized, meaning only one thread can execute either of these methods 
 * on the same BankAccount instance at a time.
 * -> If Thread 1 is executing deposit, Thread 2 has to wait until Thread 1 completes its operation and releases the 
 * monitor lock on account.
 * 
 * 2) Monitor Lock in Action:
 * -> When t1 calls account.deposit(100), it acquires the lock on account object. While this lock is held, t2 cannot execute 
 * any synchronized method on the same account instance.
 * -> Once t1 exits deposit (or any synchronized method), it releases the lock, allowing t2 to enter a synchronized 
 * block.
 * 
 * 3) Thread Safety:
 * -> By ensuring that only one thread can modify balance at a time, the synchronized block prevents data 
 * inconsistencies.
 * -> If deposit and withdraw were not synchronized, t1 and t2 could potentially read and write balance 
 * simultaneously, leading to incorrect results.
 * 
 * 4) Key Points:
 * -> Monitor Lock: Ensures exclusive access to synchronized methods or blocks.
 * -> Synchronized Methods: Automatically acquire the lock on the current instance (e.g., account in this example).
 * -> Atomic Operations: Synchronized methods guarantee that compound operations like balance += amount happen 
 * atomically, preserving data consistency.
 * -> Using monitor locks via synchronized is a fundamental way to handle thread safety in concurrent Java applications.
 */
