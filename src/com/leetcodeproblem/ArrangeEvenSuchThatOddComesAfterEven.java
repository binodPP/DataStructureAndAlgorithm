package com.leetcodeproblem;

//https://www.tutorialcup.com/interview/array/arrange-even-then-odd.htm
//https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
public class ArrangeEvenSuchThatOddComesAfterEven {
    public static void main(String[] args) {
     int[] nums={12, 34, 45, 9, 8, 90, 3};

     arrangeOddEvenNumberInArray(nums);
     for(int i=0; i< nums.length; i++){
         System.out.println(nums[i]);
     }
    }

    public static void arrangeOddEvenNumberInArray(int[] nums){
        int left=0, end=nums.length-1;

        while(left < end){

            if(nums[left] % 2 !=0){
                while (nums[end] % 2 ==1 && end > left){
                    end--;
                }
                int temp= nums[end];
                nums[end] = nums[left];
                nums[left] =temp;
                left++;
                end--;
            }else {
                left++;
            }
        }
    }
}
