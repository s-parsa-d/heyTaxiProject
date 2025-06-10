package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TravelCSVWriter {

    public static void writeToCSV(List<Travel> travels, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Header
            writer.append("PassengerId,PassengerName,FromX,FromY,ToX,ToY,DriverId,DriverName,DriverX,DriverY,TravelStatus,StartTime,EndTime\n");

            // Format تاریخ
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (Travel travel : travels) {
                Passenger passenger = travel.getPassenger();
                Driver driver = travel.getDriver();

                writer.append(passenger.getId() + ",");
                writer.append(passenger.getFirstName() + " " + passenger.getLastName() + ",");
                writer.append(passenger.getFromX() + "," + passenger.getFromY() + ",");
                writer.append(passenger.getToX() + "," + passenger.getToY() + ",");
                writer.append(driver.getId() + ",");
                writer.append(driver.getFirstName() + " " + driver.getLastName() + ",");
                writer.append(driver.getX() + "," + driver.getY() + ",");
                writer.append(travel.getStatus() + ",");

                // تاریخ شروع
                if (travel.getStartTripTime() != null)
                    writer.append(sdf.format(travel.getStartTripTime()) + ",");
                else
                    writer.append("null,");

                // تاریخ پایان
                if (travel.getEndTripTime() != null)
                    writer.append(sdf.format(travel.getEndTripTime()));
                else
                    writer.append("null");

                writer.append("\n");
            }

            System.out.println("CSV file written successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
