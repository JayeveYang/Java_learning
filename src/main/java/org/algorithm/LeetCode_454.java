// https://leetcode.cn/problems/4sum-ii/
package org.algorithm;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*
        * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        * 0 <= i, j, k, l < n
        * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        * */

        /*
        * 思路
        * 为了减少时间复杂度，考虑2个数组求和
        * 1. 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
        * 2. 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
        * 3. 最后返回统计值 count 就可以了
        * */

        // 为 nums1+nums2 创建哈希表
        Map<Integer,Integer> t1 = new HashMap<>();
        // 统计两个数组中的元素之和，同时统计出现的次数，放入map
        for(int num1 : nums1){
            for(int num2 : nums2){
                t1.put(num1 + num2, t1.getOrDefault(num1 + num2,0) + 1);
            }
        }
        int count =  0;
        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for(int num3 : nums3){
            for(int num4 : nums4){
                if(t1.containsKey(-num3-num4)){
                    count += t1.get(-num3-num4);
                }
            }
        }
        return count;
    }
}
