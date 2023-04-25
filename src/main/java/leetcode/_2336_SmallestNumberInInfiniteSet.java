package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _2336_SmallestNumberInInfiniteSet {

    private final Set<Integer> set;
    private final PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        _2336_SmallestNumberInInfiniteSet obj = new _2336_SmallestNumberInInfiniteSet();

        obj.addBack(2);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(1);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
    }

    public _2336_SmallestNumberInInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
        }
    }

    public int popSmallest() {
        int val = pq.poll();
        set.add(val);

        return val;
    }

    public void addBack(int num) {
        if (set.contains(num)) {
            pq.add(num);
            set.remove(num);
        }
    }
}
