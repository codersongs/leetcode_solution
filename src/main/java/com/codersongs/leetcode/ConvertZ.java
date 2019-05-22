package com.codersongs.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ConvertZ {

    public static void main(String[] args) {
//        System.out.println(convert("LEETCODEISHIRING", 3));
//        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("ABC", 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int base = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                int mod = j % base;
                int row = 0;
                if (mod < numRows){
                    row = mod;
                }else {
                    row = 2 * numRows - mod - 2;
                }
                //字符串的所属行等于行号
                if (row == i){
                    builder.append(s.charAt(j));
                }
            }

        }
        return builder.toString();
    }
}
