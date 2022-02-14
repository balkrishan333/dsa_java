package geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_012 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int i = 0; i < noOfTests; i++) {
            int elementCount = Integer.parseInt(reader.readLine());
            String[] elementStrArr = reader.readLine().split(" ");

            int[] arr = new int[elementCount];
            for (int j = 0; j < elementCount; j++) {
                arr[j] = Integer.parseInt(elementStrArr[j]);
            }

            Sort_012 solution = new Sort_012();
            solution.sort(arr);
            Arrays.stream(arr).forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        }
    }

    void sort(int[] arr) {
        int count0 =0, count1=0, count2=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        for (int i = count0; i < count0+count1; i++) {
            arr[i] = 1;
        }

        for (int i = count0+count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }
}
