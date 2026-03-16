public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {
        AddInServiceManager manager = new AddInServiceManager();

        // 1. Define available services
        AddInService breakfast = new AddInService("Breakfast", 15.0);
        AddInService spa = new AddInService("Spa", 50.0);
        AddInService airportPickup = new AddInService("Airport Pickup", 30.0);

        // 2. Simulate a reservation ID
        String myResId = "RES12345";

        // 3. Add services to the reservation
        manager.addService(myResId, breakfast);
        manager.addService(myResId, spa);

        // 4. Calculate and display costs
        double totalCost = manager.calculateTotalServiceCost(myResId);
        
        System.out.println("Reservation ID: " + myResId);
        System.out.println("Total Add-on Service Cost: $" + totalCost);
    }
}