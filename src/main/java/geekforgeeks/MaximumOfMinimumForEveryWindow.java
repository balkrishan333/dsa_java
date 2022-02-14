package geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class MaximumOfMinimumForEveryWindow {

    private static final Logger logger = LoggerFactory.getLogger(MaximumOfMinimumForEveryWindow.class);

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        int[][] inArrayList = new int[testsCount][];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            int arraySize = Integer.parseInt(line_1);

            String line_2 = reader.readLine();
            String[] line_2_split = line_2.split(" ");

            int[] inArray = new int[arraySize];
            for (int ii = 0; ii < arraySize ; ii++) {
                inArray[ii] = Integer.parseInt(line_2_split[ii]);
            }
            inArrayList[i] = inArray;
        }

        for (int i = 0 ; i < testsCount ; i++) {

            int[] inArray = inArrayList[i];

            MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
            int[] result = solution.findMaximum(inArray);

            String resultString = Arrays.toString(result).substring(1).replaceFirst("]", "").replace(", ", " ");
            logger.info("Result : " + Arrays.toString(result));

        }
    }

    int[] findMaximum(int[] arr) {

        logger.info("arr : " + Arrays.toString(arr));

        //step1: Find next(right) minimum and previous(left) minimum for every element
        int[] nextMin = findNextMin(arr);
        logger.info("Next min index : " + Arrays.toString(nextMin));

        int[] prevMin = findPrevMin(arr);
        logger.info("Prev min index : " + Arrays.toString(prevMin));

        //step2: Find direct maximums of length i
        int[] ans = new int[arr.length+1];
        for (int i = 0 ; i < arr.length; i++) {
            int len = nextMin[i] - prevMin[i] -1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        logger.info("After first pass: " + Arrays.toString(ans));

        //step3: Fill in leftovers from right
        for (int i = arr.length-1 ; i >=0 ; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return Arrays.copyOfRange(ans,1, ans.length);
    }

    private int[] findNextMin(int[] arr) {

        int notFoundIndex = arr.length; // index in case no min. is found for any element in a direction

        Deque<StackItem> stack = new ArrayDeque<>();
        stack.push(new StackItem(arr[0], 0)); //push start element in stack
        int[] indexes = new int[arr.length];

        for (int i = 1; i <= arr.length-1 ; i++) {
            // top of stack is less than incoming element
            while (stack.peek() != null && stack.peek().getItem() > arr[i]) {
                indexes[stack.pop().getIndex()] = i;
            }
            stack.push(new StackItem(arr[i], i));
        }

        while (stack.peek() != null) {
            indexes[stack.pop().getIndex()] = notFoundIndex;
        }
        return indexes;
    }

    private int[] findPrevMin(int[] arr) {

        int notFoundIndex = -1; // index in case no min. is found for any element in a direction

        Deque<StackItem> stack = new ArrayDeque<>();
        stack.push(new StackItem(arr[arr.length-1], arr.length-1)); //push start element in stack
        int[] indexes = new int[arr.length];

        for (int i = arr.length-2; i >= 0 ; i--) {
            // top of stack is less than incoming element
            while (stack.peek() != null && stack.peek().getItem() > arr[i]) {
                indexes[stack.pop().getIndex()] = i;
            }
            stack.push(new StackItem(arr[i], i));
        }

        while (stack.peek() != null) {
            indexes[stack.pop().getIndex()] = notFoundIndex;
        }
        return indexes;
    }

   static class StackItem {
        private int _item;
        private int _index;

        StackItem(int item, int index) {
            _item = item;
            _index = index;
        }

        int getItem() {
            return _item;
        }

        int getIndex() {
            return _index;
        }
    }
}
