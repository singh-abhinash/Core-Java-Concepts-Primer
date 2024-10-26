package multithreading.basicExample;

public class MultithreadingExample {

	public static void main(String[] args) {
		System.out.println("Thread Name is: " + Thread.currentThread().getName());
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * 1. Multithreading:
 * -> Definition: Multithreading is a programming approach where multiple threads (smaller units of a process) are 
 * created within a single process. Threads share the same memory space, allowing them to communicate and share 
 * data easily.
 * -> Use Case: Useful in applications where tasks are lightweight and can run concurrently within the same process, 
 * such as handling multiple requests in a web server.
 * -> Advantages: Lower memory consumption as threads share resources, faster context-switching, efficient CPU usage.
 * -> Example: In a browser, multiple tabs can be handled as threads within a single process.
 * 
 * 2. Multitasking:
 * -> Definition: Multitasking is an operating system feature that allows multiple tasks (processes) to run 
 * concurrently on a single CPU. The OS switches between tasks quickly, giving the illusion of simultaneous execution.
 * -> Use Case: Running multiple applications simultaneously, like listening to music while writing a document.
 * -> Advantages: Improves overall system responsiveness and allows users to run multiple applications.
 * -> Example: A user can browse the internet while simultaneously running an antivirus scan.
 * 
 * 3. Multiprocessing:
 * -> Definition: Multiprocessing is a system that uses multiple CPUs (or cores) to execute multiple processes at the 
 * same time. Each process runs independently on a separate CPU, which allows true parallelism.
 * -> Use Case: Ideal for CPU-intensive tasks or applications that can be split into parallel parts, such as video 
 * rendering or large-scale scientific computations.
 * -> Advantages: Achieves real parallelism, efficient use of multiple cores, faster task execution for CPU-bound 
 * tasks.
 * -> Example: A multi-core processor where each core can run a separate instance of an application simultaneously.
 */
