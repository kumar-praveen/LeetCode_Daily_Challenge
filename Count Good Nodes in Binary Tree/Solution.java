// Question : https://leetcode.com/problems/count-good-nodes-in-binary-tree/



class Solution {
    // Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }
    private int count;
    public void countGoodNode(TreeNode root,int maxi){
        if(root==null) return;
        maxi=Math.max(maxi,root.val);
        if(root.val==maxi){
            count++;
        }
        countGoodNode(root.left,maxi);
        countGoodNode(root.right,maxi);
    }
    public int goodNodes(TreeNode root) {
        count=0;
        countGoodNode(root,Integer.MIN_VALUE);
        return count;
    }
}