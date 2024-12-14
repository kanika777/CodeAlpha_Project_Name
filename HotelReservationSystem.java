import java.util.*;

class Room {
    int roomNumber;
    boolean isAvailable;
    String type;
    double price;

    // Constructor for Room
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;  // All rooms are available by default
    }

    // Method to book the room
    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been successfully booked!");
        } else {
            System.out.println("Sorry, Room " + roomNumber + " is already booked.");
        }
    }

    // Method to cancel the room booking
    public void cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Room " + roomNumber + "'s booking has been cancelled.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + type);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Booked"));
        System.out.println("-------------------------");
    }
}

class ReservationSystem {
    List<Room> rooms;

    // Constructor to initialize the rooms
    public ReservationSystem() {
        rooms = new ArrayList<>();
        // Adding some rooms to the system
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 250.0));
        rooms.add(new Room(104, "Single", 100.0));
        rooms.add(new Room(105, "Double", 150.0));
    }

    // Method to display all available rooms
    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                room.displayRoomDetails();
            }
        }
    }

    // Method to reserve a room
    public void reserveRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.bookRoom();
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    // Method to cancel a reservation
    public void cancelReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                room.cancelBooking();
                return;
            }
        }
        System.out.println("Room " + roomNumber + " not found.");
    }

    // Method to view all rooms
    public void viewAllRooms() {
        System.out.println("All Rooms in the Hotel:");
        for (Room room : rooms) {
            room.displayRoomDetails();
        }
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();
        
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View all rooms");
            System.out.println("2. View available rooms");
            System.out.println("3. Reserve a room");
            System.out.println("4. Cancel a reservation");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.viewAllRooms();
                    break;
                case 2:
                    reservationSystem.displayAvailableRooms();
                    break;
                case 3:
                    System.out.print("Enter the room number to reserve: ");
                    int roomNumberToReserve = scanner.nextInt();
                    reservationSystem.reserveRoom(roomNumberToReserve);
                    break;
                case 4:
                    System.out.print("Enter the room number to cancel reservation: ");
                    int roomNumberToCancel = scanner.nextInt();
                    reservationSystem.cancelReservation(roomNumberToCancel);
                    break;
                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
