package com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern;

import com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy.NormalDriveStrategy;
import com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy.SportsDriveStrategy;

//https://github.com/keertipurswani/Uber-Ola-Low-Level-Design
public class main {
    public static void main(String[] args) {
        /*Vehicle vehicle = new GoodsVehicle(new SportsDriveStrategy());
        vehicle.drive();
        Vehicle vehicle1 = new PassengerVehicle(new NormalDriveStrategy());
        vehicle1.drive();
        Vehicle vehicle2 = new GoodsVehicle(new SportsDriveStrategy());
        vehicle2.drive();
*/

        VehicleManager vehicleManager = new VehicleManager(new SportsDriveStrategy());
        vehicleManager.drive();
        VehicleManager vehicleManager1 = new VehicleManager(new NormalDriveStrategy());
        vehicleManager1.drive();
        VehicleManager vehicleManager2 = new VehicleManager(new SportsDriveStrategy());
        vehicleManager2.drive();
    }
}
