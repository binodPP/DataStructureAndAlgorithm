package com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports drive features");
    }
}
