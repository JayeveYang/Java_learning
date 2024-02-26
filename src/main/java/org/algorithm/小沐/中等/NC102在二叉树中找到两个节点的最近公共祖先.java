package org.algorithm.小沐.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NC102在二叉树中找到两个节点的最近公共祖先 {

    /**
     * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
     *
     * 数据范围：树上节点数满足 1≤n≤10^5, 节点值val满足区间 [0,n)
     * 要求：时间复杂度 O(n)
     *
     * 注：本题保证二叉树中每个节点的val值均不相同。
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    private static Boolean flag = false;

    public static int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        // 找到第一个后找第二个
        dfs(root, o1, path1);
        flag = false;
        dfs(root, o2, path2);

        // 遍历路径(不相同的前一个是最近的)
        int len = Math.min(path1.size(), path2.size());
        for (int i = 0; i < len; i++) {
            if (!Objects.equals(path1.get(i), path2.get(i))) {
                len = i;
                break;
            }
        }

        // 取上一个(即最近的)
        return path1.get(len-1);
    }

    public static void dfs(TreeNode root, int o1, ArrayList<Integer> path) {
        if (flag || root == null) {
            return;
        }
        path.add(root.val);

        // 找到了就结束
        if (root.val == o1) {
            flag = true;
            return;
        }

        // 继续遍历
        dfs(root.left, o1, path);
        dfs(root.right, o1, path);

        if (flag) {
            return;
        }

        // 回溯
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);

        rootNode.left = rootLeft;
        rootNode.right = rootRight;
        rootLeft.left = new TreeNode(4);
        rootLeft.right = new TreeNode(5);
        rootRight.left = new TreeNode(6);
        rootRight.right = new TreeNode(7);

        System.out.println(lowestCommonAncestor(rootNode, 5, 6));

    }
}
