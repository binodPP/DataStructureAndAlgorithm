package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class InsertIntoBinarySearchTree_701 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);

        int val = 5;

        treeNode.left= new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);

        TreeNode temp = insertIntoBST(treeNode,val);

        preorderBST(temp);


    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
             if(root == null){
                 return new TreeNode(val);
             }else {
                 if(val < root.val){
                     root.left = insertIntoBST(root.left,val);
                 }

                 if(val > root.val){
                     root.right = insertIntoBST(root.right,val);
                 }
             }

             return root;
    }

    public static void preorderBST(TreeNode root) {
        System.out.println(root.val);

        if(root.left != null){
            preorderBST(root.left);
        }

        if (root.right != null){
            preorderBST(root.right);
        }
    }
}
