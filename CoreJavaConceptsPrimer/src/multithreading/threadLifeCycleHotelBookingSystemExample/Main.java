package multithreading.threadLifeCycleHotelBookingSystemExample;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Room room = new Room(2); // Hotel with 2 rooms
        List<Thread> guests = new ArrayList<>();

        // Creating multiple guest threads
        for (int i = 1; i <= 5; i++) {
            Thread guestThread = new Thread(new Guest(room, "Guest " + i));
            guests.add(guestThread);
            guestThread.start();
        }

        // Main thread waits for all guest threads to finish using join()
        for (Thread guest : guests) {
            try {
                guest.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted.");
            }
        }

        System.out.println("All guests have checked out. Releasing rooms for the next day...");
        
        synchronized (room) {
            room.releaseRooms(); // Release all rooms and notify waiting guests
        }

        System.out.println("Hotel is ready for new bookings.");
	}

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Here’s a comprehensive example simulating a Hotel Booking System with a shared resource (Room) that multiple 
 * threads (guests) try to book simultaneously. This example implements synchronized methods, wait(), notifyAll(), 
 * join(), and other lifecycle management techniques.
 * 
 * In this scenario:
 * -> Guests (threads) attempt to book a room.
 * -> If a room isn’t available, they wait until notified.
 * -> The main thread waits for all guests to finish their booking process using join().
 * -> Each guest can book a single room at a time, ensuring only one guest can access room booking at any moment.
 * 
 * 
 * Explanation of Key Parts:
 * 1) Room Class with Synchronized Book Room Method:
 * -> Ensures that only one guest can book a room at any given time.
 * -> If no rooms are available, the booking attempt fails, and the guest waits.
 * 2) Guest Class:
 * -> Each guest runs as a separate thread trying to book a room.
 * -> When bookRoom() fails, the thread enters a waiting state using wait().
 * 3) releaseRooms() in Room Class:
 * -> Resets the available rooms to the initial count and calls notifyAll() to alert all waiting threads that rooms 
 * are available.
 * 4) Main Thread’s Role:
 * -> The main thread waits for each guest thread to complete using join().
 * -> Once all guests have checked out, the main thread releases rooms for the next day and notifies all threads using notifyAll().
 * 
 * 
 * Summary of Thread Lifecycle Here:
 * -> New: Threads are created for each guest.
 * -> Runnable: Threads are started, moving to the runnable state.
 * -> Blocked: If a guest tries to book a room while another guest is booking, they’re blocked.
 * -> Waiting: Guests enter the waiting state if no rooms are available.
 * -> Timed Waiting: Threads simulate staying in the room by using Thread.sleep().
 * -> Terminated: Each thread finishes its lifecycle once the guest has checked out.
 */