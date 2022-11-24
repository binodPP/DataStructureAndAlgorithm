package com.leetcodeproblem;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        //int[] nums = {0,2,3,4};
        //int[] nums = {0,0,3,4};
       /* for(int i=0; i< productExceptSelfOptimizeOne(nums).length; i++){
            System.out.println(productExceptSelfOptimizeOne(nums)[i]);
        }

        for(int i=0; i< productExceptSelf(nums).length; i++){
            System.out.println(productExceptSelf(nums)[i]);
        }

        for(int i=0; i< productExceptSelfWithDividePattern(nums).length; i++){
            System.out.println(productExceptSelfWithDividePattern(nums)[i]);
        }*/

        int[] result= productExceptSelf(nums);
        //int[] result= productExceptSelfSpaceOptimizeOne(nums);
        for(int i=0; i< result.length; i++){
            System.out.println(result[i]);
        }

    }

    //Method-1
    //TimeComplexity= O(2n)-> O(n), SpaceComplexity= O(1)
    public static int[] productExceptSelfSpaceOptimizeOne(int[] nums) {
        int product=1;
        int zeroCount=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0){
            product = product* nums[i];
            }else {
                zeroCount++;
            }
        }

        for(int i=0; i< nums.length; i++){
            if(zeroCount > 1){
                nums[i]=0;
            }else if(zeroCount == 1){
                if(nums[i] == 0) {
                    nums[i] = product;
                }else {
                    nums[i] =0;
                }
            }else {
                nums[i] = product/ nums[i];
            }
        }

        return nums;
    }

    //TimeComplexity= O(2n)-> O(n), SpaceComplexity= O(n)
    public static int[] productExceptSelfOptimizeOne(int[] nums) {
        int[] productPrefix= new int[nums.length];
        productPrefix[0]=1;
        for(int i=1; i< nums.length; i++){
            productPrefix[i]=productPrefix[i-1] * nums[i-1];
        }

        int suffixProduct=1;

        for(int j=nums.length-1; j>=0; j--){
            productPrefix[j]= productPrefix[j] * suffixProduct;
            suffixProduct= suffixProduct * nums[j];
        }

        return productPrefix;
    }

    //TimeComplexity= O(3n)-> O(n), SpaceComplexity= O(3n)->O(n)
    public static int[] productExceptSelf(int[] nums) {
        int[] productPrefix= new int[nums.length];
        int[] suffixProduct= new int[nums.length];
        int[] ans= new int[nums.length];

        productPrefix[0]=1;

        suffixProduct[nums.length-1]=1;
        for(int i=1; i< nums.length; i++){
            productPrefix[i]=productPrefix[i-1] * nums[i-1];
        }

        for(int j=nums.length-2; j>=0; j--){
            suffixProduct[j]=suffixProduct[j+1] * nums[j+1];
        }

        for(int k=0; k< nums.length; k++){
            ans[k]= productPrefix[k] * suffixProduct[k];
        }

        return ans;
    }

    //TimeComplexity= O(2n)-> O(n), SpaceComplexity= O(n)
    public static int[] productExceptSelfWithDividePattern(int[] nums) {
        int[] ans= new int[nums.length];
        int product=1;

        for(int i=0; i< nums.length; i++){
            product= product * nums[i];
        }

        for(int k=0; k< nums.length; k++){
            ans[k]= product/nums[k];
        }

        return ans;
    }

}
