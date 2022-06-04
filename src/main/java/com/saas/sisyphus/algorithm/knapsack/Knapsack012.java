package com.saas.sisyphus.algorithm.knapsack;

/**
 * @author zard
 * @date Created in 28/04/2022 23:55
 */
public class Knapsack012 {
    public static void main(String[] args) {
        int totalweight = 4;
        int values[] = {1500, 3000, 2000};
        int weights[] = {1, 4, 3};
        System.out.println(bag(totalweight,weights,values));
        System.out.println(bag01(totalweight, weights, values));
    }


    //二维数组实现背包问题
    public static int bag(int totalV, int[] weights, int[] values) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int n = weights.length;
        int m = totalV;
        //创建二维数组，v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //初始化第一行和第一列，这里本程序可以不用处理，因为默认就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0
        }
        for (int j = 0; j < v[0].length; j++) {
            v[0][j] = 0; //第一行设置为0
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (weights[i-1] > j) {//weights[i-1]表示第一件物品的重量
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j]=Math.max(v[i-1][j],v[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return v[n][m];

    }

    //非递归一纬数组 totalV是背包的容量
    public static int bag01(int totalV, int[] weights, int[] values) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int goodsNum = weights.length;
        int f[] = new int[totalV + 1];
        for (int i = 0; i < goodsNum; i++) {
            int w = weights[i];
            int v = values[i];
            for (int j = totalV; j >= w; j--) {
                f[j] = Math.max(f[j], f[j - w] + v);
                //f[j]表示：前i个物品放入容量为j的背包的最大价值
            }
        }
        return f[totalV];
    }

}
