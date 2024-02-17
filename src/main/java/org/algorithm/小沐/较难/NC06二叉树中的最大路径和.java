package org.algorithm.小沐.较难;

public class NC06二叉树中的最大路径和 {

    /** 题目
     *  二叉树里面的路径被定义为:从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。
     *  注意:
     *  1.同一个节点在一条二叉树路径里中最多出现一次
     *  2.一条路径至少包含一个节点，且不一定经过根节点
     *
     *  给定一个二叉树的根节点root，请你计算它的最大路径和
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型
     */

    /** 记录能拿到的现金数(赋值最小的整数) */
    private static int MAX = Integer.MIN_VALUE;

    public static int maxPathSum (TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }

        // 左右小组现金统计
        int leftMaxPathSum = maxPathSum(root.left);
        int rightMaxPathSum = maxPathSum(root.right);

        // 只能拿一个小组和他们头的现金
        int cur = Math.max(0 ,leftMaxPathSum) + Math.max(0 ,rightMaxPathSum) + root.val;

        // 如果这个小组能取到的现金更多，那就在不要之前的了
        MAX = Math.max(MAX, cur);

        // 计算一个小组有多少现金
        return Math.max(leftMaxPathSum, rightMaxPathSum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);

        rootNode.left = rootLeft;
        rootNode.right = rootRight;
//        rootLeft.left = new TreeNode(4);
//        rootLeft.right = new TreeNode(5);
//        rootRight.left = new TreeNode(6);
//        rootRight.right = new TreeNode(7);
        maxPathSum(rootNode);
        System.out.println(MAX);
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}