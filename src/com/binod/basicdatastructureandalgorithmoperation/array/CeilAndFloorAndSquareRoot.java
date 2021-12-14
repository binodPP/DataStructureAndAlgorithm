package com.binod.basicdatastructureandalgorithmoperation.array;

/**
 * Created by 609722983 on 2/23/2020.
 */
public class CeilAndFloorAndSquareRoot {
    public static void main(String[] args) {
        int squareRoot=9;
        int ceilRoot=17;
        int floorRoot=26;
        System.out.println("Square root of number is : " + findTheSquareAndFloorRoot(squareRoot));
        findCeilSquareRoot(ceilRoot);
        System.out.println("Floor Root of number is : " + findTheSquareAndFloorRoot(floorRoot));
    }

    private static int findTheSquareAndFloorRoot(int number){
        int start=1,end=number/2, result=0;// if x>1
        if(number<2){
            return number;
        }
        while (start<=end){
            int mid=(start+end)/2;
            int sqrRoot=mid*mid;
            if(sqrRoot == number){
                return mid;
            }else if(sqrRoot<number){
                //Floor Square Root
                start=mid+1;
                result=mid;
            }else{
                end=mid-1;
            }
        }
     return result;
    }

    private static void findCeilSquareRoot(int number){
        int result=findTheSquareAndFloorRoot(number);
        if(result*result != number){
            result=result+1;
            System.out.println("it is a celing number : " + result);
        }else{
            System.out.println("Number is perfect square, it is not celing number : " + result);
        }
    }
}
