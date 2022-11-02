package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class BinaryTreeMaximumPathSum_124 {
    private int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeMaximumPathSum_124().maxPathSum(treeNode));

    }

    public int maxPathSum(TreeNode root) {
      maxPathSumDFSHelper(root);
     return max;
    }

    public int maxPathSumDFSHelper(TreeNode root) {
       if(root == null){
           return 0;
       }

       int leftMax= Math.max(maxPathSumDFSHelper(root.left),0);
        int rightMax= Math.max(maxPathSumDFSHelper(root.right),0);

        max = Math.max(max, root.val+leftMax+rightMax);

        return root.val + Math.max(leftMax,rightMax);
    }
}
