package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257_BinaryTreePaths {

    public static void main(String[] args) {
        _257_BinaryTreePaths obj = new _257_BinaryTreePaths();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,null,5});
        System.out.println(obj.binaryTreePaths(root));
    }

    private final List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(BinaryTreeNode root) {
        if (root.left == null && root.right == null) {
            return List.of(Integer.toString(root.val));
        }

        traverse(root.left, Integer.toString(root.val));
        traverse(root.right, Integer.toString(root.val));

        return paths;
    }

    public void traverse(BinaryTreeNode node, String path) {
        if (node == null) {
            return;
        }

        path = path + "->" + node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        traverse(node.left, path);
        traverse(node.right, path);
    }
}
