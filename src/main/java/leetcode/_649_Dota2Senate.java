package leetcode;

import java.util.PriorityQueue;

public class _649_Dota2Senate {

    public static void main(String[] args) {
        _649_Dota2Senate obj = new _649_Dota2Senate();

        String senate = "DRRDRDRDRDDRDRDR";
        System.out.println(obj.predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        PriorityQueue<Integer> dpq = new PriorityQueue<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rpq.add(i);
            } else {
                dpq.add(i);
            }
        }

        int strSize = senate.length();
        while (!rpq.isEmpty() && !dpq.isEmpty()) {
            int rIndex = rpq.poll();
            int dIndex = dpq.poll();

            if (rIndex < dIndex) {
                rpq.add(rIndex + strSize);
            } else {
                dpq.add(dIndex + strSize);
            }
        }
        return rpq.isEmpty() ? "Dire" : "Radiant";
    }
}
