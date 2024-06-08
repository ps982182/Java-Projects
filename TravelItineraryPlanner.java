import java.util.Scanner;

public class TravelItineraryPlanner {

    // Class to represent a destination
    static class Destination {
        private String name;
        private String date;

        public Destination(String name, String date) {
            this.name = name;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }
    }

    // Class to represent a travel itinerary planner
    static class Planner {
        private Destination[] destinations;
        private int currentIndex;

        public Planner(int size) {
            destinations = new Destination[size];
            currentIndex = 0;
        }

        public void addDestination(Destination destination) {
            destinations[currentIndex++] = destination;
        }

        public int getSize() {
            return currentIndex;
        }

        public Destination getDestination(int index) {
            return destinations[index];
        }
    }

    // Main method to run the travel itinerary planner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of destinations
        System.out.print("Enter the maximum number of destinations: ");
        int maxDestinations = Integer.parseInt(scanner.nextLine());

        // Create a planner with the specified number of destinations
        Planner planner = new Planner(maxDestinations);

        // Loop to continuously add destinations
        while (true) {
            System.out.println("Enter destination details (or type 'done' to finish):");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break; // Exit loop if user is done adding destinations
            }

            System.out.print("Date: ");
            String date = scanner.nextLine();

            // Create a new destination object and add it to the planner
            Destination destination = new Destination(name, date);
            planner.addDestination(destination);

            System.out.println("Destination added successfully!\n");
        }

        // Display the travel itinerary
        System.out.println("\nTravel Itinerary:");
        int numDestinations = planner.getSize();
        for (int i = 0; i < numDestinations; i++) {
            Destination destination = planner.getDestination(i);
            System.out.println("Destination " + (i + 1) + ": " + destination.getName() + " (" + destination.getDate() + ")");
        }

        scanner.close();
    }
}

