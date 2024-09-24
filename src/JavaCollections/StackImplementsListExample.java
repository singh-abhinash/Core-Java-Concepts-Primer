package JavaCollections;

import java.util.List;
import java.util.Stack;

public class StackImplementsListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		List<Integer> stack1 = new Stack<>();//we can initialize stack like this as well because stack also implements list 

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("*******values in stack******** ");
        System.out.println(stack);

        // Peeking at the top element
        System.out.println("Top of the stack: " + stack.peek());
        System.out.println("*******values in stack******** ");
        System.out.println(stack);

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("*******values in stack******** ");
        System.out.println(stack);

        // Checking if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Pushing more elements
        stack.push(40);
        stack.push(50);
        System.out.println("*******values in stack******** ");
        System.out.println(stack);

        // Popping remaining elements
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }
        System.out.println("*******values in stack******** ");
        System.out.println(stack);
	}

}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
-> Initialization: We create a new LinkedList named stack to act as our stack.

-> It uses LIFO approach i.e. "last in first out".

-> Pushing Elements: Using stack.push(element), we push integers onto the stack (10, 20, 30).

-> Peeking: stack.peek() retrieves but does not remove the top element (30 in this case).

-> Popping: stack.pop() removes and returns the top element of the stack (30 first, then 20).

-> Checking if Empty: stack.isEmpty() checks if the stack is empty.

-> Pushing More Elements: We add more elements (40, 50) to the stack.

-> Popping Remaining Elements: Using a while loop, we pop all elements until the stack is empty, printing each popped element.
*/