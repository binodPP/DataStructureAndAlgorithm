package com.binod.basicdatastructureandalgorithmoperation.array;


/* Checking Array for duplicate elements Java
        In this Java tutorial, we will see a couple of ways to find if an array contains duplicates or not in Java.
        We will use the unique property of Java collection class Set which doesn’t allow duplicates
        to check java array for duplicate elements.  Here are five ways we can check if an array has duplicates or not:

        1) brute force method which compares each element of Array to all other elements and returns true if it
        founds duplicates. Though this is not an efficient choice it is the one which first comes to mind.

        2) Another quick way of checking if a Java array contains duplicates or not is to convert that array into Set.
        Since Set doesn’t allow duplicates size of  the corresponding Set will be smaller than original Array if
        Array contains duplicates otherwise the size of both Array and Set will be same.

        3) One more way to detect duplication in java array is adding every element of the array into HashSet which
        is a Set implementation. Since the add(Object obj) method of Set returns false if Set already contains
        an element to be added, it can be used to find out if the array contains duplicates in Java or not.
*/

import java.util.*;

public class CheckDuplicatesInJavaArray {

    public static void main(String[] args) {


        String[] withDuplicateData = new String[]{"binod", "singh", "nitesh", "nitesh"};

        String[] withOutDuplicateData = new String[]{"samsung", "apple", "nokia"};

         //Method 1
        //comparing each element to all other elements of array
        //complexity on order of O(n^2) not advised in production

        System.out.println("Checking array with duplicate using brute force: "+bruteForce(withDuplicateData));
        System.out.println("Checking array without any duplicate using brute force: "+bruteForce(withOutDuplicateData));

        //Method 2
        // Using collection api SET

        System.out.println("Checking array with duplicate using set: "+usingSetMethod(withDuplicateData));
        System.out.println("Checking array without any duplicate using set: "+usingSetMethod(withOutDuplicateData));


        //Method 3
        //Since Set doesn't allow duplicates add() return false
        //if we try to add duplicates into Set and this property
        //can be used to check if array contains duplicates in Java

        System.out.println("Checking array with duplicate using set add: "+usingSetAdd(withDuplicateData));
        System.out.println("Checking array without any duplicate using set add: "+usingSetAdd(withOutDuplicateData));
    }

    private static boolean bruteForce(String[] data){

        for(int i=0;i <data.length;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i].equalsIgnoreCase(data[j]) && i!=j){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean usingSetMethod(String[] data) {
        List list = new ArrayList(Arrays.asList(data));
        Set set = new HashSet<String>(list);

        if(list.size() > set.size()){
            return true;
        }
        return false;
    }

    private static boolean usingSetAdd(String[] data){
        Set set = new HashSet<String>();
        for(String str : data){
            if(!set.add(str)){
                return true;
            }
        }
        return false;
    }
}
