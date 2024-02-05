package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class ConstructBinaryTreeFromInOrderAndPostorderTraversal_106 {
    //Method 1.
    public TreeNode constructFromInPost(int[] inorder, int[] postorder) {
        int inStart=0;
        int inEnd=inorder.length-1;
        int postEnd=postorder.length-1;
        TreeNode treeNode = constructBinaryTree(inorder,postorder,postEnd,inStart,inEnd);
        return treeNode;
    }

    private TreeNode constructBinaryTree(int[] inorder, int[] postorder, int postIndex, int inStart, int inEnd) {
        if (postIndex < 0 || inStart > inEnd) {
            return null;  // Base case: no more elements to process
        }

        // The last element in postorder is the root
        TreeNode root = new TreeNode(postorder[postIndex]);

        // Find the index of the root in inorder
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        // Recursively construct right and left subtrees
        root.right = constructBinaryTree(inorder, postorder, postIndex - 1, inIndex + 1, inEnd);
        root.left = constructBinaryTree(inorder, postorder, postIndex - (inEnd - inIndex) - 1, inStart, inIndex - 1);

        return root;
    }
}
