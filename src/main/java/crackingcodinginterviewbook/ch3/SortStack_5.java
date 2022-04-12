package crackingcodinginterviewbook.ch3;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack_5 {

    public static void main(String[] args) {
        SortStack_5 obj = new SortStack_5();
        Deque<Integer> s1 = new ArrayDeque<>();
        s1.push(10);
        s1.push(15);
        s1.push(1);
        s1.push(150);
        s1.push(23);
        s1.push(3);
        s1.push(45);
        s1.push(20);

        System.out.println("before = " + s1);
        s1 = obj.sort_v2(s1);
        System.out.println("after = " + s1);
    }

    private Deque<Integer> sort_v2(Deque<Integer> s1) {
        Deque<Integer> s2 = new ArrayDeque<>();

        while (!s1.isEmpty()) {
            int next = s1.pop();
            if (s2.isEmpty()) {
                s2.push(next);
            } else {
                while (!s2.isEmpty() && s2.peek() < next) {
                    s1.push(s2.pop());
                }
                s2.push(next);
            }
        }
        return s2;
    }

}
