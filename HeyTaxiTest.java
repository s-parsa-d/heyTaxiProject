import classes.*;

public class HeyTaxiTest {
    public static void main(String[] args) {
        // 1. Create an Owner instance to manage our business
        Owner owner = new Owner();
        System.out.println("HeyTaxi service started!");

        // 2. Add several drivers to the system
        Driver driver1 = new Driver(5, 5, "Reza", "Alavi");
        Driver driver2 = new Driver(20, 25, "Maryam", "Sadeghi");
        Driver driver3 = new Driver(1, 1, "Amir", "Hosseini");
        owner.addDriver(driver1);
        owner.addDriver(driver2);
        owner.addDriver(driver3);
        System.out.println("Total drivers in system: " + owner.getDrivers().size());
        System.out.println("------------------------------------------");

        // 3. Create two passengers with different trip requests
        Passenger passenger1 = new Passenger("Sara", "Ahmadi", 2, 3, 10, 15);
        Passenger passenger2 = new Passenger("Nima", "Moradi", 18, 22, 30, 40);
        owner.addPassenger(passenger1);
        owner.addPassenger(passenger2);
        
        // --- Trip Scenario 1 ---
        System.out.println("\n--- Starting Trip Scenario 1 for " + passenger1.getFirstName() + " ---");
        
        // 4. Find the nearest driver for the first passenger
        System.out.println("Finding nearest driver for " + passenger1.getFirstName() +
                           " at (" + passenger1.getFromX() + "," + passenger1.getFromY() + ")");
        Driver nearestDriverForP1 = owner.findNearestDriver(passenger1);
        System.out.println("Nearest driver found: " + nearestDriverForP1.getFirstName()); // Expected: Reza
        
        // 5. Calculate the trip price
        double priceForP1 = owner.calculatePrice(passenger1);
        System.out.printf("Estimated price for the trip: %.2f\n", priceForP1);
        
        // 6. Start the trip
        owner.startTrip(passenger1, nearestDriverForP1);
        
        // 7. End the trip after some time
        // (in a real app you might have a delay here)
        System.out.println("Trip is ongoing...");
        owner.endTrip(passenger1, nearestDriverForP1);
        System.out.println("--- Trip Scenario 1 Finished ---");
        
        System.out.println("------------------------------------------");
        
        // --- Trip Scenario 2 ---
        System.out.println("\n--- Starting Trip Scenario 2 for " + passenger2.getFirstName() + " ---");
        
        // 8. Find the nearest driver for the second passenger
        System.out.println("Finding nearest driver for " + passenger2.getFirstName() +
                           " at (" + passenger2.getFromX() + "," + passenger2.getFromY() + ")");
        Driver nearestDriverForP2 = owner.findNearestDriver(passenger2);
        System.out.println("Nearest driver found: " + nearestDriverForP2.getFirstName()); // Expected: Maryam
        
        // 9. Calculate the trip price
        double priceForP2 = owner.calculatePrice(passenger2);
        System.out.printf("Estimated price for the trip: %.2f\n", priceForP2);

        // 10. Start the second trip (leave it ongoing)
        owner.startTrip(passenger2, nearestDriverForP2);
        System.out.println("--- Trip Scenario 2 Started (and is ongoing) ---");

        System.out.println("------------------------------------------");

        // 11. Finally, print a report of all trips to the console
        System.out.println("\n--- Final Report of All Travels ---");
        owner.printAllTravels();
        
        // 12. Write the full report to a CSV file
        System.out.println("\n--- Writing all travels to CSV file ---");
        TravelCSVWriter.writeToCSV(owner.getAllTravels(), "travels.csv");
        
    }
}
