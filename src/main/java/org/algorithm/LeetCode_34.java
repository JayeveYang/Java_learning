package org.algorithm;

public class LeetCode_34 {
    /*
     * 题目
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     * 思路
     * 要求时间复杂度为O(logn),使用二分查找，又由于返回值为区间，考虑使用两次二分法。
     * 题目中数据类型为int,找其target+1位置，就可以得到区间
     * */
    public int[] searchRange(int[] nums, int target) {
        int start;
        if (nums.length < 1) return new int[]{-1, -1};
        start = getIndex(nums, target);
        // start == nums.length 右边界下标越界
        // nums[start] != target适用于判断左边界是不是target
        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        int end = getIndex(nums, target + 1);
        return new int[]{start, end - 1};
    }

    // 找到第一个target的位置
    // 注意二分法的开闭区间
    public int getIndex(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    //时间复杂度为O(logn)+O(m),其中m为区间长度
    public int[] searchRange1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int i, j;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else {
                i = mid;
                j = mid;
                while (i >= 0 && nums[i] == target) i--;
                while (j < nums.length && nums[j] == target) j++;
                return new int[]{i + 1, j - 1};
            }
        }
        return new int[]{-1, -1};
    }
}
