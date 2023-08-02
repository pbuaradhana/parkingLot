package com.prabhu.parkinglot.model;

// Class to represent a vehicle
abstract class Vehicle {
  private String licensePlate;

  public Vehicle(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public abstract VehicleType getType();
}
