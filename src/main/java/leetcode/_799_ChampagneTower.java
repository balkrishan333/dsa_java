package leetcode;

public class _799_ChampagneTower {

    public static void main(String[] args) {
        _799_ChampagneTower obj = new _799_ChampagneTower();

        int poured = 2, query_row = 1, query_glass=1;
        System.out.println(obj.champagneTower(poured, query_row, query_glass));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] quantity = new double[102][102];

        quantity[0][0] = poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                double overflow = quantity[row][col] - 1.0;
                if (overflow > 0) {
                    quantity[row+1][col] += overflow/2.0;
                    quantity[row+1][col+1] += overflow/2.0;
                }
            }
        }
        return Math.min(1, quantity[query_row][query_glass]);
    }
}
