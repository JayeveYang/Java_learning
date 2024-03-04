package org.algorithm.小沐.中等;

import java.util.*;

public class NC97字符串出现次数的TopK问题 {
    /** 题目
     * 给定一个字符串数组，再给定整数 k ，请返回出现次数前k名的字符串和对应的次数。
     * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
     * 对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
     * 比如"ah1x"小于"ahb"，"231"<”32“
     * 字符仅包含数字和字母
     *
     * 数据范围：字符串数满足 0≤n≤100000，每个字符串长度0≤n≤10，0≤k≤2500
     * 要求：空间复杂度 O(n)，时间复杂度O(nlogk)
     */
    /**
     *输入：["123","123","231","32"],2
     * 返回值：[["123","2"],["231","1"]]
     * 说明："123"出现了2次，记["123","2"]，"231"与"32"各出现1次，但是"231"字典序在"32"前面，记["231","1"]，最后返回[["123","2"],["231","1"]]
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public static String[][] topKstrings (String[] strings, int k) {
        // write code here
        if (strings.length == 0) {
            return null;
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings) {
            map.put(string, map.containsKey(string) ? map.get(string) + 1 : 1);
        }

        // 转成list排序
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((str1, str2) -> (str1.getValue().compareTo(str2.getValue()) == 0 ? str1.getKey().compareTo(str2.getKey()) : str2.getValue().compareTo(str1.getValue())));

        String[][] strArr = new String[k][2];
        for (int i = 0; i < k; i++) {
            strArr[i][0] = list.get(i).getKey();
            strArr[i][1] = String.valueOf(list.get(i).getValue());
        }

        return strArr;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"123","123","231","32"};
        String[][] strings = topKstrings(strArr, 2);
        if (strings == null) {
            return;
        }
        for (String[] string : strings) {
            System.out.println(string[0] + ":" +string[1]);
        }
    }
}
