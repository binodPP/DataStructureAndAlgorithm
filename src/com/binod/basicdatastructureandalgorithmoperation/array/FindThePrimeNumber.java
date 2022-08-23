package com.binod.basicdatastructureandalgorithmoperation.array;

public class FindThePrimeNumber {
    static int k = 2;
    public static void main(String[] args) {
        int[] array= new int[100];
        int count=0;
        int i;
        boolean isPrime;
        for(i=1; i <= array.length; i ++){

            isPrime=isPrime(i);
            if(isPrime && i!=1) {
                System.out.println(i);
            }


        }
    }

    public static boolean isPrime(int i){

        for(int j=2; j<=i/2; j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }



    public static boolean isPrimeForGivenNumber(int n)
    {

        // Corner cases
        if (n == 0 || n == 1)
        {
            return false;
        }

        // Checking Prime
        if (n == k)
            return true;

        // Base cases
        if (n % k == 0)
        {
            return false;
        }
        k++;
        return isPrime(n);
    }


}
