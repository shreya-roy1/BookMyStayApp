public class ReservationValidator {
    /**
     * Validates booking input provided by the user.
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(String guestName, String roomType, RoomInventory inventory) 
            throws InvalidBookingException {
        
        // Rule 1: Name cannot be empty
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Rule 2: Room type must be valid
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException("Room type must be specified.");
        }

        // Rule 3: Check availability in inventory
        if (!inventory.isRoomAvailable(roomType)) {
            throw new InvalidBookingException("No rooms of type '" + roomType + "' are available.");
        }
    }
}