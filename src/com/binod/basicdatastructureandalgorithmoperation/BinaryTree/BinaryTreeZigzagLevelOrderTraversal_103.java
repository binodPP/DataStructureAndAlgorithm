package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList= new ArrayList<>();
        return zigzagLevelOrderHelper(root,listList,0);
    }

    public static List<List<Integer>> zigzagLevelOrderHelper(TreeNode root,List<List<Integer>> listList,int level){
        if(root == null){
            return listList;
        }
        if(level >=listList.size()){
            List<Integer> newLabel= new ArrayList<>();
            listList.add(newLabel);
        }
        if(level%2==0){
            listList.get(level).add(root.val);
        }else {
            listList.get(level).add(0,root.val);
        }

        zigzagLevelOrderHelper(root.left,listList,level+1);
        zigzagLevelOrderHelper(root.right,listList,level+1);

        return listList;

    }

    public static void main(String[] args) {
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
