package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree_110 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTree_110().isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      if(Math.abs(left-right) > 1){
          return false;
      }
      return true;
    }

    public int getHeight(TreeNode node) {
      if(node == null){
          return 0;
      }
      int left = getHeight(node.left);
      int right = getHeight(node.right);
      return Math.max(left, right) + 1;
    }
}
