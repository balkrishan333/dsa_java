package hackerrank.interviewkit.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6,4,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.countSwaps(arr);
    }

    private void countSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swaps++;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Array is sorted in " + swaps +" swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length-1]);
    }
}
