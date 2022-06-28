package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class ConstructBinaryTreeFromInOrderAndPostorderTraversal_106 {
    //Method 1.
    public TreeNode constructFromInPost(int[] inorder, int[] postorder) {
        int inStart=0;
        int inEnd=inorder.length-1;
        int postStart= 0;
        int postEnd=postorder.length-1;
        TreeNode treeNode = constructBinaryTree(inStart,inEnd,inorder,postStart,postEnd,postorder);
        return treeNode;
    }

    public TreeNode constructBinaryTree(int inStart, int inEnd , int[] inOrder, int postStart, int postEnd , int[] postorder){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root= new TreeNode(postorder[postEnd]);

        int j=0;
        int i=0;
        for( i=inStart; i<inEnd;i++){
            if(inOrder[i] == postorder[postEnd]){
                break;
            }

        }
        j=i-inStart;
        root.left = constructBinaryTree(inStart, i-1, inOrder,postStart,postStart+j-1,postorder);
        root.right = constructBinaryTree(i+1, inEnd, inOrder,postStart+j,postEnd-1,postorder);

        return root;
    }
}
