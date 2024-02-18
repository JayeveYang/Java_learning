package org.algorithm.小沐.中等;


import java.util.ArrayList;
import java.util.List;

public class NC45实现二叉树先序中序后序遍历 {

    /** 题目
     *  给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        // 先、中、后，指的是根节点的输出顺序
        preOrder(root, preOrder);
        inOrder(root, inOrder);
        postOrder(root, postOrder);

        int size = preOrder.size();
        int[][] threeOrders = new int[3][size];
        for (int i = 0; i < size; i++) {
            threeOrders[0][i] = preOrder.get(i);
            threeOrders[1][i] = inOrder.get(i);
            threeOrders[2][i] = postOrder.get(i);
        }

        return threeOrders;
    }

    private static void preOrder (TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private static void inOrder (TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private static void postOrder (TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
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

        int[][] ints = threeOrders(rootNode);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
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
