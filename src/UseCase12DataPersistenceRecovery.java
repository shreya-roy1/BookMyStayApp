public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {
        String persistencePath = "inventory_state.txt";
        
        // Initialize components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // 1. System Startup: Restore state
        System.out.println("--- System Boot ---");
        persistenceService.loadInventory(inventory, persistencePath);

        // 2. Simulate activity (e.g., booking a room)
        System.out.println("Simulating activity: Reducing Deluxe inventory...");
        inventory.reduceInventory("Deluxe");

        // 3. System Shutdown: Persist state
        System.out.println("--- System Shutdown ---");
        persistenceService.saveInventory(inventory, persistencePath);
    }
}