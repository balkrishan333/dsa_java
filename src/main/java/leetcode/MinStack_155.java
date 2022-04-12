package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack_155 {

    private List<StackNode> stack = new ArrayList<>();

    public static void main(String[] args) {
        MinStack_155 obj = new MinStack_155();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);

        System.out.println("obj.getMin() = " + obj.getMin());
        System.out.println("obj.top() = " + obj.top());
        obj.pop();
        System.out.println("obj.getMin() = " + obj.getMin());
    }

    public void push(int val) {
        StackNode node = new StackNode();
        node.val = val;

        if(stack.size() == 0) {
            node.min = val;
        } else {
            node.min = Math.min(val, getMin());
        }
        stack.add(node);
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1).val;
    }

    public int getMin() {
        return stack.get(stack.size()-1).min;
    }

    class StackNode {
        int val;
        int min;
    }
}
