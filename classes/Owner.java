package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner {

    private final int BASERATE = 20;
    private final String[] STATUS = {"PENDING", "ONGOING", "END", "CANCEL"};
    
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    
    //private Map<Passenger, Travel> passengerTravelMap = new HashMap<>();
    //private Map<Driver, Travel> driverTravelMap = new HashMap<>();
    //private List<Travel> allTravels = new ArrayList<>()

    // ✅ لیست تمام سفرها
    private List<Travel> allTravels = new ArrayList<>(); 

    private Passenger currentPassenger;
    private Driver currentDriver;
    private Date tripStartTime;
    private Date tripEndTime;
    private String tripStatus = STATUS[0]; // وضعیت اولیه

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public double calculatePrice(Passenger passenger) {
        double distance = passenger.calculateDistance();
        return BASERATE + distance * 2;
    }

    // ✅ تغییر: نوع خروجی الان Driver است، نه String
    public Driver findNearestDriver(Passenger passenger) {
        if (drivers.isEmpty()) {
            System.out.println("No available drivers.");
            return null;
        }

        Driver nearest = drivers.get(0);
        double minDistance = nearest.distanceTo(passenger.getFromX(), passenger.getFromY());

        for (Driver driver : drivers) {
            double currentDistance = driver.distanceTo(passenger.getFromX(), passenger.getFromY());
            if (currentDistance < minDistance) {
                minDistance = currentDistance;  
                nearest = driver;         
            }
        }

        return nearest;
    }

    // ✅ تغییر: ثبت سفر توی allTravels
    public void startTrip(Passenger passenger, Driver driver) {
        if (!passengers.contains(passenger) || !drivers.contains(driver)) {
            System.out.println("Passenger or driver not valid !");
            return;
        }

        this.currentPassenger = passenger;
        this.currentDriver = driver;
        this.tripStartTime = new Date();
        this.tripStatus = STATUS[1]; // ONGOING

        // ✅ ثبت سفر در Travel
        Travel travel = new Travel(passenger, driver, "ONGOING");
        travel.setStartTripTime(this.tripStartTime);
        allTravels.add(travel);

        System.out.println("Your trip has begun at this time: " + tripStartTime + " with driver " + driver.getFirstName() + " " + driver.getLastName());
    }

    public void endTrip(Passenger passenger, Driver driver) {
        if (!tripStatus.equals(STATUS[1])) {
            System.out.println("There is no ongoing trip!");
            return;
        }

        this.tripEndTime = new Date();
        this.tripStatus = STATUS[2];

        // ✅ پیدا کردن سفر مرتبط و آپدیتش
        for (Travel travel : allTravels) {
            if (travel.getPassenger().getId() == passenger.getId() && 
                travel.getDriver().getId() == driver.getId() &&
                travel.getStatus().equals("ONGOING")) {
                
                travel.setEndTripTime(this.tripEndTime);
                travel.setStatus("END");
                break;
            }
        }

        System.out.println("Your trip ended at this time: " + tripEndTime);
    }

    // ✅ متد جدید: چاپ تمام سفرها
public void printAllTravels() {
    if (allTravels.isEmpty()) {
        System.out.println("No trips recorded yet.");
        return;
    }

    for (int i = 0; i < allTravels.size(); i++) {
        Travel travel = allTravels.get(i);
        System.out.println("Trip #" + (i + 1));
        System.out.println("Passenger ID: " + travel.getPassenger().getId());
        System.out.println("Driver ID: " + travel.getDriver().getId());
        System.out.println("Status: " + travel.getStatus());

        // زمان شروع
        if (travel.getStartTripTime() != null) {
            System.out.println("Start Time: " + travel.getStartTripTime().toString());
        } else {
            System.out.println("Start Time: Not started");
        }

        // زمان پایان
        if (travel.getEndTripTime() != null) {
            System.out.println("End Time: " + travel.getEndTripTime().toString());
        } else {
            System.out.println("End Time: Not ended");
        }

        System.out.println("-----------------------------");
    }
}
}



