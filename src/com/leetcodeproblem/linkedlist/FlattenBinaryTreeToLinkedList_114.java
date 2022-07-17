package com.leetcodeproblem.linkedlist;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_114 {
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    static TreeNode prev=null;
    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root . left = new TreeNode(2);
        root . left . left = new TreeNode(3);
        root . left . right = new TreeNode(4);
        root . right = new TreeNode(5);
        root . right . right = new TreeNode(6);
        root . right . right . left = new TreeNode(7);
        flattenPattern1(root);
        flattenPattern2(root);
        flattenPattern3(root);
        while(root.right!=null)
        {
            System.out.print(root.val+"->");
            root=root.right;
        }
        System.out.print(root.val);
    }

    //Pattern1: Using Intuition behind Morris Traversal, TimeComplexity=O(n), space complexity=O(1)
    public static void flattenPattern1(TreeNode root) {
        TreeNode curr=root;
        while(curr != null){

            if (curr.left != null){
                TreeNode pre=curr.left;
                while (pre.right != null){
                    pre= pre.right;
                }

                pre.right=curr.right;
                curr.right=curr.left;
                curr.left= null;
            }

            curr=curr.right;
        }

    }

    //Pattern2: Iterative Approach – Using Stack, TimeComplexity=O(n), space complexity=O(n)
    public static void flattenPattern2(TreeNode root) {

        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current= stack.pop();
            if(current.right != null){
                stack.push(current.right);
            }

            if(current.left != null){
                stack.push(current.left);
            }

            if(!stack.isEmpty()){
                current.right= stack.peek();
            }

            current.left=null;

        }

    }

    //Pattern3: Using Recursion, TimeComplexity=O(n), space complexity=O(n)
    public static void flattenPattern3(TreeNode root) {
        if(root == null){
            return;
        }

        if(root.right != null) {
            flattenPattern3(root.right);
        }

        if(root.left != null) {
            flattenPattern3(root.left);
        }

        root.right=prev;
        root.left=null;
        prev=root;

    }
}
