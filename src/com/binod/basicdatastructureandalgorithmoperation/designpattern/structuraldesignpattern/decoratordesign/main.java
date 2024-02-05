package com.binod.basicdatastructureandalgorithmoperation.designpattern.structuraldesignpattern.decoratordesign;

public class main {
    public static void main(String[] args) {
        BasePizza basePizza = new BasePizzaTopping();
        System.out.println(basePizza.cost());
        BasePizza basePizza1 = new CheeseBasePizzaTopping(basePizza);
        System.out.println(basePizza1.cost());
        BasePizza basePizza2 = new FarmBasePizzaTopping(basePizza);
        System.out.println(basePizza2.cost());
        BasePizza basePizza3 = new VegBasePizzaTopping(basePizza);
        System.out.println(basePizza3.cost());
    }
}
