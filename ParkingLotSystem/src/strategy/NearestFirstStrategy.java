package strategy;

import entities.ParkingLevel;
import entities.ParkingSpot;
import vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingLevel> floors, Vehicle vehicle){
        for(ParkingLevel floor : floors){
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
    }
}
