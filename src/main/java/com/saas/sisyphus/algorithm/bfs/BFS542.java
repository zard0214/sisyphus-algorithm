package com.saas.sisyphus.algorithm.bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zard
 * @date Created in 30/09/2021 17:01
 */
public class BFS542 {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0} ,
                {1,1,1}};
        int[][] ints = Solution.updateMatrix(mat);
        for(int i = 0; i < Solution.M; i++){
            for(int j = 0; j < Solution.N; j++){
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        private static int M;
        private static int N;
        private static int dirs[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}, res[][];
        private static boolean visited[][];

        public static int[][] updateMatrix(int[][] mat) {
            M = mat.length;
            N = mat[0].length;
            res = new int[M][N];
            visited = new boolean[M][N];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(mat[i][j] == 0){
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            return bfs(queue, mat, visited, res, dirs);
        }

        private static int[][] bfs(Queue<int[]> queue, int[][] mat, boolean[][] visited, int[][] res, int[][] dirs) {
            int cost = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    int[] cur = queue.poll();
                    int i = cur[0], j = cur[1];
                    if(mat[i][j] == 1){
                        res[i][j] = cost;
                    }
                    for (int[] dir: dirs
                    ) {
                        int x = i + dir[0],y = j + dir[1];
                        if(x >= 0 && x < M && y >= 0 && y < N && !visited[x][y]){
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;
                        }
                    }
                }
                cost ++;
            }
            return res;
        }


    }

}
