package geekforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public final class ReverseArrayInGroups {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());

        ReverseArrayInGroups reverseArrayInGroups = new ReverseArrayInGroups();
        for (int i = 0; i < noOfTests; i++) {
            String[] sizes = reader.readLine().split(" ");
            int arraySize = Integer.parseInt(sizes[0]);
            int groupSize = Integer.parseInt(sizes[1]);

            int[] arr = new int[arraySize];
            String arrStr = reader.readLine();

            arr = Arrays.stream(arrStr.split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] result = reverseArrayInGroups.run(arr, groupSize);

            PrintWriter writer = new PrintWriter(System.out);
            for (int j = 0 ; j < result.length ; j++) {
                writer.print(result[j] + " ");
            }
            writer.println();
            writer.flush();
        }
    }

    int[] run(int[] arr, int groupSize) {
        int groups = arr.length/groupSize;
        int[] result = new int[arr.length];

        for (int i = 0; i < groups; i++) {
            int index = i * groupSize;
            int[] subArr = Arrays.copyOfRange(arr, i*groupSize, groupSize*i+groupSize);
            for (int j = subArr.length-1; j >= 0; j--) {
                result[index++] = subArr[j];
            }
        }

        int index = groups*groupSize;
        for (int i = arr.length-1; i >= groups*groupSize; i--) {
            result[index++] = arr[i];
        }

        return result;
    }
}
