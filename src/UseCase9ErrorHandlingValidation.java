import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize required components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        // Assuming this is the service that would process the booking
        // BookingProcessService bookingService = new BookingProcessService();

        try {
            System.out.print("Enter Guest Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Room Type: ");
            String type = scanner.nextLine();

            // Perform validation
            validator.validate(name, type, inventory);

            // If validation passes, proceed
            System.out.println("Validation successful! Proceeding with booking...");

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors
            System.out.println("Booking Failed: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected errors
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/**
 * Minimal placeholder for RoomInventory to make the code runnable.
 */
class RoomInventory {
    public boolean isRoomAvailable(String roomType) {
        // Simple logic for demonstration
        return roomType.equalsIgnoreCase("Deluxe") || roomType.equalsIgnoreCase("Suite");
    }
}