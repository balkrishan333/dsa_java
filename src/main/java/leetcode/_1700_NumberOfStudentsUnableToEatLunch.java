package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _1700_NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        _1700_NumberOfStudentsUnableToEatLunch obj = new _1700_NumberOfStudentsUnableToEatLunch();

        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(obj.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> sandwichesStack = new ArrayDeque<>();
        Queue<Integer> studentsQueue = new ArrayDeque<>();

        int len = sandwiches.length; // students and sandwiches are equal

        for (int i = 0; i < len; i++) {
            sandwichesStack.push(sandwiches[len-i-1]);
            studentsQueue.add(students[i]);
        }

        int lastServed = 0;
        while (!studentsQueue.isEmpty() && lastServed < studentsQueue.size()) {
            if (studentsQueue.peek() == sandwichesStack.peek()) {
                sandwichesStack.pop();
                studentsQueue.remove();
                lastServed = 0;
            } else {
                studentsQueue.offer(studentsQueue.remove());
                lastServed++;
            }
        }
        return studentsQueue.size();
    }
}
