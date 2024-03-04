package leetcode;

import java.util.Arrays;

public class _948_BagOfTokens {

    public static void main(String[] args) {
        _948_BagOfTokens obj = new _948_BagOfTokens();

        int[] tokens = {100,200,300,400};
        int power = 200;
        System.out.println(obj.bagOfTokensScore(tokens, power));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int max = 0;

        int end = tokens.length;
        int score = 0;
        for (int i = 0; i < end; i++) {
            if (tokens[i] <= power) {
                score++;
                power -= tokens[i];
                max = Math.max(max, score);
            } else if (score >= 1){
                power += tokens[end-1]; //increase power
                score--; //reduce score
                end--; //move end to left
                i--; //go back one step as current token was not used, instead token from end was used
            } else {
                break;
            }
        }
        return max;
    }
}
