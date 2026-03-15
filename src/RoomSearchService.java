import java.util.Map;

public class RoomSearchService {

    public void searchAvailability(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single") > 0) {
            System.out.println("Single Room Available");
            singleRoom.displayRoomDetails();
        }

        if (availability.get("Double") > 0) {
            System.out.println("Double Room Available");
            doubleRoom.displayRoomDetails();
        }

        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room Available");
            suiteRoom.displayRoomDetails();
        }
    }
}