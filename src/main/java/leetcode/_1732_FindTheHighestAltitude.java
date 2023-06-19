package leetcode;

public class _1732_FindTheHighestAltitude {

    public static void main(String[] args) {
        _1732_FindTheHighestAltitude obj = new _1732_FindTheHighestAltitude();

        int[] gain = {-5,1,5,0,-7};
        System.out.println(obj.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        int answer = 0, prev = 0;

        for(int altitude : gain) {
            prev += altitude;
            answer = Math.max(answer, prev);
        }
        return answer;
    }
}
