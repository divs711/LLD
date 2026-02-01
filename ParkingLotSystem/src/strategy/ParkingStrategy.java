package strategy;

import entities.ParkingLevel;
import entities.ParkingSpot;;
import vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingLevel> floors, Vehicle vehicle);
}
