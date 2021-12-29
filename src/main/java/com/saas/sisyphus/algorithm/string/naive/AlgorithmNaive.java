package com.saas.sisyphus.algorithm.string.naive;


/**
 * @author zard
 * @date Created in 03/10/2021 20:56
 */
public class AlgorithmNaive {

    public static void main(String[] args) {
        String txt = "ABAAAAAABABAABBBAAAABA";
        String pat = "AAAABA";
        //0，0，1，1，2，0
        AlgorithmNaive.Solution.naive(txt, pat);
    }

    public static class Solution {

        public static void naive(String txt, String pat) {
            int T = txt.length();
            int P = pat.length();
            int i = 0;
            int j = 0;
            while (i < T){
                if(txt.charAt(i) == pat.charAt(j)){
                    i ++;
                    j ++;
                }
                if(j == P){
                    System.out.println("Found pattern "
                            + "at index " + (i - j));
                    i = i - j + 1;
                }else if(txt.charAt(i) != pat.charAt(j)){
                    j = 0;
                    i ++;
                }
            }
        }
    }
}
