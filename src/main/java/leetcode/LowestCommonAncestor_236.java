package leetcode;

import leetcode.common.TreeNode;

public class LowestCommonAncestor_236 {

    public static void main(String[] args) {
        LowestCommonAncestor_236 obj = new LowestCommonAncestor_236();
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = new TreeNode().createTree(input);

        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        p.val = 6;
        q.val = 8;

        System.out.println(obj.lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if any node is null, No common ancestor
        if (root == null || p == null || q == null) {
            return null;
        }

        //if p and q are same, return any one of them
        if (p.val == q.val) {
            return p;
        }

        //if any one of them is root, return root
        if (p.val== root.val || q.val== root.val) {
            return root;
        }

        boolean pExistsOnLeft = exists(root.left, p);
        boolean qExistsOnLeft = exists(root.left, q);

        //if p and q are on different side of root, return root
        if (pExistsOnLeft!=qExistsOnLeft) {
            return root;
        }

        //being here means p and q are on same side of root
        //if in left side, search in root.left
        if (pExistsOnLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        //search in root.right
        return lowestCommonAncestor(root.right, p, q);
    }

    private boolean exists(TreeNode node, TreeNode search) {
        if (node == null) {
            return false;
        }

        if (node.val == search.val) {
            return true;
        }
        return exists(node.left, search) || exists(node.right, search);
    }
}
