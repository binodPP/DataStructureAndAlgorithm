package com.leetcodeproblem;

//https://leetcode.com/problems/asteroid-collision/
import java.util.Stack;

public class AsteroidCollision_735 {
    public static void main(String[] args) {
     int[] asteroids = {9,10,-11};
     int[] arr=asteroidCollision(asteroids);
     for(int i=0; i<arr.length; i++){
         System.out.println(arr[i]);
     }
    }

    //TC:O(N), SC: O(N)
    public static int[] asteroidCollision(int[] asteroids) {
       if(asteroids.length <=1){
           return asteroids;
       }

        Stack<Integer> stack= new Stack();

       for(int i : asteroids){
           if(i>0){
               stack.push(i);
           }else {
               while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)){
                 stack.pop();
               }
               if(stack.isEmpty() || stack.peek() < 0){
                   stack.push(i);
               }else if(Math.abs(stack.peek()) == Math.abs(i)){
                   stack.pop();
               }
           }
       }
       return stack.stream().mapToInt(i->i).toArray();
    }
}
