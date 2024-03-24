package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.Stack;

//https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumBST_938 {
    private int ans=0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(15);
        treeNode.right.right = new TreeNode(18);

        int low = 7, high = 15;

        System.out.println(new RangeSumBST_938().rangeSumBST(treeNode,low,high));
        System.out.println(new RangeSumBST_938().rangeSumBSTDFSIterativeUsingStack(treeNode,low,high));


       /* TreeNode treeNode1 = new TreeNode(10);
        treeNode1.left = new TreeNode(5);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(7);
        treeNode1.right = new TreeNode(15);
        treeNode1.right.right = new TreeNode(18);

        int low1 = 7, high1 = 15;*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int left = 2, right = 5;
        System.out.println(new RangeSumBST_938().rangeSumBinaryTree(root,left,right));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
      return rangeSumBSTDFS(root,low,high);
    }

    public int rangeSumBSTDFS(TreeNode root, int left, int right) {
       if(root != null){
           if(left <= root.val && root.val <= right){
               ans = ans + root.val;
           }

           if(root.val > left){
               rangeSumBSTDFS(root.left,left,right);
           }

           if(root.val < right){
               rangeSumBSTDFS(root.right,left,right);
           }
       }

       return ans;
    }
// Iterative way using stack
    public int rangeSumBSTDFSIterativeUsingStack(TreeNode root, int left, int right) {
        int ans = 0;
        if (root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (left <= node.val && node.val <= right)
                    ans += node.val;

                if (node.val > left)
                    stack.push(node.left);

                if (node.val < right)
                    stack.push(node.right);
            }
        }

        return ans;
    }

    //Option 2 it will work for both binary tree and BST
    public int rangeSumBinaryTree(TreeNode root, int left, int right) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // If the current node's value falls within the range, add it to the sum
        if (left <= root.val && root.val <= right) {
            sum += root.val;
        }

        // Recursively traverse left and right subtrees and accumulate the sum
        sum += rangeSumBinaryTree(root.left, left, right);
        sum += rangeSumBinaryTree(root.right, left, right);

        return sum;
    }
}
