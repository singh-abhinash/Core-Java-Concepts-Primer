package JavaCollections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInterfaceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        System.out.println("*******values in Queue*******");
        System.out.println(queue);

        // Peeking at the front element
        System.out.println("Front of the queue: " + queue.peek());
        System.out.println("*******values in Queue*******");
        System.out.println(queue);

        // Polling elements from the queue
        System.out.println("Polled element: " + queue.poll());
        System.out.println("*******values in Queue*******");
        System.out.println(queue);
        
        System.out.println("Polled element: " + queue.poll());
        System.out.println("*******values in Queue*******");
        System.out.println(queue);

        // Checking if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Adding more elements
        queue.offer(5);
        System.out.println("*******values in Queue*******");
        System.out.println(queue);
        queue.offer(4);
        System.out.println("*******values in Queue*******");
        System.out.println(queue);

        // Polling remaining elements
        while (!queue.isEmpty()) {
            System.out.println("Polled element: " + queue.poll());
            System.out.println("*******values in Queue*******");
            System.out.println(queue);
        }
	}

}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
-> The Queue Interface is present in java.util package and extends the Collection interface is used to 
hold the elements about to be processed in FIFO(First In First Out) order. It is an ordered list of objects 
with its use limited to inserting elements at the end of the list and deleting elements from the 
start of the list, (i.e.), it follows the FIFO or the First-In-First-Out principle.
Being an interface the queue needs a concrete class for the declaration and the most common classes are the 
PriorityQueue and LinkedList in Java. Note that neither of these implementations is thread-safe. 
PriorityBlockingQueue is one alternative implementation if the thread-safe implementation is needed.

-> Initialization: We create a new LinkedList instance named queue which implements the Queue interface 
and holds integers.

-> Adding Elements: Using queue.offer(element), we add integers to the queue (1, 2, 3).

-> Peeking: queue.peek() retrieves but does not remove the front element of the queue (1 in this case).

-> Polling: queue.poll() removes and returns the front element of the queue (1, then 2).

-> Checking if Empty: queue.isEmpty() checks if the queue is empty.

-> Adding More Elements: We add more integers (4, 5) to the queue.

-> Polling Remaining Elements: Using a while loop, we poll all elements until the queue is empty, printing 
each polled element.

-> This example demonstrates basic queue operations (offer, peek, poll, isEmpty) using a LinkedList to 
implement the Queue interface with integers.
*/