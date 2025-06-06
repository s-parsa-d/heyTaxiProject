package classes;
public class Passenger {
    private String firstName;
    private String lastName;
    private int fromX;
    private int fromY;
    private int toX;
    private int toY;
    private static int nextId = 1;
    private final int id;

    public Passenger() {
        this.firstName = "";
        this.lastName = "";
        this.fromX = 0;
        this.fromY = 0;
        this.toX = 0;
        this.toY = 0;
        this.id = nextId++;
    }

    public Passenger(String firstName, String lastName, int fromX, int fromY, int toX, int toY) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.id = nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getFromX() {
        return fromX;
    }

    public int getFromY() {
        return fromY;
    }

    public int getToX() {
        return toX;
    }

   
    public int getToY() {
        return toY;
    }

    public int getId() {
        return id;
    }

    public double calculateDistance() {
        int dx = toX - fromX;
        int dy = toY - fromY;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
}