package com.binod.basicdatastructureandalgorithmoperation.collectionsFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

        public static void main(String[] args)
        {
            List list = new ArrayList();

            for (int counter = 1; counter < 1000; counter++)
            {
                list.add(counter);
            }
        }
}
