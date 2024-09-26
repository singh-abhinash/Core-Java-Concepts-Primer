package JavaCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LinkedListAndArrayDequeImplementsDequeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> deque = new LinkedList<>();

        // Adding elements
        deque.addFirst("Element 1"); // Adds "Element 1" at the beginning
        deque.addLast("Element 2");  // Adds "Element 2" at the end
        System.out.println("******values in deque1******");
        System.out.println(deque);

        // Accessing elements
        System.out.println("First Element: " + deque.getFirst()); // Retrieves first element without removing
        System.out.println("Last Element: " + deque.getLast());   // Retrieves last element without removing
        System.out.println("******values in deque2******");
        System.out.println(deque);

        // Removing elements
        System.out.println("Removed First: " + deque.removeFirst()); // Removes and retrieves first element
        System.out.println("Removed Last: " + deque.removeLast());   // Removes and retrieves last element
        System.out.println("******values in deque3******");
        System.out.println(deque);
        
        // Checking if empty
        System.out.println("Is deque empty? " + deque.isEmpty());

        // Adding elements again
        deque.offerFirst("New First"); // Adds "New First" at the beginning
        deque.offerLast("New Last");   // Adds "New Last" at the end
        System.out.println("******values in deque4******");
        System.out.println(deque);

        // Peeking elements
        System.out.println("Peek First: " + deque.peekFirst()); // Retrieves first element without removing
        System.out.println("Peek Last: " + deque.peekLast());   // Retrieves last element without removing
        System.out.println("******values in deque5******");
        System.out.println(deque);

        // Popping and pushing (stack operations)
        deque.push("Pushed Element"); // Pushes "Pushed Element" onto the stack
        System.out.println("******values in deque6******");
        System.out.println(deque);
        System.out.println("Popped Element: " + deque.pop()); // Pops the top element from the stack
        System.out.println("******values in deque7******");
        System.out.println(deque);

        // Queue operations
        deque.offer("Queue Element"); // Adds "Queue Element" to the end of the deque
        System.out.println("******values in deque8******");
        System.out.println(deque);
        System.out.println("Polled Element: " + deque.poll()); // Retrieves and removes first element from the deque
        System.out.println("******values in deque9******");
        System.out.println(deque);
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("IMPLEMENTING DEQUE USING LINKEDLIST");
        		Deque<Integer> dq = new LinkedList<>();

                // Adding elements to the deque
                dq.addFirst(1); // Add to the front
                dq.addLast(2);  // Add to the back
                dq.offerFirst(0); // Add to the front
                dq.offerLast(3);  // Add to the back

                // Accessing elements
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);
                System.out.println("First Element: " + dq.getFirst());
                System.out.println("Last Element: " + dq.getLast());
                System.out.println("Peek First Element: " + dq.peekFirst());
                System.out.println("Peek Last Element: " + dq.peekLast());
                
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);

                // Removing elements
                System.out.println("Removed First Element: " + dq.removeFirst());
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);
                System.out.println("Removed Last Element: " + dq.removeLast());
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);
                System.out.println("Polled First Element: " + dq.pollFirst());
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);
                System.out.println("Polled Last Element: " + dq.pollLast());
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);

                // Checking if the deque is empty
                System.out.println("Is deque empty? " + dq.isEmpty());

                // Adding more elements
                dq.addFirst(5);
                dq.addLast(4);
                System.out.println("*******values in deque*******");
                System.out.println("Deque: " + dq);
                // Checking if deque contains a specific element
                System.out.println("Contains 'Element 4'? " + dq.contains(4));
                System.out.println("Contains 'Element 5'? " + dq.contains(5));

                // Iterating over the elements in the deque
                System.out.println("Deque elements:");
                for (Integer element : dq) {
                    System.out.println("*******values in deque*******");
                    System.out.println(element);
                    System.out.println("Deque: " + dq);
                }

                // Clearing the deque
                dq.clear();
                System.out.println("Deque after clear: " + dq);
                
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("IMPLEMENTING DEQUE USING ARRAYDEQUE");
        Deque<Integer> adq = new ArrayDeque<>();
     // Adding elements to the deque
        adq.addFirst(1); // Add to the front
        adq.addLast(2);  // Add to the back
        adq.offerFirst(0); // Add to the front
        adq.offerLast(3);  // Add to the back

        // Accessing elements
        System.out.println("Deque: " + adq);
        System.out.println("First Element: " + adq.getFirst());
        System.out.println("Last Element: " + adq.getLast());
        System.out.println("Peek First Element: " + adq.peekFirst());
        System.out.println("Peek Last Element: " + adq.peekLast());

        // Removing elements
        System.out.println("Removed First Element: " + adq.removeFirst());
        System.out.println("Removed Last Element: " + adq.removeLast());
        System.out.println("Polled First Element: " + adq.pollFirst());
        System.out.println("Polled Last Element: " + adq.pollLast());

        // Checking if the deque is empty
        System.out.println("Is deque empty? " + adq.isEmpty());

        // Adding more elements
        adq.addFirst(4);
        adq.addLast(5);

        // Checking if deque contains a specific element
        System.out.println("Contains 4? " + adq.contains(4));
        System.out.println("Contains 5? " + adq.contains(5));

        // Iterating over the elements in the deque
        System.out.println("Deque elements:");
        for (Integer element : adq) {
            System.out.println(element);
        }

        // Clearing the deque
        adq.clear();
        System.out.println("Deque after clear: " + adq);

	}

}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

