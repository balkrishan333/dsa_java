package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ArrayWithStackOperations_1441 {

    public static void main(String[] args) {
        int[] target = {1,3};
        int n = 3;
        List<String> result = buildArray(target, n);
        System.out.println("result = " + result);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ops = new LinkedList<>();
        int nextTarget = 1;

        for(int i =0 ; i < target.length; i++) {
            if(target[i] == nextTarget) {
                ops.add("Push");
            } else {
                int diff = target[i] - nextTarget;
                for(int j = 0; j < diff ; j++) {
                    ops.add("Push");
                    ops.add("Pop");
                }
                ops.add("Push");
            }
            nextTarget = target[i]+1;
        }

        return ops;
    }
}
