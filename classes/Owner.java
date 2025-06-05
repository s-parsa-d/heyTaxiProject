package classes;
import java.util.ArrayList;

public class Owner {
    // List to store Driver objects
    private ArrayList<Driver> drivers = new ArrayList<>();
    // List to store Passenger objects
    private ArrayList<Passenger> passengers = new ArrayList<>();

    // Getter for drivers list
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    // Getter for passengers list
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    // Method to add a driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Method to remove a driver
    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    // Method to add a passenger
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Method to remove a passenger
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
}
