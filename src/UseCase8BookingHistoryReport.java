public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {
        // Initialize history and reporting service
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulate adding confirmed reservations
        history.addReservation(new Reservation("RES001", "Alice", 250.0));
        history.addReservation(new Reservation("RES002", "Bob", 400.0));
        history.addReservation(new Reservation("RES003", "Charlie", 120.0));

        // Generate the report
        reportService.generateReport(history);
    }
}

/**
 * Placeholder for the Reservation class used in this use case.
 */
class Reservation {
    private String id;
    private String guestName;
    private double totalAmount;

    public Reservation(String id, String guestName, double totalAmount) {
        this.id = id;
        this.guestName = guestName;
        this.totalAmount = totalAmount;
    }

    public String getDetails() {
        return String.format("ID: %s | Guest: %s | Total: $%.2f", id, guestName, totalAmount);
    }
}