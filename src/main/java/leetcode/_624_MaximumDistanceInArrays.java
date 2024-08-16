package leetcode;

import java.util.List;

public class _624_MaximumDistanceInArrays {

    public static void main(String[] args) {
        _624_MaximumDistanceInArrays obj = new _624_MaximumDistanceInArrays();

        List<List<Integer>> arrays =  List.of(List.of(1,2,5), List.of(3,4), List.of(2,3));
        System.out.println(obj.maxDistance(arrays));
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.getFirst().getFirst();
        int biggest = arrays.getFirst().getLast();
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            maxDistance = Math.max(maxDistance, Math.abs(biggest - arrays.get(i).getFirst()));
            maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).getLast() - smallest));
            smallest = Math.min(smallest, arrays.get(i).getFirst());
            biggest = Math.max(biggest, arrays.get(i).getLast());
        }
        return maxDistance;
    }
}
