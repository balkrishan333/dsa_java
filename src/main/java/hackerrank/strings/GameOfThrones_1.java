package hackerrank.strings;

public final class GameOfThrones_1 {

    public static void main(String[] args) {
        String str = "aaabbbb";
        GameOfThrones_1 game = new GameOfThrones_1();
        String result = game.check(str);
        System.out.println("result = " + result);
    }

    public String check(String s) {
        int[] charCount = new int[26];
        for(int i = 0; i < s.length() ; i++) {
            charCount[s.charAt(i)-97]++;
        }

        int oddCharCount = 0;
        for(int i = 0; i <26 ; i++) {
            if(charCount[i] % 2 ==1) {
                oddCharCount++;
            }
        }
        if(oddCharCount > 1){
            return "NO";
        }
        return "YES";
    }
}
