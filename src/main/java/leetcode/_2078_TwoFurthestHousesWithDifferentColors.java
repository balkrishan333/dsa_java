package leetcode;

public class _2078_TwoFurthestHousesWithDifferentColors {

    public static void main(String[] args) {
        _2078_TwoFurthestHousesWithDifferentColors obj =
                new _2078_TwoFurthestHousesWithDifferentColors();

        int[] colors = {1,1,1,6,1,1,1};
        System.out.println(obj.maxDistance(colors));
    }

    public int maxDistance(int[] colors) {
        int answer = 0;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    answer = Math.max(answer, j-i);
                }
            }
        }
        return answer;
    }
}
