package com.prabhu.parkinglot.model;

// Concrete class representing a Motorcycle
public class Motorcycle extends Vehicle {
  public Motorcycle(String licensePlate) {
    super(licensePlate);
  }

  @Override
  public VehicleType getType() {
    return VehicleType.MOTORCYCLE;
  }
}

