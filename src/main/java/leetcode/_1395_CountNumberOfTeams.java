package leetcode;

public class _1395_CountNumberOfTeams {

    public static void main(String[] args) {
        _1395_CountNumberOfTeams obj = new _1395_CountNumberOfTeams();

        int[] rating = {2,5,3,4,1};
        System.out.println(obj.numTeams(rating));
    }

    public int numTeams(int[] rating) {
        int n = rating.length;

        Integer[][] increasingCache = new Integer[n][4];
        Integer[][] decreasingCache = new Integer[n][4];

        int teams = 0;
        for (int startIndex = 0; startIndex < n; startIndex++) {
            teams += increasingOrder(rating, startIndex, 1, increasingCache);
            teams += decreasingOrder(rating, startIndex, 1, decreasingCache);
        }

        return teams;
    }

    private int decreasingOrder(int[] rating, int currIndex, int teamSize, Integer[][] decreasingCache) {

        if (teamSize == 3) {
            return 1;
        }

        if (currIndex == rating.length) {
            return 0;
        }

        if (decreasingCache[currIndex][teamSize] != null) {
            return decreasingCache[currIndex][teamSize];
        }

        int validTeams = 0;
        for (int nextIndex = currIndex + 1; nextIndex < rating.length; nextIndex++) {
            if (rating[nextIndex] < rating[currIndex]) {
                validTeams += decreasingOrder(rating, nextIndex, teamSize + 1, decreasingCache);
            }
        }
        return decreasingCache[currIndex][teamSize] = validTeams;
    }

    private int increasingOrder(int[] rating, int currIndex, int teamSize, Integer[][] increasingCache) {
        if (teamSize == 3) {
            return 1;
        }

        if (currIndex == rating.length) {
            return 0;
        }

        if (increasingCache[currIndex][teamSize] != null) {
            return increasingCache[currIndex][teamSize];
        }

        int validTeams = 0;
        for (int nextIndex = currIndex + 1; nextIndex < rating.length; nextIndex++) {
            if (rating[nextIndex] > rating[currIndex]) {
                validTeams += increasingOrder(rating, nextIndex, teamSize + 1, increasingCache);
            }
        }
        return increasingCache[currIndex][teamSize] = validTeams;
    }
}
