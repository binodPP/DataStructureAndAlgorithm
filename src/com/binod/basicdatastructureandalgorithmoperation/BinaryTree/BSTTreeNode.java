package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class BSTTreeNode {
    private int data;
    private BSTTreeNode leftChild;
    private BSTTreeNode rightChild;

    public void insertData(int value){
        if(data == value){
            return;
        }

        if(value < data){
            if(leftChild == null){
                leftChild = new BSTTreeNode(value);
            }else{
                leftChild.insertData(value);
            }
        }else {
            if(rightChild == null){
                rightChild = new BSTTreeNode(value);
            }else{
                rightChild.insertData(value);
            }
        }
    }

    public void traverseInorder(){
        if(leftChild !=null){
            leftChild.traverseInorder();
        }

        System.out.print(data+", ");

        if (rightChild != null){
            rightChild.traverseInorder();
        }
    }

    public void traversePreOrder(){
        System.out.print(data+", ");
        if(leftChild !=null){
            leftChild.traversePreOrder();
        }
        if (rightChild != null){
            rightChild.traversePreOrder();
        }

    }

    public void traversePostOrder(){
        if(leftChild !=null){
            leftChild.traversePostOrder();
        }

        if (rightChild != null){
            rightChild.traversePostOrder();
        }

        System.out.print(data+", ");
    }

    public BSTTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BSTTreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
