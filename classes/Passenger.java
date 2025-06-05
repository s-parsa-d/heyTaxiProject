package classes;
public class Passenger {
    
    // Static counter for unique IDs
    private static int id_counter = 1; 
    private String name;
    private int id = 1;
    private int x;
    private int y;

    // Default constructor initializes with empty name and coordinates (0,0)
    public Passenger() {
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.id = id_counter++;
    }

    // Constructor with coordinates and name
    public Passenger(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.id = id_counter++;
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