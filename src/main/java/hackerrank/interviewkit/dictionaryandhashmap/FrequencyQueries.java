package hackerrank.interviewkit.dictionaryandhashmap;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> answer = new LinkedList<>();
        // element is key and count is value
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        // element count is key and no of times that count occurs is value
        Map<Integer, Integer> elementFrequencyMap = new HashMap<>();

        for (List<Integer> list : queries) {
            int query = list.get(0);
            int val = list.get(1);
            if (query == 1) {
                int oldCount = elementCountMap.getOrDefault(val, 0);
                elementCountMap.merge(val, 1, Integer::sum); //increase the count of element
                elementFrequencyMap.merge(elementCountMap.get(val), 1, Integer::sum); // increase the frequency of count
                if (oldCount > 0) {
                    elementFrequencyMap.merge(oldCount, -1, Integer::sum);
                }
            } else if (query == 2) {
                int oldCount = elementCountMap.getOrDefault(val, 0);
                if (oldCount > 0) {
                    elementCountMap.merge(val, -1, Integer::sum);
                    elementFrequencyMap.merge(elementCountMap.get(val), 1, Integer::sum);
                    elementFrequencyMap.merge(oldCount, -1, Integer::sum);
                }
            } else {
                if (elementFrequencyMap.getOrDefault(val, 0) > 0) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        /*List<List<Integer>> queries = new ArrayList<>();

        List<Integer> q1 = new ArrayList<>();
        q1.add(1);
        q1.add(5);
        List<Integer> q2 = new ArrayList<>();
        q2.add(1);
        q2.add(6);
        List<Integer> q3 = new ArrayList<>();
        q3.add(3);
        q3.add(2);
        List<Integer> q4 = new ArrayList<>();
        q4.add(1);
        q4.add(10);
        List<Integer> q5 = new ArrayList<>();
        q5.add(1);
        q5.add(10);
        List<Integer> q6 = new ArrayList<>();
        q6.add(1);
        q6.add(6);
        List<Integer> q7 = new ArrayList<>();
        q7.add(2);
        q7.add(5);
        List<Integer> q8 = new ArrayList<>();
        q8.add(3);
        q8.add(2);

        queries.add(q1);
        queries.add(q2);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);
        queries.add(q6);
        queries.add(q7);
        queries.add(q8);*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\ba004na\\Documents\\Frequency-queries.txt"))));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        /*bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println("freqQuery(queries) = " + freqQuery(queries));
        System.out.println("size = " + freqQuery(queries).size());

    }
}

