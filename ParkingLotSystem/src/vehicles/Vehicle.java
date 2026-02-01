package vehicles;

import enums.VehicleSize;

public abstract class Vehicle {
    private final VehicleSize vehicleSize;
    private final String licenseNumber;
//    Final fields must be set in the constructor, and only the Vehicle constructor can set them.
    public Vehicle(String licenseNumber, VehicleSize size){
        this.licenseNumber = licenseNumber;
        this.vehicleSize = size;
    }

    public VehicleSize getVehicleSize(){return vehicleSize;}

    public String getLicenseNumber(){ return  licenseNumber; }
}
