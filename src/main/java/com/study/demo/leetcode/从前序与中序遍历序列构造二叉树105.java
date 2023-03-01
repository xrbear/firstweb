package com.study.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xurong02
 * @date ：2023/2/28 9:09 下午
 */
public class 从前序与中序遍历序列构造二叉树105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right){
            return null;
        }

        int preorder_root = preorder_left;
        Integer inorderRoot = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorderRoot - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left + size_left_subtree,inorder_left,inorderRoot-1);
        root.right = myBuildTree(preorder,inorder,preorder_left + size_left_subtree+1,preorder_right,inorderRoot+1,inorder_right);
        return root;
    }
}
