package leetcode;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class _1337_TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        _1337_TheKWeakestRowsInAMatrix obj = new _1337_TheKWeakestRowsInAMatrix();

        int[][] mat = {{1,1,0,0,0},
                         {1,1,1,1,0},
                         {1,0,0,0,0},
                         {1,1,0,0,0},
                         {1,1,1,1,1}};

        int k = 3;
        System.out.println(Arrays.toString(obj.kWeakestRows(mat, k)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int  count = (int)Arrays.stream(row).filter(val -> val == 1).count();
            pq.add(new int[]{count, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(pq.poll())[1];
        }
        return result;
    }
}
