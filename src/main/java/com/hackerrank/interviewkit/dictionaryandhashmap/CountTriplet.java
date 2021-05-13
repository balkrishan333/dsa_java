package com.hackerrank.interviewkit.dictionaryandhashmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplet {

    public static void main(String[] args) throws Exception {
     /*   List<Long> arr = Arrays.asList(1L,1L,1L,1L,1L);
        int r = 1;

        CountTriplet triplet = new CountTriplet();
        long result = triplet.count(arr, r);
        System.out.println("result = " + result);
*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\ba004na\\Documents\\count-trplet.txt"))));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = new CountTriplet().count(arr, r);

        bufferedReader.close();
        System.out.println("ans = " + ans);

    }

    public long count(List<Long> arr, long r) {
        Map<Long,Long> leftMap = new HashMap<>();
        Map<Long,Long> rightMap = new HashMap<>();
        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            rightMap.merge(arr.get(i), 1L, Long::sum);
        }

        for (int i = 0; i < arr.size(); i++) {
            rightMap.merge(arr.get(i), -1L, Long::sum);

            long left = 0;
            if (arr.get(i)%r == 0) {
                left = leftMap.getOrDefault(arr.get(i)/r, 0L);
            }

            long right = rightMap.getOrDefault(arr.get(i)*r, 0L);
            count = count + (left *right);

            leftMap.merge(arr.get(i), 1L, Long::sum);
        }
        return count;
    }
}
