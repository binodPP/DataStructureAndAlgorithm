package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public class CheeseBasePizzaTopping extends BasePizzaToppingDecorator {
    public CheeseBasePizzaTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost(){
        return basePizza.cost() + addExtraCheeseCost();
    }

    public int addExtraCheeseCost(){
        return 30;
    }
}
