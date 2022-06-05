package com.saas.sisyphus.algorithm.dynamic;

/**
 * @author zard
 * @date Created in 05/06/2022 01:06
 */
public class Fibonacci {

    //recursion
    public static int fib(int n) {
        if(n < 2) return n;
        int prev = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }

    //dynamic programming
    public static int fibonacci(int n) {
        int dp[] = new int[n + 1];
        return CalculateFibonacciRecursive(dp, n);
    }

    public static int CalculateFibonacciRecursive(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] == 0)
            dp[n] = CalculateFibonacciRecursive(dp, n - 1) + CalculateFibonacciRecursive(dp, n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(fib(30));
        System.out.println(fibonacci(30));
    }

}
