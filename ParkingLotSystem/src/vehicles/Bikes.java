package vehicles;

import enums.VehicleSize;

public class Bikes extends Vehicle {
    public Bikes(String licenseNumber){
        super(licenseNumber, VehicleSize.SMALL);
    }
}
