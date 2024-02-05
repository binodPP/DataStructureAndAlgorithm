package com.leetcodeproblem;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class DesignStackReturnsMinimumElement_155 {

    //Option-1
        private Stack<Integer> stack;
        private int min;

        public DesignStackReturnsMinimumElement_155() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min); // Save the previous minimum before updating
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }

            // If the popped element is the current minimum, update the minimum using the saved previous minimum
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return min;
        }

        public static void main(String[] args) {
            DesignStackReturnsMinimumElement_155 minStack = new DesignStackReturnsMinimumElement_155();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);

            System.out.println(minStack.getMin()); // Output: -3
            minStack.push(4);
            System.out.println(minStack.top());    // Output: 4
            minStack.pop();
            System.out.println(minStack.top());    // Output: -3
            System.out.println(minStack.getMin()); // Output: -3


            minStack.pop();
            System.out.println(minStack.top());    // Output: 0
            System.out.println(minStack.getMin()); // Output: -2
        }



    //Option-2
    /*private Stack<Integer> stack= new Stack();
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

    //We define a variable minEle that stores the current minimum element in the stack.
    // Now the interesting part is, how to handle the case when the minimum element is removed.
    // To handle this, we push “2x – minEle” into the stack instead of x so that the previous minimum
    // element can be retrieved using the current minEle and its value stored in the stack
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
    }*/
}
