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

        // Create a new passenger with default values
        Passenger passenger1 = new Passenger();
        System.out.println("Passenger ID: " + passenger1.getId());
        System.out.println("Passenger Name: " + passenger1.getFirstName() + " " + passenger1.getLastName());
        System.out.println("Passenger From: (" + passenger1.getFromX() + ", " + passenger1.getFromY() + ")");
        System.out.println("Passenger To: (" + passenger1.getToX() + ", " + passenger1.getToY() + ")");
        System.out.println("Passenger Distance: " + passenger1.calculateDistance());

        // Create a new passenger with specific values
        Passenger passenger2 = new Passenger("Alice", "Smith", 2, 3, 10, 15);
        System.out.println("Passenger ID: " + passenger2.getId());
        System.out.println("Passenger Name: " + passenger2.getFirstName() + " " + passenger2.getLastName());
        System.out.println("Passenger From: (" + passenger2.getFromX() + ", " + passenger2.getFromY() + ")");
        System.out.println("Passenger To: (" + passenger2.getToX() + ", " + passenger2.getToY() + ")");
        System.out.printf("Passenger Distance: %.2f \n", passenger2.calculateDistance());
    }
}
