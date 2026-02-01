package strategy;

import entities.ParkingLevel;
import entities.ParkingSpot;
import vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public class BestFitStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingLevel> floors, Vehicle vehicle){
        Optional<ParkingSpot> bestSpot = Optional.empty();
         for(ParkingLevel floor : floors){
             Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);

             if(spotOnThisFloor.isPresent()){
                 if(bestSpot.isEmpty()){
                     bestSpot = spotOnThisFloor;
                 }else{
                     if(spotOnThisFloor.get().getSpotSize().getValue() < bestSpot.get().getSpotSize().getValue()){
                         bestSpot = spotOnThisFloor;
                     }
                 }
             }
         }
         return bestSpot;
    }
}
