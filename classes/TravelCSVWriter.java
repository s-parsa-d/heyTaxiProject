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
                Passenger p = travel.getPassenger();
                Driver d = travel.getDriver();

                writer.append(p.getId() + ",");
                writer.append(p.getFirstName() + " " + p.getLastName() + ",");
                writer.append(p.getFromX() + "," + p.getFromY() + ",");
                writer.append(p.getToX() + "," + p.getToY() + ",");
                writer.append(d.getId() + ",");
                writer.append(d.getFirstName() + " " + d.getLastName() + ",");
                writer.append(d.getX() + "," + d.getY() + ",");
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
