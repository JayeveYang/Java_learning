package org.algorithm.小沐.中等;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NC15求二叉树的层序遍历 {
    /** 题目
     *  给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 遍历队列
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int len = treeNodes.size();
            // 遍历完上一次进入队列的数据
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = treeNodes.poll();
                row.add(treeNode.val);

                // 如果有孩子就进队列里
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }

            // 一次层次遍历完了
            result.add(row);
        }
        return result;
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

        levelOrder(rootNode).forEach(System.out::println);
    }

}
