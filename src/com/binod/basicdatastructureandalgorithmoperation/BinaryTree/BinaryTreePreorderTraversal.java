package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    // Using Recursive call
    /*List<Integer> list =  new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
         return constructPreOrderList(root);
    }

    public List<Integer> constructPreOrderList(TreeNode root){
        if(root == null){
            return null;
        }
        list.add(root.val);
        constructPreOrderList(root.left);
        constructPreOrderList(root.right);

        return list;
    }
*/
    // Using Iterative call
    List<Integer> list =  new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
            }
        return list;
    }
}