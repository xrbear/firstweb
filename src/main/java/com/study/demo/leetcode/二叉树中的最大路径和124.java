package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/3/8 11:05 上午
 */

/**
 * hard
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 */
public class 二叉树中的最大路径和124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);

        return result;
    }

    private int process(TreeNode root) {
        if (root ==null){
            return 0;
        }
        int p1 = root.val;
        int left = Math.max(process(root.left),0);
        int right = Math.max(process(root.right),0);
        int priceNewPath = p1+left+right;
        result = Math.max(result,priceNewPath);
        return p1 + Math.max(left, right);
    }
}
