package org.example.strategy;

import org.example.models.ParkingTicket;

import java.time.Duration;

public class MotorcycleFeeStrategy implements FeeStrategy {
    private static final double HOURLY_RATE = 5.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = duration.toHours();
        if (duration.toMinutes() % 60 != 0) {
            hours++;
        }
        return hours * HOURLY_RATE;
    }
}