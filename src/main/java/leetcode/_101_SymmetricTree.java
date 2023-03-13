package leetcode;

import leetcode.common.BinaryTreeNode;

public class _101_SymmetricTree {

    public static void main(String[] args) {
        _101_SymmetricTree obj = new _101_SymmetricTree();
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,2,3,4,4,3});

        System.out.println(obj.isSymmetric(root));
    }

    public boolean isSymmetric(BinaryTreeNode root) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        return verifySubTree(root.left,root.right);
    }

    private boolean verifySubTree(BinaryTreeNode nodeL, BinaryTreeNode nodeR) {
        //if both left and right are null, return true
        if(nodeL == null && nodeR == null) {
            return true;
        }

        //Above if statement checks for nullability of both but either one can still be null
        if(nodeL != null && nodeR != null && nodeL.val == nodeR.val) {

            //As per rul of symmetry, compare left child of one with right child of other and vice verse
            return verifySubTree(nodeL.left, nodeR.right) && verifySubTree(nodeL.right,nodeR.left);
        }
        return false;
    }
}
