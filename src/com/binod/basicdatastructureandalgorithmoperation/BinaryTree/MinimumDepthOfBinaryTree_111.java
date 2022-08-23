package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
public class MinimumDepthOfBinaryTree_111 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(97);

        System.out.println(new MinimumDepthOfBinaryTree_111().minDepth(treeNode));
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0){
            return 1+left+right;
        }else{
            return 1+ Math.min(left,right);
        }
    }
}
