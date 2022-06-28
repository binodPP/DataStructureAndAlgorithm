package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    // Using Recursive call
    List<Integer> list =  new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
         return constructPostOrderList(root);
    }

    public List<Integer> constructPostOrderList(TreeNode root){
        if(root == null){
            return null;
        }
        constructPostOrderList(root.left);
        constructPostOrderList(root.right);
        list.add(root.val);

        return list;
    }

    // Using Iterative call
    /*List<Integer> list =  new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack= new Stack<>();
        Stack<TreeNode> stack1= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();

            stack1.push(treeNode);
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }

            }

        while(!stack1.isEmpty()){
            list.add(stack1.peek().val);
            stack1.pop();
        }
        return list;
    }*/


}