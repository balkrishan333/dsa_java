package com.hackerrank;

/*
https://www.hackerrank.com/challenges/fair-rations/problem
 */
public final class FindRations {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};

        FindRations findRations = new FindRations();
        String result  = findRations.find(arr);
        System.out.println("result = " + result);
    }

    String find(int[] arr) {
        int count = 0;
        for (int i = 0 ; i < arr.length -1 ; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
                arr[i+1]++;
                count +=2;
            }
        }
        if (arr[arr.length-1] %2 == 0) {
            return String.valueOf(count);
        }
        return "NO";
    }
}
