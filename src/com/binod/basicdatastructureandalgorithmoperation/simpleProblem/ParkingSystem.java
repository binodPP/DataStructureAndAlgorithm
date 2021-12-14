package com.binod.basicdatastructureandalgorithmoperation.simpleProblem;

public class ParkingSystem {

    int bigSlot=0;
    int mediumSlot=0;
    int smallSlot=0;
    public ParkingSystem(int big, int medium, int small) {
        this.bigSlot=big;
        this.mediumSlot=medium;
        this.smallSlot=small;

    }

    public boolean addCar(int carType) {

        switch(carType){
            case 1:
                if(bigSlot == 0){
                    return false;
                }
                bigSlot --;
                break;

            case 2:
                if(mediumSlot == 0){
                    return false;
                }
                mediumSlot --;
                break;

            case 3:
                if(smallSlot == 0){
                    return false;
                }
                smallSlot --;
                break;
        }
        return true;

    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
        System.out.println(parkingSystem.addCar(1));
    }
}
