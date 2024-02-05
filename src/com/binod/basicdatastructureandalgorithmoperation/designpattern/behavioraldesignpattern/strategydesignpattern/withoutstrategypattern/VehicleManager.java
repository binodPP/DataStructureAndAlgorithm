package com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withoutstrategypattern;

public class VehicleManager {
    private String driveStrategy;
    public VehicleManager(String driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        if(driveStrategy.equalsIgnoreCase("Normal")){
            new PassengerVehicle().drive();
        }else if(driveStrategy.equalsIgnoreCase("Sport")){
            new SportsVehicle().drive();
        }else if(driveStrategy.equalsIgnoreCase("Goods")){
            new GoodsVehicle().drive();
        }
    }
}