/*
*********NOTE: MOST OF THE METHODS PRESENT IN LINKEDLIST AND ARRAYDEQUE IS SAME BEACUSE BOTH IMPLEMENTS
               DEQUE. 
               ARRAYDEQUE IMPLEMENTS DEQUE -> Deque<Integer> dq = new ArrayDeque<>();
               LINKEDLIST IMPLEMENTS DEQUE -> Deque<Integer> dq = new LinkedList<>();

Initialization: We create a new LinkedList instance named deque which implements the Deque interface and holds integers.

Adding Elements:

deque.addFirst(1): Adds the integer 1 to the front of the deque.
deque.addLast(2): Adds the integer 2 to the back of the deque.
deque.offerFirst(0): Adds the integer 0 to the front of the deque.
deque.offerLast(3): Adds the integer 3 to the back of the deque.
Accessing Elements:

System.out.println("Deque: " + deque);: Prints the current state of the deque.
System.out.println("First Element: " + deque.getFirst());: Retrieves but does not remove the first element.
System.out.println("Last Element: " + deque.getLast());: Retrieves but does not remove the last element.
System.out.println("Peek First Element: " + deque.peekFirst());: Retrieves but does not remove the first element (alternative method).
System.out.println("Peek Last Element: " + deque.peekLast());: Retrieves but does not remove the last element (alternative method).
Removing Elements:

System.out.println("Removed First Element: " + deque.removeFirst());: Removes and retrieves the first element.
System.out.println("Removed Last Element: " + deque.removeLast());: Removes and retrieves the last element.
System.out.println("Polled First Element: " + deque.pollFirst());: Removes and retrieves the first element (alternative method).
System.out.println("Polled Last Element: " + deque.pollLast());: Removes and retrieves the last element (alternative method).
Checking if Empty:

System.out.println("Is deque empty? " + deque.isEmpty());: Checks if the deque is empty.
Adding More Elements:

deque.addFirst(4): Adds the integer 4 to the front of the deque.
deque.addLast(5): Adds the integer 5 to the back of the deque.
Contains Check:

System.out.println("Contains 4? " + deque.contains(4));: Checks if the deque contains the integer 4.
System.out.println("Contains 5? " + deque.contains(5));: Checks if the deque contains the integer 5.
Iterating:

Using a for-each loop, we iterate over the elements in the deque and print them.
Clearing:

deque.clear();: Removes all elements from the deque.
System.out.println("Deque after clear: " + deque);: Prints the deque after clearing it.
This example demonstrates the use of various Deque methods with integer values.
*/