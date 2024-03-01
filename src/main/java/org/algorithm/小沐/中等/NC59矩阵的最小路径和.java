package org.algorithm.小沐.中等;

public class NC59矩阵的最小路径和 {

    /** 题目
     *  给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
     *
     * 数据范围:1≤n,m≤500，矩阵中任意值都满足 0≤a下标i,j ≤100
     * 要求：时间复杂度 O(nm)
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public static int minPathSum (int[][] matrix) {
        // write code here
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        // 初始化界限
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - 1]) + matrix[j][i];
            }
        }

        return dp[row-1][col-1];
    }


    public static void main(String[] args) {
        // [1,3,5,9],
        // [8,1,3,4],
        // [5,0,6,1],
        // [8,8,4,0]
        int[][] arr = {{1,3,5,9}, {8,1,3,4}, {5,0,6,1}, {8,8,4,0}};
        System.out.println(minPathSum(arr));
    }
}
