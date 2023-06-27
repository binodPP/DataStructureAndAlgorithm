package com.binod.basicdatastructureandalgorithmoperation.designpattern.behavioraldesignpattern.strategydesignpattern.withstrategypattern.drivestrategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal drive features");
    }
}
