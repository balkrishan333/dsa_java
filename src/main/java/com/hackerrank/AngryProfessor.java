package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
https://www.hackerrank.com/challenges/angry-professor/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 */
public final class AngryProfessor {

    public static void main(String[] args) throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int i = 0 ; i < noOfTests ; i++) {
            String line_1 = reader.readLine();
            String timeStr = reader.readLine();

            String[] line_1_split = line_1.split(" ");
            int noOfStudents = Integer.parseInt(line_1_split[0]);
            int threshold = Integer.parseInt(line_1_split[1]);

            int[] studentTimes = new int[noOfStudents];
            String[] timeArr = timeStr.split(" ");

            PrintWriter writer = new PrintWriter(System.out);
            for (int j = 0; j < noOfStudents ; j++) {
                studentTimes[j] = Integer.parseInt(timeArr[j]);
            }

            AngryProfessor professor = new AngryProfessor();
            String cancelled = professor.isCancelled(studentTimes, threshold);
            writer.println(cancelled);
            writer.flush();
        }
    }

    String isCancelled(int[] studentTimes, int threshold) {
        int count = 0;
        for (int i = 0 ; i < studentTimes.length ; i++) {
            if (studentTimes[i] <= 0) {
                count++;
            }
            if (count == threshold) {
                return "NO";
            }
        }
        System.out.println("count = " + count);
        return "YES";
    }
}
