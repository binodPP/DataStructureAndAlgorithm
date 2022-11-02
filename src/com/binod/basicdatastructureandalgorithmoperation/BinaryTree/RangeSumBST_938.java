package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;
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
}
