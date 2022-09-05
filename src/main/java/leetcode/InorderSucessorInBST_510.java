package leetcode;

import leetcode.common.BinaryTreeNode;

public class InorderSucessorInBST_510 {

    private BinaryTreeNode successor;

    public static void main(String[] args) {
        InorderSucessorInBST_510 obj = new InorderSucessorInBST_510();
        BinaryTreeNode node = createTree_4();

        BinaryTreeNode successor = obj.findSuccessor(node);

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
    private BinaryTreeNode findSuccessor(BinaryTreeNode node) {

        if (node.right != null) {
            inorderTraversal(node.right);
            return successor;
        }

        BinaryTreeNode parent = node.parent;
        while (true) {
            if (parent == null) {
                return parent;
            } else if (parent.val > node.val){
                return parent;
            }
            parent = parent.parent;
        }
    }

    private void inorderTraversal(BinaryTreeNode node) {
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
    public static BinaryTreeNode createTree_1() {
        BinaryTreeNode node_1 = new BinaryTreeNode(1);
        BinaryTreeNode node_2 = new BinaryTreeNode(2);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);

        node_2.left = node_1;
        node_2.right = node_3;

        node_1.parent = node_2;
        node_3.parent = node_2;

        return node_1;
    }

    //expected null
    public static BinaryTreeNode createTree_2() {
        BinaryTreeNode node_1 = new BinaryTreeNode(1);
        BinaryTreeNode node_2 = new BinaryTreeNode(2);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_5 = new BinaryTreeNode(5);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);

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
    public static BinaryTreeNode createTree_3() {
        BinaryTreeNode node_2 = new BinaryTreeNode(2);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);
        BinaryTreeNode node_7 = new BinaryTreeNode(7);
        BinaryTreeNode node_9 = new BinaryTreeNode(9);
        BinaryTreeNode node_13 = new BinaryTreeNode(13);
        BinaryTreeNode node_15 = new BinaryTreeNode(15);
        BinaryTreeNode node_17 = new BinaryTreeNode(17);
        BinaryTreeNode node_18 = new BinaryTreeNode(18);
        BinaryTreeNode node_20 = new BinaryTreeNode(20);

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
    public static BinaryTreeNode createTree_4() {
        BinaryTreeNode node_2 = new BinaryTreeNode(2);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);
        BinaryTreeNode node_7 = new BinaryTreeNode(7);
        BinaryTreeNode node_9 = new BinaryTreeNode(9);
        BinaryTreeNode node_13 = new BinaryTreeNode(13);
        BinaryTreeNode node_15 = new BinaryTreeNode(15);
        BinaryTreeNode node_17 = new BinaryTreeNode(17);
        BinaryTreeNode node_18 = new BinaryTreeNode(18);
        BinaryTreeNode node_20 = new BinaryTreeNode(20);

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
