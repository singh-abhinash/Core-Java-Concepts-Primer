package multithreading.threadLifeCycleHotelBookingSystemExample;

public class Guest implements Runnable {
	private Room room;
    private String guestName;

    public Guest(Room room, String guestName) {
        this.room = room;
        this.guestName = guestName;
    }

    @Override
    public void run() {
        synchronized (room) {
            while (!room.bookRoom(guestName)) {
                try {
                    room.wait(); // Wait if no rooms are available
                } catch (InterruptedException e) {
                    System.out.println(guestName + " was interrupted while waiting.");
                }
            }

            // Simulate stay
            try {
                System.out.println(guestName + " is staying in the room...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(guestName + " was interrupted during stay.");
            }

         // Guest checks out, freeing up the room
            room.checkOut(guestName);
        }
    }
}
