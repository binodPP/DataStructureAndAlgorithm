package com.binod.basicdatastructureandalgorithmoperation.Stack;

import java.util.Stack;

public class DesignStackReturnsMinimumElement {
    private Stack<Integer> stack= new Stack();
    private int min;
        public static void main (String[] args)
        {
            DesignStackReturnsMinimumElement s = new DesignStackReturnsMinimumElement();

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

    public int getMin(){
        return min;
    }
}
