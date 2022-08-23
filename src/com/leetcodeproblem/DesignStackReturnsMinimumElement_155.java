package com.leetcodeproblem;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class DesignStackReturnsMinimumElement_155 {
    private Stack<Integer> stack= new Stack();
    private int min;
        public static void main (String[] args)
        {
            DesignStackReturnsMinimumElement_155 s = new DesignStackReturnsMinimumElement_155();

            s.push(6);
            System.out.println(s.getMin());

            s.push(7);
            System.out.println(s.getMin());

            s.push(5);
            System.out.println(s.getMin());

            s.push(3);
            System.out.println(s.getMin());

            s.pop();
            System.out.println(s.getMin());

            s.pop();
            System.out.println(s.getMin());

            s.pop();
            System.out.println(s.getMin());

            s.pop();
            System.out.println(s.getMin());

            System.out.println(s.stack.isEmpty());
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            min=x;
        }else if(x >= min){
            stack.push(x);
        }else if(x < min){
            int dummyValue= 2*x - min;
            stack.push(dummyValue);
            min = x;
        }
    }

    public void pop(){

        if(stack.isEmpty()){
            System.out.println("stack overflow error");
            System.exit(-1);
        }

        int top = stack.peek();
        if(top < min){
            int previousMinValue= 2*min - top;
            min = previousMinValue;
        }

        stack.pop();
    }

    public int top() {
        if(stack.size()==0) return -1;
        else
        {
            if(stack.peek()>=min)
            {
                return stack.peek();
            }

            else
            {
                return min;
            }
        }
    }

    public int getMin(){
        return min;
    }
}
