package com.leetcodeproblem;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        int number = 20;
        System.out.println(getSquareRootNumber(number));
    }

    public static double getSquareRootNumber(int number){
        if(number ==0 || number ==1){
            return number;
        }

        double precision= 0.00001;
        double start = 0;
        double end = number;
        double mid = (start + end) / 2;
        double midPrev=0;
        while (Math.abs(mid-midPrev) > precision){
            if(mid * mid == number){
                return mid;
            }else if(mid * mid < number){
                start = mid;
            }else{
                end = mid;
            }

            midPrev = mid;
            mid =(start+end)/2;
        }

        return mid;
    }
}
