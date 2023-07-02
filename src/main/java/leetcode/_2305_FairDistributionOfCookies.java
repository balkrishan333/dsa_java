package leetcode;

import java.util.Arrays;

public class _2305_FairDistributionOfCookies {

    public static void main(String[] args) {
        _2305_FairDistributionOfCookies obj = new _2305_FairDistributionOfCookies();

        int[] cookies = {6,1,3,2,2,4,1,2};
        int k = 3;
        System.out.println(obj.distributeCookies(cookies, k));
    }

    /*
        Approach: Backtracking

        Try to allocate each cookie bag to each candidate and take min. Then from all these such combinations take max.

        Keep track of candidates which have zero cookies.

        If no of bags left, is less than candidates with zero cookie count, return as that's not a valid path because we want to do
        fair allocation of cookies.
     */
    public int distributeCookies(int[] cookies, int k) {
        int[] distribution = new int[k];

        //initially no of candidates with zero cookie bags are same as k
        return distribute(0, distribution, cookies, k, k);
    }

    private int distribute(int cookieIndex, int[] distribution, int[] cookies, int k, int zeroCount) {

        //invalid path: as fair allocation not possible, no of cookie bag left are less than candidates with zero allocation
        if (cookies.length - cookieIndex < zeroCount) {
            return Integer.MAX_VALUE;
        }

        //if all cookie bag have been allocated
        if (cookieIndex == cookies.length) {
            return Arrays.stream(distribution).max().orElse(0);
        }

        int answer = Integer.MAX_VALUE;

        //allocate the current cookie bag to each candidate and recursively call the method with next index.
        for (int i = 0; i < k; i++) {
            if (distribution[i] == 0) { //if this candidate has zero cookies before allocation, decrease the zero count
                zeroCount--;
            }
            distribution[i] += cookies[cookieIndex];

            //recursively call the method with next index
            answer = Math.min(answer, distribute(cookieIndex+1, distribution, cookies, k, zeroCount));

            //back tacking : remove the cookies allocated and increase the zero count if required. This is required because if we want to
            // allocate the cookie bag to next candidate, it can't be with previous candidate, so decrease the no. of cookies frm
            // previous candidate.
            distribution[i] -= cookies[cookieIndex];
            if (distribution[i] == 0) {
                zeroCount++;
            }
        }
        return answer;
    }
}
