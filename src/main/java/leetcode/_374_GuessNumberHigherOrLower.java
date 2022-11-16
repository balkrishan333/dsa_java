package leetcode;

public class _374_GuessNumberHigherOrLower {

    public static void main(String[] args) {
        _374_GuessNumberHigherOrLower obj = new _374_GuessNumberHigherOrLower();
        int n = 50;

        System.out.println(obj.guessNumber(n));
    }

    public int guessNumber(int n) {
        int lo =1, hi = 100;

        int result = guess(n);
        if(result == 0){
            return n;
        }

        while(result != 0) {
            if(result == 1) {
                lo = n;
                n = n + (hi-n)/2;
                result = guess(n);
            } else {
                hi = n;
                n = lo + (n-lo)/2;
                result = guess(n);
            }
        }
        return n;
    }

    private int guess(int guess) {
        int pick = 90;
        if (pick == guess) {
            return 0;
        }
        return (pick-guess > 0) ? 1 : -1;
    }
}
