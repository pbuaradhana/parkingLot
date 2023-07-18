package com.prabhu.parkinglot;

import com.prabhu.parkinglot.service.ParkingLotServiceImpl;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {
  @Autowired
  ParkingLotServiceImpl parkingLot;

  public static void main(String[] args) {
    SpringApplication.run(ParkingLotApplication.class, args);
  }

  @PostConstruct
  public void process() {
    parkingLot.process();
    parkingLot.park();
  }
}
