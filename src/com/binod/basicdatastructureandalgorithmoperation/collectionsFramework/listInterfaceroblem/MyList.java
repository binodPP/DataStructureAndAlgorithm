package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework.listInterfaceroblem;

import java.util.ArrayList;

public interface MyList<E>{

    void convert(E element);

    void replace(int index);

    ArrayList<E> compact();

}
