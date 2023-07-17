package com.prabhu.parkinglot.model;

public class Convertible extends Car {
  private boolean roofUp;

  public Convertible(String name, int numberOfSeats, String productionNumber, Engine engine) {
    super(name, numberOfSeats, productionNumber, engine);
    this.roofUp = true;
  }

  public void moveRoof() {
    roofUp = !roofUp;
    System.out.println("Roof " + (roofUp ? "up" : "down"));
  }
}
