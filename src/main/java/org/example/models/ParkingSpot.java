package org.example.models;

import org.example.enums.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private int floor;
    private VehicleType spotType;
    private boolean isAvailable;

    public ParkingSpot(int spotNumber, int floor, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.floor = floor;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getFloor() {
        return floor;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}