package leetcode;

public class _292_NimGame {

    public static void main(String[] args) {
        _292_NimGame obj = new _292_NimGame();

        int n = 7;
        System.out.println(obj.canWinNim(n));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
