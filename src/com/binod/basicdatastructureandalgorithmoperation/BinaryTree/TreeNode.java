package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.List;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int x) { val = x; }

    public static void main(String[] args) {
        // Below commented data are for Class: FlipBinaryTreeToMatchPreorderTraversal
        /*TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        int[] voyage={1,3,2};
        List<Integer> result = new FlipBinaryTreeToMatchPreorderTraversal().flipMatchVoyage(root, voyage);
        System.out.println("Level order traversal of given tree : " + result);*/

        // Below commented data are for Class: ConstructBinaryTreeFromPreorderAndInorderTraversal

        /*int[] preOrder = {3,4,9,20,15,7};
        int[] inOrder = {9,4,3,15,20,7};

        TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preOrder,inOrder);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + treeNode );*/

        // Below commented data are for Class: ConstructBinaryTreeFromPreorderAndPostorderTraversal
        /*int[] preOrder = {1,2,4,5,3,6,7};
        int[] postOrder = {4,5,2,6,7,3,1};

        TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(preOrder,postOrder);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + treeNode );*/

        // Below commented data are for Class: BinaryTreePreorderTraversal
        /*TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right= new TreeNode(3);
        root.right.left=new TreeNode(4);

        List<Integer> integerList = new BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + integerList );*/

        // Below commented data are for Class: BinaryTreeInorderTraversal
        TreeNode root = new TreeNode(1);
        root.right= new TreeNode(2);
        root.right.left=new TreeNode(3);

        List<Integer> integerList = new BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println("Constructed thr Binary tree from Inorder  : " + integerList );

    }
}