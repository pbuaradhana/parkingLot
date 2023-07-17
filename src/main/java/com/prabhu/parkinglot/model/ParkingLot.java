package com.prabhu.parkinglot.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

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
    directory.put(spot, car);
  }

  public void removeCar(int spot) {
    System.out.println("\nRemoving car from spot : " + spot);
    directory.remove(spot);
  }

  public void printDirectory() {
    for (Map.Entry<Integer, Car> entry : directory.entrySet()) {
      System.out.println(
          "Spot: " + entry.getKey() + ", Car: " + entry.getValue().getCharacteristics());
    }
  }
}
