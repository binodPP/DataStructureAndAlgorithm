package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    //Method 1.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart=0;
        int preEnd=preorder.length-1;
        int inStart= 0;
        int inEnd=inorder.length-1;
        TreeNode treeNode = constructBinaryTree(preStart,preEnd,preorder,inStart,inEnd,inorder);
        return treeNode;
    }

    public TreeNode constructBinaryTree(int preStart, int preEnd , int[] preOrder, int inStart, int inEnd , int[] inOrder){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root= new TreeNode(preOrder[preStart]);
          int j=0;
          for(int i=0; i<inOrder.length;i++){
              if(preOrder[preStart] == inOrder[i]){
                 j=i;
                 break;
              }
          }
        root.left = constructBinaryTree(preStart+1, preEnd, preOrder,inStart,j-1,inOrder);
        root.right = constructBinaryTree(preStart+(j-inStart)+1, preEnd, preOrder,j+1,inEnd,inOrder);
        return root;
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