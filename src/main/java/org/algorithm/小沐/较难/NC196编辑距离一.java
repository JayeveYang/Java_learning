package org.algorithm.小沐.较难;

public class NC196编辑距离一 {
    /**
     * 给定两个字符串 str1 和 str2 ，请你算出将 str1 转为 str2 的最少操作数。
     * 你可以对字符串进行3种操作：
     * 1.插入一个字符
     * 2.删除一个字符
     * 3.修改一个字符。
     *
     * 字符串长度满足1 ≤ n ≤ 1000  ，保证字符串中只出现小写英文字母。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str1 string字符串
     * @param str2 string字符串
     * @return int整型
     */
    public static int editDistance (String str1, String str2) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();

        // 新建动态规划空间, 两个字符串都有空的可能
        int[][] dp = new int[len2+1][len1+1];

        // 初始化dp边界(即假定两个字符串, 其中一个为空)(极端场景)
        for (int i = 1; i <= len1; i++) {
            // 假定str2字符串为空,那么就需要str1删除成为str2
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= len2; i++) {
            // 假定str1字符串为空,那么就需要str1插入成为str2
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 开始规划处理问题
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                // 遍历二维数组
                if (str1.charAt(j-1) == str2.charAt(i-1)) {
                    // 如果相等,最优解就是不处理
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 插入, 删除, 替换中选择最优解
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }

//                dp[i][j] = str1.charAt(j-1) == str2.charAt(i-1) ? dp[i-1][j-1] : Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }

        return dp[len2][len1];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("nowcoder", "new"));
    }
}
