package leetcode;

public class _1444_NumberOfWaysOfCuttingAPizza {

    private long count = 0;

    public static void main(String[] args) {
        _1444_NumberOfWaysOfCuttingAPizza obj = new _1444_NumberOfWaysOfCuttingAPizza();

        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        System.out.println(obj.ways(pizza, k));
    }

    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        char[][] pizzaChar = new char[rows][cols];

        int row = 0, col=0;
        for (String str : pizza) {
            for (char ch : str.toCharArray()) {
                pizzaChar[row][col++] = ch;
            }
            row++;
            col = 0;
        }
        cutPizza(0,0, k-1, pizzaChar, rows, cols);
        return (int)(count % 1000000007);
    }

    private void cutPizza(int topR, int topC, int cuts, char[][] pizza, int rows, int cols) {

        if (topR >= pizza.length || topC >= pizza[0].length) {
            return;
        }

        if (cuts == 0) {
            for (int i = topR; i < pizza.length; i++) {
                for (int j = topC; j < pizza[0].length; j++) {
                    if (pizza[i][j] == 'A') {
                        count++;
                        return;
                    }
                }
            }
            return;
        }

        //horizontal cut
        for (int i = topC; i < cols; i++) {
            if (pizza[topR][i] == 'A') {
                cutPizza(topR+1, topC, cuts-1, pizza, rows-1, cols);
            }
        }

        //vertical cut
        for (int i = topR; i < rows; i++) {
            if (pizza[i][topC] == 'A') {
                cutPizza(topR, topC+1, cuts-1, pizza, rows, cols-1);
            }
        }
    }
}
