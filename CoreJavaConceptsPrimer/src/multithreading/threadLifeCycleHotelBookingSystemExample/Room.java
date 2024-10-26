package multithreading.threadLifeCycleHotelBookingSystemExample;

public class Room {
	private int totalRooms;
    private int availableRooms;

    public Room(int totalRooms) {
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
    }

    // Synchronized method for booking a room
    public synchronized boolean bookRoom(String guestName) {
        if (availableRooms > 0) {
            System.out.println(guestName + " is booking a room...");
            availableRooms--;
            System.out.println("Room booked successfully by " + guestName + ". Rooms left: " + availableRooms);
            return true;
        } else {
            System.out.println(guestName + " could not book a room. No rooms available. Waiting...");
            return false;
        }
    }

    // Method to free up rooms for guests and notify them
    public synchronized void releaseRooms() {
        availableRooms = totalRooms;
        System.out.println("Rooms have been released. Available rooms: " + availableRooms);
        notifyAll(); // Notify all waiting threads that rooms are available
    }
    
 // Synchronized method for checking out and releasing a room
    public synchronized void checkOut(String guestName) {
        availableRooms++;
        System.out.println(guestName + " has checked out. Rooms left: " + availableRooms);
        notifyAll(); // Notify waiting guests that a room has become available
    }

    public int getAvailableRooms() {
        return availableRooms;
    }
}
