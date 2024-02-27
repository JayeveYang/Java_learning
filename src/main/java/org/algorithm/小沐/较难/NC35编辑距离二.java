package org.algorithm.小沐.较难;

public class NC35编辑距离二 {
    /** 题目
     * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
     *
     * 数据范围：0 ≤ ∣str1∣,∣str2∣ ≤ 5000，0 ≤ ic,dc,rc ≤ 10000
     * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public static int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();

        // 建立动态规划数组
        int[][] dp = new int[len2 + 1][len1 + 1];

        for (int i = 1; i <= len1 ; i++) {
            // 假定str2为空, 需要删除
            dp[0][i] = dp[0][i-1] + dc;
        }
        for (int i = 1; i <= len2; i++) {
            // 假定str1为空, 需要插入
            dp[i][0] = dp[i-1][0] + ic;
        }

        rc = Math.min(rc, ic + dc);

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                // dp[i-1][j-1] 替换
                // dp[i][j-1]   删除
                // dp[i-1][j]   插入
                dp[i][j] = str1.charAt(j - 1) == str2.charAt(i - 1) ? dp[i-1][j-1]: Math.min(dp[i-1][j-1] + rc, Math.min(dp[i][j-1] + dc, dp[i-1][j] + ic));
            }
        }

        return dp[len2][len1];
    }

    public static void main(String[] args) {
        System.out.println(minEditCost("fbnbqsputklmmwrdqszwgxzgxrevqhautncdzsmlllufqifhkadoqgqpwemiposathdxdgfrjqmtjwrmchxpbcobozdwpepsiivt",
                "rbxfspcdputlzxrmwpdusqcpafszfdwosxzgmezhcuucdgwsmleznbaullannbzevifqdhvizdgqgpbenmuposatafhedjdevoxgfqlamtafmgrmlmhxvouswipvvxjrecoupbdiuqwnpucesiyvt",
                6325,2459,3712));
    }
}
