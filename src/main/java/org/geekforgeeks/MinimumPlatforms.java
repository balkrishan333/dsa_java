package org.geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class MinimumPlatforms {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTests = Integer.parseInt(reader.readLine());

        for (int i = 0; i < noOfTests; i++) {
            int trainCount = Integer.parseInt(reader.readLine());
            int[] arrival = new int[trainCount];
            int[] departure = new int[trainCount];

            String[] arrivalArr = reader.readLine().split("\\s+");
            String[] departureArr = reader.readLine().split("\\s+");

            for (int j = 0; j < trainCount; j++) {
                arrival[j] = Integer.parseInt(arrivalArr[j]);
                departure[j] = Integer.parseInt(departureArr[j]);
            }

            MinimumPlatforms platforms = new MinimumPlatforms();
            int count = platforms.count(arrival, departure);
            System.out.println(count);
        }
    }

    int count(int[] arrival, int[] departure) {
        if (arrival.length != departure.length) {
            throw new RuntimeException("Wrong data");
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformCount = 1;
        int trainsOnPlatform = 1;

        if (arrival.length <= 1) {
            return platformCount;
        }
        int i = 0; //pointer to train, which will be first to depart
        for (int j = 1; j < arrival.length; j++) {
            if (arrival[j] <= departure[i]) {
                if (platformCount <= trainsOnPlatform) {
                    platformCount++;
                }
            } else {
                while (i < j && arrival[j] > departure[i]) {
                    i++;
                    trainsOnPlatform--;
                }
            }
            trainsOnPlatform++;
        }
        return platformCount;



    }
}
