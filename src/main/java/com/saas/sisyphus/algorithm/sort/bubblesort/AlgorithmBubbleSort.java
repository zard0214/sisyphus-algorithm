package com.saas.sisyphus.algorithm.sort.bubblesort;


/**
 * @author zard
 * @date Created in 27/09/2021 06:05
 */
public class AlgorithmBubbleSort {

    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
//        AlgorithmBubbleSort.Solution.bubbleSort(arr);
//        AlgorithmBubbleSort.Solution.printArray(arr);

        AlgorithmBubbleSort.Solution.recursiveBubbleSort(6, 0 , 0, arr);
        for (int i = 0; i < 6; i++) {
            System.out.println(arr[i]);
        }
    }

    public static class Solution {

        public static void recursiveBubbleSort(int n,int i,int j,int a[]){
            if(i >= n)
                return;
            else if(j>=n-i){
                i ++;
                j = 0;
            }
            if(a[j] < a[j+1])
                swap(a, j, j + 1);
            recursiveBubbleSort(n,i,j+1,a);
        }

        public static void swap(int a[], int i, int j) {
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

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
