package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues_225 {

    private Deque<Integer> queue;

    public static void main(String[] args) {
        ImplementStackUsingQueues_225 obj = new ImplementStackUsingQueues_225();
        obj.push(1);
        obj.push(2);
        obj.top();
        obj.pop();
        obj.empty();
    }

    public ImplementStackUsingQueues_225() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offerLast(x);
    }

    public int pop() {
        int val = queue.pollLast();
        System.out.println(val);
        return val;
    }

    public int top() {
        int val = queue.peekLast();
        System.out.println(val);
        return val;
    }

    public boolean empty() {
        System.out.println(queue.size() == 0);
        return queue.size() == 0;
    }
}
