package com.saas.sisyphus.algorithm.knapsack;

import java.util.Scanner;

/**
 * @author zard
 * @date Created in 29/04/2022 18:28
 */
public class UnboundedKnapsack {

    private static int max(int i, int j)
    {
        return (i > j) ? i : j;
    }

    // Returns the maximum value with knapsack
    // of W capacity
    private static int unboundedKnapsack(int W, int n,
                                         int[] val, int[] wt) {

        // dp[i] is going to store maximum value
        // with knapsack capacity i.
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for(int i = 0; i <= W; i++){
            for(int j = 0; j < n; j++){
                if(wt[j] <= i){
                    dp[i] = max(dp[i], dp[i - wt[j]] +
                            val[j]);
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println("dp[" + i + "]: "+ dp[i]);
//        }
        return dp[W];
    }

    static int N = 1010;
    static int n, bagVolume;
    static int[] volume = new int[N];
    static int[] worth = new int[N];
    static int[][] dp = new int[N][N];

    // Driver program
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bagVolume = sc.nextInt();
        //一定要注意，输入输出版的背包问题，2个数组都是从第二个数开始填入的
        for (int i = 1; i <= n; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= bagVolume; j++)
                for (int k = 0;k*volume[i]<=j;k++)
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-k*volume[i]]+worth[i]);
        System.out.println(dp[n][bagVolume]);
    }

}
