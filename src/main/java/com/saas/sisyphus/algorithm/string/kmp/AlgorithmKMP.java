package com.saas.sisyphus.algorithm.string.kmp;

/**
 * @author zard
 * @date Created in 25/09/2021 07:57
 */
public class AlgorithmKMP {

    public static void main(String[] args) {
        String txt = "ABAAAAAABABAABBBAAAABA";
        String pat = "AAAABA";
        //0，0，1，1，2，0
        AlgorithmKMP.Solution.KMP(txt, pat);
    }

    public static void KMP(String txt, String pat) {
        int T = txt.length();
        int P = pat.length();
        int i = 0;
        int j = 0;
        int[] lsp = new int[P];
        computerLsp(lsp, pat, P);
        while (i < T) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == P) {
                System.out.println(" Found pattern "
                        + "at index " + (i - j));
                j = lsp[j - 1];
            } else if (txt.charAt(i) != pat.charAt(j)
                    && i <= T) {
                if (j != 0) {
                    j = lsp[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private static void computerLsp(int[] lsp, String pat, int P) {
        int i = 0;
        int j = 1;
        while (j < P) {
            if (pat.charAt(i) == pat.charAt(j)) {
                i++;
                lsp[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = lsp[i - 1];
                } else {
                    lsp[i] = i;
                    j++;
                }
            }
        }
        for (int k = 0; k < lsp.length; k++) {
            System.out.println(lsp[k]);
        }
    }
    public static class Solution {

        public static void KMP(String txt, String pat) {
            int T = txt.length();
            int P = pat.length();
            int i = 0;
            int j = 0;
            int[] lsp = new int[P];
            computerLsp(lsp, pat, P);
            while (i < T) {
                if (txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == P) {
                    System.out.println(" Found pattern "
                            + "at index " + (i - j));
                    j = lsp[j - 1];
                } else if (txt.charAt(i) != pat.charAt(j)
                        && i <= T) {
                    if (j != 0) {
                        j = lsp[j - 1];
                    } else {
                        i++;
                    }
                }
            }
        }

        private static void computerLsp(int[] lsp, String pat, int P) {
            int i = 0;
            int j = 1;
            while (j < P) {
                if (pat.charAt(i) == pat.charAt(j)) {
                    i++;
                    lsp[j] = i;
                    j++;
                } else {
                    if (i != 0) {
                        i = lsp[i - 1];
                    } else {
                        lsp[i] = i;
                        j++;
                    }
                }
            }
            for (int k = 0; k < lsp.length; k++) {
                System.out.print(lsp[k]);
            }
        }
    }
}