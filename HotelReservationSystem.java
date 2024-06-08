import java.util.*;

// Enum for room types
enum RoomType {
    SINGLE,
    DOUBLE,
    SUITE
}

// Class representing a hotel room
class Room {
    private int roomNumber;
    private RoomType type;
    private boolean isAvailable;

    public Room(int roomNumber, RoomType type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void releaseRoom() {
        isAvailable = true;
    }
}

// Class representing a hotel
class Hotel {
    private String name;
    private List<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        rooms = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        // Initialize some sample rooms
        for (int i = 1; i <= 10; i++) {
            if (i <= 5)
                rooms.add(new Room(i, RoomType.SINGLE));
            else if (i <= 8)
                rooms.add(new Room(i, RoomType.DOUBLE));
            else
                rooms.add(new Room(i, RoomType.SUITE));
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + " - " + room.getType());
            }
        }
    }

    public boolean makeReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.bookRoom();
                System.out.println("Reservation for Room " + roomNumber + " (" + room.getType() + ") successful!");
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
        return false;
    }

    public void viewBookingDetails() {
        System.out.println("Booking Details:");
        for (Room room : rooms) {
            if (!room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber() + " - " + room.getType());
            }
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Sample Hotel");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    hotel.makeReservation(roomNumber);
                    break;
                case 3:
                    hotel.viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
