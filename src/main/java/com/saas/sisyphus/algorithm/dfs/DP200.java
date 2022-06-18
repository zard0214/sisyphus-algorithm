package com.saas.sisyphus.algorithm.dfs;


/**
 * @author zard
 * @date Created in 30/09/2021 17:01
 */
public class DP200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'} , {'1','1','0','0','0'} ,
                {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(Solution.numIslands(grid));
    }

    static class Solution {
        private static int M;
        private static int N;
        private static int memo[][];

        public static int numIslands(char[][] grid) {
            M = grid.length;
            N = grid[0].length;
            int max = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(dfs(grid, i, j) > 0){
                        max++;
                    }
                }
            }
            return max;
        }

        public static int dfs(char[][] grid, int r, int d){
            if(!(r >= 0 && r <= M - 1) || !(d >= 0 && d <= N - 1) || grid[r][d] == '0')
                return 0;
            grid[r][d] = '0';
            int right = dfs(grid, r , d  + 1);
            int left = dfs(grid, r, d - 1);
            int down = dfs(grid, r + 1, d);
            int up = dfs(grid, r - 1, d);
            return right + left + down + up + 1;
        }
    }
}
