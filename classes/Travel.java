package classes;
import static java.lang.Math.abs;

public class Travel {
    
    private Driver driver;
    private Passenger passenger;
    private int distance; // Distance of the travel in kilometers
    private double fare; // Fare for the travel in currency units

    // Constructor to initialize a travel with driver, passenger, distance, and fare
    public Travel(Driver driver, Passenger passenger) {
        this.driver = driver;
        this.passenger = passenger;
        // this.distance = abs(driver.getX() - passenger.getX()) + abs(driver.getY() - passenger.getY());
        this.fare = 20 + (distance * 2); // Base fare + distance charge
    }

    // Getters
    public Driver getDriver() {
        return driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }
}
