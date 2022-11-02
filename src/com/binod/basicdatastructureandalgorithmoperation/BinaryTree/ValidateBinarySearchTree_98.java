package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(new ValidateBinarySearchTree_98().isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
      return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root,Integer low, Integer high) {
        if(root == null){
            return true;
        }
        if((low != null && low >= root.val) || (high != null && high <= root.val)){
            return false;
        }

        return isValidBSTHelper(root.left,low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }
}
