package entities;

import enums.VehicleSize;
import vehicles.Vehicle;

public class ParkingSpot {
    private String spotId;
    private Boolean isOccupied;
    private VehicleSize spotSize;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleSize spotSize){
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return spotSize.getValue()>=vehicle.getVehicleSize().getValue();
    }

    public VehicleSize getSpotSize(){
        return this.spotSize;
    }

    public String getSpotId(){
        return this.spotId;
    }

    public boolean isAvailable(){
        return  !isOccupied;
    }

    public void parkVehicle(Vehicle vehicle){
        this.isOccupied = true;
        this.parkedVehicle = vehicle;
    }

    public void unparkVehicle(){
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

}
