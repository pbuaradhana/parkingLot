package com.prabhu.parkinglot.model;

import com.prabhu.parkinglot.service.ParkingLotServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingLot {

  private static final Logger logger = LoggerFactory.getLogger(ParkingLot.class);

  private Map<Integer, Car> directory;
  private int capacity;

  public ParkingLot(int capacity) {
    this.capacity = capacity;
    this.directory = new HashMap<>();
  }

  public void parkCar(int spot, Car car) {
    if (directory.size() >= capacity) {
      throw new IllegalStateException("Parking lot is full");
    }

    if (directory.containsKey(spot)) {
      throw new IllegalStateException("Spot is already in use !");
    }

    if (spot > capacity) {
      throw new IllegalStateException("Invalid Spot!");
    }

    directory.put(spot, car);
  }

  public void removeCar(int spot) {
    logger.info("Removing car from spot : {}", spot);
    directory.remove(spot);
  }

  public void printDirectory() {
    for (Map.Entry<Integer, Car> entry : directory.entrySet()) {
      logger.info("Spot: {}, Car: {}", entry.getKey(), entry.getValue().getCharacteristics());
    }
  }
}
