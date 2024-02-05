package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public class VegBasePizzaTopping extends BasePizzaToppingDecorator {
    public VegBasePizzaTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return basePizza.cost()+20;
    }
}
