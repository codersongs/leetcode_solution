package com.codersongs.leetcode;

import org.omg.CORBA.INTERNAL;

/**
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInt {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE + Integer.MAX_VALUE;
//        System.out.println(a);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.parseInt("2147483647"));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Double.MAX_VALUE );
//        System.out.println((int) Math.pow(10, 3));
        System.out.println(reverse(-2147483412));
    }

    /**
     * 反转数字
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE){
            return 0;
        }
        boolean isNegative = false;
        if (x < 0){
            x = -x;
            isNegative = true;
        }

        String s = x + "";
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        Long result =  Long.parseLong(builder.toString());

        if (isNegative){
            if (result + Integer.MIN_VALUE > 0){
                return 0;
            }
        }else {
            if (result > Integer.MAX_VALUE){
                return  0;
            }
        }
        return (int) (isNegative ? -1 * result : result);
    }
}
