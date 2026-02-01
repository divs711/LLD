import entities.ParkingLevel;
import entities.ParkingSpot;
import entities.ParkingTicket;
import strategy.BestFitStrategy;
import strategy.FeeStrategy;
import strategy.FlatFeeStrategy;
import strategy.ParkingStrategy;
import vehicles.Vehicle;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotSystem {
    private static ParkingLotSystem INSTANCE;
    private final List<ParkingLevel> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    private ParkingLotSystem() {
        this.activeTickets = new ConcurrentHashMap<>(); //for making it thread safe
        this.parkingStrategy = new BestFitStrategy();
        this.feeStrategy = new FlatFeeStrategy();
    }

    public static synchronized ParkingLotSystem getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ParkingLotSystem();
        }
        return INSTANCE;
    }

    public void addFloor(ParkingLevel floor){
        floors.add(floor);
    }

    public synchronized Optional<ParkingTicket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);

        if(availableSpot.isPresent()){
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            String ticketId = String.valueOf(activeTickets.size()+1);
            ParkingTicket parkingTicket = new ParkingTicket(spot, ticketId, Instant.now().getEpochSecond(), vehicle);
            activeTickets.put(vehicle.getLicenseNumber(), parkingTicket);
            return Optional.of(parkingTicket);
        }
        System.out.print("No vacant parking spot found....");
        return Optional.empty();
    }
    public Optional<Double> unparkVehicle(String licenseNumber){
        ParkingTicket ticket = activeTickets.get(licenseNumber);
        ParkingSpot spot = ticket.getSpot();
        spot.unparkVehicle();
        ticket.setExitTimeStamp(Instant.now().getEpochSecond());
        Double parkingFee = feeStrategy.calculateParkingFee(ticket);
        return Optional.of(parkingFee);
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }
}