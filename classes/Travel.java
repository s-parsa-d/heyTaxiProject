package classes;

public class Travel {
    
    private Driver driver;
    private Passenger passenger;
    private int fromX , fromY , toX , toY ;
    private double  distance;
    private String status ; 
    private long startTime , endTime ;

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

    public int getFromX(){
        return fromX ;
    }

    public int getFromY(){
        return fromY ;
    }

    public int getToX(){
        return toX ;
    }

    public int getToY(){
        return toY;
    }

    public double  getDistance(){
        return distance;
    }

    public String getStatus(){
        return  status ;
    }

    public long getStartTime(){
        return startTime ;
    }

    public long getEndTime(){
        return endTime ;
    }

    public void setStatus(String status){
        this.status = status ;
    }

    public void startTrip(){
        if(!status.equals("PENDING")){
            System.out.println("Trip is not in PENDING state.");
            return; 
        }
        this.status = "OnGoing" ;
        this.startTime = System.currentTimeMillis();
        System.out.println("Trip started for passenger " + passenger.getId() + " with driver " + driver.getId());
    }

    public void endTrip(){
        if(!status.equals("ONGOING")){
            System.out.println("Trip is not int ONGOING state. ");
            return;
        }
        this.status = "END" ; 
        this.endTime = System.currentTimeMillis();
        System.out.println("Trip ended at time: " + endTime);
    }

    public void cancelTrip(){
        if(!status.equals("ONGOING") || !status.equals("END")){
            System.out.println("Cannot cancel !");
            return;
        }
        this.status = "CANCEL" ; 
        System.out.println("Trip Cancled.");
    }
    
}
