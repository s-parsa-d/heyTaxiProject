package classes;
import java.util.ArrayList;

public class Owner {
    // List to store Driver objects
    private ArrayList<Driver> drivers = new ArrayList<>();

    // Getter for drivers list
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    // Method to add a driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Method to remove a driver
    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    
}
