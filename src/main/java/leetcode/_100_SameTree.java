package leetcode;

import leetcode.common.BinaryTreeNode;

public class _100_SameTree {

    public static void main(String[] args) {
        _100_SameTree obj = new _100_SameTree();

        BinaryTreeNode p = new BinaryTreeNode().createTree(new Integer[]{10,5,15});
        BinaryTreeNode q = new BinaryTreeNode().createTree(new Integer[]{10,5,null,null,15});

        System.out.println(obj.isSameTree(p, q));
    }

    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null) ||  (p.val != q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
