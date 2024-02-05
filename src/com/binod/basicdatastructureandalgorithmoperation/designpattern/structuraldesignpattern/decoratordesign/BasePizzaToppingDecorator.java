package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public abstract class BasePizzaToppingDecorator implements BasePizza{
    protected BasePizza basePizza;

    public BasePizzaToppingDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost();
    }
}
