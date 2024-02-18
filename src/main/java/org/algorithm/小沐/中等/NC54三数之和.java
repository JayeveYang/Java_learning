package org.algorithm.小沐.中等;

import java.util.*;

public class NC54三数之和 {

    /** 题目
     *  给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
     *
     * 数据范围：0 ≤ n ≤ 1000，数组中各个元素值满足 ∣val∣ ≤ 100
     * 空间复杂度：O(n^2)，时间复杂度O(n^2)
     *
     * 注意：
     * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
     * 解集中不能包含重复的三元组。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */

    /** 哈希 */
    public static ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        // write code here
        HashSet<ArrayList<Integer>> set = new LinkedHashSet<>();
        for (int i = 0; i < num.length; i++) {
            // 存储待匹配的数据
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < num.length; j++) {
                // 直接取相反数，这样就能直接匹配了
                int result = -(num[i] + num[j]);

                if (map.containsKey(result)) {
                    // 匹配到合适的就存到set中
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(num[i], num[j], result));
                    Collections.sort(list);
                    set.add(list);
                } else {
                    // 没有匹配到的就进map
                    map.put(num[j], num[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    /** 双指针 */
    public static ArrayList<ArrayList<Integer>> threeSum1 (int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (num.length < 3) {
            return list;
        }

        // 先排序方便去重、存储和指针走向
        Arrays.sort(num);

        // 开始遍历(截至的减2减1都一样)
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                // 目标值也要去重
                continue;
            }
            // 取一个数的相反数作为结果值
            int result = -num[i];

            // 左右指针
            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                if (result == num[left] + num[right]) {
                    // 匹配上就存起来num[i]必然是最小的
                    list.add(new ArrayList<>(Arrays.asList(num[i], num[left], num[right])));

                    // 匹配上之后才考虑去重
                    while (left + 1 < right && num[left] == num[left + 1]) {
                        left += 1;
                    }
                    while (left < right - 1 && num[right] == num[right - 1]) {
                        right -= 1;
                    }

                    // 去重完之后两边收敛
                    right -= 1;
                    left += 1;
                } else if (result < num[left] + num[right]) {
                    // 大于结果值，就往小的移动
                    right -= 1;
                } else {
                    // 小于结果值，就往大的移动
                    left += 1;
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
//        int[] num = {0,0,0,0};
        int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        threeSum1(num).forEach(System.out::println);
    }
}
