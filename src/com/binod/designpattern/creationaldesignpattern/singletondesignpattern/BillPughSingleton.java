package com.binod.designpattern.creationaldesignpattern.singletondesignpattern;

import java.io.Serializable;

public class BillPughSingleton implements Serializable, Cloneable {

    private static final long serialVersionUID = 2088778914384963252L;

    private BillPughSingleton(){
        //to overcome the multiple instance creation issue using reflection we can use below code
        if(BillPughSingletonHelper.INSTANCE!=null)
        {
            throw new RuntimeException("You can not create object of singleton class twice");
        }
    }

    private static class BillPughSingletonHelper{
        private static final BillPughSingleton INSTANCE= new BillPughSingleton();
    }

    public static BillPughSingleton getInstanceBillPughSingleton(){
        return BillPughSingletonHelper.INSTANCE;
    }

    // to restrict not to create multiple instance using serialization , need to use below method
    protected Object readResolve() {
        return getInstanceBillPughSingleton();
    }

    // to restrict not to create multiple instance using clone, need to use below code
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("You can not clone object of Singleton class ");
    }
}
