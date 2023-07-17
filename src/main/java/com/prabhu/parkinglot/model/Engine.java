package com.prabhu.parkinglot.model;

import lombok.Data;

@Data
public class Engine {

  double horsepower;

  double milesPerGallon;

  public Engine(double horsepower, double milesPerGallon) {
    this.horsepower = horsepower;
    this.milesPerGallon = milesPerGallon;
  }
}
