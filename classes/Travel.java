package classes;
import java.util.Date;

public class Travel {

    private Passenger passenger;
    private Driver driver;
    private String status;
    private Date startTripTime;
    private Date endTripTime;

    // Constructor with Passenger and Driver
    public Travel(Passenger passenger, Driver driver, String status) {
        this.passenger = passenger;
        this.driver = driver;
        this.status = status;
        this.startTripTime = null;
        this.endTripTime = null;
    }

    // Getter
    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTripTime() {
        return startTripTime;
    }

    public void setStartTripTime(Date startTripTime) {
        this.startTripTime = startTripTime;
    }

    public Date getEndTripTime() {
        return endTripTime;
    }

    public void setEndTripTime(Date endTripTime) {
        this.endTripTime = endTripTime;
    }
}