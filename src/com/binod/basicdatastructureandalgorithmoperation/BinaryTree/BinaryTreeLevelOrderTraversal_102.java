package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList= new ArrayList<>();
        return levelOrderHelper(root,listList,0);
    }

    public static List<List<Integer>> levelOrderHelper(TreeNode root,List<List<Integer>> listList,int level){
       if(root == null){
            return listList;
        }
        if(level >=listList.size()){
            List<Integer> newLabel= new ArrayList<>();
            listList.add(newLabel);
        }
        listList.get(level).add(root.val);
        levelOrderHelper(root.left,listList,level+1);
        levelOrderHelper(root.right,listList,level+1);

        return listList;

    }

    public static void main(String[] args) {
        // Below commented data are for Class: BinaryTreeLevelOrderTraversal_102
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(9);
        root4.right= new TreeNode(20);
        root4.right.left = new TreeNode(15);
        root4.right.right=new TreeNode(7);

        List<List<Integer>> integerList3 = new BinaryTreeLevelOrderTraversal_102().levelOrder(root4);
        System.out.println("Binary tree LevelOrderTraversal  : " + integerList3 );
    }
}
