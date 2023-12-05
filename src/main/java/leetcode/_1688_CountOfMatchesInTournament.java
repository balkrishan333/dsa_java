package leetcode;

public class _1688_CountOfMatchesInTournament {

    public static void main(String[] args) {
        _1688_CountOfMatchesInTournament obj = new _1688_CountOfMatchesInTournament();

        int n = 7;
        System.out.println(obj.numberOfMatches(n));
    }

    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        int answer = 0;
        while (n >= 2) {
            answer = answer + n/2;
            n = (n % 2 == 1) ? n/2 +1 : n/2;
        }
        return answer;
    }
}
