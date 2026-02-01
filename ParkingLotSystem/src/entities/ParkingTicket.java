package entities;

import vehicles.Vehicle;

public class ParkingTicket {
    private final ParkingSpot spot;
    private final String ticketId;
    private final Long entryTimeStamp;
    private Long exitTimeStamp;
    private final Vehicle vehicle;

    public ParkingTicket(ParkingSpot spot, String ticketId, Long entryTimeStamp, Vehicle vehicle){
        this.entryTimeStamp = entryTimeStamp;
        this.vehicle = vehicle;
        this.ticketId = ticketId;
        this.spot = spot;
    }

    public void setExitTimeStamp(Long exitTimeStamp){
        this.exitTimeStamp = exitTimeStamp;
    }

    public Long getTimeDifference(){
        return this.exitTimeStamp - this.entryTimeStamp;
    }

    public ParkingSpot getSpot(){
        return this.spot;
    }
}
