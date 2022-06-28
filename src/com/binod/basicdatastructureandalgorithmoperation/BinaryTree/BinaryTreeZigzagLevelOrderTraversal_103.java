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
}
