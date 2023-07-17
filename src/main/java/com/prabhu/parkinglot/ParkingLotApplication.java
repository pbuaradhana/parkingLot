package com.prabhu.parkinglot;

import com.prabhu.parkinglot.model.Car;
import com.prabhu.parkinglot.model.Convertible;
import com.prabhu.parkinglot.model.Engine;
import com.prabhu.parkinglot.model.ParkingLot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {

  public static void main(String[] args) {
    SpringApplication.run(ParkingLotApplication.class, args);
    Engine priusEngine = new Engine(121, 53);
    Engine boxsterEngine = new Engine(265, 32);

    Convertible boxster = new Convertible("Porsche Boxster", 2, "1234", boxsterEngine);
    boxster.moveRoof();
    boxster.moveRoof();
    boxster.moveRoof();

    Car prius = new Car("Prius", 5, "5678", priusEngine);

    while (boxster.getCurrentSpeed() < 200 && prius.getCurrentSpeed() < 200) {
      boxster.accelerate(0.2);
      prius.accelerate(0.2);
      System.out.println("Boxster Speed: " + boxster.getCurrentSpeed());
      System.out.println("Prius Speed: " + prius.getCurrentSpeed());
    }

    // Phase 2
    System.out.println("\n");
    ParkingLot parkingLot = new ParkingLot(3);
    try {
      parkingLot.parkCar(1, boxster);
      parkingLot.parkCar(2, prius);
      parkingLot.parkCar(3, new Car("Car 1", 4, "1111", new Engine(200, 30)));
      // The following line will throw an exception since the parking lot is already at full capacity
      parkingLot.parkCar(4, new Car("Car 2", 3, "2222", new Engine(180, 35)));
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
      parkingLot.printDirectory();
    }

    parkingLot.removeCar(2);
    parkingLot.parkCar(4, new Car("Car 2", 3, "2222", new Engine(180, 35)));

    System.out.println();
    parkingLot.printDirectory();
  }

}
