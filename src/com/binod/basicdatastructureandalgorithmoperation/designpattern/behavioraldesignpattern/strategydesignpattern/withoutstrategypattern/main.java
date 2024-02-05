package com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withoutstrategypattern;

import com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy.NormalDriveStrategy;
import com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy.SportsDriveStrategy;

//https://github.com/keertipurswani/Uber-Ola-Low-Level-Design
public class main {
    public static void main(String[] args) {
        VehicleManager vehicleManager = new VehicleManager("Normal");
        vehicleManager.drive();

        VehicleManager vehicleManager1 = new VehicleManager("Sport");
        vehicleManager1.drive();

        VehicleManager vehicleManager2 = new VehicleManager("Goods");
        vehicleManager2.drive();
    }
}
