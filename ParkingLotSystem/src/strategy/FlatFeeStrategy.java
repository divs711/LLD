package strategy;

import entities.ParkingTicket;

public class FlatFeeStrategy implements FeeStrategy{
    private Double RATE_PER_HOUR = 10.0; // rupees
    public Double calculateParkingFee(ParkingTicket parkingTicket){
        Long timeDifference = parkingTicket.getTimeDifference();
        return timeDifference*RATE_PER_HOUR;
    }
}
