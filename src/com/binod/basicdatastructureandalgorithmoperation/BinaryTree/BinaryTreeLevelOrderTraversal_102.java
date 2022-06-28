package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

import java.util.ArrayList;
import java.util.List;

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
}
