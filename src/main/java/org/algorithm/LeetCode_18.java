package org.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    /*
    * 题目
    * 四数之和
    * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
    * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
    *
    * 思路
    * n数之和模板,这里的测试用例有存在溢出整数类型的值，因此把target类型换成long就行
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(4,nums,0,target);
    }
    public List<List<Integer>> nSum(int n, int[] nums, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        //递归结束条件
        if(n < 2 || nums.length < n) return res;
        else if (n == 2){
            int i = start,j = nums.length - 1;
            while(i<j){
                int left=nums[i],right=nums[j];
                if(nums[i]+nums[j]>target){
                    while(i<j&&nums[j]==right)j--;
                }
                else if(nums[i]+nums[j]<target){
                    while(i<j&&nums[i]==left)i++;
                }
                else{
                    List<Integer> sub=new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    res.add(sub);
                    while(i<j&&nums[j]==right)j--;
                    while(i<j&&nums[i]==left)i++;
                }
            }
        }else{
            for(int i=start;i<nums.length-1;i++){
                int ll=nums[i];
                List<List<Integer>> temp = nSum(n-1,nums,i+1,target-ll);
                for(List<Integer> sub:temp){
                    sub.add(ll);
                    res.add(sub);
                }
                while(i<nums.length-1&&nums[i+1]==ll)i++;
            }
        }
        return res;
    }
}
