package classes;

import java.util.Date;

public class Travel {
    private Passenger passenger;
    private Driver driver;
    private String status;
    private Date startTripTime;
    private Date endTripTime;

    public Travel(Passenger passenger, Driver driver, String status) {
        this.passenger = passenger;
        this.driver = driver;
        this.status = status;
        this.startTripTime = null;
        this.endTripTime = null;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTripTime() {
        return startTripTime;
    }

    public void setStartTripTime(Date date) {
        this.startTripTime = date;
    }

    public Date getEndTripTime() {
        return endTripTime;
    }

    public void setEndTripTime(Date date) {
        this.endTripTime = date;
    }
}