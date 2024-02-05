package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/description/
public class FlipBinaryTreeToMatchPreorderTraversal_971 {

    //Method 1 using DFS(Depth first search)
    List<Integer> res;
    int i;
    public List<Integer> flipMatchVoyage1(TreeNode root, int[] voyage) {
        i=0;
       res = new ArrayList<>();
        dfs(root,voyage);
        return res;
    }

    public void dfs(TreeNode root,int[] voyage){
            if (root != null) {
                if (root.val != voyage[i]) {
                    res.clear();
                    res.add(-1);
                    return;
                }
                i++;
                // If the left child exists and its value not matches the next value in voyage, flip the subtree
                if (root.left != null && root.left.val != voyage[i]) {
                    res.add(root.val);
                    dfs(root.right, voyage);
                    dfs(root.left, voyage);
                } else {
                    // Otherwise, maintain the order and push left child first
                    dfs(root.left, voyage);
                    dfs(root.right, voyage);
                }
        }
    }

    //Method 2: Using Stack

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        int i=0;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode= stack.pop();

            if(treeNode == null){
                continue;
            }
            if(treeNode.val != voyage[i]){
                res.add(-1);
                return res;
            }

            i++;

            if (treeNode.right != null && treeNode.right.val == voyage[i]) {
                // If the right child exists and its value matches the next value in voyage, flip the subtree
                res.add(treeNode.val);
                stack.push(treeNode.left);
                stack.push(treeNode.right);
            } else {
                // Otherwise, maintain the order and push right child first
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Below commented data are for Class: FlipBinaryTreeToMatchPreorderTraversal
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        int[] voyage={1,3,2};
        List<Integer> result = new FlipBinaryTreeToMatchPreorderTraversal_971().flipMatchVoyage(root, voyage);
        System.out.println("Level order traversal of given tree : " + result);


        // Below commented data are for Class: FlipBinaryTreeToMatchPreorderTraversal
        TreeNode root1= new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);
        List<Integer> result1 = new FlipBinaryTreeToMatchPreorderTraversal_971().flipMatchVoyage1(root1, voyage);
        System.out.println("Level order traversal of given tree : " + result1);
    }
}