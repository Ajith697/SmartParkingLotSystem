# Smart Parking Lot System

This project provides a low-level design for a smart parking lot system. The system manages vehicle entry and exit, parking space allocation, and fee calculation.

## Project Structure

The project is organized into the following packages:

-   `org.example.models`: Contains the data models for the system, including `Vehicle`, `ParkingSpot`, `ParkingTicket`, and `ParkingLot`.
-   `org.example.services`: Contains the service interfaces for the system, including `ParkingLotService`, `FeeCalculationService`, and `SpotAllocationService`.
-   `org.example.services.impl`: Contains the implementations of the service interfaces.
-   `org.example.enums`: Contains enumerations for `VehicleType` and `SpotType`.

## Data Model

The database schema consists of the following tables:

-   `vehicles`: Stores information about vehicles, including their license plate number and type.
-   `parking_spots`: Stores information about parking spots, including their number, floor, and type.
-   `parking_tickets`: Stores information about parking transactions, including the vehicle, parking spot, entry time, and exit time.

## Algorithm for Spot Allocation

The system uses a simple algorithm for spot allocation. When a vehicle enters the parking lot, the system searches for an available spot of the appropriate type. If a spot is found, it is assigned to the vehicle. Otherwise, the vehicle is turned away.

## Fee Calculation Logic

The system calculates parking fees based on the duration of the stay and the vehicle type. The fee structure is as follows:

-   Motorcycle: ₹50 per hour
-   Car: ₹100 per hour
-   Bus: ₹200 per hour

## Concurrency Handling

The system uses synchronized methods to ensure that only one thread can access the parking lot at a time. This prevents race conditions and ensures data consistency.