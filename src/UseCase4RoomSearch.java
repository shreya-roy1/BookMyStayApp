public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new Room(1,200,1500){};
        Room doubleRoom = new Room(2,350,2500){};
        Room suite = new Room(3,500,4500){};

        RoomSearchService service = new RoomSearchService();

        service.searchAvailability(
                inventory,
                single,
                doubleRoom,
                suite
        );
    }
}