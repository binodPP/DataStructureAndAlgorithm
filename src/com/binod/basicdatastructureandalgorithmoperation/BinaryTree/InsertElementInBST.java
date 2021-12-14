package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class InsertElementInBST {
    private BSTTreeNode root;

    public void insert(int value){
        if(root == null){
            root = new BSTTreeNode(value);
        }else {
            root.insertData(value);
        }
    }

    public void inorderTraversal(){
        if(root !=null){
            root.traverseInorder();
        }
    }

    public void preOrderTraversal(){
        if(root !=null){
            root.traversePreOrder();
        }
    }

    public void postOrderTraversal(){
        if(root !=null){
            root.traversePostOrder();
        }
    }

    public static void main(String[] args) {
        InsertElementInBST insertElementInBST= new InsertElementInBST();

        insertElementInBST.insert(8);
        insertElementInBST.insert(6);
        insertElementInBST.insert(10);
        insertElementInBST.insert(4);
        insertElementInBST.insert(12);
        insertElementInBST.insert(5);
        insertElementInBST.insert(2);
        insertElementInBST.insert(3);
        insertElementInBST.insert(13);
        insertElementInBST.insert(9);

        //insertElementInBST.inorderTraversal();
        //insertElementInBST.preOrderTraversal();
        insertElementInBST.postOrderTraversal();
    }
}
