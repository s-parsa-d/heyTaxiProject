package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner {

    // final var
    private final int BASERATE = 20;
    private final String[] STATUS = {"PENDING", "ONGOING", "END"};
    
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    // list for all travels
    private List<Travel> allTravels = new ArrayList<>(); 
    
    private Passenger currentPassenger;
    private Driver currentDriver;
    private Date tripStartTime;
    private Date tripEndTime;
    private String tripStatus = STATUS[0]; // default value
    
    // Getter
    public List<Travel> getAllTravels() {
        return allTravels;
    }
    
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

    // function for find nearst driver
    public Driver findNearestDriver(Passenger passenger) {
        if (drivers.isEmpty()) {
            System.out.println("No available drivers.");
            return null;
        }

        Driver nearest = drivers.get(0);
        double minDistance = nearest.distanceToPassenger(passenger);

        for (Driver driver : drivers) {
            double currentDistance = driver.distanceToPassenger(passenger);
            if (currentDistance < minDistance) {
                minDistance = currentDistance;  
                nearest = driver;         
            }
        }

        return nearest;
    }

    // function for start trip
    public void startTrip(Passenger passenger, Driver driver) {
        if (!passengers.contains(passenger) || !drivers.contains(driver)) {
            System.out.println("Passenger or driver not valid !");
            return;
        }

        this.currentPassenger = passenger;
        this.currentDriver = driver;
        this.tripStartTime = new Date();
        this.tripStatus = STATUS[1]; // ONGOING

        Travel travel = new Travel(passenger, driver, STATUS[1]);
        travel.setStartTripTime(this.tripStartTime);
        allTravels.add(travel);

        System.out.println("Your trip has begun at this time: " + tripStartTime + " with driver " + driver.getFirstName() + " " + driver.getLastName());
    }
    // function for end trip
    public void endTrip(Passenger passenger, Driver driver) {
        if (!tripStatus.equals(STATUS[1])) {
            System.out.println("There is no ongoing trip!");
            return;
        }

        this.tripEndTime = new Date() ;
        this.tripStatus = STATUS[2];

        // find the correct travel
        for (Travel travel : allTravels) {
            if (travel.getPassenger().getId() == passenger.getId() && 
                travel.getDriver().getId() == driver.getId() &&
                travel.getStatus().equals("ONGOING")) {
                
                travel.setEndTripTime(this.tripEndTime);
                travel.setStatus(STATUS[2]);
                break;
            }
        }

        System.out.println("Your trip ended at this time: " + tripEndTime);
    }

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

            // start time
            if (travel.getStartTripTime() != null) {
                System.out.println("Start Time: " + travel.getStartTripTime().toString());
            } else {
                System.out.println("Start Time: Not started");
            }

            // end time
            if (travel.getEndTripTime() != null) {
                System.out.println("End Time: " + travel.getEndTripTime().toString());
            } else {
                System.out.println("End Time: Not ended");
            }

            System.out.println("-----------------------------");
        }
    }
}



