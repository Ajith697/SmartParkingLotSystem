package org.example.models;

import org.example.enums.VehicleType;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        Optional<ParkingSpot> spot = parkingSpots.stream()
                .filter(s -> s.isAvailable() && s.getSpotType() == vehicleType)
                .min(Comparator.comparingInt(ParkingSpot::getSpotNumber));
        return spot.orElse(null);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.setAvailable(false);
    }

    public void unparkVehicle(ParkingSpot spot) {
        spot.setAvailable(true);
    }
}