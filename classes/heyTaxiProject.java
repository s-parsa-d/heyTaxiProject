package classes;
public class heyTaxiProject {
    public static void main(String[] args) {
        Owner owner = new Owner();
        Driver driver1 = new Driver(0, 0);
        Driver driver2 = new Driver(-2, 7);
        Driver driver3 = new Driver(1, 6);
        Driver driver4 = new Driver(3, 4);

        owner.addDriver(driver1);
        owner.addDriver(driver2);
        owner.addDriver(driver3);
        owner.addDriver(driver4);

        Passenger passenger = new Passenger(1, 1);
        Driver nearest = owner.findNearestDriver(passenger);

        System.out.println("the nearest driver is" + nearest.fromX);
    }
}
        