package com.study.demo.leetcode;

/**
 * @author ：xurong02
 * @date ：2023/2/25 11:35 下午
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class 二叉树的层序遍历102 {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pop();
                level.add(treeNode.val);
                if (treeNode.left != null){
                    deque.offerLast(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.offerLast(treeNode.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("A");
        StringBuffer stringBuffer2 = new StringBuffer("B");
        swap(stringBuffer,stringBuffer2);
        System.out.println(stringBuffer+ "." + stringBuffer2);
    }

    private static void swap(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        stringBuffer.append(stringBuffer2);
        stringBuffer2 = stringBuffer;
        System.out.println(stringBuffer2);
    }
}
