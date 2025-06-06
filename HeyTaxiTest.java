import classes.Driver;
import classes.Passenger;

public class HeyTaxiTest {
    public static void main(String[] args) {
        // Create a new driver with default values
        Driver driver1 = new Driver();
        System.out.println("Driver ID: " + driver1.getId());
        System.out.println("Driver Name: " + driver1.getName());
        System.out.println("Driver Coordinates: (" + driver1.getX() + ", " + driver1.getY() + ")");
        
        // Create a new driver with specific values
        Driver driver2 = new Driver(10, 20, "John Doe");
        System.out.println("Driver ID: " + driver2.getId());
        System.out.println("Driver Name: " + driver2.getName());
        System.out.println("Driver Coordinates: (" + driver2.getX() + ", " + driver2.getY() + ")");

        // // Create a new passenger with default values
        // Passenger passenger1 = new Passenger();
        // System.out.println("Passenger ID: " + passenger1.getId());
        // System.out.println("Passenger Name: " + passenger1.getName());
        // System.out.println("Passenger Coordinates: (" + passenger1.getX() + ", " + passenger1.getY() + ")");

        // // Create a new passenger with specific values
        // Passenger passenger2 = new Passenger(5, 15, "Alice");
        // System.out.println("Passenger ID: " + passenger2.getId());
        // System.out.println("Passenger Name: " + passenger2.getName());
        // System.out.println("Passenger Coordinates: (" + passenger2.getX() + ", " + passenger2.getY() + ")");
    }
}
