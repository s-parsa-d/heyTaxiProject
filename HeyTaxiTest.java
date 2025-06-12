import classes.*;



public class HeyTaxiTest {
    public static void main(String[] args) {
        // 1. یک نمونه از Owner می‌سازیم که کسب و کار ما را مدیریت می‌کند
        Owner owner = new Owner();
        System.out.println("HeyTaxi service started!");

        // 2. چند راننده به سیستم اضافه می‌کنیم
        Driver driver1 = new Driver(5, 5, "Reza", "Alavi");
        Driver driver2 = new Driver(20, 25, "Maryam", "Sadeghi");
        Driver driver3 = new Driver(1, 1, "Amir", "Hosseini");
        owner.addDriver(driver1);
        owner.addDriver(driver2);
        owner.addDriver(driver3);
        System.out.println("Total drivers in system: " + owner.getDrivers().size());
        System.out.println("------------------------------------------");

        // 3. دو مسافر با درخواست‌های سفر متفاوت ایجاد می‌کنیم
        Passenger passenger1 = new Passenger("Sara", "Ahmadi", 2, 3, 10, 15);
        Passenger passenger2 = new Passenger("Nima", "Moradi", 18, 22, 30, 40);
        owner.addPassenger(passenger1);
        owner.addPassenger(passenger2);
        
        // --- شروع سناریوی سفر اول ---
        System.out.println("\n--- Starting Trip Scenario 1 for " + passenger1.getFirstName() + " ---");
        
        // 4. نزدیک‌ترین راننده برای مسافر اول را پیدا می‌کنیم
        System.out.println("Finding nearest driver for " + passenger1.getFirstName() + " at (" + passenger1.getFromX() + "," + passenger1.getFromY() + ")");
        Driver nearestDriverForP1 = owner.findNearestDriver(passenger1);
        System.out.println("Nearest driver found: " + nearestDriverForP1.getFirstName()); // انتظار می‌رود Reza پیدا شود
        
        // 5. قیمت سفر را محاسبه می‌کنیم
        double priceForP1 = owner.calculatePrice(passenger1);
        System.out.printf("Estimated price for the trip: %.2f\n", priceForP1);
        
        // 6. سفر را شروع می‌کنیم
        owner.startTrip(passenger1, nearestDriverForP1);
        
        // 7. سفر را پس از مدتی به پایان می‌رسانیم
        // (در یک برنامه واقعی اینجا یک تاخیر وجود دارد)
        System.out.println("Trip is ongoing...");
        owner.endTrip(passenger1, nearestDriverForP1);
        System.out.println("--- Trip Scenario 1 Finished ---");
        
        System.out.println("------------------------------------------");
        
        // --- شروع سناریوی سفر دوم ---
        System.out.println("\n--- Starting Trip Scenario 2 for " + passenger2.getFirstName() + " ---");
        
        // 8. نزدیک‌ترین راننده برای مسافر دوم را پیدا می‌کنیم
        System.out.println("Finding nearest driver for " + passenger2.getFirstName() + " at (" + passenger2.getFromX() + "," + passenger2.getFromY() + ")");
        Driver nearestDriverForP2 = owner.findNearestDriver(passenger2);
        System.out.println("Nearest driver found: " + nearestDriverForP2.getFirstName()); // انتظار می‌رود Maryam پیدا شود
        
        // 9. سفر دوم را شروع می‌کنیم (اما تمام نمی‌کنیم تا وضعیتش ONGOING بماند)
        owner.startTrip(passenger2, nearestDriverForP2);
        System.out.println("--- Trip Scenario 2 Started (and is ongoing) ---");

        System.out.println("------------------------------------------");

        // 10. در انتها، گزارش تمام سفرها را در کنسول چاپ می‌کنیم
        System.out.println("\n--- Final Report of All Travels ---");
        owner.printAllTravels();
        
        // 11. گزارش کامل را در یک فایل CSV ذخیره می‌کنیم
        System.out.println("\n--- Writing all travels to CSV file ---");
        // چون متد getTravels در Owner وجود ندارد، لیست سفرها را باید از جایی بگیریم
        // برای این کار یک متد get در Owner اضافه می‌کنیم
        // public List<Travel> getAllTravels() { return allTravels; }
        // فرض می‌کنیم این متد را اضافه کرده‌ایم
        TravelCSVWriter.writeToCSV(owner.getAllTravels(), "travels_report.csv");
        
        // یک راه حل بدون تغییر Owner: لیست را مستقیما به نویسنده CSV پاس دهیم
        // این کار در ساختار فعلی ممکن نیست، پس باید متد getAllTravels را به Owner اضافه کنید.
        // در اینجا فرض می کنیم که چنین متدی وجود دارد و آن را فراخوانی می کنیم.
        // لطفا این متد را به کلاس Owner اضافه کنید:
        // public List<Travel> getAllTravels() { return this.allTravels; }
        
        // TravelCSVWriter.writeToCSV(owner.getAllTravels(), "travels_report.csv");
        // برای اجرای این بخش، متد getAllTravels را به کلاس Owner اضافه کنید
    }
}