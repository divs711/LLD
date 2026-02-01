package vehicles;

import enums.VehicleSize;

public class Cars extends Vehicle {
    public Cars(String licenseNumber){
        super(licenseNumber, VehicleSize.MEDIUM);
    }
}
