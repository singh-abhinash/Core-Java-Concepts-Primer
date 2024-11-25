package JavaCollections;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMaxHeapImplementsQueue {

    public static void main(String[] args) {
        // Creating a PriorityQueue as a max-heap using a custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // Alternative initialization

        // Adding elements to the PriorityQueue
        pq.offer(30);
        pq.offer(60);
        pq.offer(10);
        pq.offer(70);
        pq.offer(80);
        System.out.println("*******values in PriorityQueue (Max-Heap)*******");
        System.out.println(pq);

        // Printing elements in priority order (reverse order)
        System.out.println("PriorityQueue elements: " + pq);

        // Peeking at the top element
        System.out.println("Peeked element: " + pq.peek());
        System.out.println("*******values in PriorityQueue (Max-Heap)*******");
        System.out.println(pq);

        // Polling elements from the PriorityQueue
        System.out.println("Polled element: " + pq.poll());
        System.out.println("*******values in PriorityQueue (Max-Heap)*******");
        System.out.println(pq);
        System.out.println("Polled element: " + pq.poll());
        System.out.println("*******values in PriorityQueue (Max-Heap)*******");
        System.out.println(pq);

        // Adding more elements
        pq.offer(50);
        pq.offer(40);
        System.out.println("*******values in PriorityQueue (Max-Heap)*******");
        System.out.println(pq);

        // Printing elements in priority order (reverse order)
        System.out.println("PriorityQueue elements: " + pq);

        // Polling remaining elements
        while (!pq.isEmpty()) {
            System.out.println("Polled element: " + pq.poll());
            System.out.println("*******values in PriorityQueue (Max-Heap)*******");
            System.out.println(pq);
        }
    }
}

