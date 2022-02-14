package hackerrank.interviewkit.warmup;

/*
https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
 */
public final class RepeatedString {

    public static void main(String[] args) {
        String str = "a";
        long n = 1000000000000L;
//        String str = "aba";
//        long n = 10;

        RepeatedString repeatedString = new RepeatedString();
        long count = repeatedString.countChar(str, n);
        System.out.println("count = " + count);
    }

    long countChar(String str, long n) {
        long quoeint = n / str.length();
        int mod = (int) (n % str.length());

        int noOfAinStr = 0;
        int noOfAinModLength = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == 'a') {
                noOfAinStr++;
                if (i+1 <= mod) {
                    noOfAinModLength++;
                }
            }
        }

        if (noOfAinStr == 0) {
            return 0;
        }
        return noOfAinStr * quoeint + noOfAinModLength;
    }
}
