package org.algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15 {
    /*
     * 题目
     * 给你一个整数数组 nums ，
     * 判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     * 请你返回所有和为 0 且不重复的三元组
     *
     * 思路
     * 1. 哈希解法
     * 两层for循环就可以确定 a 和b 的数值了，可以使用哈希法来确定 0-(a+b) 是否在 数组里出现过，其实这个思路是正确的, 但是去重复杂
     *
     * 2. 双指针法
     * 首先将数组排序，
     * 然后有一层for循环，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
     * 依然还是在数组中找到 abc 使得a + b +c =0，
     * 如果 nums[i] + nums[left] + nums[right] < 0 说明此时三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 保证每个环节去重
        // 递归停止条件
        // 一些不满足条件的情况
        if (n < 2 || nums.length < n) {
            return res;
        }
        // 两数之和
        if (n == 2) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                int left = nums[i], right = nums[j];
                if (nums[i] + nums[j] < target) {
                    //去重，并向后挪i，使得值变大.循环结束条件是nums[i]==left
                    //需要将指针调整到第一个不重复值，所以nums[i]==left多做一层循环，而不是nums[i]==nums[i+1](只会让指针指到最后一个重复值)
                    while (i < j && nums[i] == left) i++;
                } else if (nums[i] + nums[j] > target) {
                    //去重，循环结束条件是nums[j]!=nums[j-1]
                    while (i < j && nums[j] == right) j--;
                } else {
                    //找到
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                    //去重
                    while (i < j && nums[i] == left) i++;
                    while (i < j && nums[j] == right) j--;
                }
            }
        } else {
            for (int i = start; i < nums.length - 1; i++) {
                int ll = nums[i];
                List<List<Integer>> temp = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> sub : temp) {
                    sub.add(nums[i]);
                    res.add(sub);
                }
                //去重,因为外层for循环自带+1，这里只需要把i调整到重复值的最后一位
                while (i < nums.length - 1 && nums[i + 1] == ll) i++;
            }
        }
        return res;
    }

}
