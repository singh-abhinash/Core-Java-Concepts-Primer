package JavaCollections;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMinHeapImplementsQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new PriorityQueue<>();//we can initialize PriorityQueue like this as well because PriorityQueue also implements Queue

        // Adding elements to the PriorityQueue
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println("*******values in PriorityQueue*******");
        System.out.println(pq);
        
        // Printing elements in priority order (natural order)
        System.out.println("PriorityQueue elements: " + pq);

        // Peeking at the top element
        System.out.println("Peeked element: " + pq.peek());
        System.out.println("*******values in PriorityQueue*******");
        System.out.println(pq);

        // Polling elements from the PriorityQueue
        System.out.println("Polled element: " + pq.poll());
        System.out.println("*******values in PriorityQueue*******");
        System.out.println(pq);
        System.out.println("Polled element: " + pq.poll());
        System.out.println("*******values in PriorityQueue*******");
        System.out.println(pq);

        // Adding more elements
        pq.offer(50);
        pq.offer(40);
        System.out.println("*******values in PriorityQueue*******");
        System.out.println(pq);

        // Printing elements in priority order (natural order)
        System.out.println("PriorityQueue elements: " + pq);

        // Polling remaining elements
        while (!pq.isEmpty()) {
            System.out.println("Polled element: " + pq.poll());
            System.out.println("*******values in PriorityQueue*******");
            System.out.println(pq);
        }
	}

}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
-> PRIORITY QUEUE MIN HEAP IMPLEMENTATION

-> Initialization: We create a new PriorityQueue named pq. PriorityQueue is implemented as a priority heap 
and orders elements according to their natural ordering or by a comparator provided at queue construction 
time.

-> Adding Elements: Using pq.offer(element), we add integers to the priority queue (30, 10, 20). 
These elements are ordered automatically based on their natural ordering (ascending order for integers).

-> Printing Elements: The statement System.out.println("PriorityQueue elements: " + pq); prints all elements 
currently in the priority queue in their priority order.

-> Peeking: pq.peek() retrieves but does not remove the top (lowest) element in the priority queue 
(10 in this case).

-> Polling: pq.poll() removes and returns the top (lowest) element in the priority queue (10, then 20). 
The priority queue reorders itself after each removal to maintain the heap property.

-> Adding More Elements: We add more elements (40, 50) to the priority queue.

-> Polling Remaining Elements: Using a while loop, we poll all elements until the priority queue is empty, 
printing each polled element.

-> This example demonstrates basic operations (offer, peek, poll, isEmpty) using a PriorityQueue, which 
maintains elements in natural order or by a specified comparator, making it suitable for scenarios 
requiring elements to be processed based on priority.
*/