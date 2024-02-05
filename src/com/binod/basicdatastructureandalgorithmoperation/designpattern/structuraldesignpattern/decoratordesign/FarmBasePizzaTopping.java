package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public class FarmBasePizzaTopping extends BasePizzaToppingDecorator {

    public FarmBasePizzaTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return basePizza.cost()+50;
    }
}
