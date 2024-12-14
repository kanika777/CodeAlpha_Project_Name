import java.util.*;

class Destination {
    String name;
    String date;
    String activity;
    String accommodation;

    // Constructor to initialize destination details
    public Destination(String name, String date, String activity, String accommodation) {
        this.name = name;
        this.date = date;
        this.activity = activity;
        this.accommodation = accommodation;
    }

    // Method to display destination details
    public void displayDestinationDetails() {
        System.out.println("Destination: " + name);
        System.out.println("Date: " + date);
        System.out.println("Activity: " + activity);
        System.out.println("Accommodation: " + accommodation);
        System.out.println("-------------------------");
    }
}

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Destination> itinerary = new ArrayList<>();

        // Main loop for adding destinations
        while (true) {
            System.out.println("Enter the destination name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter the date for " + name + " (e.g., 2024-12-25): ");
            String date = scanner.nextLine();

            System.out.print("Enter the main activity for " + name + ": ");
            String activity = scanner.nextLine();

            System.out.print("Enter the accommodation details for " + name + ": ");
            String accommodation = scanner.nextLine();

            // Create a new destination and add it to the itinerary list
            Destination destination = new Destination(name, date, activity, accommodation);
            itinerary.add(destination);

            System.out.println("Destination added successfully!\n");
        }

        // Display the full itinerary
        System.out.println("\nYour Travel Itinerary:");
        if (itinerary.isEmpty()) {
            System.out.println("No destinations have been added.");
        } else {
            for (Destination destination : itinerary) {
                destination.displayDestinationDetails();
            }
        }

        scanner.close();
    }
}
