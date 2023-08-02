package com.prabhu.parkinglot.model;

import com.prabhu.parkinglot.model.Engine;
import lombok.Data;

@Data
public class Car extends Vehicle {
  private String name;
  private int numberOfSeats;
  private double currentSpeed;
  private String productionNumber;
  private Engine engine;

  public Car(String name, int numberOfSeats, String productionNumber, Engine engine) {
    super(productionNumber);
    this.name = name;
    this.numberOfSeats = numberOfSeats;
    this.productionNumber = productionNumber;
    this.engine = engine;
  }

  public void accelerate(double acceleration) {
    double modifiedAcceleration = acceleration * engine.getHorsepower();
    currentSpeed += modifiedAcceleration;
  }

  public String getCharacteristics() {
    return "Name: " + name + ", Production Number: " + productionNumber + ", Horsepower: " + engine.getHorsepower();
  }

  public Car(String licensePlate) {
    super(licensePlate);
  }
  @Override
  public VehicleType getType() {
    return VehicleType.CAR;
  }
}
