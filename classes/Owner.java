package classes;
import java.util.ArrayList;
import java.util.Date;


public class Owner {

    private final int BASERATE = 20;
    private final String[] STATUS = {"PENDING", "ONGOING", "END", "CANCEL"}; 

    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    private Passenger currentPassenger;
    private Driver currentDriver;
    private Date tripStartTime;
    private Date tripEndTime;
    private String tripStatus =  STATUS[0]; // وضعیت اولیه

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
        return BASERATE + distance * 2 ;
    }

    public String findNearestDriver(Passenger passenger) {
        
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
        nearest.setFlag(true);
        startTrip(passenger, nearest);
        return nearest.getFirstName() + " " + nearest.getLastName();
    }

    // شروع سفر
    public void startTrip(Passenger passenger, Driver driver) {
        if (!passengers.contains(passenger) || !drivers.contains(driver)) {
            System.out.println("passenger or driver not valid !");
            return;
        }

        this.currentPassenger = passenger;
        this.currentDriver = driver;
        this.tripStartTime = new Date();
        this.tripStatus = STATUS[1];

        System.out.println("your trip has begun at this time :  " + tripStartTime + " by " + driver.getFirstName() + " " + driver.getLastName());
    }

    public void endTrip(Passenger passenger , Driver driver){
        if(!tripStatus.equals("Ongoing")){
            System.out.println("there is no trip !");
            return; 
        }
        this.tripEndTime = new Date();
        this.tripStatus = STATUS[2];
        System.out.println("your trip ends at this time :  " + tripEndTime);
        driver.setFlag(false);
    }
}
