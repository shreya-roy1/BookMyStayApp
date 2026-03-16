import java.util.*;

public class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        String roomId = generateRoomId(roomType);
        
        allocatedRoomIds.add(roomId);
        assignedRoomsByType.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
        inventory.markRoomAsOccupied(roomId);
        
        System.out.println("Allocated " + roomType + " room: " + roomId);
    }

    private String generateRoomId(String roomType) {
        String roomId;
        int counter = 1;
        do {
            roomId = roomType.toUpperCase() + "-" + String.format("%03d", counter++);
        } while (allocatedRoomIds.contains(roomId));
        return roomId;
    }
}