package com.leetcodeproblem;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int zeroCounter=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[zeroCounter]=nums[i];
                zeroCounter++;
            }
        }

        for (int j=zeroCounter; j<nums.length; j++){
            nums[j]=0;
        }

        for (int k=0; k<nums.length ; k++){
            System.out.println(nums[k]);
        }
    }
}
