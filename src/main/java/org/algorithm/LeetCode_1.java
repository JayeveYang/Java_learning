//https://leetcode.cn/problems/two-sum/
package org.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    /*
    * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    * 你可以按任意顺序返回答案。
    * */

    //虽然元素是唯一的，但是我们需要返回目标值的数组下标，不能用HashSet
    //需要用HashMap将下标和值生成键值对

    //优化方法
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        //只需一次循环，先判断是否存在，后直接写入，避免出现target-nums[i]是当前值的情况
        for (int i = 0; i < nums.length; ++i) {
            if (table.containsKey(target - nums[i])) {
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i], i);
        }
        return new int[0];
    }

    //我的方法
    public int[] twoSum_me(int[] nums, int target) {
        //该方法用了，两次循环，在判断过程中还要判断是否找到的值是当前值
        Map<Integer, Integer> table = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);

        }
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i]) && table.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = table.get(target - nums[i]);
                return result;
            }
        }
        return result;
    }
}
