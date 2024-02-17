package org.algorithm.小沐.较难;

public class NC128接雨水问题 {
    /** 题目
     *  给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0)
     *  数据范围：数组长度 0 ≤ n ≤ 2×10^5，数组中每个值满足 0 < val ≤ 10^9 ，保证返回结果满足 0 ≤ val ≤ 10^9
     * 要求：时间复杂度 O(n)
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public static long maxWater (int[] arr) {
        // write code here

        int left = 0;
        int right = arr.length - 1;
        int leftIndex = left;
        int rightIndex = right;

        // 记录总
        long maxWater = 0;
        long leftWater = 0;
        long rightWater = 0;

        while (left <= right) {
            if (left+1 >= right) {
                // 两军相遇，尴尬了
                break;
            }

            // 往左路打过去
            if (arr[left] >= arr[leftIndex]) {
                maxWater += leftWater;
                // 打不过就成为,奖励清零
                leftIndex = left;
                leftWater = 0;
            }

            // 往右路打过去
            if (arr[right] >= arr[rightIndex]) {
                maxWater += rightWater;
                // 打不过就成为,奖励清零
                rightIndex = right;
                rightWater = 0;
            }

            // 打过了就有奖励
            leftWater += arr[leftIndex] - arr[left];
            rightWater += arr[rightIndex] - arr[right];

            left += 1;
            right -= 1;
        }
        // 两军相遇
        int min = Math.min(arr[leftIndex], arr[rightIndex]);
        int max = Math.max(arr[leftIndex], arr[rightIndex]);
        int middle = (left + right) / 2;
        // 两边不是最小的,那就最小的打过去
        if (min >= arr[middle] && arr[leftIndex] >= arr[rightIndex]) {
            while (leftIndex < right) {
                if (arr[right] >= arr[rightIndex]) {
                    maxWater += rightWater;
                    // 打不过就成为,奖励清零
                    rightIndex = right;
                    rightWater = 0;
                }
                rightWater += arr[rightIndex] - arr[right];
                right -= 1;
            }
            maxWater += rightWater;
        } else if (min >= arr[middle] && arr[leftIndex] <= arr[rightIndex]) {
            while (left < rightIndex) {
                if (arr[left] >= arr[leftIndex]) {
                    maxWater += leftWater;
                    // 打不过就成为,奖励清零
                    leftIndex = left;
                    leftWater = 0;
                }
                leftWater += arr[leftIndex] - arr[left];
                left += 1;
            }
            maxWater += leftWater;
        } else if (max <= arr[middle]) {
            maxWater += leftWater + rightWater;
        }

        return maxWater;
    }

    public static long maxWater1 (int[] arr) {
        // write code here
        int maxWater = 0;
        int left = 0;
        int right = arr.length-1;
        int leftWater = 0;
        int rightWater = 0;

        while( left < right) {
            leftWater = Math.max(leftWater,arr[left]);
            rightWater = Math.max(rightWater,arr[right]);
            maxWater += leftWater < rightWater ? leftWater-arr[left++] : rightWater-arr[right--];
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}; // 83
//        int[] arr = {5,5,1,7,1,1,5,2,7,6}; // 23
        System.out.println(maxWater1(arr));
    }
}
