import entities.ParkingLevel;
import entities.ParkingSpot;
import entities.ParkingTicket;
import enums.VehicleSize;
import strategy.FlatFeeStrategy;
import vehicles.Bikes;
import vehicles.Cars;
import vehicles.Trucks;
import vehicles.Vehicle;

import java.util.Optional;

public class ParkingLotDemo {

    public static void main(String[] args) throws InterruptedException {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();


        ParkingLevel level1 = new ParkingLevel(1);
        level1.addSpot(new ParkingSpot("F1-S1", VehicleSize.SMALL));
        level1.addSpot(new ParkingSpot("F1-M1", VehicleSize.MEDIUM));
        level1.addSpot(new ParkingSpot("F1-L1", VehicleSize.LARGE));

        ParkingLevel level2 = new ParkingLevel(2);
        level2.addSpot(new ParkingSpot("F2-M1", VehicleSize.MEDIUM));
        level2.addSpot(new ParkingSpot("F2-M2", VehicleSize.MEDIUM));

        parkingLotSystem.addFloor(level1);
        parkingLotSystem.addFloor(level2);

        parkingLotSystem.setFeeStrategy(new FlatFeeStrategy());

        System.out.println("\n-- Vehicle Entries --");

        level1.displayAvailability();
        level2.displayAvailability();

        Vehicle bike = new Bikes("B-123");
        Vehicle car = new Cars("C-456");
        Vehicle truck = new Trucks("T-789");

        Optional<ParkingTicket> bikeTicket = parkingLotSystem.parkVehicle(bike);
        Optional<ParkingTicket> truckTicket = parkingLotSystem.parkVehicle(truck);
        Optional<ParkingTicket> carTicket = parkingLotSystem.parkVehicle(car);

        System.out.println("\n--- Availability after parking ---");
        level1.displayAvailability();
        level2.displayAvailability();

        Vehicle car2 = new Cars("C-999");
        Optional<ParkingTicket> car2Ticket = parkingLotSystem.parkVehicle(car2);

        Vehicle bike2 = new Bikes("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLotSystem.parkVehicle(bike2);

        System.out.println("\n--- Vehicle Exits ---");

        Thread.sleep(3000); // Added some delay so that the parking time diff is >0

        if (carTicket.isPresent()) {
            Optional<Double> feeOpt = parkingLotSystem.unparkVehicle(car.getLicenseNumber());
            feeOpt.ifPresent(aDouble -> System.out.printf("Car C-456 unparked. Fee: %.2f", aDouble));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        level1.displayAvailability();
        level2.displayAvailability();
    }
}
