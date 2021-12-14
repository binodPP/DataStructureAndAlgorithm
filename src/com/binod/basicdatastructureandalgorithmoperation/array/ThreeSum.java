package com.binod.basicdatastructureandalgorithmoperation.array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/3sum/
        int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {};
        List<List<Integer>> listList=addThreeNumber1(nums);
        for (List list :listList) {
            System.out.println(list);
        }

    }

    //Pattern -1
    public static List<List<Integer>> addThreeNumber(int[] nums){
        List<List<Integer>> listList = null;
        Set<List<Integer>> listSet= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //System.out.println("["+nums[i]+","+nums[j]+","+nums[k]+"]");
                        listSet.add(list);
                        listList=new ArrayList<>(listSet);
                    }
                }
                while(j+1<nums.length && nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
        return listList;
    }

    //pattern-2
    public static List<List<Integer>> addThreeNumber1(int[] nums){
        List<List<Integer>> listList = new ArrayList<>();;
        //Set<List<Integer>> listSet= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                    if(binarySearch(j+1,nums.length-1,nums,-(nums[i]+nums[j]))){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(-(nums[i]+nums[j]));
                        //System.out.println("["+nums[i]+","+nums[j]+","+nums[k]+"]");
                        //listSet.add(list);
                        listList.add(list);
                    }
                while(j+1<nums.length && nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
        return listList;
    }

    private static boolean binarySearch(int low, int high, int[] nums, int x) {
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==x){
                return true;
            }else if(nums[mid]>x){
                high=mid-1;
            }else if(nums[mid] < x){
                low=mid+1;
            }
        }
        return false;
    }

}
