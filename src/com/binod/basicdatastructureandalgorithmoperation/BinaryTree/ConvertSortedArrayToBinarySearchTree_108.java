package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree_108 {

    public static TreeNode sortedArrayToBST(int A[])
    {
        TreeNode root = sortedArrayToBST_helper(A, 0, A.length-1);
        return root;
    }

    public static TreeNode sortedArrayToBST_helper(int A[], int start, int end)
    {
        // continue while this branch has values to process
        if(start > end){
            return null;
        }

        // Get the middle element and make it root
        int midIndex = (start + (end-start)/2);

        TreeNode root = new TreeNode(A[midIndex]);

        // Recursively construct the left subtree
        // and make it left child of root
        root.left = sortedArrayToBST_helper(A, start, midIndex-1);


        // Recursively construct the right subtree
        // and make it right child of root
        root.right = sortedArrayToBST_helper(A, midIndex+1, end);

        return root;

    }

    // Function to print the preorder traversal on a given binary tree
    public static void preorder(TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] a = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(a);
        preorder(treeNode);
    }
}
