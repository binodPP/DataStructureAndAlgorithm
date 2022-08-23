package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree_543 {

    int ans=0;
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);

        System.out.println(new DiameterOfBinaryTree_543().diameterOfBinaryTree(treeNode));


    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightRight = helper(root.right);

        ans= Math.max(ans, leftHeight + rightRight);

        return 1+Math.max(leftHeight,rightRight);
    }
}
