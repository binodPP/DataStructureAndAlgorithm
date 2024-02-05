package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 treeConstructor =
                new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = treeConstructor.buildTree(preorder,inorder);

        System.out.println("Inorder traversal of the constructed tree:");
        treeConstructor.inorderTraversal(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in inorder array
        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInorder = i;
                break;
            }
        }

        // Recursively build left and right subtrees
        int leftSubtreeSize = rootIndexInorder - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndexInorder + 1, inEnd);

        return root;
    }

    // Helper method to perform inorder traversal and print the elements
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    //Method 2.

    /*int total;
    Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        total=0;
        TreeNode node = constructBinaryTree(inorder, preorder, 0, inorder.length-1);
        return node;
    }

    TreeNode constructBinaryTree(int[] inorder, int[] preorder, int start, int end) {
        if(start>end)
            return null;

        int value=preorder[total++];
        int location=map.get(value);
        TreeNode current=new TreeNode(value);
        current.left=constructBinaryTree(inorder, preorder, start, location-1);
        current.right=constructBinaryTree(inorder, preorder, location+1, end);

        return current;*/

}