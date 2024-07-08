package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class _1823_FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        _1823_FindTheWinnerOfTheCircularGame obj = new _1823_FindTheWinnerOfTheCircularGame();

        int n = 5, k = 2;
        System.out.println(obj.findTheWinner(n, k));
    }

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, n+1).forEach(list::add);

        int currIndex = 0;
        while (list.size() > 1) {
            currIndex = (currIndex + k-1) % list.size();
            list.remove(currIndex);
        }
        return list.getFirst();
    }
}
