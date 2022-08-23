package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/invert-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTreeOrMirrorBinaryTree_226 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);

       TreeNode temp = invertTree(treeNode);
       preOrderTree(temp);
        System.out.println("/n");

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.right = new TreeNode(7);
        treeNode1.right.left = new TreeNode(6);
        treeNode1.right.right = new TreeNode(9);

        TreeNode temp1= invertTreeIterative(treeNode1);
        preOrderTree(temp1);

    }

    //Recursion: TC: O(n), SC: O(n)
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;

    }


    //Recursion: TC: O(n), SC: O(n)
    public static TreeNode invertTreeIterative(TreeNode root) {

        Queue<TreeNode> queue= new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current= queue.poll();
             if(current.left != null){
                 queue.add(current.left);
             }

             if(current.right != null){
                 queue.add(current.right);
             }

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
        }

        return root;
    }

    public static void preOrderTree(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println(root.val);

        if(root.left != null) {
            preOrderTree(root.left);
        }

        if(root.right != null){
            preOrderTree(root.right);
        }
    }
}
