import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddInServiceManager {
    // Maps reservation ID to selected services
    private Map<String, List<AddInService>> servicesByReservation;

    public AddInServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attaches a service to a reservation.
     * @param reservationId confirmed reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, AddInService service) {
        // If reservation doesn't exist in map, create a new list
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total add-on cost for a reservation.
     * @param reservationId reservation ID
     * @return total service cost
     */
    public double calculateTotalServiceCost(String reservationId) {
        List<AddInService> services = servicesByReservation.get(reservationId);
        if (services == null || services.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (AddInService service : services) {
            total += service.getCost();
        }
        return total;
    }
}