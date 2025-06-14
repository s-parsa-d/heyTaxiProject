# HeyTaxi Project 

A simple Java-based project that analyzes taxi travel data.

## Project Structure

```markdown
ROOT
├── HeyTaxiTest.java
├── .gitignore
├── README.md
├── travels.csv         (created when you run the code)
├── classes
│   ├── Driver.java
│   ├── Owner.java
│   ├── Passenger.java
│   ├── Travel.java
│   └── TravelCSVWriter.java
└── bin                        (created when you compile the code)
    ├── HeyTaxiTest.class
    └── classes
        ├── Driver.class
        ├── Owner.class
        ├── Passenger.class
        ├── Travel.class
        └── TravelCSVWriter.class
```
## CSV file
- `travels_report.csv` 
- - (PassengerID, PassengerName, fromX, fromY, ToX, ToY, DriverID, DriverName, DriverX, DriverY, TravelStatus, StartTime, EndTime)

## How to Run

Make sure you have Java installed. You can run the project using the following steps:

1. Compile the Java file:
   ```bash
   javac -d bin HeyTaxiTest.java classes/*.java

2. Run the code:
    ```bash
    javc -cp bin HeyTaxiTest

## collaborators

This project was built and maintained by the following contributors:

| Name            | Role                   | GitHub/Contact                              |
|-----------------|------------------------|---------------------------------------------|
| Sajede Farzaneh  |  Developer      | [@sajede4030](https://github.com/sajede4030)    |
| Seyed Parsa Darroudi|  Developer         | [@s-parsa-d](https://github.com/s-parsa-d) |

