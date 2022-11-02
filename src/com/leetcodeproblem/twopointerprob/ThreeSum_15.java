package com.leetcodeproblem.twopointerprob;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum_15 {
    public static void main(String[] args) {
        //https://leetcode.com/problems/3sum/
        int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {};
       // List<List<Integer>> listList=threeSum(nums);
        List<List<Integer>> listList=addThreeNumber2(nums);
       // List<List<Integer>> listList=addThreeNumber3(nums);
        for (List list :listList) {
            System.out.println(list);
        }

    }


    //Pattern -1, Time Complexity= O(N Power 2), space complexity= O(n)
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            int left=i+1,right=n-1;
            while(left<right)
            {
                if(nums[left]+nums[right]==-nums[i])
                {
                    List<Integer> t=new ArrayList<Integer>();
                    t.add(nums[i]);
                    t.add(nums[left]);
                    t.add(nums[right]);

                    ans.add(t);

                    while(left<right &&  nums[left+1]==nums[left]){
                        left++;
                    }
                    while(left< right &&  nums[right-1]==nums[right]){
                        right--;
                    }

                    left++; right--;
                }
                else if(nums[left]+nums[right] < -nums[i])
                {
                    left++;
                }
                else{
                    right--;
                }
            }

            while(i+1<n && nums[i+1]==nums[i]){
                i++;
            }
        }
        return ans;
    }

    //pattern-2, Time Complexity= O(N*N*log(N)), space complexity= O(n)
    public static List<List<Integer>> addThreeNumber2(int[] nums){
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

    //Pattern -3, Time Complexity= O(N Power 3), space complexity= O(n)
    public static List<List<Integer>> addThreeNumber3(int[] nums){
        List<List<Integer>> listList = new ArrayList<>();
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
                        listSet.add(list);
                        listList=listSet.stream().collect(Collectors.toList());
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

}
