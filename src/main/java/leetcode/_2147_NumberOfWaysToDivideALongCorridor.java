package leetcode;
public class _2147_NumberOfWaysToDivideALongCorridor {

    public static void main(String[] args) {
        _2147_NumberOfWaysToDivideALongCorridor obj = new _2147_NumberOfWaysToDivideALongCorridor();

        String corridor = "SSPPSPS";
        System.out.println(obj.numberOfWays(corridor));
    }

    private static final int MOD = (int)1e9+7;
    public int numberOfWays(String corridor) {
        char[] chars = corridor.toCharArray();

        int sCount = 0;
        long result = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'S') {
                sCount++;

                while (++i < chars.length && chars[i] != 'S') {
                    //skip P
                }

                if (i < chars.length && chars[i] == 'S') {
                    sCount++;
                }

                int division = 1; //there is 1 division by default
                while (++i < chars.length && chars[i] != 'S') {
                    division++;
                }

                if (division > 1 && i < chars.length) {
                    result = result * division % MOD;
                }
                i--;
            }
        }

        //if there are odd or zero S, return 0
        return (sCount != 0 && sCount % 2 == 0) ? (int)result : 0;
    }
}

