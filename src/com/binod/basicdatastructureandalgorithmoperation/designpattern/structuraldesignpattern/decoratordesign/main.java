package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public class main {
    public static void main(String[] args) {
        BasePizza basePizza = new VegBasePizza();
        BasePizza basePizza1 = new FarmBasePizza();
        System.out.println(basePizza.cost());
        System.out.println(basePizza1.cost());

        BasePizza basePizza2 = new CheeseBasePizzaTopping(new VegBasePizza());
        System.out.println(basePizza2.cost());
    }
}
