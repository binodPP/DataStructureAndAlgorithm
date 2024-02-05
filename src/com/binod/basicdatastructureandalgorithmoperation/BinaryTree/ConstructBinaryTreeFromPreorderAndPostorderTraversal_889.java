package com.binod.basicdatastructureandalgorithmoperation.BinaryTree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 treeConstructor =
                new  ConstructBinaryTreeFromPreorderAndPostorderTraversal_889();

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = treeConstructor.buildTree(preorder, postorder);

        System.out.println("Inorder traversal of the constructed tree:");
        treeConstructor.inorderTraversal(root);
    }

    //Method 1.
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        if (preStart == preEnd) {
            // Single-node tree, no need to proceed further
            return root;
        }

        // Find the index of the root value in postorder array
        int rootIndexPostorder = postStart;
        while (postorder[rootIndexPostorder] != preorder[preStart + 1]) {
            rootIndexPostorder++;
        }

        // Let's break down the components of this calculation:
        //
        //rootIndexPostorder: This variable represents the index of the root value in the
        // postorder array. It is determined by iterating through the postorder array starting
        // from postStart until the value matches the first element of the preorder array
        // (preorder[preStart + 1]).
        //
        //postStart: This is the starting index of the current postorder array segment.
        // It represents the leftmost index of the elements relevant to the current recursive call.
        //
        //+ 1: Since we are including the root element in the left subtree, we add 1
        // to the difference between rootIndexPostorder and postStart.
        int leftSubtreeSize = rootIndexPostorder - postStart + 1;

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, rootIndexPostorder);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, rootIndexPostorder + 1, postEnd - 1);

        return root;
    }

    // Helper method to perform inorder traversal and print the elements
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
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