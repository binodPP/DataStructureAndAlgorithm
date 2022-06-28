package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem.overriding;

public class E{
    public int display(final int i){
        int j=i*2;
        System.out.println("Constructor E");
        return j;
    }

    public void main(String[] args) {

            final int arr1[] = {1, 2, 3, 4, 5};
            int arr2[] = {10, 20, 30, 40, 50};
            arr2 = arr1;
            //arr1 = arr2;
            for (int i = 0; i < arr2.length; i++)
                System.out.println(arr2[i]);



        E e= new E();
        A a= new A();
        System.out.println(a.str);
        System.out.println(e.display(5));
        //System.out.println(a.str);
    }
}
