package geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeadersInArray {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());
        LeadersInArray leaders = new LeadersInArray();
        PrintWriter writer = new PrintWriter(System.out);

        for (int i = 0; i < noOfTests; i++) {
            int arrSize = Integer.parseInt(reader.readLine());
            int[] arr = new int[arrSize];

            String[] eleStrArr = reader.readLine().split("\\s+");
            for (int j = 0; j < arrSize; j++) {
                arr[j] = Integer.parseInt(eleStrArr[j]);
            }
            int[] result = leaders.find(arr);
            StringBuilder builder = new StringBuilder();
            Arrays.stream(result).forEach(element -> {
                builder.append(element).append(" ");
            });
            builder.append("\n");
            writer.write(builder.toString());
            writer.flush();
        }
    }

    int[] find(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]); // push first element

        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            while (stack.peek()!= null && stack.peek() < currentElement) {
                stack.pop();
            }
            stack.push(currentElement);
        }

        int resultSetSize = stack.size();
        int[] result = new int[resultSetSize];
        for (int i = 0; i < resultSetSize; i++) {
            result[i] = stack.removeLast();
        }
        return result;
    }
}
