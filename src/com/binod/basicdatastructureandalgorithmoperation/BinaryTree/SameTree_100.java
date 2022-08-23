package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class SameTree_100 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);


        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        System.out.println(new SameTree_100().isSameTree(treeNode,treeNode1));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
          if(p == null && q == null){
             return true;
         }else if(p == null || q == null) {
              return false;
          }

        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }

        return false;
    }


}
