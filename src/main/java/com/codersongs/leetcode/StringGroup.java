package com.codersongs.leetcode;

import java.util.*;

/**
 * 这是永禄给的一道算法题，实现一下
 * ·算法：字符串数组["abc","bac","abe","bae","cab"...],里边每个字符串长度不定，但保证都是'a-z'和'A-Z',请写出算法，将包含相同的字符组成的字符串进行分组。如上述输出[["abc","bac","cab"],["bae","abe"]...]，并回答实现的算法的复杂度是多少。
 * @author wusongsong
 * @date 2019/5/24
 */
public class StringGroup {
    public static void main(String[] args) {
        String[][] group = group(new String[]{"abc", "bac", "abe", "bae", "cab"});
        for (int i = 0; i < group.length; i++) {
            String[] strings = group[i];
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                System.out.print(string + ",");
            }
            System.out.println();
        }
    }

    public static String[][] group(String[] origin){
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            charMap.put((char)i, i - 97);
        }
        for (int i = 65; i <= 90; i++) {
            charMap.put((char)i, i - 40);
        }

        Map<String, List<String>> resultMap = new HashMap<>();
        for (int i = 0; i < origin.length; i++) {
            String str = origin[i];
            char[] tmp = "0000000000000000000000000000000000000000000000000000".toCharArray();
            for (int j = 0; j < str.length(); j++) {
                int index = charMap.get(str.charAt(j));
                int count = Integer.parseInt(tmp[index] + "");
                tmp[index] = Character.forDigit(count+1,10);
            }
            String key = new String(tmp);
            if (resultMap.get(key) == null){
                List<String> list = new ArrayList<>();
                list.add(str);
                resultMap.put(key, list);
            }else {
                List<String> list = resultMap.get(key);
                list.add(str);
            }
        }

        return generateResult(resultMap);
    }

    private static String[][] generateResult(Map<String, List<String>> resultMap) {
        String[][] result = new String[resultMap.size()][];
        Set<Map.Entry<String, List<String>>> entries = resultMap.entrySet();
        int i = 0;
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> value = entry.getValue();
            String[] strings = new String[value.size()];
            result[i++] = value.toArray(strings);
        }
        return result;
    }
}
