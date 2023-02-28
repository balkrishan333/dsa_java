package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _652_FindDuplicateSubtrees {

    private Map<String, Integer> map = new HashMap<>();
    private List<BinaryTreeNode> result = new ArrayList<>();

    public static void main(String[] args) {
        _652_FindDuplicateSubtrees obj = new _652_FindDuplicateSubtrees();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{0,0,0,0,null,null,0,null,null,null,0});
//        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,null,2,4,null,null,4});
        System.out.println(obj.findDuplicateSubtrees(root));
    }

    public List<BinaryTreeNode> findDuplicateSubtrees(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        traverse(root);
        return result;
    }

    private String traverse(BinaryTreeNode node) {

        if (node == null) {
            return "";
        }

        String left = traverse(node.left);
        String right = traverse(node.right);

        // brackets are required to make sure nodes with same values don't create same substring.
        //if node with same value are in left and right subtree without brackets they will produce same string
        String subTree = "("+left+")" + node.val + "("+right+")";
        map.merge(subTree, 1, Integer::sum);

        if (map.get(subTree) == 2) {
            result.add(node);
        }

        return subTree;
    }
}
