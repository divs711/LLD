package vehicles;

import enums.VehicleSize;

public class Trucks extends Vehicle {
    //super is used because the Vehicle constructor must run to initialize the fields inside Vehicle.
    public Trucks(String licenseNumber){
        super(licenseNumber, VehicleSize.LARGE); //That means: “call the parent (Vehicle) constructor and let it initialize licenseNumber and vehicleSize.”

//        Without super(...), the subclass can’t properly construct the Vehicle part of the object.
    }
}
