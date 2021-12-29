package com.saas.sisyphus.algorithm.sort.insertionsort;


/**
 * @author zard
 * @date Created in 27/09/2021 06:13
 */
public class AlgorithmInsertionSort {

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
//        AlgorithmInsertionSort.Solution.insertionSort(arr);
//        AlgorithmInsertionSort.Solution.printArray(arr);
        AlgorithmInsertionSort.Solution.recursiveInsertionSort(arr, 0 , 0 , arr.length);
        AlgorithmInsertionSort.Solution.printArray(arr);
    }

    public static class Solution {

        public static void recursiveInsertionSort(int b[],int m,int n,int length){
            if(n == length)
                return;
            if(m == 0)
                return;
            if (b[m] > b[m - 1] && m>=1){
                swap(b, m, m - 1);
                recursiveInsertionSort(b, n,m - 1, length);
            }
            if (b[n] <= b[m]){
                recursiveInsertionSort(b, n+1,n + 1, length);
            }

        }

        public static void swap(int a[], int i, int j) {
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        public static void insertionSort(int[] arr) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }

        /* Prints the array */
        public static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}


