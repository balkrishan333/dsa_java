package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1431_KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        _1431_KidsWithTheGreatestNumberOfCandies obj = new _1431_KidsWithTheGreatestNumberOfCandies();

        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> answer = new ArrayList<>();

        for (int kid : candies) {
            answer.add(kid + extraCandies >= max);
        }
        return answer;
    }
}
