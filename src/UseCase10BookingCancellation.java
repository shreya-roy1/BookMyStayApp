public class UseCase10BookingCancellation {

    public static void main(String[] args) {
        // Initialize core components
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // 1. Register some bookings
        cancellationService.registerBooking("RES_001", "Deluxe");
        cancellationService.registerBooking("RES_002", "Suite");
        cancellationService.registerBooking("RES_003", "Standard");

        // 2. Perform cancellations
        System.out.println("Processing cancellations...");
        cancellationService.cancelBooking("RES_002", inventory);
        cancellationService.cancelBooking("RES_001", inventory);

        // 3. Show history
        cancellationService.showRollbackHistory();
    }
}

/**
 * Placeholder for RoomInventory to support rollback logic.
 */
class RoomInventory {
    public void releaseRoom(String roomType) {
        System.out.println("Inventory Restored: 1 " + roomType + " room added back.");
    }
}