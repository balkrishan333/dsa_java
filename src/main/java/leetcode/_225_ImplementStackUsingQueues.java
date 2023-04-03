package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _225_ImplementStackUsingQueues {

    private Deque<Integer> queue;

    public static void main(String[] args) {
        _225_ImplementStackUsingQueues obj = new _225_ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        obj.top();
        obj.pop();
        obj.empty();
    }

    public _225_ImplementStackUsingQueues() {
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
