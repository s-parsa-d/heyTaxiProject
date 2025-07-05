import classes.*;
import java.util.Scanner;

public class HeyTaxiTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            
            // 1. Create an Owner instance to manage our business
            Owner owner = new Owner();
            System.out.println("HeyTaxi service started!");

            // 2. Add several drivers to the system
            Driver driver1 = null, driver2 = null, driver3 = null;
            try {
                driver1 = new Driver(5, 5, "Reza", "Alavi");
                driver2 = new Driver(20, 25, "Maryam", "Sadeghi");
                driver3 = new Driver(1, 1, "Amir", "Hosseini");
                owner.addDriver(driver1);
                owner.addDriver(driver2);
                owner.addDriver(driver3);
            } catch (Exception e) {
                System.out.println("Error creating or adding drivers: " + e.getMessage());
            }
            System.out.println("Total drivers in system: " + owner.getDrivers().size());
            System.out.println("------------------------------------------");

            System.out.println("Please Enter Your Name :");
            String PassengerName = scanner.nextLine();
            System.out.println("Please Enter Your Family :");
            String PassengerFamily = scanner.nextLine();
            System.out.println("Whats Your Current Location ? (x,y)"); 
            int fromX = scanner.nextInt();
            int fromY = scanner.nextInt();
            System.out.println("Where Do You Want To Go ? (x,y)");
            int toX = scanner.nextInt();
            int toY = scanner.nextInt();
            scanner.close();

            // 3. Create two passengers with different trip requests
            Passenger passenger1 = null, passenger2 = null;
            try {
                passenger1 = new Passenger(PassengerName, PassengerFamily, fromX, fromY, toX, toY);
                passenger2 = new Passenger("Nima", "Moradi", 18, 22, 30, 40);
                owner.addPassenger(passenger1);
                owner.addPassenger(passenger2);
            } catch (Exception e) {
                System.out.println("Error creating or adding passengers: " + e.getMessage());
            }
            
            // --- Trip 1 ---
            if (passenger1 != null) {
                System.out.println("\n--- Starting Trip 1 for " + passenger1.getFirstName() + " ---");
                try {
                    // 4. Find the nearest driver for the first passenger
                    System.out.println("Finding nearest driver for " + passenger1.getFirstName() +
                                    " at (" + passenger1.getFromX() + "," + passenger1.getFromY() + ")");
                    Driver nearestDriverForP1 = owner.findNearestDriver(passenger1);
                    if (nearestDriverForP1 == null) {
                        System.out.println("No driver found for passenger 1.");
                    } else {
                        System.out.println("Nearest driver found: " + nearestDriverForP1.getFirstName());
                        // 5. Calculate the trip price
                        double priceForP1 = owner.calculatePrice(passenger1);
                        System.out.printf("Estimated price for the trip: %.2f\n", priceForP1);
                        // 6. Start the trip
                        owner.startTrip(passenger1, nearestDriverForP1);
                        // 7. End the trip after some time
                        System.out.println("Trip is ongoing...");
                        owner.endTrip(passenger1, nearestDriverForP1);
                        System.out.println("--- Trip 1 Finished ---");
                    }
                } catch (Exception e) {
                    System.out.println("Error during Trip 1: " + e.getMessage());
                }
            } else {
                System.out.println("Passenger 1 is null, skipping Trip 1.");
            }
            System.out.println("------------------------------------------");
            
            // --- Trip 2 ---
            if (passenger2 != null) {
                System.out.println("\n--- Starting Trip 2 for " + passenger2.getFirstName() + " ---");
                try {
                    // 8. Find the nearest driver for the second passenger
                    System.out.println("Finding nearest driver for " + passenger2.getFirstName() +
                                    " at (" + passenger2.getFromX() + "," + passenger2.getFromY() + ")");
                    Driver nearestDriverForP2 = owner.findNearestDriver(passenger2);
                    if (nearestDriverForP2 == null) {
                        System.out.println("No driver found for passenger 2.");
                    } else {
                        System.out.println("Nearest driver found: " + nearestDriverForP2.getFirstName());
                        // 9. Calculate the trip price
                        double priceForP2 = owner.calculatePrice(passenger2);
                        System.out.printf("Estimated price for the trip: %.2f\n", priceForP2);
                        // 10. Start the second trip (leave it ongoing)
                        owner.startTrip(passenger2, nearestDriverForP2);
                        System.out.println("--- Trip 2 Started (and is ongoing) ---");
                    }
                } catch (Exception e) {
                    System.out.println("Error during Trip 2: " + e.getMessage());
                }
            } else {
                System.out.println("Passenger 2 is null, skipping Trip 2.");
            }
            System.out.println("------------------------------------------");

            // 11. Finally, print a report of all trips to the console
            try {
                System.out.println("\n--- Final Report of All Travels ---");
                owner.printAllTravels();
            } catch (Exception e) {
                System.out.println("Error printing all travels: " + e.getMessage());
            }
            
            // 12. Write the full report to a CSV file
            try {
                System.out.println("\n--- Writing all travels to CSV file ---");
                TravelCSVWriter.writeToCSV(owner.getAllTravels(), "travels.csv");
            } catch (Exception e) {
                System.out.println("Error writing travels to CSV: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Unexpected error in HeyTaxiTest: " + e.getMessage());
        }
    }
}
