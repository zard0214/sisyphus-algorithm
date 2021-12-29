package com.saas.sisyphus.algorithm.sort.selectionsort;

/**
 * @author zard
 * @date Created in 27/09/2021 06:14
 */
public class AlgorithmSelectionSort {

    // Driver code to test above
    public static void main(String args[]) {
        int arr[] = {64,25,12,22,11};
        AlgorithmSelectionSort.Solution.SelectionSort(arr);
        System.out.println("Sorted array");
        AlgorithmSelectionSort.Solution.printArray(arr);
    }

    public static class Solution {

        public static void SelectionSort(int arr[]) {
            int n = arr.length;
            for (int i = 0; i < n-1; i++) {
                // Find the minimum element in unsorted array
                int minIdx = i;
                for (int j = i+1; j < n; j++)
                    if (arr[j] < arr[minIdx])
                        minIdx = j;
                // Swap the found minimum element with the first
                // element
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
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
