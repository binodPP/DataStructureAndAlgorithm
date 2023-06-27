package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public abstract class BasePizzaTopping implements BasePizza{
    protected BasePizza basePizza;

    public BasePizzaTopping(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost();
    }
}
