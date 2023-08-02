package com.prabhu.parkinglot.model;

import lombok.Data;

// Class to represent a parking spot
@Data
class ParkingSpot {
  private int spotNumber;
  private VehicleType type;
  private boolean isOccupied;

  public ParkingSpot(int spotNumber, VehicleType type) {
    this.spotNumber = spotNumber;
    this.type = type;
    this.isOccupied = false;
  }

  public VehicleType getType() {
    return type;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void parkVehicle() {
    isOccupied = true;
  }

  public void removeVehicle() {
    isOccupied = false;
  }
}
