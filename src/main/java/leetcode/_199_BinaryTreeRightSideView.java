package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _199_BinaryTreeRightSideView {

    private List<Integer> vals = new ArrayList<>();
    private int maxLevel = 0;

    public static void main(String[] args) {
        _199_BinaryTreeRightSideView obj = new _199_BinaryTreeRightSideView();
        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4});
        System.out.println(obj.rightSideView(root));
    }

    public List<Integer> rightSideView(BinaryTreeNode root) {
        if(root == null) {
            return vals;
        }
        vals.add(root.val);

        traverse(root.right, 1);
        traverse(root.left, 1);

        return vals;
    }

    private void traverse(BinaryTreeNode node, int level) {
        if (node == null) {
            return;
        }

        if(level > maxLevel) {
            vals.add(node.val);
            maxLevel = level;
        }
        traverse(node.right, level+1);
        traverse(node.left, level+1);
    }
}
