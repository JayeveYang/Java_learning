package org.algorithm;

import java.util.HashSet;

public class LeetCode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> table=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();
        for(int num:nums1){
            table.add(num);
        }
        for(int num:nums2){
            if(table.contains(num)){
                res.add(num);
            }
        }
        int i=0;
        int[] result=new int[res.size()];
        for(int num:res){
            result[i]=num;
            i++;
        }
        return result;
    }
}
