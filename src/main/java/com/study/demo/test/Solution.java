package com.study.demo.test;

import java.util.*;

/**
 * @author ：xurong02
 * @date ：2022/11/27 11:07 下午
 */
public class Solution {

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

    int ans ;

    /**
     * 二叉树直径
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans =1;
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode node) {
        if (node == null){
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans =  Math.max(l+r+1,ans);
        return Math.max(l,r)+1;
    }


    /**
     * 合并二叉树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    /**
     * 二叉树变为累加树
     * 反序中序遍历
     */
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
         convertBST(root.left);

        return root;
    }

    /**
     * 展开成单链表
     * @param root
     */
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        Integer size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if (root == null){
            return;
        }
        list.add(root);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }

    //迭代
    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node =root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                list.add(node);
                node=node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        Integer size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }


    /**
     * 二叉树是否为二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        Integer size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i).val < list.get(i-1).val){
                return false;
            }
        }
        return true;
    }

    /**
     * 求最大面积的岛屿
     * @param grid
     * @return
     */
    public int maxAreaIslands(char[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){

                int area = area(grid,i,j);
                res = Math.max(res,area);
            }
        }
        return res;
    }

    private int area(char[][] grid, int i, int j) {
        if (!inArea(grid,i,j)){
            return 0;
        }
        if (grid[i][j]!=1){
            return 0;
        }
        grid[i][j] =2;
        return 1+area(grid,i-1,j)
                +area(grid,i+1,j)
                +area(grid,i,j-1)
                +area(grid,i,j+1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return i>=0&&i<grid.length&&j>0&&j<grid[0].length;
    }


    /**
     * 课程表
     * @param numCourses
     * @param prerequisites
     * @return
     */
    boolean valid =true;
    int[]  visited;
    List<List<Integer>> edges = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        visited = new int[numCourses];

        for (int i=0;i<numCourses;i++){
            if (!valid){
                return false;
            }

            if (visited[i] == 0){
                dfs(i);
            }

        }
        return valid;
     }

    private void dfs(int i) {
        visited[i] = 1;
        List<Integer> integerList = edges.get(visited[i]);
        for (int x = 0; x<integerList.size();i++){
            if (visited[integerList.get(x)] == 1){
                valid =false;
                return ;
            }
            if (visited[integerList.get(x)] == 0){
                dfs(integerList.get(x));
                if (!valid){
                    return ;
                }
            }
        }
        visited[i] = 2;
    }


    /**
     * 二叉树公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        Map<Integer,Integer> pMap = new HashMap<>();
        Boolean pValid =false;
        Boolean qvalid =false;
        pList.add(p);
        qList.add(q);
        ance(root,p,pList,pValid);
        ance(root,q,qList,qvalid);
        int lengthP = pList.size();
        int lengthQ = qList.size();
        int min = Math.min(lengthP, lengthQ);
        for (int i=0;i<lengthP;i++){
            pMap.put(pList.get(i).val, i);
        }
        for (int i=0;i<lengthQ;i++){
            if (pMap.get(qList.get(i).val) != null){
                return qList.get(i);
            }
        }
        return null;
    }

    private void ance(TreeNode node, TreeNode target, List<TreeNode> nodeList, Boolean valid){
        if (node == null || (node.left == null && node.right == null)){
            return ;
        }
        if (node == target){
            nodeList.add(node);
        }
        if (node.left == target){
            nodeList.add(node);
            valid = true;
        }else if (node.right == target){
            nodeList.add(node);
            valid = true;
        }else{
            if (node.left != null){
                ance(node.left,target,nodeList,valid);
            }
            if (node.right != null){
                ance(node.right,target,nodeList,valid);
            }
        }
        if (valid){
            nodeList.add(node);
        }
    }

    /**
     * 求路径和
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum){
        if (root == null){
            return 0;
        }
        int ans = rootNum(root,targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right,targetSum);
        return ans;
    }

    private int rootNum(TreeNode root, long targetSum) {
        int ret =0;
        if(null == root){
            return 0;
        }
        if (root.val == targetSum){
             ret++;
        }
        ret += rootNum(root.left,targetSum-root.val);
        ret += rootNum(root.right,targetSum-root.val);
        return ret;
    }

    /**
     * 大家结舍
     */
    Map<TreeNode, Integer> fMap = new HashMap<>();
    Map<TreeNode, Integer> gMap = new HashMap<>();
    public int rob(TreeNode root) {
        dfsRob(root);
        return Math.max(fMap.getOrDefault(root,0), gMap.getOrDefault(root,0));
    }

    void dfsRob(TreeNode node){
        if (node == null){
            return;
        }
        dfsRob(node.left);
        dfsRob(node.right);
        fMap.put(node,node.val+ gMap.getOrDefault(node.left,0)+ gMap.getOrDefault(node.right,0));
        gMap.put(node,Math.max(fMap.getOrDefault(node.left,0), fMap.getOrDefault(node.left,0))+Math.max(fMap.getOrDefault(node.right,0), fMap.getOrDefault(node.right,0)));
    }

    /**
     * 最大路径和
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        int priceNewPath = root.val + leftGain + rightGain;
        maxSum = Math.max(priceNewPath,maxSum);
        return root.val + Math.max(leftGain,rightGain);
    }


   //=============================== 背包问题 ===========================
   int maxValue(int[] w, int[] value,int bag){
       if (w.length != value.length){
           return 0;
       }
       return process(w,value,0,bag);
   }
   //当前考虑到了index号货物，index往后所有的货物可以自由选择
    int process(int[] w, int[] value, int index, int rest){
        //之所以不判断等于0是因为可能重量0却有价值
        if (rest <0){
            return 0;
        }

        if (w.length ==index){
            return 0;
        }


        int p1 = process(w,value,index+1,rest);
        int p2 = 0;
        if (rest - w[index] >=0){
            p2 = value[index] + process(w,value,index+1,rest-w[index]);
        }

        return Math.max(p1,p2);
    }


    int maxValue2(int[] w, int[] value,int bag){
        if (w.length != value.length){
            return 0;
        }

        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        /*for (int i = 0; i <= bag; i++) {
            dp[N][i] = 0;
        }*/
        for (int index = N-1; index >=0 ; index--) {
            for (int rest=0;rest<=bag;rest++){
                int p1 = dp[index+1][rest];
                int p2 =0;
                if (rest-w[index]>=0){
                    p2 = value[index]+dp[index+1][rest-w[index]];
                }
                dp[index][rest] = Math.max(p1,p2);
            }
        }

        return dp[0][bag];
    }

    public static void main(String[] args) {
        String s = new String("s");
        s.hashCode();
        int[] weight = {3,2,4,7,3,1,7};
        int[] value = {5,6,3,19,12,4,2};
        Solution solution = new Solution();
        int bag =15;
        int maxValue = solution.maxValue(weight, value, bag);
        int maxValue2 = solution.maxValue2(weight, value, bag);
        System.out.println(maxValue);
        System.out.println(maxValue2);
    }




}
