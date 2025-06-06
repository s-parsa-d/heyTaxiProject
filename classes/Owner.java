package classes;
import java.util.ArrayList;

public class Owner {
    // List to store Driver objects
    private ArrayList<Driver> drivers = new ArrayList<>();
    // List to store Passenger objects
    private ArrayList<Passenger> passengers = new ArrayList<>();

    private int factor;

    public Owner() {
        this.factor = 1; // مقدار پیش‌فرض برای ضریب قیمت
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) { 
        this.factor = factor;
    }

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

    // Method to add a passenger
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // محاسبه قیمت بر اساس فاصله یک مسافر خاص
    public double calculatePrice(Passenger passenger) {
        double distance = passenger.calculateDistance();
        return distance * factor;
    }

    public Driver findNearestDriver(Passenger passenger) {
        
        if (drivers.isEmpty()) {
            return null; // اگر هیچ راننده‌ای وجود نداشته باشه
        }

        Driver nearest = drivers.get(0); // اولین راننده رو به عنوان نزدیک‌ترین در نظر می‌گیریم
        double minDistance = nearest.distanceTo(passenger.getFromX(), passenger.getFromY()); // فاصله اولین راننده

        for (Driver driver : drivers) {
            double currentDistance = driver.distanceTo(passenger.getFromX(), passenger.getFromY()); // فاصله راننده فعلی
            
            if (currentDistance < minDistance) {
                minDistance = currentDistance;  
                nearest = driver;         
            }
        }

        return nearest;
    }
}
