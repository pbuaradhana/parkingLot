package com.prabhu.parkinglot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Convertible extends Car {
  private static final Logger logger = LoggerFactory.getLogger(Convertible.class);
  private boolean roofUp;

  public Convertible(String name, int numberOfSeats, String productionNumber, Engine engine) {
    super(name, numberOfSeats, productionNumber, engine);
    this.roofUp = true;
  }

  public void moveRoof() {
    roofUp = !roofUp;
    logger.info("Roof {}", (roofUp ? "up" : "down"));
  }
}
