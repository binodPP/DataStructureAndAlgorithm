package com.binod.basicdatastructureandalgorithmoperation.dynamicprogramming;

public class GetFibonacciNumber {

    public static void main(String[] args) {
    GetFibonacciNumber a = new GetFibonacciNumber();
    int n = 7;
    System.out.println(a.getFibonacciNumber(n));

    int[] arr = new int[n + 1];
    System.out.println(a.getFibonacciNumberTopDown(arr, n));

    System.out.println(a.getFibonacciNumberBottomUp(n));

    System.out.println(a.getFibonacciNumberBottomUpBetter(n));
    }

    public int getFibonacciNumber(int n){

        if (n < 2){
            return n;
        }
        return getFibonacciNumber(n-1)+ getFibonacciNumber(n-2);
    }

    public int getFibonacciNumberTopDown(int arr[], int n){
        if (n < 2){
            return arr[n];
        }

        if(arr[n] == 0){
            arr[n] = getFibonacciNumberTopDown(arr,n-1) + getFibonacciNumberTopDown(arr,n-2);
        }
        return arr[n];
    }

    public int getFibonacciNumberBottomUp(int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public int getFibonacciNumberBottomUpBetter(int n){
        int a=0;
        int b=1;
        int c;
        for(int i = 2 ; i <= n ; i++){
            c = a+b;
            a=b;
            b=c;
        }
        return b;
    }
}
