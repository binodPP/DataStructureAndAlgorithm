package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;
//https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int left = 2, right = 5;
        System.out.println(new RangeSumBinaryTree().rangeSumBinaryTree(root,left,right));
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
