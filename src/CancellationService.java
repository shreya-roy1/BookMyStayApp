import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {
    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID to room type for rollback logic. */
    private Map<String, String> reservationRoomTypeMap;

    /**
     * Initializes cancellation tracking structures.
     */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     * This method simulates storing confirmation data required for cancellation.
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking and restores inventory safely.
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            String roomType = reservationRoomTypeMap.remove(reservationId);
            
            // Restore the room to the inventory
            inventory.releaseRoom(roomType);
            
            // Track the cancellation in the rollback stack
            releasedRoomIds.push(reservationId);
            
            System.out.println("Successfully cancelled Reservation: " + reservationId);
        } else {
            System.out.println("Error: Reservation ID " + reservationId + " not found.");
        }
    }

    /**
     * Displays recently cancelled reservations.
     * This method helps visualize rollback order (LIFO).
     */
    public void showRollbackHistory() {
        System.out.println("--- Rollback History (Most Recent First) ---");
        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations recorded.");
            return;
        }
        
        // Stack follows Last-In-First-Out (LIFO)
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Cancelled: " + releasedRoomIds.get(i));
        }
    }
}