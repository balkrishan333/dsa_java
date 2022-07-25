package leetcode;

import leetcode.common.TreeNode;

public class InorderSucessorInBST_510 {

    private TreeNode successor;

    public static void main(String[] args) {
        InorderSucessorInBST_510 obj = new InorderSucessorInBST_510();
        TreeNode node = createTree_4();

        TreeNode successor = obj.findSuccessor(node);

        if (successor == null) {
            System.out.println("null");
        } else {
            System.out.println(successor.val);
        }
    }

    /*
          1. If Right child exists, Inorder traversal of right subtree and return first element
          2. If both left and right are null, start moving to parent and find either a node with higher value or
             root. Return which ever found first
     */
    private TreeNode findSuccessor(TreeNode node) {

        if (node.right != null) {
            inorderTraversal(node.right);
            return successor;
        }

        TreeNode parent = node.parent;
        while (true) {
            if (parent == null) {
                return parent;
            } else if (parent.val > node.val){
                return parent;
            }
            parent = parent.parent;
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        if (successor == null) {
            successor = node;
        }
        inorderTraversal(node.right);

    }

    //expected 2
    public static TreeNode createTree_1() {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);

        node_2.left = node_1;
        node_2.right = node_3;

        node_1.parent = node_2;
        node_3.parent = node_2;

        return node_1;
    }

    //expected null
    public static TreeNode createTree_2() {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);

        node_1.parent = node_2;

        node_2.left = node_1;
        node_2.parent = node_3;

        node_3.left = node_2;
        node_3.right = node_4;
        node_3.parent = node_5;

        node_4.parent = node_3;

        node_5.left = node_3;
        node_5.right = node_6;

        node_6.parent = node_5;

        return node_6;
    }

    //expected 17
    public static TreeNode createTree_3() {
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_17 = new TreeNode(17);
        TreeNode node_18 = new TreeNode(18);
        TreeNode node_20 = new TreeNode(20);

        node_2.parent = node_3;

        node_4.parent = node_3;

        node_3.left = node_2;
        node_3.right = node_4;
        node_3.parent = node_6;

        node_9.parent = node_13;

        node_13.left = node_9;
        node_13.parent = node_7;

        node_7.parent = node_6;
        node_7.right = node_13;

        node_6.parent = node_15;
        node_6.left = node_3;
        node_6.right = node_7;

        node_15.left = node_6;
        node_15.right = node_18;

        node_18.parent = node_15;
        node_18.left = node_17;
        node_18.right = node_20;

        node_17.parent = node_18;
        node_20.parent = node_18;

        return node_15;
    }

    //expected 15
    public static TreeNode createTree_4() {
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_13 = new TreeNode(13);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_17 = new TreeNode(17);
        TreeNode node_18 = new TreeNode(18);
        TreeNode node_20 = new TreeNode(20);

        node_2.parent = node_3;

        node_4.parent = node_3;

        node_3.left = node_2;
        node_3.right = node_4;
        node_3.parent = node_6;

        node_9.parent = node_13;

        node_13.left = node_9;
        node_13.parent = node_7;

        node_7.parent = node_6;
        node_7.right = node_13;

        node_6.parent = node_15;
        node_6.left = node_3;
        node_6.right = node_7;

        node_15.left = node_6;
        node_15.right = node_18;

        node_18.parent = node_15;
        node_18.left = node_17;
        node_18.right = node_20;

        node_17.parent = node_18;
        node_20.parent = node_18;

        return node_13;
    }
}
