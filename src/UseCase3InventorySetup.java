/**
 * =========================================================
 * MAIN CLASS - UseCase3InventorySetup
 * =========================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        System.out.println("Room Inventory Initialized Successfully");

        System.out.println(inventory.getRoomAvailability());

    }
}