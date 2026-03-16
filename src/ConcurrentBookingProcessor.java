public class ConcurrentBookingProcessor implements Runnable {
    
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    /**
     * Creates a new booking processor.
     * @param bookingQueue shared booking queue
     * @param inventory shared inventory
     * @param allocationService shared room allocation service
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue, 
            RoomInventory inventory, 
            RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Executes booking processing logic in a thread-safe manner.
     */
    @Override
    public void run() {
        while (true) {
            Reservation reservation = null;

            /*
             * Synchronize on the booking queue to ensure
             * that only one thread can retrieve a request at a time.
             */
            synchronized (bookingQueue) {
                if (!bookingQueue.isEmpty()) {
                    reservation = bookingQueue.getNextRequest();
                } else {
                    // Optional: break or sleep if queue is empty
                    break; 
                }
            }

            if (reservation != null) {
                /*
                 * Allocation also mutates shared inventory.
                 * Synchronization ensures atomic allocation.
                 */
                synchronized (inventory) {
                    allocationService.allocateRoom(reservation, inventory);
                }
            }
        }
    }
}