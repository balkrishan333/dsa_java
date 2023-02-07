package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _904_FruitIntoBaskets {

    public static void main(String[] args) {
        _904_FruitIntoBaskets obj = new _904_FruitIntoBaskets();

        int[] fruits = {0,1,2,2};
        System.out.println(obj.totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        int max = 0;

        //maintain 2 types of fruits in basket
        int type1 = -1;
        int type2 = -1;

        int left = 0; //start index of window

        //use sliding window. Remove elements from window if 3rd type of fruit is found
        for (int i = 0; i < fruits.length; i++) {

            //assign fruit type to any one type, if type == -1 i.e. not assigned any fruit and current type is
            //not assigned to other type variable
            if (type1 == -1 && type2 != fruits[i]) {
                type1 = fruits[i];
            } else if (type2 == -1 && type1 != fruits[i]) {
                type2 = fruits[i];
            } else if (fruits[i] == type1 || fruits[i] == type2)  {
                //if current fruit type is in basket, count this in and continue
            } else {

                //if new fruit type is found i.e. 3rd type
                //find max of current max and current window
                max = Math.max(max, i-left);

                //reset one of types depending on outgoing fruit i.e. left most fruit
                if (type1 == fruits[left]) {
                    type1 = -1;
                } else {
                    type2 = -1;
                }
                left++;
                //skip fruits of same type
                while (left < i) {
                    if (fruits[left] == fruits[left-1]) {
                        left++;
                    } else {
                        break;
                    }
                }
                i = left-1; // this is required because loop increment will increase the variable
            }
        }

        max = Math.max(max, fruits.length-left);
        return max;
    }
}
