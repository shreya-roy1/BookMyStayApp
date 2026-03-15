/**
 * MAIN CLASS - UseCase5BookingRequestQueue
 * Use Case 5: Booking Request (First-Come-First-Served)
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Rahul", "Single");
        Reservation r2 = new Reservation("Rekha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued booking requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Processing request for: " + next.getGuestName() + 
                               " | Room Type: " + next.getRoomType());
        }
    }
}