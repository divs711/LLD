package strategy;

import entities.ParkingTicket;

public interface FeeStrategy {
    Double calculateParkingFee(ParkingTicket parkingTicket);
}
