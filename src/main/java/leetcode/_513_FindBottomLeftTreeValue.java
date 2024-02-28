package leetcode;

import leetcode.common.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class _513_FindBottomLeftTreeValue {

    public static void main(String[] args) {
        _513_FindBottomLeftTreeValue obj = new _513_FindBottomLeftTreeValue();

        BinaryTreeNode root = new BinaryTreeNode().createTree(new Integer[]{1,2,3,4,null,5,6,null,null,7});
        System.out.println(obj.findBottomLeftValue(root));
    }

    private int answer;
    private final List<BinaryTreeNode> queue = new LinkedList<>();
    public int findBottomLeftValue(BinaryTreeNode root) {
        bfs(root);
        return answer;
    }

    private void bfs(BinaryTreeNode node) {

        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            BinaryTreeNode first = queue.removeFirst();
            answer = first.val;
            addChildrenToQueueIfNotNull(first);
            size--;

            while (size > 0) {
                BinaryTreeNode next = queue.removeFirst();
                addChildrenToQueueIfNotNull(next);
                size--;
            }
        }
    }

    private void addChildrenToQueueIfNotNull(BinaryTreeNode node) {
        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
