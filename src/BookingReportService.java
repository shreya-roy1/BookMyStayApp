public class BookingReportService {

    /**
     * Displays a summary report of all confirmed bookings.
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {
        System.out.println("------ BOOKING HISTORY REPORT ------");
        if (history.getConfirmedReservations().isEmpty()) {
            System.out.println("No confirmed bookings found.");
            return;
        }

        for (Reservation res : history.getConfirmedReservations()) {
            // Assuming Reservation has a toString() or similar display logic
            System.out.println(res.getDetails());
        }
        System.out.println("------------------------------------");
    }
}