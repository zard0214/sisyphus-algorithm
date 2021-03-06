package com.saas.sisyphus.algorithm.knapsack;

/**
 * @author zard
 * @date Created in 28/04/2022 23:55
 */
public class Knapsack01 {
    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 120, 60, 100 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
//
//    private static int knapSack(int w, int[] wt, int[] val, int n) {
//        if(w == 0 || n == 0)
//            return 0;
//        if(wt[n - 1] > w)
//            return knapSack(w, wt, val, n - 1);
//        else
//            if(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1) >  knapSack(w, wt, val, n - 1)){
//                return val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1);
//            }else{
//                return knapSack(w, wt, val, n - 1);
//            }
//    }
}
