package classes;
public class Driver {

    private static int id_counter = 1; // Static counter for unique IDs
    private int id;
    private int x;
    private int y;
    private String name;

    // Constructors
    public Driver(int x, int y, String name) {
        this.id = id_counter++;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public Driver() {
        this.id = id_counter++;
        this.x = 0;
        this.y = 0;
        this.name = "driver" + this.id; // Default name based on ID
    }

    // Getters 
    public int getId() {
        return id;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getIdCounter() {
        return id_counter;
    }
    public String getName() {
        return name;
    }

}