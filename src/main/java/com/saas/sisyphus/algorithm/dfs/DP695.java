package com.saas.sisyphus.algorithm.dfs;


/**
 * @author zard
 * @date Created in 30/09/2021 17:01
 */
public class DP695 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0} ,
                {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(Solution.maxAreaOfIsland(grid));
    }

    static class Solution {
        private static int M;
        private static int N;
        private static int memo[][];

        public static int maxAreaOfIsland(int[][] grid) {
            M = grid.length;
            N = grid[0].length;
            int max = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
            return max;
        }

        public static int dfs(int[][] grid, int r, int d){
            if(!(r >= 0 && r <= M - 1) || !(d >= 0 && d <= N - 1) || grid[r][d] == 0)
                return 0;
            grid[r][d] = 0;
            int right = dfs(grid, r , d  + 1);
            int left = dfs(grid, r, d - 1);
            int down = dfs(grid, r + 1, d);
            int up = dfs(grid, r - 1, d);
            return right + left + down + up + 1;
        }
//
//        private static int dfs(int[][] grid, int r, int d) {
//            if (!(r >= 0 && r <= M - 1) || !(d >= 0 && d <= N - 1)) {
//                return 0;
//            }
//            int right = dfs(grid, r , d  + 1);
//            int left = dfs(grid, r, d - 1);
//            int down = dfs(grid, r + 1, d);
//            int up = dfs(grid, r - 1, d);
//            return right + left + down + up + 1;
//        }

//        private static int dfs(int[][] grid, int l, int u, int r, int d, int max) {
//            if (!(r >= 0 && r <= M - 1) || !(d >= 0 && d <= N - 1)) {
//                return 0;
//            }
//            if (memo[r][d] == 1)
//                return 0;
//            memo[r][d] = 1;
//            if(grid[r][d] == 1)
//                return 1;
//            int ans = max;
//            int left = dfs(grid, l + 1, u, r, d, max);
//            int up = dfs(grid, l, u + 1, r, d, max);
//            int right = dfs(grid, l, u, r + 1, d, max);
//            int down = dfs(grid, l, u, r , d  + 1, max);
//            if(left != 1 && up != 1 && right != 1 && down != 1)
//                return 0;
//            int max1 = Math.max(left, up);
//            int max2 = Math.max(right, down);
//            int max3 = Math.max(max1, max2);
//            ans = Math.max(max, max3) + grid[r][d];
//            memo[r][d] = 0;
//            return ans;
//        }

    }
}
