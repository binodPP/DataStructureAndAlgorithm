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
        TreeNode root1= new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);
        int[] voyage={1,3,2};
        List<Integer> result = new FlipBinaryTreeToMatchPreorderTraversal_971().flipMatchVoyage(root1, voyage);
        System.out.println("Level order traversal of given tree : " + result);

        // Below commented data are for Class: ConstructBinaryTreeFromPreorderAndInorderTraversal

        int[] preOrder = {3,4,9,20,15,7};
        int[] inOrder = {9,4,3,15,20,7};

        TreeNode treeNode = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105().buildTree(preOrder,inOrder);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + treeNode );

        // Below commented data are for Class: ConstructBinaryTreeFromPreorderAndPostorderTraversal
        int[] preOrder1 = {1,2,4,5,3,6,7};
        int[] postOrder = {4,5,2,6,7,3,1};

        TreeNode treeNode1 = new ConstructBinaryTreeFromPreorderAndPostorderTraversal_889().constructFromPrePost(preOrder1,postOrder);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + treeNode1 );

        // Below commented data are for Class: ConstructBinaryTreeFromInorderAndPostorderTraversal
        int[] inOrder1 = {9,3,15,20,7};
        int[] postOrder1 = {9,15,7,20,3};

        TreeNode treeNode2 = new ConstructBinaryTreeFromInOrderAndPostorderTraversal_106().constructFromInPost(inOrder1,postOrder1);
        System.out.println("Constructed thr Binary tree from In Order and Post order  : " + treeNode2 );

        // Below commented data are for Class: BinaryTreePreorderTraversal
        TreeNode root11 = new TreeNode(1);
        root11.left=new TreeNode(2);
        root11.right= new TreeNode(3);
        root11.right.left=new TreeNode(4);

        List<Integer> integerList = new BinaryTreePreorderTraversal().preorderTraversal(root11);
        System.out.println("Constructed thr Binary tree from preOrder and In order  : " + integerList );

        // Below commented data are for Class: BinaryTreeInorderTraversal
        TreeNode root2 = new TreeNode(1);
        root2.right= new TreeNode(2);
        root2.right.left=new TreeNode(3);

        List<Integer> integerList1 = new BinaryTreeInorderTraversal().inorderTraversal(root2);
        System.out.println("Constructed thr Binary tree from Inorder  : " + integerList1 );

        // Below commented data are for Class: BinaryTreePostOrderTraversal
        TreeNode root3 = new TreeNode(1);
        root3.right= new TreeNode(2);
        root3.right.left=new TreeNode(3);

        List<Integer> integerList2 = new BinaryTreePostorderTraversal_145().postorderTraversal(root3);
        System.out.println("Constructed thr Binary tree from postOrder  : " + integerList2 );


        // Below commented data are for Class: BinaryTreeLevelOrderTraversal_102
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(9);
        root4.right= new TreeNode(20);
        root4.right.left = new TreeNode(15);
        root4.right.right=new TreeNode(7);

        List<List<Integer>> integerList3 = new BinaryTreeLevelOrderTraversal_102().levelOrder(root4);
        System.out.println("Binary tree LevelOrderTraversal  : " + integerList3 );

        // Below commented data are for Class: BinaryTreeZigzagLevelOrderTraversal_103
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(9);
        root5.right= new TreeNode(20);
        root5.right.left = new TreeNode(15);
        root5.right.right=new TreeNode(7);

        List<List<Integer>> integerList4 = new BinaryTreeZigzagLevelOrderTraversal_103().zigzagLevelOrder(root5);
        System.out.println("Binary tree ZigzagLevelOrderTraversal  : " + integerList4 );

    }
}