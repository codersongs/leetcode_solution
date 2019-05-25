package com.codersongs.leetcode;

/**
 * @author wusongsong
 * @date 2019/5/23
 */
public class RearrangeString {
    public static void main(String[] args) {
//        rearrangeString("aabbcc", 3);
        System.out.println("finish:" + rearrangeString2("aabbcc", 3));
        System.out.println("finish:" + rearrangeString2("abb", 2));
//        System.out.println((char)66);

//        System.out.println("finish:" + rearrangeString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc", 2));
    }

    public static String rearrangeString2(String s, int k) {
        if (k == 0){
            return s;
        }
        int[] array = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i);
            array[index] += 1;
        }
        char[] result = new char[s.length()];
        int size = s.length() % k == 0 ? k : s.length() % k;
        int[] longArray = new int[size];
        for (int i = 0; i < longArray.length; i++) {
            longArray[i] = -1;
        }
        int index = k-1;
        int traverse = k-1;
        int longIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int groupNum = (s.length() + k - 1) / k;
            if (array[i] > groupNum){
                return "";
            }
            if (array[i] == groupNum){
                if (longIndex > longArray.length - 1){
                    return "";
                }
                longArray[longIndex++] = i;
                continue;
            }
            for (int j = 1; j <= array[i]; j++) {
                result[index] = (char)i;
                index += k;
                if (index > result.length - 1){
                    traverse--;
                    index = traverse;
                }
            }
        }
        int resultIndex = 0;
        int resultTraverse = 0;
        for (int i = 0; i < longArray.length; i++) {
            if (longArray[i] == -1){
                continue;
            }
            for (int j = 0; j < result.length; j++) {
                result[resultIndex] = (char) longArray[i];
                resultIndex += k;
                if (resultIndex > result.length - 1){
                    break;
                }
            }
            resultTraverse ++;
            resultIndex = resultTraverse;
        }
        return new String(result);
    }
    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static String rearrangeString(String s, int k) {
        String s1 = rearrangeString1(s, k);
        System.out.println(s1);
        StringBuilder builder = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            builder.append(s1.charAt(i));
        }
        String result = rearrangeString1(builder.toString(), k);
        System.out.println(result);
        for (int i = 0; i < result.length(); i++) {
            for (int j = Math.max(i - k + 1, 0); j <= Math.min(result.length() - 1, i + k - 1); j++){
                if (i == j){
                    continue;
                }
                if (result.charAt(i) == result.charAt(j)){
                    return "";
                }
            }
        }
        return result;
    }
    
    /**
     *
     * @param s
     * @param k
     * @return
     */
    public static String rearrangeString1(String s, int k) {
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length - 1; i++) {
            boolean flag = false;
            StringBuilder tmp = new StringBuilder();
            //检查该char是否满足条件，左边的子串为排好的字符串
            for (int j = 1; j <= Math.min(k-1, i); j++) {
                tmp.append(array[i-j]);
                if (!flag && array[i] == array[i - j]){
                    flag = true;
                }
            }
            if (flag){
                for (int j = i + 1; j < array.length ; j++) {
                    if (array[j] != array[i] && !tmp.toString().contains(array[j] + "")){
                        char tmpChar = array[i];
                        array[i] = array[j];
                        array[j] = tmpChar;
                        break;
                    }
                }
            }
        }
        return new String(array);
    }
}
