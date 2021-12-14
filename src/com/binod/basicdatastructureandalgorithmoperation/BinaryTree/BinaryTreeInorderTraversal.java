package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    //Method 1: using recursive approach
    /*List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
      return constructInOrderFromBinaryTree(root);
    }

    private List<Integer> constructInOrderFromBinaryTree(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        if(treeNode.left != null) {
            constructInOrderFromBinaryTree(treeNode.left);
        }
        list.add(treeNode.val);
        if(treeNode.right != null) {

            constructInOrderFromBinaryTree(treeNode.right);
        }
        return list;
    }*/

    //Method 2: iterative approach

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while( treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode=stack.pop();
            list.add(treeNode.val);
            treeNode=(treeNode.right);
        }
        return list;
    }
}