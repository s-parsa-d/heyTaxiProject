package classes;
public class Driver {

    
    private static int id_counter = 1; // Static counter for unique IDs
    private String name;
    private int id;
    private int x;
    private int y;

    // Default constructor initializes with default values
    public Driver() {
        this.id = id_counter++;
        this.x = 0;
        this.y = 0;
        this.name = "driver" + this.id; // Default name based on ID
    }

    // Constructor with coordinates and name
    public Driver(int x, int y, String name) {
        this.id = id_counter++;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    // Getters 
    public String getName() {
        return name;
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

}