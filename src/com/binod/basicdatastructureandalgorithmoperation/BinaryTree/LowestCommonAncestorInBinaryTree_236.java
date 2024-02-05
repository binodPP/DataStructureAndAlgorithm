package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorInBinaryTree_236 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);

        int left = 5;
        int right =4;

        System.out.println(new LowestCommonAncestorInBinaryTree_236().getLCA(treeNode,left,right).val);
    }

    //Oprion 3: Which will work for both binary tree and BST
    public TreeNode getLCA(TreeNode root, int left, int right) {
        if (root == null) {
            return null;
        }

        // If the current node is one of the nodes we are looking for, return it
        if (root.val == left || root.val == right) {
            return root;
        }

        // Recursively search left and right subtrees for LCA
        TreeNode leftLCA = getLCA(root.left, left, right);
        TreeNode rightLCA = getLCA(root.right, left, right);

        // If both leftLCA and rightLCA are not null, it means left and right
        // are found in different subtrees, so the current node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If either leftLCA or rightLCA is not null, return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
