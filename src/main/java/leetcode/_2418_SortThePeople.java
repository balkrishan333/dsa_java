package leetcode;

import java.util.*;

public class _2418_SortThePeople {

    public static void main(String[] args) {
        _2418_SortThePeople obj = new _2418_SortThePeople();

        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(obj.sortPeople(names, heights)));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            personList.add(new Person(names[i], heights[i]));
        }
        personList.sort(Comparator.comparingInt(Person::height).reversed());
        String[] answer = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            answer[i] = personList.get(i).name();
        }

        return answer;
    }

    record Person(String name, int height){}
}
