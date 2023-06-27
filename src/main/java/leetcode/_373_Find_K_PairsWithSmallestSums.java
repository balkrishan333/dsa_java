package leetcode;

import java.util.*;

public class _373_Find_K_PairsWithSmallestSums {

    public static void main(String[] args) {
        _373_Find_K_PairsWithSmallestSums obj = new _373_Find_K_PairsWithSmallestSums();

        int[] num1 = {1,7,11};
        int[] num2 = {2,4,6};
        int k = 3;
        System.out.println(obj.kSmallestPairs(num1, num2, k));
    }

    /*
        Approach: Min Heap - Priority queue
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int i = 0, j =0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        priorityQueue.add(new int[]{nums1[i] + nums2[j], i, j});

        List<List<Integer>> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(i+"#"+j);

        while (k-- > 0 && !priorityQueue.isEmpty()) {

            int[] ele = priorityQueue.poll();
            i = ele[1];
            j = ele[2];

            answer.add(List.of(nums1[i], nums2[j]));

            if (i+1 < nums1.length && !visited.contains((i+1)+"#"+j)) {
                priorityQueue.add(new int[]{nums1[i+1]+ nums2[j], i+1, j});
                visited.add((i+1)+"#"+j);
            }

            if (j+1 < nums2.length && !visited.contains((i)+"#"+(j+1))) {
                priorityQueue.add(new int[]{nums1[i]+ nums2[j+1], i, j+1});
                visited.add(i+"#"+(j+1));
            }
        }
        return answer;
    }
}
