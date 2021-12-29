package com.saas.sisyphus.algorithm.string.bf;

/**
 * @author zard
 * @date Created in 25/09/2021 08:06
 */
public class AlgorithmBruteForce {

    public static void main(String[] args) {
        String s1 = "ggggggoogleggoogleoogl";
        String s2 = "google";
        int postion = AlgorithmBruteForce.Solution.BruteForce(s1, s2);
        System.out.println(postion);
    }

    static class Solution {

        public static int search(String text, String pattern) {
            int N = text.length();
            int M = pattern.length();
            for (int i = 0; i < N-M; i++) {
                int j;
                for (j = 0; j < M; j++) {
                    if (text.charAt(i+j) != pattern.charAt(j))
                        break;
                }
                if (j == M) return i;
            }

            return -1;
        }

        public static int BruteForce(String s1, String s2){
            int i = 0;
            int j = 0;
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            while (i < chars1.length
                    && j < chars2.length){
                if(chars1[i] == chars2[j]){
                    i ++;
                    j ++;
                }else{
                    i = i - j + 1;
                    j = 0;
                }
            }
            if(j == chars2.length){
                return i - chars2.length;
            }
            return -1;
        }
    }
}
