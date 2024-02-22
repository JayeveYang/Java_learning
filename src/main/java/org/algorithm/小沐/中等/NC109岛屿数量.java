package org.algorithm.小沐.中等;

public class NC109岛屿数量 {
    /** 题目
     *  给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public static int solve (char[][] grid) {
        // write code here
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    // 四周赋值为0
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /** 深度优先搜索: deep first search */
    private static void dfs(char[][] grid, int i, int j) {
        // 设为0
        grid[i][j] = '0';

        // 上下左右
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[10][10];
        grid[1][1] = '1';
        grid[1][2] = '1';

        grid[3][3] = '1';

        grid[4][4] = '1';
        grid[4][5] = '1';
        grid[4][6] = '1';
        grid[3][6] = '1';
        grid[2][6] = '1';

        System.out.println(solve(grid));
    }

}
