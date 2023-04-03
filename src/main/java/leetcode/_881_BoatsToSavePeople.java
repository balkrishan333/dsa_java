package leetcode;

import java.util.Arrays;

public class _881_BoatsToSavePeople {

    public static void main(String[] args) {
        _881_BoatsToSavePeople obj = new _881_BoatsToSavePeople();

        int[] people = {3,2,2,1};
        int limit = 3;
        System.out.println(obj.numRescueBoats(people, limit));
    }

    /*
        Approach: Sorting + 2 pointer
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        for (int i = 0, j= people.length-1; i <= j ; ) {
            if(i ==j) {
                boats++;
                break;
            }
            int sum = people[i] + people[j];
            if (sum <= limit) {
                boats++;
                i++;
                j--;
            } else {
                boats++;
                j--;
            }
        }
        return boats;
    }
}
