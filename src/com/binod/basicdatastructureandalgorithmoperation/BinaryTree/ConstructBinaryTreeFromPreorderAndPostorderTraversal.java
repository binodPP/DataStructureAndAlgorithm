package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    //Method 1.
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int preStart=0;
        int preEnd=preorder.length-1;
        int postStart= 0;
        int postEnd=postorder.length-1;
        TreeNode treeNode = constructBinaryTree(preStart,preEnd,preorder,postStart,postEnd,postorder);
        return treeNode;
    }

    public TreeNode constructBinaryTree(int preStart, int preEnd , int[] preOrder, int postStart, int postEnd , int[] postorder){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        TreeNode root= new TreeNode(preOrder[preStart]);
        if(preStart == preEnd){
            return root;
        }
        int find=preStart+1;
        int j=0;
          int i=0;
          for( i=postStart; i<postEnd;i++){
              if(preOrder[find] == postorder[i]){
                 break;
              }
          }
          j=i-postStart+1;
        root.left = constructBinaryTree(preStart+1, preStart+j, preOrder,postStart,postStart+j-1,postorder);
        root.right = constructBinaryTree(preStart+j+1, preEnd, preOrder,postStart+j,postEnd-1,postorder);
        return root;
    }

    //Method 2.

    /*int total;
    Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0; i<postorder.length; i++) {
            map.put(postorder[i], i);
        }
        total=1;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node = constructBinaryTree(root,preorder);
        return node;
    }

    TreeNode constructBinaryTree(TreeNode treeNode, int[]preorder) {
        if(preorder.length == 0) {
            return null;
        }
        if(total < preorder.length && map.get(treeNode.val) > map.get(preorder[total])){
            TreeNode treeNode1= new TreeNode(total);
            total++;
            treeNode.left= constructBinaryTree(treeNode1,preorder);
        }else{
            return treeNode;
        }

        if(total < preorder.length && map.get(treeNode.val) > map.get(preorder[total])){
            TreeNode treeNode1= new TreeNode(total);
            total++;
            treeNode.right= constructBinaryTree(treeNode1,preorder);
        }
        return treeNode;

    }*/

}