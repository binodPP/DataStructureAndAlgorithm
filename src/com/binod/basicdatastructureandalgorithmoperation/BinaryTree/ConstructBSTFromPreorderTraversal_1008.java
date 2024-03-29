package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

//https://www.techiedelight.com/build-binary-search-tree-from-preorder-sequence/
public class ConstructBSTFromPreorderTraversal_1008 {

    //TC: O(n)
    private static int pIndex = 0;
    public static TreeNode buildTree(int[] preorder,
                                 int min, int max)
    {
        // Base case
        if(pIndex == preorder.length){
            return null;
        }

        // Return if the next element of preorder traversal is not in the valid range
        int val = preorder[pIndex];

        if(val < min || val > max){
            return null;
        }

        // Construct the root node and increment `pIndex`
        TreeNode treeNode = new TreeNode(val);
        pIndex++;

        // Since all elements in the left subtree of a BST must be less
        // than the root node's value, set range as `[min, val-1]` and recur
        treeNode.left = buildTree(preorder,min,val);

        // Since all elements in the right subtree of a BST must be greater
        // than the root node's value, set range as `[val+1…max]` and recur
        treeNode.right = buildTree(preorder,val,max);

        return treeNode;

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
        int[] preorder= {8,5,1,7,10,12};
        TreeNode treeNode = buildTree(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);

        // print the BST
        System.out.print("Preorder traversal of BST is : " );

        // preorder on the BST always returns a sorted sequence
        preorder(treeNode);
    }
}
