package com.codersongs.leetcode;

import java.util.Map;

/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 示例 1:

 输入: "bcabc"
 输出: "abc"

 示例 2:

 输入: "cbacdcbc"
 输出: "acdb"


 * @author wusongsong
 * @date 2019/5/24
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 0) {
            return "";
        }else{
            int[] count=new int[26];
            for(int i = 0;i < s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            int pos=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)<s.charAt(pos)){
                    pos=i;
                }
                count[s.charAt(i)-'a']--;
                if(count[s.charAt(i)-'a']==0){
                    break;
                }
            }
            String res = s.charAt(pos)+ removeDuplicateLetters(s.substring(pos+1).replace(""+s.charAt(pos),""));
            return res;
        }
    }

}
