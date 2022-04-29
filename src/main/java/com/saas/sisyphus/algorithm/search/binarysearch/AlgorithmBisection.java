package com.saas.sisyphus.algorithm.search.binarysearch;

/**
 * @author zard
 * @date Created in 25/10/2021 15:44
 */
public class AlgorithmBisection {

    public static void main(String[] args) {
        int array[] = {0, 1,3,5,6,8,10};
        System.out.println("index: " + bisectionSearch(array, 0));
        System.out.println("index: " +  binarySearch(array, 0, array.length - 1, 3));
        System.out.println(binarySearch(array, 0, array.length - 1, 3));
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    static int bisection(int array[], int left, int right, int k){
        int m = (left + right) / 2;
        if(left > right){
            return  - 1;
        }
        if(array[m] == k){
            return m;
        }else{
            if(array[m] < k){
                return bisection(array, m + 1, right, k);
            }else{
                return bisection(array, left, m - 1, k);
            }
        }
    }

    static int bisectionSearch(int array[], int k){
        return bisection(array, 0 , array.length - 1, k);
    }
//
//    static int thirdsectionsection(int array[], int left, int right, int mid1, int mid2){
//        int m = (left + right) / 2;
//        if(left > right){
//            return  - 1;
//        }
//        if(array[m] == mid1){
//            return m;
//        }else{
//            if(array[m] < mid2){
//                return thirdsectionsection(array, m + 1, right, mid1 + 1, mid2 - 1);
//            }else{
//                return thirdsectionsection(array, left, m - 1, mid1, mid2);
//            }
//        }
//    }
//
//    static int thirdsectionSearch(int array[], int k, int mid1, int mid2){
//        return bisection(array, 0, mid1 - 1, mid2 + 1);
//    }
}
