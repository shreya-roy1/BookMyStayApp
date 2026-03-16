import java.util.*;

public class UseCaseRoomAllocation {
    public static void main(String[] args) {
        RoomAllocationService service = new RoomAllocationService();
        RoomInventory inventory = new RoomInventory(); 

        Queue<Reservation> requests = new LinkedList<>();
        requests.add(new Reservation("Deluxe"));
        requests.add(new Reservation("Suite"));

        while (!requests.isEmpty()) {
            service.allocateRoom(requests.poll(), inventory);
        }
    }
}