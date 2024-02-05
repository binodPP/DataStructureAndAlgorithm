package com.leetcodeproblem;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums1 = {0,1,0,3,12};
        moveZeroes(nums);
        moveZeroes1(nums1);
    }

    //Pattern-1
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

    //Pattern-2
    public static void moveZeroes1(int[] nums) {
        int zeroCounter=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                if(zeroCounter != i){
                    int temp = nums[i];
                    nums[i] = nums[zeroCounter];
                    nums[zeroCounter] = temp;
                    zeroCounter++;
                }
            }
        }

        for (int k=0; k<nums.length ; k++){
            System.out.println(nums[k]);
        }
    }
}
