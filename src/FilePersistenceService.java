import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;

public class FilePersistenceService {

    /**
     * Saves room inventory state to a file.
     * Each line follows the format: roomType=availableCount
     * @param inventory centralized room inventory
     * @param filePath path to persistence file
     */
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Map<String, Integer> data = inventory.getInventoryData();
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
            System.out.println("Inventory state persisted to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Loads room inventory state from a file.
     * @param inventory centralized room inventory
     * @param filePath path to persistence file
     */
    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("No persistence file found. Starting with default inventory.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String type = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    inventory.updateInventory(type, count);
                }
            }
            System.out.println("Inventory state restored from: " + filePath);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
        }
    }
}