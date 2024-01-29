package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _232_ImplementQueueUsingStacks {

    public static void main(String[] args) {
        _232_ImplementQueueUsingStacks obj = new _232_ImplementQueueUsingStacks();

        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    private final Deque<Integer> s1;
    private final Deque<Integer> s2;

    public _232_ImplementQueueUsingStacks() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        pushtoSecondStackIfRequired();
        return s2.pop();
    }

    public int peek() {
        pushtoSecondStackIfRequired();
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void pushtoSecondStackIfRequired() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
