package com.hackerrank.interviewkit.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FraudulentActivityNotifications {

    private static Logger logger = LoggerFactory.getLogger(FraudulentActivityNotifications.class);

    public static void main(String[] args) throws Exception {
//        int trailingDays = 5;
//        int[] arr = {2, 3, 4, 2, 3, 6, 8, 4, 5}; //2
//        int trailingDays = 4;
//        int[] arr = {1, 2, 3, 4, 4}; //0
//        int trailingDays = 3;
//        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3}; //1
//        int trailingDays = 3;
//        int[] arr = {8,7,6,5,4,3,2,1}; //0
//         int trailingDays = 3;
//        int[] arr = {1,2,3,4,5,6,7,8}; //1
         int trailingDays = 4;
        int[] arr = {1,2,3,4,4}; //0


        FraudulentActivityNotifications activityNotifications = new FraudulentActivityNotifications();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\ba004na\\Desktop\\new 2")));
        String line1 = reader.readLine();
        trailingDays = Integer.parseInt(line1.split(" ")[1]);
        int arraySize = Integer.parseInt(line1.split(" ")[0]);

        arr = new int[arraySize];
        String[] numbers = reader.readLine().split(" ");

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        int notificationCount = activityNotifications.countNotifications(arr, trailingDays);
        System.out.println("notificationCount = " + notificationCount);
    }

    public int countNotifications(int[] arr, int trailingDays) {

        if (arr.length + 1 < trailingDays) {
            return 0;
        }

        int notificationCount = 0;
        int[] elementCount = new int[201]; //elements can range from 0 to 200
        int medianIndex1 , medianIndex2 = -1;

        if (trailingDays % 2 == 0) {
            medianIndex1 = (trailingDays/2) -1;
            medianIndex2 = medianIndex1+1;
        } else {
            medianIndex1 = trailingDays/2;
        }

        for (int i = 0; i < trailingDays; i++) {
            elementCount[arr[i]]++;
        }

        for (int i = trailingDays; i < (arr.length) ; i++) {
            float median = findMedian(elementCount, medianIndex1, medianIndex2);
            if (2* median <= arr[i]) {
                notificationCount++;
            }

            //kick out first element in queue and pull next element
            elementCount[arr[i-trailingDays]]--;
            elementCount[arr[i]]++;
        }
        return notificationCount;
    }

    private float findMedian(int[] elementCount, int medianIndex1, int medianIndex2) {
        int count = 0;
        float median = 0;
        for (int i = 0; i < elementCount.length; i++) {
            count += elementCount[i];
            if (count >= medianIndex1+1) { // +1 because count starts from 1 and index starts from 0
                median = i;
                if (medianIndex2 != -1) {
                    if (count >= medianIndex2+1) {
                        return median;
                    }
                    //count < medianIndex2
                    int j = i+1;
                    while (elementCount[j] == 0){
                        j++;
                    }
                    median = (median+j)/2;
                    return median;
                } else {
                    return median;
                }
            }
        }
        return median;
    }
}
