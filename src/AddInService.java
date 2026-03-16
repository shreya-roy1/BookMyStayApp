public class AddInService {
    private String serviceName;
    private double cost;

    /**
     * Creates a new add-on service.
     * @param serviceName name of the service
     * @param cost cost of the service
     */
    public AddInService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}