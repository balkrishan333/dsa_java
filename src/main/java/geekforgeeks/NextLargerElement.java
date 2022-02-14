package geekforgeeks;

/*
https://www.geeksforgeeks.org/next-greater-element/
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class NextLargerElement {

    private static final Logger logger = LoggerFactory.getLogger(NextLargerElement.class);

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testsCount = Integer.parseInt(reader.readLine());

        long[][] inArrayList = new long[testsCount][];

        for (int i = 0 ; i < testsCount ; i++) {
            String line_1 = reader.readLine();
            String line_2 = reader.readLine();

            String[] line_2_split = line_2.split(" ");

            int inArraySize = Integer.parseInt(line_1);

            long[] inArray = new long[inArraySize];
            for (int ii = 0; ii < inArraySize ; ii++) {
                inArray[ii] = Long.parseLong(line_2_split[ii]);
            }
            inArrayList[i] = inArray;
        }

        NextLargerElement solution = new NextLargerElement();
        for (int i = 0 ; i < testsCount ; i++) {

            long[] arr = inArrayList[i];

            long[] result = solution.nextLarger(arr);
            String resultString = Arrays.toString(result).substring(1).replaceFirst("]", "").replace(", ", " ");
            System.out.println(resultString);
        }
    }

    long[] nextLarger(long[] arr) {

        logger.info("Input arr :" + Arrays.toString(arr));
        Deque<StackElement> stack = new ArrayDeque<>();

        StackElement firstElement = new StackElement(arr[0], 0);
        stack.push(firstElement);

        long[] result = new long[arr.length];
        for (int i = 1 ; i < arr.length ; i++) {
            while (stack.peek() != null && stack.peek().getElement() < arr[i]) {
                StackElement poppedElement = stack.pop();
                result[poppedElement.getIndex()] = arr[i];
            }
            stack.push(new StackElement(arr[i], i));
        }

        result[arr.length-1] = -1; // set -1 for last element
        stack.pop(); // remove last element from stack

        if (stack.size() > 0) {
            for (int i = 0 ; i < result.length ; i++) {
                if (result[i] == 0 ) {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    static class StackElement {
        private long _element;
        private int _index;

        StackElement(long element, int index) {
            _element = element;
            _index = index;
        }

        long getElement() {
            return _element;
        }

        int getIndex() {
            return _index;
        }
    }
}
