package entities;

import vehicles.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLevel {
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingLevel(int floorNumber){
        this.floorNumber = floorNumber;
        spots = new ConcurrentHashMap<>();
    }

    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }
    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot : spots.values()){
            if(spot.canFitVehicle(vehicle) && spot.isAvailable()){
                return Optional.of(spot);
            }
        }
        return  Optional.empty();
    }

    public void displayAvailability(){
        System.out.println("Floor Number: "+floorNumber+" details:");
        for(var entry : spots.entrySet()){
            ParkingSpot spot = entry.getValue();
            if(spot.isAvailable())
                System.out.println("Spot Id: "+ spot.getSpotId() + ", Vehicle Capacity: "+ spot.getSpotSize().name() +" Status : Available");
            else
                System.out.println("Spot Id: "+ spot.getSpotId() + ", Vehicle Capacity: "+ spot.getSpotSize().name() +" Status : Occupied");
        }
    }
}
