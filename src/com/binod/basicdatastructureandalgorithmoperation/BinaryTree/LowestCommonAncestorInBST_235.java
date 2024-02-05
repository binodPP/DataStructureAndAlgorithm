package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorInBST_235 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(20);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(22);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(12);
        treeNode.left.right.left = new TreeNode(10);
        treeNode.left.right.right = new TreeNode(14);

        int left = 10;
        int right =14;

        System.out.println(new LowestCommonAncestorInBST_235().getLCABST(treeNode,left,right).val);

        TreeNode treeNode1 = new TreeNode(20);
        treeNode1.left = new TreeNode(8);
        treeNode1.right = new TreeNode(22);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(12);
        treeNode1.left.right.left = new TreeNode(10);
        treeNode1.left.right.right = new TreeNode(14);

        int left1 = 8;
        int right1 =14;

        System.out.println(new LowestCommonAncestorInBST_235().getLCABSTIterative(treeNode1,left1,right1).val);


        TreeNode treeNode2 = new TreeNode(20);
        treeNode2.left = new TreeNode(8);
        treeNode2.right = new TreeNode(22);
        treeNode2.left.left = new TreeNode(4);
        treeNode2.left.right = new TreeNode(12);
        treeNode2.left.right.left = new TreeNode(10);
        treeNode2.left.right.right = new TreeNode(14);

        int left2 = 8;
        int right2 =14;
        System.out.println(new LowestCommonAncestorInBST_235().getLCA(treeNode2,left2,right2).val);
    }

    //Recursive approach only works in case of BST
    public TreeNode getLCABST(TreeNode treeNode, int left, int right){

        if(treeNode == null){
            return null;
        }

        if(treeNode.val == left || treeNode.val == right){
            return treeNode;
        }

        if(treeNode.val > left && treeNode.val > right){
            return getLCABST(treeNode.left,left,right);
        }else if(treeNode.val < left && treeNode.val < right){
            return getLCABST(treeNode.right,left,right);
        }

        return treeNode;
    }

    //Iterative approach only works in case of BST
    public TreeNode getLCABSTIterative(TreeNode treeNode, int left, int right){

        while (treeNode != null)
        {
            // If both n1 and n2 are smaller
            // than root, then LCA lies in left
            if (treeNode.val> left && treeNode.val > right) {
                treeNode = treeNode.left;
            }

                // If both n1 and n2 are greater
                // than root, then LCA lies in right
            else if (treeNode.val < left && treeNode.val < right) {
                treeNode = treeNode.right;
            }else {
                return treeNode;
            }

        }
        return null;
    }


    //Oprion 3: Which will work for both binary tree and BST
    public TreeNode getLCA(TreeNode root, int left, int right) {
        if (root == null) {
            return null;
        }

        // If the current node is one of the nodes we are looking for, return it
        if (root.val == left || root.val == right) {
            return root;
        }

        // Recursively search left and right subtrees for LCA
        TreeNode leftLCA = getLCA(root.left, left, right);
        TreeNode rightLCA = getLCA(root.right, left, right);

        // If both leftLCA and rightLCA are not null, it means left and right
        // are found in different subtrees, so the current node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If either leftLCA or rightLCA is not null, return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
