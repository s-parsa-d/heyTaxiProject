package classes;
public class Driver {

    private static int id_counter = 1; // Static counter for unique IDs
    private String firstName;
    private String lastName;
    private int id;
    private int x;
    private int y;
    // private boolean is_in_travel = false;

    // Constructor with coordinates and name
    public Driver(int x, int y, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id_counter++;
        this.x = x;
        this.y = y;
    }

    // Getters 
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getId() {
        return id;
    }
    // public boolean getFlag(){
    //     return is_in_travel;
    // }
    // public void setFlag(boolean flag){
    //     is_in_travel = flag;
    // }
    // function for distance
    public double distanceToPassenger(Passenger passenger) {
        int dx = this.x - passenger.getFromX();
        int dy = this.y - passenger.getFromY();
        return  Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + id + " ";
    }
}