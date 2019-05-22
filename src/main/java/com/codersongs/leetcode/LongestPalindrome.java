package com.codersongs.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome2("aaaa"));

    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        int max = 1;
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i > 0 && s.charAt(i-1) == s.charAt(i + 1)){
                int j = 2;
                while (i - j >= 0 && i + j < s.length()){
                    if (s.charAt(i - j) == s.charAt(i + j)){
                        j++;
                        continue;
                    }
                    break;
                }
                if (max < 2*j - 1){
                    start = i - j + 1;
                    max = 2*j - 1;
                }
//                continue;
            }

            if (s.charAt(i) == s.charAt(i+1)){
                int j = 2;
                while (i - j + 1 >= 0 && i + j < s.length()){
                    if (s.charAt(i - j + 1) == s.charAt(i + j)){
                        j++;
                        continue;
                    }
                    break;
                }

                if (max < 2*(j-1)){
                    start = i - j + 2;
                    max = 2 * (j-1);
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
