package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

//https://www.techiedelight.com/build-binary-search-tree-from-preorder-sequence/
public class ConstructBSTFromPreorderTraversal_1008 {

    //TC: O(n)
    public static TreeNode buildTree(int[] preorder, AtomicInteger pIndex,
                                 int min, int max)
    {
        // Base case
        if(pIndex.get() == preorder.length){
            return null;
        }

        // Return if the next element of preorder traversal is not in the valid range
        int val = preorder[pIndex.get()];

        if(val < min || val > max){
            return null;
        }

        // Construct the root node and increment `pIndex`
        TreeNode treeNode = new TreeNode(val);
        pIndex.incrementAndGet();

        // Since all elements in the left subtree of a BST must be less
        // than the root node's value, set range as `[min, val-1]` and recur
        treeNode.left = buildTree(preorder,pIndex,min,val);

        // Since all elements in the right subtree of a BST must be greater
        // than the root node's value, set range as `[val+1…max]` and recur
        treeNode.right = buildTree(preorder,pIndex,val,max);

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
        AtomicInteger pIndex= new AtomicInteger(0);
        int[] preorder= {8,5,1,7,10,12};
        TreeNode treeNode = buildTree(preorder,pIndex,Integer.MIN_VALUE,Integer.MAX_VALUE);

        // print the BST
        System.out.print("Preorder traversal of BST is : " );

        // preorder on the BST always returns a sorted sequence
        preorder(treeNode);
    }
}
