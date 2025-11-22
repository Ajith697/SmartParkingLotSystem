package org.example.strategy;

import org.example.models.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}