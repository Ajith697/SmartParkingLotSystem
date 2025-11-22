package org.example;

import org.example.enums.VehicleType;
import org.example.models.*;
import org.example.strategy.BusFeeStrategy;
import org.example.strategy.CarFeeStrategy;
import org.example.strategy.FeeStrategy;
import org.example.strategy.MotorcycleFeeStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            parkingSpots.add(new ParkingSpot(i, 1, VehicleType.MOTORCYCLE));
        }
        for (int i = 11; i <= 30; i++) {
            parkingSpots.add(new ParkingSpot(i, 1, VehicleType.CAR));
        }
        for (int i = 31; i <= 35; i++) {
            parkingSpots.add(new ParkingSpot(i, 1, VehicleType.BUS));
        }

        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        // Simulate vehicle entry
        Vehicle car = new Vehicle("CAR-001", VehicleType.CAR);
        ParkingSpot carSpot = parkingLot.findAvailableSpot(car.getVehicleType());
        if (carSpot != null) {
            parkingLot.parkVehicle(car, carSpot);
            ParkingTicket carTicket = new ParkingTicket("TICKET-001", car, carSpot, LocalDateTime.now());
            System.out.println("Car parked at spot: " + carSpot.getSpotNumber());

            // Simulate vehicle exit
            carTicket.setExitTime(LocalDateTime.now().plusHours(2).plusMinutes(30));
            FeeStrategy carFeeStrategy = new CarFeeStrategy();
            double carFee = carFeeStrategy.calculateFee(carTicket);
            System.out.println("Car unparked. Fee: ₹" + carFee);
            parkingLot.unparkVehicle(carSpot);
        } else {
            System.out.println("No available spot for the car.");
        }

        Vehicle motorcycle = new Vehicle("MC-001", VehicleType.MOTORCYCLE);
        ParkingSpot mcSpot = parkingLot.findAvailableSpot(motorcycle.getVehicleType());
        if (mcSpot != null) {
            parkingLot.parkVehicle(motorcycle, mcSpot);
            ParkingTicket mcTicket = new ParkingTicket("TICKET-002", motorcycle, mcSpot, LocalDateTime.now());
            System.out.println("Motorcycle parked at spot: " + mcSpot.getSpotNumber());

            // Simulate vehicle exit
            mcTicket.setExitTime(LocalDateTime.now().plusHours(1).plusMinutes(15));
            FeeStrategy mcFeeStrategy = new MotorcycleFeeStrategy();
            double mcFee = mcFeeStrategy.calculateFee(mcTicket);
            System.out.println("Motorcycle unparked. Fee: ₹" + mcFee);
            parkingLot.unparkVehicle(mcSpot);
        } else {
            System.out.println("No available spot for the motorcycle.");
        }

        Vehicle bus = new Vehicle("BUS-001", VehicleType.BUS);
        ParkingSpot busSpot = parkingLot.findAvailableSpot(bus.getVehicleType());
        if (busSpot != null) {
            parkingLot.parkVehicle(bus, busSpot);
            ParkingTicket busTicket = new ParkingTicket("TICKET-003", bus, busSpot, LocalDateTime.now());
            System.out.println("Bus parked at spot: " + busSpot.getSpotNumber());

            // Simulate vehicle exit
            busTicket.setExitTime(LocalDateTime.now().plusHours(3));
            FeeStrategy busFeeStrategy = new BusFeeStrategy();
            double busFee = busFeeStrategy.calculateFee(busTicket);
            System.out.println("Bus unparked. Fee: ₹" + busFee);
            parkingLot.unparkVehicle(busSpot);
        } else {
            System.out.println("No available spot for the bus.");
        }
    }
}