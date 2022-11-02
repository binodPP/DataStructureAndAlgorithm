package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree_110 {
    private boolean isBalancedFlag=true;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTree_110().isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root) {
      isBalancedDFSHelper(root);
      return isBalancedFlag;
    }

    public int isBalancedDFSHelper(TreeNode root) {
      if(root == null){
          return 0;
      }

      int left = isBalancedDFSHelper(root.left);
      int right = isBalancedDFSHelper(root.right);
      if(Math.abs(left-right)>1){
          isBalancedFlag = false;
      }

      return 1+Math.max(left, right);
    }
}
