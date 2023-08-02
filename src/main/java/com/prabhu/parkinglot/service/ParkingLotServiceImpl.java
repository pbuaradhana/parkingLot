package com.prabhu.parkinglot.service;

import com.prabhu.parkinglot.model.Car;
import com.prabhu.parkinglot.model.Convertible;
import com.prabhu.parkinglot.model.Engine;
import com.prabhu.parkinglot.model.Motorcycle;
import com.prabhu.parkinglot.model.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotServiceImpl {
  private static final Logger logger = LoggerFactory.getLogger(ParkingLotServiceImpl.class);
  Engine priusEngine = new Engine(121, 53);
  Engine boxsterEngine = new Engine(265, 32);
  Car prius = new Car("Prius", 5, "5678", priusEngine);
  Convertible boxster = new Convertible("Porsche Boxster", 2, "1234", boxsterEngine);
  public void process() {

    boxster.moveRoof();
    boxster.moveRoof();

    raiseAcceleration(boxster, prius);
  }

  public void park() {
//    ParkingLot parkingLot = new ParkingLot(3);
//    try {
//      parkingLot.parkCar(1, boxster);
//      parkingLot.parkCar(2, prius);
//      parkingLot.parkCar(3, new Car("Car 1", 4, "1111", new Engine(200, 30)));
//      // The following line will throw an exception since the parking lot is already at full capacity
//      parkingLot.parkCar(4, new Car("Car 2", 3, "2222", new Engine(180, 35)));
//    } catch (IllegalStateException e) {
//      logger.warn(e.getMessage());
//      parkingLot.printDirectory();
//    }
//
//    parkingLot.removeCar(2);
//    parkingLot.parkCar(2, new Car("Car 2", 3, "2222", new Engine(180, 35)));
//
//    parkingLot.printDirectory();
    ParkingLot parkingLot = new ParkingLot(10);

    Car car1 = new Car("ABC123");
    Car car2 = new Car("XYZ789");
    Motorcycle bike1 = new Motorcycle("MOT456");

    parkingLot.parkVehicle(car1);
    parkingLot.parkVehicle(bike1);
    parkingLot.parkVehicle(car2);

    parkingLot.displayParkingStatus();

    parkingLot.removeVehicle(bike1);

    parkingLot.displayParkingStatus();
  }

  public void raiseAcceleration(Car boxster, Car prius) {
    while (boxster.getCurrentSpeed() < 200 && prius.getCurrentSpeed() < 200) {
      boxster.accelerate(0.2);
      prius.accelerate(0.2);
      logger.info("Boxster Speed: {}", boxster.getCurrentSpeed());
      logger.info("Prius Speed: {}", prius.getCurrentSpeed());
    }
  }

}
