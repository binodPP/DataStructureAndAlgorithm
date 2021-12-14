package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlipBinaryTreeToMatchPreorderTraversal {

    //Method 1 using DFS(Depth first search)
    /*List<Integer> res;
    int i;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i=0;
       res = new ArrayList<>();
        dfs(root,voyage);
        return res;
    }

    public void dfs(TreeNode root,int[] voyage){
            if (root != null) {
                if (root.val != voyage[i++]) {
                    res.clear();
                    res.add(-1);
                    return;
                }
                if (root.left != null && root.left.val != voyage[i]) {
                    res.add(root.val);
                    dfs(root.right, voyage);
                    dfs(root.left, voyage);
                } else {
                    dfs(root.left, voyage);
                    dfs(root.right, voyage);
                }
        }
    }*/

    //Method 2: Using Stack

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        int i=0;
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        if(!stack.isEmpty()){
            TreeNode treeNode= stack.pop();
            if(treeNode.val != voyage[i++]){
                res.clear();
                res.add(-1);
            }
            if(treeNode.left != null && treeNode.left.val != voyage[i]){
                res.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }else {
                stack.push(treeNode.left);
                stack.push(treeNode.right);
            }
        }
        return res;
    }
}