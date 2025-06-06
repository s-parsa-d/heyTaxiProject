package classes;
public class Driver {

    
    private static int id_counter = 1; // Static counter for unique IDs
    private String name;
    private int id;
    private int x;
    private int y;

    // Default constructor initializes with default values
    public Driver() {
        this.name = "Driver" + id_counter; // Default name based on ID
        this.id = id_counter++;
        this.x = 0;
        this.y = 0;
    }

    // Constructor with coordinates and name
    public Driver(int x, int y, String name) {
        this.name = name;
        this.id = id_counter++;
        this.x = x;
        this.y = y;
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

    public double distanceTo(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}