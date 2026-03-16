public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {
        // Initialize shared resources
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Pre-populate queue with some requests
        bookingQueue.addRequest(new Reservation("RES_A", "Standard"));
        bookingQueue.addRequest(new Reservation("RES_B", "Deluxe"));
        bookingQueue.addRequest(new Reservation("RES_C", "Suite"));

        // Create booking processor tasks
        Thread t1 = new Thread(
            new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
            new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // Start concurrent processing
        System.out.println("Starting concurrent booking threads...");
        t1.start();
        t2.start();

        try {
            // Wait for threads to finish
            t1.join();
            t2.join();
            System.out.println("All booking requests processed safely.");
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }
    }
}