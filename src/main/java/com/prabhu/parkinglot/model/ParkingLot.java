package com.prabhu.parkinglot.model;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingLot {

  private static final Logger logger = LoggerFactory.getLogger(ParkingLot.class);

  private ArrayList<ParkingSpot> spots;

  public ParkingLot(int capacity) {
    spots = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      spots.add(new ParkingSpot(i + 1, null));
    }
  }

  public boolean parkVehicle(Vehicle vehicle) {
    for (ParkingSpot spot : spots) {
      if (!spot.isOccupied() && (spot.getType() == null || spot.getType() == vehicle.getType())) {
        spot.parkVehicle();
        spot.setType(vehicle.getType());
        logger.info("{} with license plate {}  parked at spot {} ", vehicle.getType(),
            vehicle.getLicensePlate(), spot.getSpotNumber());
        return true;
      }
    }
    logger.info("No suitable spot available for {} with license plate {}", vehicle.getType(),
        vehicle.getLicensePlate());
    return false;
  }

  public void removeVehicle(Vehicle vehicle) {
    for (ParkingSpot spot : spots) {
      if (spot.isOccupied() && spot.getType() == vehicle.getType()) {
        spot.removeVehicle();
        logger.info("{} with license plate {} removed from spot {}", vehicle.getType(),
            vehicle.getLicensePlate(), spot.getSpotNumber());
        return;
      }
    }
    logger.info("{} with license plate {} not found in any spot", vehicle.getType(),
        vehicle.getLicensePlate());
  }

  public void displayParkingStatus() {
    for (ParkingSpot spot : spots) {
      if (spot.isOccupied()) {
        logger.info("Spot {} is occupied by a {} ", spot.getSpotNumber(), spot.getType());
      } else {
        logger.info("Spot {} is empty", spot.getSpotNumber());
      }
    }
  }
}
