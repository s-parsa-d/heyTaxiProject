import classes.Driver;
import classes.Owner;
import classes.Passenger;

public class HeyTaxiTest {
    public static void main(String[] args) {
        Owner owner = new Owner();

        // Create a new driver with specific values
        Driver driver2 = new Driver(10, 20, "John", "Doe");
        System.out.println(driver2.toString());

        // Create a new passenger with specific values
        Passenger passenger2 = new Passenger("Alice", "Smith", 2, 3, 10, 15);
        System.out.println("Passenger ID: " + passenger2.getId());
        System.out.println("Passenger Name: " + passenger2.getFirstName() + " " + passenger2.getLastName());
        System.out.println("Passenger From: (" + passenger2.getFromX() + ", " + passenger2.getFromY() + ")");
        System.out.println("Passenger To: (" + passenger2.getToX() + ", " + passenger2.getToY() + ")");
        System.out.printf("Passenger Distance: %.2f \n", passenger2.calculateDistance());

        System.out.printf("price for p2 %.2f \n", owner.calculatePrice(passenger2));
        owner.addDriver(driver2);
        owner.addPassenger(passenger2);
        System.out.println(owner.findNearestDriver(passenger2)); 
        System.out.println(driver2.getFlag());
    }
}
