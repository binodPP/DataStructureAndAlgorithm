package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import com.leetcodeproblem.trie.TrieNode;

public class LowestCommonAncestorInBST {
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
        System.out.println(new LowestCommonAncestorInBST().getLCABST(treeNode,left,right).val);
        //System.out.println(new LowestCommonAncestorInBST().getLCABSTIterative(treeNode,left,right).val);
    }

    public TreeNode getLCABST(TreeNode treeNode, int left, int right){

        if(treeNode == null){
            return null;
        }

        if(treeNode.val > left && treeNode.val > right){
            return getLCABST(treeNode.left,left,right);
        }

        if(treeNode.val < left && treeNode.val < right){
            return getLCABST(treeNode.right,left,right);
        }

        return treeNode;
    }

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
            if (treeNode.val < left && treeNode.val < right) {
                treeNode = treeNode.right;
            }

        }
        return treeNode;
    }
}
