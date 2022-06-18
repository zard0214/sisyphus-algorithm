package com.saas.sisyphus.algorithm.dfs;

import java.util.Arrays;

/**
 * @author zard
 * @date Created in 30/09/2021 17:01
 */
public class DP1025 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1} , {1,5,1} , {4,2,1}};
        System.out.println(Solution.minPathSum(grid));
    }

    static class Solution {
        private static int M;
        private static int N;
        private static int memo[][];

        public static int minPathSum(int[][] grid) {
            M = grid.length;
            N = grid[0].length;
            memo = new int[M][N];
            for(int i = 0 ; i < M ; i ++){
                Arrays.fill(memo[i], -1);
            }
            return dfs(grid, 0 , 0);
        }

        private static int dfs(int[][] grid, int r, int d){
            if(r < 0 || r >= M || d < 0 || d >= N){ return Integer.MAX_VALUE; }
            if(memo[r][d] > -1) return memo[r][d];
            if(r == M - 1 && d == N - 1)  return grid[r][d];
            int right = dfs(grid, r, d + 1);
            int down = dfs(grid, r + 1, d);
            int ans = Math.min(right, down) + grid[r][d];
            memo[r][d] = ans;
            return ans;
        }
    }
}
