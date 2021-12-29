package com.saas.sisyphus.algorithm.sort.bucketsort;

/**
 * @author zard
 * @date Created in 27/09/2021 06:13
 */
public class AlgorithmBucketSort {

    public static void main(String[] args) {

    }

    public static class Solution {
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++)
                for (int j = 0; j < n - i - 1; j++)
                    if (arr[j] > arr[j + 1]) {
                        // swap arr[j+1] and arr[j]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
        }

        /* Prints the array */
        public static void printArray(int arr[]) {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
