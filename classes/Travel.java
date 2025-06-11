package classes;

import java.util.Date;
public class Travel{
    public Travel(Passenger passenger , Driver driver , int fromX , int fromY , int toX , int toY , double  distance , String status ,long startTime , long endTime){
        this.passenger = passenger ; 
        this.driver = driver ;
        this.fromX = fromX ;
        this.fromY = fromY ; 
        this.toX = toX ; 
        this.toY = toY ;
        this.distance = distance ;
        this.status = status ;
        this.startTime = startTime ;
        this.endTime = endTime ;
    }
    
    // Getters
    public Driver getDriver() {
        return driver;
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