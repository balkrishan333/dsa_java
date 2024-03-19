package leetcode;

import java.util.*;

public class _621_TaskScheduler {

    public static void main(String[] args) {
        _621_TaskScheduler obj = new _621_TaskScheduler();

        char[] tasks = {'A','C','A', 'B','D','B'};
        int n = 1;
        System.out.println(obj.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        // Build frequency map
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !pq.isEmpty()) { //iterate until either pq is empty (in which case there is nothing tp process) or
                // cycle > 0 that means only take out elements equal to n after that start the cycle and allocate to task to most
                // frequent element.
                int currentFreq = pq.poll();
                if (currentFreq > 1) {
                    store.add(currentFreq - 1); //add to queue only if element needs to repeat
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            store.forEach(pq::offer);
            // Add time for the completed cycle
            time += (pq.isEmpty() ? taskCount : n + 1); //if pq is empty, that mean we have processed all the tasks and take that or else
            // take cycle (n+1) which mean these are the number of tasks we performed in this cycle
        }
        return time;
    }
}
