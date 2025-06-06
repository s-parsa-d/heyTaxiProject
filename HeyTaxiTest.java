import classes.Driver;

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
    }
}
